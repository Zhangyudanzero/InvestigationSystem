package com.investigation.investigationsystem.common.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.investigation.investigationsystem.R;
import com.zhy.android.percent.support.PercentRelativeLayout;

import butterknife.Bind;


/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on  2016/6/28  15:34
 * <p/>
 * 描    述 ：
 * 带标题的通用 fragment 抽象基类
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public abstract class BaseTitleFragemnt extends BaseFragment {

    // 内容视图
    @Bind(R.id.fragmenr_base_view_content)
    protected PercentRelativeLayout view_content;

    /**
     * 头布局UI控件
     */
    @Bind(R.id.fragmenr_base_head_left)
    protected View head_view_left;
    @Bind(R.id.fragmenr_base_head_right)
    protected View head_view_right;
    @Bind(R.id.fragmenr_base_head_title)
    protected TextView head_tv_title;
    @Bind(R.id.fragmenr_base_head_right_image)
    protected TextView head_text_right;

    // 设置头布局的样式显示
    protected abstract void initHeadView();

    // 设置头布局相关的点击事件
    protected abstract void InitHeadClick();

    /**
     * 返回的视图的ID,方法留给子类实现
     */
    protected abstract int getContentViewID();

    /**
     * 加载内容视图布局
     */
    private void attachContentView() {
        LayoutInflater layoutInflater = LayoutInflater.from(rootActivity);
        PercentRelativeLayout.LayoutParams la = null;
        if (getContentViewID() != 0) {
            la = new PercentRelativeLayout.LayoutParams(PercentRelativeLayout.LayoutParams.MATCH_PARENT, PercentRelativeLayout.LayoutParams.MATCH_PARENT);
            view_content.addView(layoutInflater.inflate(getContentViewID(), null), la);
        }
        layoutInflater = null;
        la = null;
    }

    /**
     * 留给子类实现
     *
     * @param bundle
     */
    @Override
    protected abstract void analyzeBundle(Bundle bundle);

    /**
     * 初始化用户自己的UI控件和点击事件
     */
    protected abstract void initView();

    protected abstract void initClick();

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_base_title;
    }

    @Override
    protected void initDefaultView() {

        // 添加架几种加载状态视图布局
        attachContentView();
        // 初始化用户自己的UI控件
        initView();
    }

    @Override
    protected void initDefaultClick() {

        // 设置头布局相关的点击事件
        InitHeadClick();
        // 初始化用户自己的UI控件的点击事件
        initClick();
    }

    @Override
    protected void onActivityCreatedByUser() {
        // 设置头布局的样式显示
        initHeadView();
    }

    // 设置标题栏显示样式和数据的
    protected void setTitleStyle(boolean leftShow, boolean rightShow, String title) {
        // 不显示标题栏右边图标时，图片资源id传什么都行
        head_view_left.setVisibility(leftShow ? View.VISIBLE : View.GONE);
        head_view_right.setVisibility(rightShow ? View.VISIBLE : View.GONE);
        head_tv_title.setText((TextUtils.isEmpty(title) ? "" : title));
    }

}
