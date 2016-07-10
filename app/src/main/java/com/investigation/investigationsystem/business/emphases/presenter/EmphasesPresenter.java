package com.investigation.investigationsystem.business.emphases.presenter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.google.gson.Gson;
import com.investigation.investigationsystem.business.emphases.bean.TeamList;
import com.investigation.investigationsystem.business.emphases.bean.emphases;
import com.investigation.investigationsystem.business.emphases.view.EmphasesActivity;
import com.investigation.investigationsystem.business.emphases.view.EmphasesDetailFragment;
import com.investigation.investigationsystem.business.emphases.view.EmphasesFragment;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
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
     * 从本地获取重点监测数据中的团队信息
     */
    public void getEmphasesInfo(){
        List<String> teamnamelist = new ArrayList<>();
        Gson gson = new Gson();
        emphases emphases = gson.fromJson(Data.FocusMonitoring, emphases.class);
        DebugLog.i(TAG , emphases.toString());
        List<TeamList> teamlist = emphases.getTeamlist();
        for (int i = 0; i < teamlist.size(); i++) {
            teamnamelist.add(teamlist.get(i).getTeamname());
        }
        

    }


}
