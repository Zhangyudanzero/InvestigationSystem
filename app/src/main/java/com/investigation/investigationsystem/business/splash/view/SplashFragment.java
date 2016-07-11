package com.investigation.investigationsystem.business.splash.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.login.view.LoginActivity;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.BaseUtils;
import com.investigation.investigationsystem.common.utils.DebugLog;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/11  0:09
 * <p/>
 * 描    述 ：
 * 闪屏页
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class SplashFragment extends Fragment {

    private static final String TAG = StringConstants.TAG + SplashFragment.class.getName();
    private View rootView;
    private TextView tv_title;
    private Handler handler = new Handler();

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_splash, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv_title = (TextView) rootView.findViewById(R.id.splash_title);
        String title = StringConstants.TITLE_LOGIN + " V " + BaseUtils.getMyVersionCode() + " 版";
        tv_title.setText(title);
        title = null;

        long beaginTime = System.currentTimeMillis();
        // 解析数据
        BaseUtils.anacyleInitData();
        long endTime = System.currentTimeMillis();
        long time = endTime - beaginTime;
        DebugLog.d(TAG, "解析数据用时：" + time);
        if (time > StringConstants.SPLASH_TIME) {
            // 时间大于闪屏页时间,切换到登陆界面
            toggetLoginActivity();
        } else {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    toggetLoginActivity();
                }
            }, StringConstants.SPLASH_TIME - time);
        }
    }

    @Override
    public void onDestroy() {
        rootView = null;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        handler = null;
        super.onDestroy();
    }

    private void toggetLoginActivity() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        getActivity().startActivity(intent);
        intent = null;
        getActivity().finish();
    }
}
