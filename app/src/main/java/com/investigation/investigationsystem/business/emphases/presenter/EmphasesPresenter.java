package com.investigation.investigationsystem.business.emphases.presenter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.investigation.investigationsystem.business.emphases.adapter.EmpListAdapter;
import com.investigation.investigationsystem.business.emphases.bean.MonitoringArea;
import com.investigation.investigationsystem.business.emphases.bean.MonitoringPerson;
import com.investigation.investigationsystem.business.emphases.bean.MonitoringTeam;
import com.investigation.investigationsystem.business.emphases.bean.emphases;
import com.investigation.investigationsystem.business.emphases.view.EmphasesActivity;
import com.investigation.investigationsystem.business.emphases.view.EmphasesDetailFragment;
import com.investigation.investigationsystem.business.emphases.view.EmphasesFragment;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.DataConstants;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.data.Data;
import com.investigation.investigationsystem.common.utils.DebugLog;

import java.util.ArrayList;
import java.util.List;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/3  13:47
 * <p/>
 * 描    述 ：
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class EmphasesPresenter extends BasePresenter {

    private static final String TAG = StringConstants.TAG + EmphasesPresenter.class.getName();
    private static EmphasesPresenter persenter;
    protected Fragment currentFragment;

    private EmphasesPresenter(BaseFragmentActivity rootActivity) {
        this.rootActivity = rootActivity;
    }

    public static void regist(BaseFragmentActivity rootActivity) {
        persenter = new EmphasesPresenter(rootActivity);
    }

    public static EmphasesPresenter getInstance() {
        return persenter;
    }

    public static void startUp(Activity activity) {
        Intent intent = new Intent(activity, EmphasesActivity.class);
        activity.startActivity(intent);
        intent = null;
    }

    public void startUpDetailFragment(String name) {
        addFragmentAddBackStack(EmphasesDetailFragment.newInstance(name));
    }

    /**
     * 加载默认的 fragment 页面
     */
    public void addDefaultFragment() {
        addFragmentNoBackStack(EmphasesFragment.newInstance());
    }

    private void addFragmentNoBackStack(Fragment fragment) {
        addFragmentNoBackStack(fragment, rootActivity.getFragmentViewID());
        currentFragment = fragment;
        fragment = null;
    }

    private void addFragmentAddBackStack(Fragment fragment) {
        addFragmentAddBackStack(currentFragment, fragment, rootActivity.getFragmentViewID());
        currentFragment = fragment;
        fragment = null;
    }


    /**
     * 销毁，回收资源
     */
    public void onDes() {
        currentFragment = null;
        persenter = null;
    }

    public void setCurrentFragment(Fragment fragment) {
        currentFragment = fragment;
        Log.d(TAG, fragment.getClass().getName() + "重新点亮");
    }

    /**
     * 使用json解析本地的重点监测数据 以后变成解析
     */
    public emphases analysisJson(){
        Gson gson = new Gson();
        emphases emphasesz = gson.fromJson(Data.FocusMonitoring, emphases.class);
        DebugLog.i(TAG  , "---解析本地数据emphasesz---" + emphasesz);
        return emphasesz;
    }

    /**
     * 从本地获取重点监测数据中的团队信息
     */
    public void getEmphasesTeamInfo(Spinner sp_team , final Spinner sp_area
            , final Button btn_search , final RecyclerView rv_show){
        //判断是否需要根据不同的用户获取数据
        //获取团队数据
        List<String> teamnamelist = new ArrayList<>();
        emphases emphases = analysisJson();
        final List<MonitoringTeam> teamlist = emphases.getTeamlist();
        for (int i = 0; i < teamlist.size(); i++) {
            teamnamelist.add(teamlist.get(i).getTeamname());
        }
        //把teamnamelist数据填充进spinner
        final String[] teamnames = new String[teamnamelist.size()];
        for (int i = 0 ; i < teamnamelist.size() ; i++) {
            teamnames[i] = teamnamelist.get(i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootActivity
                , android.R.layout.simple_spinner_item , teamnames);
        sp_team.setAdapter(adapter);
        //sp点击时候的事件
        sp_team.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                getEmphasesArea( teamnames[position] , teamlist , sp_area , btn_search , rv_show);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    /**
     * 根据团队信息获取地域信息 刷新spinner的数据
     */
    public void getEmphasesArea(String teamName , List<MonitoringTeam> teamlist , Spinner sp_area
            , final Button btn_search , final RecyclerView rv_show){
        //把团队信息最放到缓存中
        DataConstants.emphasesTeam = teamName;
        //通过团队信息解析数据
        for (int i = 0; i < teamlist.size(); i++)
            if (teamlist.get(i).getTeamname().equals(teamName)) {
                //把数据填充进spinner
                final List<MonitoringArea> MonitoringArea = teamlist.get(i).getMonitoringArea();
                String[] areas = new String[MonitoringArea.size()];
                for (int j = 0; j < MonitoringArea.size(); j++) {
                    areas[j] = MonitoringArea.get(j).getAreaname().toString();
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootActivity
                        , android.R.layout.simple_spinner_item , areas);
                sp_area.setAdapter(adapter);
                sp_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        //被选中的地域信息存放到全局静态变量
                        DataConstants.emphasesArea = MonitoringArea.get(position).getAreaname();
                        showUserInfo(btn_search , MonitoringArea.get(position).getMonitoringPerson() , rv_show);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }
    }

    /**
     * 点击查询时 显示对应的数据
     */
    public void showUserInfo(Button btn_search , final List<MonitoringPerson> monitoringPerson, final RecyclerView rv_show){
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击查询数据 显对应的数据内容
                EmpListAdapter empListAdapter = new EmpListAdapter(monitoringPerson);
                rv_show.setAdapter(empListAdapter);
                empListAdapter.setOnItemClickListener(new EmpListAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(MonitoringPerson monitoringPerson) {
                        if (monitoringPerson != null) {
                            DataConstants.monitoringConstants = monitoringPerson;
                            addFragmentAddBackStack(new EmphasesDetailFragment());
                        }
                    }
                });

            }
        });
    }


}
