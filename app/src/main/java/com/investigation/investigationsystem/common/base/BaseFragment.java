package com.investigation.investigationsystem.common.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

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
 * e家子项目，所有的fragment的最内存给抽象基类
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public abstract class BaseFragment extends Fragment {

    // 跟activity对象
    protected Activity rootActivity;

    // 根视图对象
    protected View rootView;

    /**
     * 获得跟布局id
     *
     * @return
     */
    protected abstract int getLayoutID();

    /**
     * 处理传递初始化参数的方法
     *
     * @param bundle
     */
    protected abstract void analyzeBundle(Bundle bundle);

    /**
     * 用户在oncreate方法中执行自己的初始化操作
     */
    protected abstract void onCreateByUser();

    /**
     * 初始化UI控件
     */
    protected abstract void initDefaultView();

    /**
     * 初始化U控件的点击事件
     */
    protected abstract void initDefaultClick();

    /**
     * 进行用户自己的各种初始操作
     */
    protected abstract void beaginWorkByUser();

    // 在fragment挂载时设置activity对象
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.rootActivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 解析初始参数
        analyzeBundle(getArguments());
        onCreateByUser();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // 初始化U控件
        rootView = inflater.inflate(getLayoutID(), container, false);
        ButterKnife.bind(rootActivity, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDefaultView();
        // 初始化数据，并初始化点击事件，此时UI控件都是创建完毕的
        initDefaultClick();
        // 进行用户自己的各种初始操作
        beaginWorkByUser();
    }

    @Override
    public void onDestroy() {
        ButterKnife.unbind(this);
        rootView = null;
        rootActivity = null;
        super.onDestroy();
    }
}
