package com.investigation.investigationsystem.common.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

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
 * 创建日期 ： on  2016/6/28  15:34
 * <p/>
 * 描    述 ：
 * 这是通用嵌套 fragment 的 activity 容器基类
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public abstract class BaseFragmentActivity extends BaseActivity {

    public static final String TAG = StringConstants.TAG + BaseFragmentActivity.class.getName();
    // 全局上下文
    protected Context rootContext;

    /**
     * 该方法由具体子类去实现
     *
     * @return
     */
    @Override
    protected abstract int getContentViewID();

    /**
     * 该方法由具体子类去实现
     *
     * @return
     */
    public abstract int getFragmentViewID();

    /**
     * 设置全局上下文对象
     */
    protected abstract void setRootContent();

    /**
     * 在oncreate时加载一些需要的数据
     */
    protected abstract void initDataOnCreate();

    /**
     * 处理传递初始化参数的方法
     *
     * @param intent
     */
    protected abstract void analyzeIntent(Intent intent);

    /**
     * 初始化默认加载fragment方法
     */
    protected abstract void initDefaultAddFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 父类中已经进行了一些操作，设置状态栏颜色，加载根布局id
        super.onCreate(savedInstanceState);

        initDataOnCreate();
        // 具体的上下文对象自己去传递
        setRootContent();

        Intent intent = getIntent();
        if (null != intent) {
            analyzeIntent(intent);
        } else {
            initDefaultAddFragment();
        }
    }
}
