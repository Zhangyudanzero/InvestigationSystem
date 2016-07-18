package com.investigation.investigationsystem.business.qusetionnaire.adapter;

import android.nfc.Tag;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.login.bean.Ti;
import com.investigation.investigationsystem.business.login.bean.TiOption;
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
 * 创建日期 ： on 2016/7/17  20:40
 * <p/>
 * 描    述 ：
 * 多选按钮适配器
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class MulAdapter extends RecyclerView.Adapter<MulAdapter.ViewHold> {

    private static final String TAG = StringConstants.TAG + MulAdapter.class.getName();
    // 用户上一次选择的结果
    private List<String> res;
    private Ti ti;
    private List<TiOption> data;
    private IMulAdapterClick click;

    public interface IMulAdapterClick {

        void onSelect(String id, String res);

        void onRemove(String id, String res);
    }

    public void setData(Ti ti, List<String> res) {
        this.ti = ti;
        this.res = res;
        this.data = ti.getQuestionOption_list();
        this.notifyDataSetChanged();
    }

    public void setClick(IMulAdapterClick click) {
        this.click = click;
    }

    @Override
    public ViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MulAdapter.ViewHold(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mul, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHold holder, final int position) {
        holder.button.setText(data.get(position).getOptionContent());
        holder.button.setChecked(false);
        // 遍历上一次的结果，设置多选项目的选中状态
        if (res != null && res.size() > 0) {
            DebugLog.d(TAG, "上次结果:" + res.toString());
            int size = res.size();
            for (int i = 0; i < size; i++) {
                if (ti.getQuestionOption_list().get(position).getOptionContent().equals(res.get(i))) {
                    // 上一次用户选这个了
                    holder.button.setChecked(true);
                }
            }
        } else {
            DebugLog.d(TAG, "上次结果，没有");
        }

        if (click != null) {
            holder.button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        // 用户选择了
                        click.onSelect(ti.getQuestionID(), ti.getQuestionOption_list().get(position).getOptionContent());
                    } else {
                        // 用户取消了
                        click.onRemove(ti.getQuestionID(), ti.getQuestionOption_list().get(position).getOptionContent());
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    public class ViewHold extends RecyclerView.ViewHolder {

        public CheckBox button;

        public ViewHold(View itemView) {
            super(itemView);
            button = (CheckBox) itemView.findViewById(R.id.mul_check_mul);
        }
    }


}
