package com.investigation.investigationsystem.business.emphases.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.emphases.adapter.EmpListAdapter;
import com.investigation.investigationsystem.business.emphases.presenter.EmphasesPresenter;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.DebugLog;

import java.util.List;

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
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class EmphasesFragment extends BaseTitleFragemnt {

    private static final String TAG = StringConstants.TAG + EmphasesFragment.class.getName();
    private EmpListAdapter adapter;
    private List<String> data;
    private RecyclerView recyclerView;
    private Spinner spinner_area;
    private Spinner spinner_team;
    private Button btn_search;

    public static EmphasesFragment newInstance() {
        return new EmphasesFragment();
    }

    @Override
    protected int getContentViewID() {
        return R.layout.fragment_keymonitoring;
    }

    @Override
    protected void initHeadView() {
        setTitleStyle(true, false, StringConstants.TITLE_EMPHASES);
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
        return;
    }

    @Override
    protected void onCreateByUser() {

    }

    @Override
    protected void initView() {

        DebugLog.i(TAG  , "---初始化控件---");
        spinner_area = (Spinner) rootView.findViewById(R.id.emphases_spinner_area);
        spinner_team = (Spinner) rootView.findViewById(R.id.emphases_spinner_team);
        btn_search = (Button) rootView.findViewById(R.id.emphases_btn_search);

//        data = new ArrayList<>();
//        data.add("123");
//        data.add("234");
//        data.add("345");
//        data.add("456");
//        data.add("567");
//        data.add("678");
//        data.add("789");
//        data.add("909");

        recyclerView = (RecyclerView) rootView.findViewById(R.id.emphases_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
//        linearLayoutManager = null;
//        adapter = new EmpListAdapter(data);
//        adapter.setClick(new EmpListAdapter.EmpListAdapterClick() {
//            @Override
//            public void onCLick(String name) {
//                EmphasesPresenter.getInstance().startUpDetailFragment(name);
//            }
//        });
//        recyclerView.setAdapter(adapter);
        DebugLog.i(TAG  , "---初始化调用fg方法---");
        EmphasesPresenter.getInstance().getEmphasesTeamInfo(spinner_team , spinner_area
                , btn_search , recyclerView);
    }

    @Override
    protected void initClick() {

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            EmphasesPresenter.getInstance().setCurrentFragment(this);
        }
    }
}
