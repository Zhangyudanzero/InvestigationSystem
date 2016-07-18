package com.investigation.investigationsystem.business.qusetionnaire.presenter;

import com.investigation.investigationsystem.business.login.bean.Juan;
import com.investigation.investigationsystem.business.login.bean.Ti;
import com.investigation.investigationsystem.business.qusetionnaire.bean.JuanUpdateUIMessage;
import com.investigation.investigationsystem.business.qusetionnaire.bean.ToggleMessage;
import com.investigation.investigationsystem.business.qusetionnaire.view.EditFragment;
import com.investigation.investigationsystem.business.qusetionnaire.view.MulFragment;
import com.investigation.investigationsystem.business.qusetionnaire.view.SingerFragment;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.base.BasePresenter;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.DebugLog;
import com.investigation.investigationsystem.common.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    private TreeMap<String, List<String>> result;

    /**
     * 页码控制
     */
    private int current = 0;
    private Juan juan;

    private JuanPresenter(BaseFragmentActivity rootActivity) {
        this.rootActivity = rootActivity;

    }

    public static void regist(BaseFragmentActivity rootActivity) {
        persenter = new JuanPresenter(rootActivity);
    }

    public static JuanPresenter getInstance() {
        return persenter;
    }

    /**
     * 设置数据
     *
     * @param juan
     */
    public void setData(Juan juan) {
        this.juan = juan;
    }

//    public static void startUp(Activity activity) {
//        Intent intent = new Intent(activity, QusetuinnaireActivity.class);
//        activity.startActivity(intent);
//        intent = null;
//    }

    /**
     * 加载第一个页面
     */
    public void addFristFaragment() {
        replaceFragment(juan.getQuestionList().get(current), -2);
    }

    /**
     * 切换页面
     */
    public void replaceFragment(Ti ti, int dri) {

        if (ti == null) {
            return;
        }
        String questionType = ti.getQuestionType();
        if ("0".equals(questionType)) {
            replaceFragment(SingerFragment.newInstance(ti, dri), rootActivity.getFragmentViewID());
            return;
        }
        if ("1".equals(questionType)) {
            replaceFragment(MulFragment.newInstance(ti, dri), rootActivity.getFragmentViewID());
            return;
        }
        if ("2".equals(questionType)) {
            replaceFragment(EditFragment.newInstance(ti, dri), rootActivity.getFragmentViewID());
            return;
        }
    }

    /**
     * 切换到上一页
     */
    public void lastOne() {

        if (current <= 0) {
            // 没有上一页了
            ToastUtils.showMessage("没有上一页了");
            return;
        }
        current--;
        EventBus.getDefault().post(new ToggleMessage(1));
        replaceFragment(juan.getQuestionList().get(current), 1);
        if (current <= 0) {
            //判断是不是第一页,是的话隐藏上一题按钮
            EventBus.getDefault().post(new JuanUpdateUIMessage(-1, juan.getQuestionList().get(current).getQuestionNO()));
        } else {
            // 不是的话显示上一页按钮
            EventBus.getDefault().post(new JuanUpdateUIMessage(1, juan.getQuestionList().get(current).getQuestionNO()));
        }
    }

    /**
     * 切换到下一页
     */
    public void nextOne() {

        if (current >= (juan.getQuestionList().size() - 1)) {
            // 没有上一页了
            ToastUtils.showMessage("没有下一页了");
            return;
        }
        current++;
        EventBus.getDefault().post(new ToggleMessage(-1));
        replaceFragment(juan.getQuestionList().get(current), -1);
        if (current >= (juan.getQuestionList().size() - 1)) {
            //判断是不是最后一页,是的话隐藏下一题按钮，显示提交按钮
            EventBus.getDefault().post(new JuanUpdateUIMessage(-2, juan.getQuestionList().get(current).getQuestionNO()));
        } else {
            // 不是的话显示下一页按钮，隐藏提交按钮
            EventBus.getDefault().post(new JuanUpdateUIMessage(2, juan.getQuestionList().get(current).getQuestionNO()));
        }
    }

    /**
     * 提交数据
     */
    public void commit() {
        DebugLog.d(TAG, "用户的结果集==" + (result == null));
        ToastUtils.showMessage("用户的结果集==" + result.toString());
        Iterator<Map.Entry<String, List<String>>> iterator = result.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> next = iterator.next();
            DebugLog.d(TAG, "用户的结果集,id:" + next.getKey() + ",答案：" + next.getValue());
        }
    }

    /**
     * 添加结果
     *
     * @param id  题目编号
     * @param res 题目答案
     */
    public void addResult(String id, String res) {
        if (result == null) {
            result = new TreeMap<>();
        }
        if (result.get(id) == null) {
            result.put(id, new ArrayList<String>());
        }
        result.get(id).add(res);
        DebugLog.d(TAG, "添加用户选择结果：" + result.toString());
    }

    /**
     * 删除结果
     *
     * @param id
     * @param res
     */
    public void delectResult(String id, String res) {
        if (result == null) {
            result = new TreeMap<>();
        }
        if (result.get(id) == null) {
            result.put(id, new ArrayList<String>());
        }
        result.get(id).remove(res);
        DebugLog.d(TAG, "添加用户选择结果：" + result.toString());
    }

    /**
     * 添加，修改填空题结果
     *
     * @param id
     * @param res
     */
    public void addSingleResult(String id, String res) {
        if (result == null) {
            result = new TreeMap<>();
        }
        if (result.get(id) == null) {
            result.put(id, new ArrayList<String>());
        }
        if (result.get(id).size() == 0) {
            result.get(id).add(res);
        } else {
            result.get(id).remove(0);
            result.get(id).add(res);
        }
        DebugLog.d(TAG, "添加用户写入结果：" + result.toString());
    }

    /**
     * 拿到上一次填写的结果
     *
     * @param id
     * @return
     */
    public List<String> getLastResult(String id) {
        if (result == null) {
            return null;
        }
        return result.get(id);
    }


    /**
     * 销毁，回收资源
     */
    public void onDes() {
        persenter = null;
    }


}
