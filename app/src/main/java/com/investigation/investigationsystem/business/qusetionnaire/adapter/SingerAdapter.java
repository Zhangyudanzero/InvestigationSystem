package com.investigation.investigationsystem.business.qusetionnaire.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.login.bean.Ti;
import com.investigation.investigationsystem.business.login.bean.TiOption;
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
 * 创建日期 ： on 2016/7/17  20:40
 * <p/>
 * 描    述 ：
 * 单选按钮适配器
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class SingerAdapter extends RecyclerView.Adapter<SingerAdapter.ViewHold> {

    private Ti ti;
    private List<TiOption> data;

    public void setData(Ti ti) {
        this.ti = ti;
        this.data = ti.getQuestionOption_list();
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SingerAdapter.ViewHold(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_singer, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHold holder, int position) {

        holder.button.setText(data.get(position).getOptionContent());
    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder {

        public RadioButton button;

        public ViewHold(View itemView) {
            super(itemView);
            button = (RadioButton) itemView.findViewById(R.id.mul_check_singer);
        }
    }


}
