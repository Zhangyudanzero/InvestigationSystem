package com.investigation.investigationsystem.business.qusetionnaire.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.investigation.investigationsystem.MyApplication;
import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.login.bean.JuanResponse;
import com.investigation.investigationsystem.business.qusetionnaire.presenter.JuanPresenter;
import com.investigation.investigationsystem.common.base.BaseFragmentActivity;
import com.investigation.investigationsystem.common.data.Data;

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
        JuanPresenter.regist(this);
        tv_title_bnumber = (TextView) findViewById(R.id.juan_title_number);
        view_title_back = findViewById(R.id.juan_title_back);
        btn_lastOne = (Button) findViewById(R.id.juan_btn_lastone);
        btn_nextOne = (Button) findViewById(R.id.juan_btn_nextone);
        btn_commit = (Button) findViewById(R.id.juan_btn_commit);
        tv_title_bnumber.setText("第一题");
    }

    @Override
    protected void analyzeIntent(Intent intent) {
        juanResponse = new Gson().fromJson(Data.getQuestion, JuanResponse.class);
        initDefaultAddFragment();
    }

    @Override
    protected void initDefaultAddFragment() {
        JuanPresenter.getInstance().replaceFragment(juanResponse);
    }

    @Override
    protected void onDestroy() {
        JuanPresenter.getInstance().onDes();
        super.onDestroy();
    }


}
