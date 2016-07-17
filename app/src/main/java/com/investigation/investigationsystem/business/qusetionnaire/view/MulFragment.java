package com.investigation.investigationsystem.business.qusetionnaire.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.login.bean.Ti;
import com.investigation.investigationsystem.business.qusetionnaire.adapter.MulAdapter;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/17  16:36
 * <p/>
 * 描    述 ：
 * 这是多选的问卷
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class MulFragment extends BaseTitleFragemnt {

    private RecyclerView recyclerView;
    private MulAdapter adapter;
    private static final String TAG_TI = "ti";
    private Ti ti;

    @Override
    protected int getContentViewID() {
        return R.layout.mul_fragment;
    }

    @Override
    protected void initHeadView() {
        setTitleStyle(false);
    }

    @Override
    protected void InitHeadClick() {
        return;
    }

    @Override
    protected void analyzeBundle(Bundle bundle) {
        ti = (Ti) bundle.getSerializable(TAG_TI);
    }

    @Override
    protected void onCreateByUser() {
        return;
    }

    public static MulFragment newInstance(Ti ti) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(TAG_TI, ti);
        MulFragment mulFragment = new MulFragment();
        mulFragment.setArguments(bundle);
        bundle = null;
        return mulFragment;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.juan_singerlist);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.juan_singerlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager = null;
        adapter = new MulAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setData(ti);
    }

    @Override
    protected void initClick() {


    }
}
