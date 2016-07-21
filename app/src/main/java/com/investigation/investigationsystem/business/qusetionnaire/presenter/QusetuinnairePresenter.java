package com.investigation.investigationsystem.business.qusetionnaire.presenter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.investigation.investigationsystem.business.login.bean.Area;
import com.investigation.investigationsystem.business.login.bean.Juan;
import com.investigation.investigationsystem.business.login.bean.JuanResponse;
import com.investigation.investigationsystem.business.login.bean.Question;
import com.investigation.investigationsystem.business.login.bean.Team;
import com.investigation.investigationsystem.business.qusetionnaire.view.JuanActivity;
import com.investigation.investigationsystem.business.qusetionnaire.view.QusetuinnairFragment;
import com.investigation.investigationsystem.business.qusetionnaire.view.QusetuinnaireActivity;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.DataConstants;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.DebugLog;
import com.investigation.investigationsystem.common.utils.PrefersUtils;
import com.investigation.investigationsystem.common.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 进入调查问卷之前的身份证扫描页面
 * <p/>
 * Created by zero on 2016/7/3.
 */
public class QusetuinnairePresenter extends BasePresenter {

    private static final String TAG = StringConstants.TAG + QusetuinnairePresenter.class.getName();
    private static QusetuinnairePresenter persenter;

    private QusetuinnairePresenter(BaseFragmentActivity rootActivity) {
        this.rootActivity = rootActivity;
    }

    public static void regist(BaseFragmentActivity rootActivity) {
        persenter = new QusetuinnairePresenter(rootActivity);
    }

    public static QusetuinnairePresenter getInstance() {
        return persenter;
    }

    public static void startUp(Activity activity) {
        Intent intent = new Intent(activity, JuanActivity.class);
//        Intent intent = new Intent(activity, QusetuinnaireActivity.class);
        activity.startActivity(intent);
        intent = null;
    }

    public static void startUpQuestionnair(Activity activity){
        Intent intent = new Intent(activity, QusetuinnaireActivity.class);
        activity.startActivity(intent);
        intent = null;
    }

    /**
     * 加载默认的 fragment 页面
     */
    public void addDefaultFragment() {
        replaceFragment(QusetuinnairFragment.newInstance(), rootActivity.getFragmentViewID());
    }


    /**
     * 选择团队
     */
    public void chooseTeam(final Spinner spinner_team , final Spinner spinner_eare , final Spinner spinner_juan ) {
        //把teamnamelist数据填充进spinner
        final List<Team> teamList = DataConstants.currentMyUserInfo.getTeamList();

        if (teamList.size() > 0) {
            //获取团队id
            final String[] teamids = new String[teamList.size()];
            for (int i = 0 ; i < teamList.size() ; i++) {
                teamids[i] = teamList.get(i).getTeamID();
            }
            //获取团队名称
            final String[] teamnames = new String[teamList.size()];
            for (int i = 0 ; i < teamList.size() ; i++) {
                teamnames[i] = teamList.get(i).getTeamName();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootActivity
                    , android.R.layout.simple_spinner_item , teamnames);
            spinner_team.setAdapter(adapter);
            //设置默认全局变量内容
            DataConstants.juanTeam = teamnames[0];
            DataConstants.juanTeamId = teamids[0];
            //选择团队的时候 放到全局变量里面
            spinner_team.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    DataConstants.juanTeam = teamnames[position];
                    DataConstants.juanTeamId = teamids[position];
                    chooseEare(spinner_eare);
                    chooseQuestion(spinner_juan);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }

    }

    /**
     * 选择调查地域
     */
    public void chooseEare(Spinner spinner_area) {
        //把teamnamelist数据填充进spinner
        List<Area> teamArea = new ArrayList<>();
        List<Team> teamList = DataConstants.currentMyUserInfo.getTeamList();
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).getTeamName().equals(DataConstants.juanTeam)) {
                teamArea = teamList.get(i).getTeamArea();
            }
        }

        if (teamArea.size() > 0) {
            //获取地域id
            final String[] areaids = new String[teamArea.size()];
            for (int i = 0 ; i < teamArea.size() ; i++) {
                areaids[i] = teamArea.get(i).getAreaID();
            }
            //获取地域名称
            final String[] areanames = new String[teamArea.size()];
            for (int i = 0 ; i < teamArea.size() ; i++) {
                areanames[i] = teamArea.get(i).getAreaName();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootActivity
                    , android.R.layout.simple_spinner_item , areanames);
            spinner_area.setAdapter(adapter);
            //设置默认全局变量内容
            DataConstants.juanArea = areanames[0];
            DataConstants.JuanAreaId = areaids[0];
            //选择团队的时候 放到全局变量里面
            spinner_area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    DataConstants.juanArea = areanames[position];
                    DataConstants.JuanAreaId = areaids[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }else{
            ToastUtils.showMessage("团队下没有地域信息");
        }

    }

    /**
     * 选择问卷
     */
    public void chooseQuestion(Spinner spinner_juan) {
        //把teamnamelist数据填充进spinner
        List<Question> teamQuestionnaire = new ArrayList<>();
        List<Team> teamList = DataConstants.currentMyUserInfo.getTeamList();
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).getTeamName().equals(DataConstants.juanTeam)) {
                teamQuestionnaire = teamList.get(i).getTeamQuestionnaire();
            }
        }

        if (teamQuestionnaire.size() > 0) {
            //获取问卷编码
            final String[] juanids = new String[teamQuestionnaire.size()];
            for (int i = 0 ; i < teamQuestionnaire.size() ; i++) {
                juanids[i] = teamQuestionnaire.get(i).getQuestionnaireID();
            }
            DebugLog.i(TAG , "---选择问卷的问卷编码---" + juanids);
            //获取问卷名称
            final String[] juannames = new String[teamQuestionnaire.size()];
            for (int i = 0 ; i < teamQuestionnaire.size() ; i++) {
                juannames[i] = teamQuestionnaire.get(i).getQuestionnaireTitle();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootActivity
                    , android.R.layout.simple_spinner_item , juannames);
            spinner_juan.setAdapter(adapter);
            //设置默认全局变量内容
            DataConstants.juanJuan = juannames[0];
            DataConstants.juanJuanId = juanids[0];
            //选择团队的时候 放到全局变量里面
            spinner_juan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    DataConstants.juanJuanId = juanids[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }else{
            ToastUtils.showMessage("该团队没有问卷信息");
        }
    }

    /**
     * 获取所有被调查人相关数据
     * 注意处理null数据
     */
    public void getInvestigatedInfo() {

    }

    /**
     * 开始问卷调查
     */
    public void beginQusetion(Activity activity) {
        //获取所有被调查人信息
        getInvestigatedInfo();
        //清空原来的试卷
        DataConstants.juan = null;
        //获取目前的问卷id
        String juanJuanId = DataConstants.juanJuanId;
        //获取当前选中的问卷
        Juan juan = null;
        String string = PrefersUtils.getString(StringConstants.questiannerPrefrenceKey);
        if(string.isEmpty()){
            ToastUtils.showMessage("缓存中没有问卷");
            return ;
        }
        JuanResponse juanResponse = new Gson().fromJson(string, JuanResponse.class);
        List<Juan> questionnaire_yes = juanResponse.getQuestionnaire_YES();
        for (int i = 0; i < questionnaire_yes.size(); i++) {
            if (questionnaire_yes.get(i).getQuestionnaireID().equals(juanJuanId)) {
                DataConstants.juan = questionnaire_yes.get(i);
                DebugLog.i(TAG , "---被选中的问卷---" + DataConstants.juan);
            }
        }
        if (DataConstants.juan != null) {
            Intent intent = new Intent(activity, JuanActivity.class);
            activity.startActivity(intent);
            intent = null;
        }else{
            ToastUtils.showMessage("您的本地当前没有该试卷，请在网络环境下下载试卷");
        }
    }


    /**
     * 开始身份证扫描
     */
    public void scanId() {

    }


    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }


}
