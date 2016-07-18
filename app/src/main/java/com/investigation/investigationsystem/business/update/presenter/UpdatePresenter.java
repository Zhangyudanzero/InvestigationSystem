package com.investigation.investigationsystem.business.update.presenter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.investigation.investigationsystem.business.emphases.bean.emphases;
import com.investigation.investigationsystem.business.login.bean.JuanResponse;
import com.investigation.investigationsystem.business.login.bean.MyUserInfo;
import com.investigation.investigationsystem.business.login.bean.UserData;
import com.investigation.investigationsystem.business.update.bean.Updata;
import com.investigation.investigationsystem.business.update.bean.UpdateResult;
import com.investigation.investigationsystem.business.update.bean.UserId;
import com.investigation.investigationsystem.business.update.view.UpdateActivity;
import com.investigation.investigationsystem.business.update.view.UpdateFragment;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.DataConstants;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.BaseUtils;
import com.investigation.investigationsystem.common.utils.ConstantUrl;
import com.investigation.investigationsystem.common.utils.DebugLog;
import com.investigation.investigationsystem.common.utils.OkhttpUtils;
import com.investigation.investigationsystem.common.utils.PrefersUtils;
import com.investigation.investigationsystem.common.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

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
public class UpdatePresenter extends BasePresenter {

    private static final String TAG = StringConstants.TAG + UpdatePresenter.class.getName();
    private static UpdatePresenter persenter;
    //是否显示小红点
    private boolean isUserName = false;//是否有新用户信息
    private boolean isQuestionnair = false;//是否有最新问卷
    private boolean isEmphases = false;//是否有最新的重点监测
    private boolean isSuggest = false;//是否有意见建议
    private boolean isAnswer = false;//是否问卷答案


    private UpdatePresenter(BaseFragmentActivity rootActivity) {
        this.rootActivity = rootActivity;
    }

    public static void regist(BaseFragmentActivity rootActivity) {
        persenter = new UpdatePresenter(rootActivity);
    }

    public static UpdatePresenter getInstance() {
        return persenter;
    }

    public static void startUp(Activity activity) {
        Intent intent = new Intent(activity, UpdateActivity.class);
        activity.startActivity(intent);
        intent = null;
    }

    /**
     * 加载默认的 fragment 页面
     */
    public void addDefaultFragment() {
        replaceFragment(UpdateFragment.newInstance(), rootActivity.getFragmentViewID());
    }

    /**
     * 问卷上传点击
     */
    public void uploadQuestionClick(final ImageView iv_questionnier) {


    }

    /**
     * 反馈信息上传点击
     */
    public void uploadFeedbackClick(final ImageView iv_feedback) {
        String feedback = PrefersUtils.getString(StringConstants.feedbackPrefrenceKey);
        if (!feedback.isEmpty()) {

            String url = ConstantUrl.url + ConstantUrl.saveFeedBack;
            OkhttpUtils.getInstance().AsynPostJson(url, feedback, new OkhttpUtils.RequestCallback() {
                @Override
                public void onTimeOut() {
                    ToastUtils.showMessage("连接超时");
                }

                @Override
                public void onError() {
                    ToastUtils.showMessage("数据上传错误");
                }

                @Override
                public void onSuccess(String result) throws IOException, JSONException {

                    //如果获取成功 清空意见建议
                    JSONObject jsonObject = new JSONObject(result);
                    String code = jsonObject.getString("result");
                    if ("1".equals(code)) {
                        PrefersUtils.putString(StringConstants.feedbackPrefrenceKey, "");
                        iv_feedback.setVisibility(View.GONE);
                        isSuggest = false;
                    }
                }
            });

        }else{
            ToastUtils.showMessage("你没有需要上传的反馈信息");
        }

    }

    /**
     * 全部上传点击点击
     */
    public void uploadAllClick(final ImageView iv_feedback , final ImageView iv_questionnier) {
        uploadFeedbackClick(iv_feedback);
        uploadQuestionClick(iv_questionnier);
    }

    /**
     * 获取调查问卷点击
     */
    public void updateQuestionClick(final ImageView iv_questionnair) {
        //获取用户id
        String userID = DataConstants.currentMyUserInfo.getUserID();
        UserId userIdz = new UserId(userID);
        String userIdjson = new Gson().toJson(userIdz);
        //提交数据内容 获取对应的数据
        if ( isUpdate() ) {

            String url = ConstantUrl.url + ConstantUrl.getTeamQuestionnaire;
            OkhttpUtils.getInstance().AsynPostJson(url, userIdjson, new OkhttpUtils.RequestCallback() {
                @Override
                public void onTimeOut() {
                    ToastUtils.showMessage("连接超时");
                }

                @Override
                public void onError() {
                    ToastUtils.showMessage("数据获取错误");
                }

                @Override
                public void onSuccess(String result) throws IOException, JSONException {
                    //获取数据以后 直接存放到sps中 覆盖原来的数据
                    ToastUtils.showMessage("获取所有调查问卷成功");
                    PrefersUtils.putString(StringConstants.questiannerPrefrenceKey, result);
                    iv_questionnair.setVisibility(View.GONE);
                }
            });

        }else{
            ToastUtils.showMessage("您还有没有上传的数据，请先上传");
        }

    }

    /**
     * 获取重点监控点击
     */
    public void updateEmphasesClick(final ImageView iv_emphases) {
        //获取用户id
        String userID = DataConstants.currentMyUserInfo.getUserID();
        UserId userIdz = new UserId(userID);
        String userIdjson = new Gson().toJson(userIdz);
        //提交数据内容 获取对应的数据
        if ( isUpdate() ) {

            String url = ConstantUrl.url + ConstantUrl.getFocusMonitoring;
            OkhttpUtils.getInstance().AsynPostJson(url, userIdjson , new OkhttpUtils.RequestCallback() {
                @Override
                public void onTimeOut() {
                    ToastUtils.showMessage("连接超时");
                }

                @Override
                public void onError() {
                    ToastUtils.showMessage("数据获取错误");
                }

                @Override
                public void onSuccess(String result) throws IOException, JSONException {
                    //获取数据以后 直接存放到sps中
                    //保存当前的数据信息
                    iv_emphases.setVisibility(View.GONE);
                    ToastUtils.showMessage("重点监测数据获取成功");
                    PrefersUtils.putString(StringConstants.emphasesPrefrenceKey , result);

                }
            });

        }else{
            ToastUtils.showMessage("您还有没有上传的数据，请先上传");
        }

    }

    /**
     * 更新个人数据点击
     */
    public void updateMyClick(ImageView iv_userinfo) {
        //获取用户id
        String userID = DataConstants.currentMyUserInfo.getUserID();
        UserId userIdz = new UserId(userID);
        String userIdjson = new Gson().toJson(userIdz);
        //提交数据内容 获取对应的数据
        if ( isUpdate() ) {//判断hi否还有没有上传的数据

            String url = ConstantUrl.url + ConstantUrl.getUserInfo;
            OkhttpUtils.getInstance().AsynPostJson(url, userIdjson, new OkhttpUtils.RequestCallback() {
                @Override
                public void onTimeOut() {

                }

                @Override
                public void onError() {

                }

                @Override
                public void onSuccess(String result) throws IOException, JSONException {
                    ToastUtils.showMessage("个人信息数据更新成功");
                    //把用户信息添加到本地和缓存数据里面
                    MyUserInfo myUserInfo = new Gson().fromJson(result, MyUserInfo.class);
                    DataConstants.currentMyUserInfo = myUserInfo;
                    // 判断该用户数据是否添加入用户登录缓存信息列表，若没有添加进入，若有，更新改用户下数据
                    if (DataConstants.userInfos == null) {
                        DataConstants.userInfos = new UserData();
                    }
                    if (DataConstants.userInfos.getData() == null) {
                        DataConstants.userInfos.setData(new HashMap<String, MyUserInfo>());
                    }
                    DataConstants.userInfos.getData().remove(myUserInfo.getAccount());
                    DataConstants.userInfos.getData().put(myUserInfo.getAccount(), myUserInfo);
                    PrefersUtils.putString(PrefersUtils.TAG_USERINFO, new Gson().toJson(DataConstants.userInfos));

                }
            });

        }else{
            ToastUtils.showMessage("您还有没有上传的数据，请先上传");
        }

    }

    /**
     * 监测是否有数据变化
     */
    public void checkDataChange(ImageView iv_answer, ImageView iv_feedback, ImageView iv_all,
                                final ImageView iv_getquestion, final ImageView iv_emphases, final ImageView iv_userinfo) {

        String time = "";
        String time2 = "";
        String time3 = "";
        DebugLog.i(TAG , "---反馈信息---" + PrefersUtils.getString(StringConstants.feedbackPrefrenceKey));
        //反馈信息上传
        if (!PrefersUtils.getString(StringConstants.feedbackPrefrenceKey).isEmpty()) {
            iv_feedback.setVisibility(View.VISIBLE);
            isSuggest = true;
        }
        //问卷答案上传
        if (!PrefersUtils.getString(StringConstants.answerPrefrenceKey).isEmpty()) {
            iv_answer.setVisibility(View.VISIBLE);
            isQuestionnair = true;
        }

        //调查问卷时间获取 如果本地没有存放数据 则直接显示小红点
        if (!PrefersUtils.getString(StringConstants.questiannerPrefrenceKey).isEmpty()) {
            String string = PrefersUtils.getString(StringConstants.questiannerPrefrenceKey);
            JuanResponse juanResponse = new Gson().fromJson(string, JuanResponse.class);
            time2 = juanResponse.getUpdateTime();
        } else {
            iv_getquestion.setVisibility(View.VISIBLE);
        }
        //重点监测对象时间获取 如果本地没有存放数据 则直接显示小红点
        if (!PrefersUtils.getString(StringConstants.emphasesPrefrenceKey).isEmpty()) {
            String string = PrefersUtils.getString(StringConstants.emphasesPrefrenceKey);
            emphases emphases = new Gson().fromJson(string, emphases.class);
            time3 = emphases.getUpdateTime();
        } else {
            iv_emphases.setVisibility(View.VISIBLE);
        }
        //用户信息时间获取 如果本地没有存放数据 则直接显示小红点
        if (!PrefersUtils.getString(StringConstants.emphasesPrefrenceKey).isEmpty()) {
            time = DataConstants.currentMyUserInfo.getUpdateTime();
            DebugLog.i(TAG , "---DataConstants.currentMyUserInfo---" + DataConstants.currentMyUserInfo.toString());
        } else {
            iv_userinfo.setVisibility(View.VISIBLE);
        }
        //用户id获取
        String userID = DataConstants.currentMyUserInfo.getUserID();
        //获取更新数据 写一个bean
        Updata updata = new Updata(userID, time, time2, time3);
        String updataJson = new Gson().toJson(updata);
        String url = ConstantUrl.url + ConstantUrl.checkUpdate;
        if (BaseUtils.isNetworkAvailable()) {

            OkhttpUtils.getInstance().AsynPostJson(url, updataJson, new OkhttpUtils.RequestCallback() {
                @Override
                public void onTimeOut() {
                    ToastUtils.showMessage("连接超时");
                }

                @Override
                public void onError() {
                    ToastUtils.showMessage("连接错误，请检查网络");
                }

                @Override
                public void onSuccess(String result) throws IOException, JSONException {
                    UpdateResult updateResult = new Gson().fromJson(result, UpdateResult.class);
                    if (updateResult.getQuestionnaireUpdate() == 1) {
                        iv_getquestion.setVisibility(View.VISIBLE);
                    }
                    if (updateResult.getMonitorUpdate() == 1) {
                        iv_emphases.setVisibility(View.VISIBLE);
                    }
                    if (updateResult.getUserInfoUpdate() == 1) {
                        iv_userinfo.setVisibility(View.VISIBLE);
                    }
                }
            });


        }

    }

    /**
     * 先上传再获取判断
     */
    public boolean isUpdate(){
        if (!isQuestionnair && !isSuggest) {
            return true;
        }
        return false;
    }

    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }


}
