package com.investigation.investigationsystem.business.update.presenter;

import android.app.Activity;
import android.content.Intent;

import com.google.gson.Gson;
import com.investigation.investigationsystem.business.suggest.view.SuggestFragment;
import com.investigation.investigationsystem.business.update.view.UpdateActivity;
import com.investigation.investigationsystem.business.update.view.UpdateFragment;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.DataConstants;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.ConstantUrl;
import com.investigation.investigationsystem.common.utils.OkhttpUtils;
import com.investigation.investigationsystem.common.utils.PrefersUtils;
import com.investigation.investigationsystem.common.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

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
    public void uploadQuestionClick() {


    }

    /**
     * 反馈信息上传点击
     */
    public void uploadFeedbackClick() {
        String feedback = PrefersUtils.getString(SuggestFragment.suggestPrefrenceKey);
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
                        PrefersUtils.putString(SuggestFragment.suggestPrefrenceKey , "");
                    }

                }
            });

        }

    }

    /**
     * 全部上传点击点击
     */
    public void uploadAllClick() {


    }

    /**
     * 获取调查问卷点击
     */
    public void updateQuestionClick() {
        //获取用户id
//        String userID = DataConstants.currentUserInfo.getUserID();
        String userID = "4e5abe17b91144b4bf858415b7a0d3d7";
        String userId = new Gson().toJson(userID);
        //提交数据内容 获取对应的数据
        String url = ConstantUrl.url + ConstantUrl.getTeamQuestionnaire;
        OkhttpUtils.getInstance().AsynPostJson(url, userId, new OkhttpUtils.RequestCallback() {
            @Override
            public void onTimeOut() {
                ToastUtils.showMessage("连接超时");
            }

            @Override
            public void onError() {
                ToastUtils.showMessage("数据提交错误");
            }

            @Override
            public void onSuccess(String result) throws IOException, JSONException {
                //获取数据以后 直接存放到sps中
                PrefersUtils.putString(StringConstants.questiannerPrefrenceKey , result);
            }
        });

    }

    /**
     * 获取重点监控点击
     */
    public void updateEmphasesClick() {
        //获取用户id
        String userID = DataConstants.currentMyUserInfo.getUserID();
        String userId = new Gson().toJson(userID);
        //提交数据内容 获取对应的数据
        String url = ConstantUrl.url + ConstantUrl.getFocusMonitoring;
        OkhttpUtils.getInstance().AsynPostJson(url, userId, new OkhttpUtils.RequestCallback() {
            @Override
            public void onTimeOut() {
                ToastUtils.showMessage("连接超时");
            }

            @Override
            public void onError() {
                ToastUtils.showMessage("数据提交错误");
            }

            @Override
            public void onSuccess(String result) throws IOException, JSONException {
                //获取数据以后 直接存放到sps中
                PrefersUtils.putString(StringConstants.emphasesPrefrenceKey , result);
            }
        });

    }

    /**
     * 更新个人数据点击
     */
    public void updateMyClick() {
        //获取用户id
        String userID = DataConstants.currentMyUserInfo.getUserID();
        String userId = new Gson().toJson(userID);
        //提交数据内容 获取对应的数据
        String url = ConstantUrl.url + ConstantUrl.getUserInfo;
        OkhttpUtils.getInstance().AsynPostJson(url, userId, new OkhttpUtils.RequestCallback() {
            @Override
            public void onTimeOut() {

            }

            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(String result) throws IOException, JSONException {
                //保存当前的数据信息
            }
        });
    }

    /**
     * 监测是否有数据变化
     */
    public void checkDataChange(){
        //获取更新数据 写一个bean
        String url = ConstantUrl.url + ConstantUrl.checkUpdate;

        
    }

    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }


}
