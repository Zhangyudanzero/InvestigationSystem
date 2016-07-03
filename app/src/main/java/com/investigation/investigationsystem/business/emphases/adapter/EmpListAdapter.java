package com.investigation.investigationsystem.business.emphases.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.investigation.investigationsystem.R;

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

    private List<String> data;
    private EmpListAdapterClick click;

    public EmpListAdapter(List<String> data) {
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
        holder.name.setText(data.get(position));
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.onCLick(data.get(position));
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

        public TextView name;

        public ViewHold(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.emp_list_name);
        }
    }


}
