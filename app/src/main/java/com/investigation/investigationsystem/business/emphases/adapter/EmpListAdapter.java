package com.investigation.investigationsystem.business.emphases.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.emphases.bean.Monitoringlist;

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
 * 创建日期 ： on 2016/7/3  17:59
 * <p/>
 * 描    述 ：
 * 重点监控的列表
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class EmpListAdapter extends RecyclerView.Adapter<EmpListAdapter.ViewHold> {

    private List<Monitoringlist> data;
    private EmpListAdapterClick click;
    private OnItemClickListener onClickListener;

    public EmpListAdapter(List<Monitoringlist> data) {
        this.data = data;
    }

    public interface EmpListAdapterClick {
        void onCLick(String name);
    }

    public void setClick(EmpListAdapterClick click) {
        this.click = click;
    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHold(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emp_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHold holder, final int position) {
        holder.tv_name.setText(data.get(position).getName()+"");
        holder.tv_age.setText(data.get(position).getAge()+"");
        holder.tv_desasser.setText(data.get(position).getDisease()+"");
        holder.tv_grender.setText(data.get(position).getFemale()+"");
        holder.ll_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击跳转详情页面
                onClickListener.onItemClick(data.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder {

        public TextView tv_name;
        public TextView tv_age;
        public TextView tv_grender;
        public TextView tv_desasser;
        private final LinearLayout ll_root;

        public ViewHold(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.emp_item_tv_name);
            tv_age = (TextView) itemView.findViewById(R.id.emp_item_tv_age);
            tv_grender = (TextView) itemView.findViewById(R.id.emp_item_tv_grender);
            tv_desasser = (TextView) itemView.findViewById(R.id.emp_item_tv_desasser);
            ll_root = (LinearLayout) itemView.findViewById(R.id.emp_item_root);
        }
    }

    /**
     * 点击事件接口
     */
    public interface OnItemClickListener{
        void onItemClick(Monitoringlist monitoringlist);
    }

    /**
     * 设置点击事件
     */
    public void setOnItemClickListener(OnItemClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

}
