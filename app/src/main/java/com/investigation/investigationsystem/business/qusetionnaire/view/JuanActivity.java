package com.investigation.investigationsystem.business.qusetionnaire.view;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.investigation.investigationsystem.MyApplication;
import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.login.bean.JuanResponse;
import com.investigation.investigationsystem.business.qusetionnaire.bean.JuanUpdateUIMessage;
import com.investigation.investigationsystem.business.qusetionnaire.presenter.JuanPresenter;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.data.Data;
import com.investigation.investigationsystem.common.utils.DebugLog;
import com.investigation.investigationsystem.common.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/15  9:37
 * <p/>
 * 描    述 ：
 * 答卷的 activity 容器
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class JuanActivity extends BaseFragmentActivity {

    private static final String TAG = StringConstants.TAG + JuanActivity.class.getName();
    // 标题中的题目号
    private TextView tv_title_bnumber;
    // 标题中的返回按钮
    private View view_title_back;
    // 按钮上一题
    private Button btn_lastOne;
    // 按钮下一题
    private Button btn_nextOne;
    // 按钮完成
    private Button btn_commit;
    private JuanResponse juanResponse;
    // 控制按钮在1秒钟内只能点一次
    private Handler handler;
    private boolean isLastCanClick = true;
    private boolean isNextCanClick = true;
    private int time = 1000;

    @Override
    protected int getContentViewID() {
        return R.layout.activity_juan;
    }

    @Override
    public int getFragmentViewID() {
        return R.id.juan_content;
    }

    @Override
    protected void setRootContent() {
        this.rootContext = MyApplication.getInstance().getApplicationContext();
    }

    @Override
    protected void onCreateByUser() {
        EventBus.getDefault().register(this);
        JuanPresenter.regist(this);
        tv_title_bnumber = (TextView) findViewById(R.id.juan_title_number);
        view_title_back = findViewById(R.id.juan_title_back);
        btn_lastOne = (Button) findViewById(R.id.juan_btn_lastone);
        btn_nextOne = (Button) findViewById(R.id.juan_btn_nextone);
        btn_commit = (Button) findViewById(R.id.juan_btn_commit);
        tv_title_bnumber.setText("第一题");

        handler = new Handler();
        btn_lastOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isLastCanClick) {
                    ToastUtils.showMessage("您点的太快了，请稍等一下");
                    return;
                }
                isLastCanClick = false;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isLastCanClick = true;
                    }
                }, time);
                JuanPresenter.getInstance().lastOne();
            }
        });

        btn_nextOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isNextCanClick) {
                    ToastUtils.showMessage("您点的太快了，请稍等一下");
                    return;
                }
                isNextCanClick = false;
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isNextCanClick = true;
                    }
                }, time);
                JuanPresenter.getInstance().nextOne();
            }
        });

        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JuanPresenter.getInstance().commit();
            }
        });
    }

    @Override
    protected void analyzeIntent(Intent intent) {
        juanResponse = new Gson().fromJson(Data.getQuestion, JuanResponse.class);
        JuanPresenter.getInstance().setData(juanResponse.getQuestionnaire_YES().get(0));
        initDefaultAddFragment();
    }

    @Override
    protected void initDefaultAddFragment() {
        JuanPresenter.getInstance().addFristFaragment();
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void updateUIEvent(JuanUpdateUIMessage message) {
        int function = message.functionl;
        tv_title_bnumber.setText("第" + message.titlename + "题");
        DebugLog.d(TAG, "接收到数据指令:" + function);
        if (function == -1) {
            // 隐藏上一题按钮，显示下一页按钮，隐藏提交按钮
            btn_lastOne.setVisibility(View.GONE);
            btn_nextOne.setVisibility(View.VISIBLE);
            btn_commit.setVisibility(View.GONE);
            return;
        }
        if (function == 1) {
            // 显示上一题按钮，显示下一页按钮，隐藏提交按钮
            btn_lastOne.setVisibility(View.VISIBLE);
            btn_nextOne.setVisibility(View.VISIBLE);
            btn_commit.setVisibility(View.GONE);
            return;
        }
        if (function == -2) {
            // 隐藏下一题按钮，显示提交按钮，显示上一题按钮
            btn_nextOne.setVisibility(View.GONE);
            btn_lastOne.setVisibility(View.VISIBLE);
            btn_commit.setVisibility(View.VISIBLE);
            return;
        }
        if (function == 2) {
            // 显示下一页按钮，隐藏提交按钮，显示上一题按钮
            btn_nextOne.setVisibility(View.VISIBLE);
            btn_lastOne.setVisibility(View.VISIBLE);
            btn_commit.setVisibility(View.GONE);
            return;
        }
    }

    @Override
    protected void onDestroy() {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        handler = null;
        EventBus.getDefault().unregister(this);
        JuanPresenter.getInstance().onDes();
        super.onDestroy();
    }


}
