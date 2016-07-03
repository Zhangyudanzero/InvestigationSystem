package com.investigation.investigationsystem.business.emphases.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.emphases.presenter.EmphasesPresenter;
import com.investigation.investigationsystem.business.update.presenter.UpdatePresenter;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;
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
 * 创建日期 ： on 2016/7/3  13:44
 * <p/>
 * 描    述 ：
 * 这是重点监控详情页面
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class EmphasesDetailFragment extends BaseTitleFragemnt {

    private TextView name;
    private String value;
    private static final String TAG_NAME = "nemp+detail_name";

    public static EmphasesDetailFragment newInstance(String name) {
        Bundle bundle = new Bundle();
        bundle.putString(TAG_NAME, name);
        EmphasesDetailFragment emphasesDetailFragment = new EmphasesDetailFragment();
        emphasesDetailFragment.setArguments(bundle);
        bundle = null;
        return emphasesDetailFragment;
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_keymonitorint_detial;
    }

    @Override
    protected void initHeadView() {
        setTitleStyle(true, false, StringConstants.TITLE_UPDATE);
    }

    @Override
    protected void InitHeadClick() {
        head_view_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmphasesPresenter.getInstance().goBack();
            }
        });
    }

    @Override
    protected void analyzeBundle(Bundle bundle) {

        if (bundle == null) {
            return;
        }
        value = bundle.getString(TAG_NAME);
    }

    @Override
    protected void onCreateByUser() {
    }

    @Override
    protected void initView() {
        name = (TextView) rootView.findViewById(R.id.emp_detail_name);
        name.setText(value);
    }

    @Override
    protected void initClick() {


    }

}
