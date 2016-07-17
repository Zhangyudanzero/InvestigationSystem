package com.investigation.investigationsystem.business.qusetionnaire.presenter;

import com.investigation.investigationsystem.business.login.bean.JuanResponse;
import com.investigation.investigationsystem.business.login.bean.Ti;
import com.investigation.investigationsystem.business.qusetionnaire.view.EditFragment;
import com.investigation.investigationsystem.business.qusetionnaire.view.MulFragment;
import com.investigation.investigationsystem.business.qusetionnaire.view.SingerFragment;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.StringConstants;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/17  17:34
 * <p/>
 * 描    述 ：
 * 这是回答问卷页面的控制器
 * <p/>
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */

public class JuanPresenter extends BasePresenter {

    private static final String TAG = StringConstants.TAG + JuanPresenter.class.getName();
    private static JuanPresenter persenter;

    private JuanPresenter(BaseFragmentActivity rootActivity) {
        this.rootActivity = rootActivity;
    }

    public static void regist(BaseFragmentActivity rootActivity) {
        persenter = new JuanPresenter(rootActivity);
    }

    public static JuanPresenter getInstance() {
        return persenter;
    }

//    public static void startUp(Activity activity) {
//        Intent intent = new Intent(activity, QusetuinnaireActivity.class);
//        activity.startActivity(intent);
//        intent = null;
//    }

    /**
     * 切换页面
     */
    public void replaceFragment(JuanResponse response) {

        if (response == null) {
            return;
        }
        String questionType = response.getQuestionnaire_YES().get(0).getQuestionList().get(0).getQuestionType();
        if ("0".equals(questionType)) {
            replaceFragment(SingerFragment.newInstance(response.getQuestionnaire_YES().get(0).getQuestionList().get(0)), rootActivity.getFragmentViewID());
            return;
        }
        if ("1".equals(questionType)) {
            replaceFragment(MulFragment.newInstance(response.getQuestionnaire_YES().get(0).getQuestionList().get(0)), rootActivity.getFragmentViewID());
            return;
        }
        if ("2".equals(questionType)) {
            replaceFragment(EditFragment.newInstance(response.getQuestionnaire_YES().get(0).getQuestionList().get(0)), rootActivity.getFragmentViewID());
            return;
        }

    }


    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }


}
