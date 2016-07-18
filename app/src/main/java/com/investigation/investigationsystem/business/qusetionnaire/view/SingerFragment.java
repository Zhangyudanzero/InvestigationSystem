package com.investigation.investigationsystem.business.qusetionnaire.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.login.bean.Ti;
import com.investigation.investigationsystem.business.qusetionnaire.adapter.SingerAdapter;
import com.investigation.investigationsystem.business.qusetionnaire.bean.RefrushAdapterMessage;
import com.investigation.investigationsystem.business.qusetionnaire.bean.ToggleMessage;
import com.investigation.investigationsystem.business.qusetionnaire.presenter.JuanPresenter;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;
import com.investigation.investigationsystem.common.constants.StringConstants;
import com.investigation.investigationsystem.common.utils.DebugLog;
import com.labo.kaji.fragmentanimations.MoveAnimation;

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
 * 创建日期 ： on 2016/7/17  16:36
 * <p/>
 * 描    述 ：
 * 这是单选的问卷
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class SingerFragment extends BaseTitleFragemnt {

    private static final String TAG = StringConstants.TAG + SingerFragment.class.getName();
    private RecyclerView recyclerView;
    private SingerAdapter adapter;
    private static final String TAG_TI = "ti";
    private Ti ti;
    public static final String TAG_DIEECTION = "direction";
    private int direction;
    public static final int DURATION = 500;
    public static final int LEFT = -1;
    public static final int RIGHT = 1;
    private Handler handler = new Handler();

    @Override
    protected int getContentViewID() {
        return R.layout.singer_fragment;
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
        direction = bundle.getInt(TAG_DIEECTION);
    }

    @Override
    protected void onCreateByUser() {
        EventBus.getDefault().register(this);
    }

    public static SingerFragment newInstance(Ti ti, int direction) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(TAG_TI, ti);
        bundle.putInt(TAG_DIEECTION, direction);
        SingerFragment singerFragment = new SingerFragment();
        singerFragment.setArguments(bundle);
        bundle = null;
        return singerFragment;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.juan_singerlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager = null;
        adapter = new SingerAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setData(ti, JuanPresenter.getInstance().getLastResult(ti.getQuestionID()));
        adapter.setClick(new SingerAdapter.ISingerAdapterClick() {
            @Override
            public void onSelect(String id, String res) {
                JuanPresenter.getInstance().addSingleResult(id, res);
            }
        });
    }

    @Override
    protected void initClick() {


    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        switch (direction) {
            case LEFT:
                return MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION);
            case RIGHT:
                return MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION);
        }
        return null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onUserEvent(ToggleMessage message) {
        direction = message.drietion;
//        DebugLog.d(TAG, "接收到动画切换：" + direction);
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void refrushAdapter(RefrushAdapterMessage message) {
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
                adapter.notifyDataSetChanged();
//            }
//        });
        DebugLog.d(TAG, "单选题刷新数据");
    }

    @Override
    public void onDestroy() {
        DebugLog.d(TAG, "onDestroy...");
        EventBus.getDefault().unregister(this);
        ti = null;
        super.onDestroy();
    }
}
