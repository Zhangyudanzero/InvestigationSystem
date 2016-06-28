package com.investigation.investigationsystem.common.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.common.utils.BaseUtils;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/6/28  15:07
 * <p/>
 * 描    述 ：
 * 这是所有 activity 容器的基类
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * 返回跟布局id
     *
     * @return
     */
    protected abstract int getContentViewID();

    /**
     * 返回键事件监听，这里是通用处理方法,有贴的处理方法，可以重新该方法
     */
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            // 回退栈中没有fragment操作记录，关闭该activity页面
            finish();
            return;
        } else {
            super.onBackPressed();
            return;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 设置状态栏颜色
        BaseUtils.setStateBarColor(R.color.main_blue, this);
        setContentView(getContentViewID());
    }


}
