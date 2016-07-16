package com.investigation.investigationsystem.business.emphases.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.emphases.presenter.EmphasesPresenter;
import com.investigation.investigationsystem.common.base.BaseTitleFragemnt;
import com.investigation.investigationsystem.common.constants.DataConstants;
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

    private TextView tv_name_empdetial;
    private TextView tv_grender_empdetial;
    private TextView tv_age_empdetial;
    private TextView tv_minzu_empdetial;
    private TextView tv_idcard_empdetial;
    private TextView tv_location_empdetial;
    private TextView tv_huji_empdetial;
    private TextView tv_juzhu_empdetial;
    private TextView tv_desasse_empdetial;
    private TextView tv_pinlv_empdetial;
    private TextView tv_jianceneirong_empdetial;
    private TextView tv_jiancefangshi_empdetial;
    private TextView tv_querenren_empdetial;
    private TextView tv_querenshijian_empdetial;
    private TextView tv_morentuanduin_empdetial;

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
//        name = (TextView) rootView.findViewById(R.id.emp_detail_name);
//        name.setText(value);
        tv_name_empdetial = (TextView) rootView.findViewById(R.id.tv_name_empdetial);
        tv_grender_empdetial = (TextView) rootView.findViewById(R.id.tv_grender_empdetial);
        tv_age_empdetial = (TextView) rootView.findViewById(R.id.tv_age_empdetial);
        tv_minzu_empdetial = (TextView) rootView.findViewById(R.id.tv_minzu_empdetial);
        tv_idcard_empdetial = (TextView) rootView.findViewById(R.id.tv_idcard_empdetial);
        tv_location_empdetial = (TextView) rootView.findViewById(R.id.tv_location_empdetial);
        tv_huji_empdetial = (TextView) rootView.findViewById(R.id.tv_huji_empdetial);
        tv_juzhu_empdetial = (TextView) rootView.findViewById(R.id.tv_juzhu_empdetial);
        tv_desasse_empdetial = (TextView) rootView.findViewById(R.id.tv_desasse_empdetial);
        tv_pinlv_empdetial = (TextView) rootView.findViewById(R.id.tv_pinlv_empdetial);
        tv_jianceneirong_empdetial = (TextView) rootView.findViewById(R.id.tv_jianceneirong_empdetial);
        tv_jiancefangshi_empdetial = (TextView) rootView.findViewById(R.id.tv_jiancefangshi_empdetial);
        tv_querenren_empdetial = (TextView) rootView.findViewById(R.id.tv_querenren_empdetial);
        tv_querenshijian_empdetial = (TextView) rootView.findViewById(R.id.tv_querenshijian_empdetial);
        tv_morentuanduin_empdetial = (TextView) rootView.findViewById(R.id.tv_morentuanduin_empdetial);
        iniData();
    }

    /**
     * 初始化所有数据
     */
    public void iniData(){
        tv_name_empdetial.setText("姓名：" + DataConstants.monitoringConstants.getName());
        tv_age_empdetial.setText("年龄：" + DataConstants.monitoringConstants.getAge());
        tv_grender_empdetial.setText("性别：" + DataConstants.monitoringConstants.getFemale());
        tv_idcard_empdetial.setText("身份证号：" + DataConstants.monitoringConstants.getIDNO());
        tv_location_empdetial.setText("所在地区：" + DataConstants.emphasesArea);//通过全局变量反字段
        tv_huji_empdetial.setText("户籍地址：" + DataConstants.monitoringConstants.getAddress());
        tv_juzhu_empdetial.setText("居住地址：" + DataConstants.monitoringConstants.getAddress2());
        tv_desasse_empdetial.setText("重点监测疾病：" + DataConstants.monitoringConstants.getDisease());
        tv_pinlv_empdetial.setText("监测频率：" + DataConstants.monitoringConstants.getTutelageFreq());
        tv_jianceneirong_empdetial.setText("监测内容：" + DataConstants.monitoringConstants.getTutelageContent());
        tv_jiancefangshi_empdetial.setText("监测方式：" + DataConstants.monitoringConstants.getTutelageWay());
        tv_morentuanduin_empdetial.setText("默认团队：" + DataConstants.emphasesTeam);
        tv_querenren_empdetial.setText("确认人：" + DataConstants.monitoringConstants.getDoctor());
        tv_querenshijian_empdetial.setText("确认日期：" + DataConstants.monitoringConstants.getTime());
    }

    @Override
    protected void initClick() {


    }

}
