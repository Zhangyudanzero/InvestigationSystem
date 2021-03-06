package com.investigation.investigationsystem.business.questionnaireinquiry.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.investigation.investigationsystem.R;
import com.investigation.investigationsystem.business.qusetionnaire.bean.QusertionnaireResultList;

import java.util.List;

/**
 * 问卷查询内容
 *
 * Created by zero on 2016/7/3.
 */
public class InquireAdapter extends RecyclerView.Adapter<InquireAdapter.InquireViiewHolder> {

    private List<QusertionnaireResultList> list;
    private Context context;

    public InquireAdapter(List list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public InquireAdapter.InquireViiewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new InquireViiewHolder(LayoutInflater.from(context).inflate(R.layout.item_inquire_list, null));
    }

    @Override
    public void onBindViewHolder(InquireAdapter.InquireViiewHolder holder, int position) {
        holder.tv_name.setText(list.get(position).getQusertionnaireResult().getName());
        holder.tv_age.setText(list.get(position).getQusertionnaireResult().getAge()+"");
        if (list.get(position).getQusertionnaireResult().getFemale() == 1) {
            holder.tv_famle.setText("男");
        }else if (list.get(position).getQusertionnaireResult().getFemale() == 2){
            holder.tv_famle.setText("女");
        }

        holder.tv_idcard.setText(list.get(position).getQusertionnaireResult().getIdno());
        holder.tv_time.setText(list.get(position).getQusertionnaireResult().getTime());
        holder.tv_question.setText(list.get(position).getQusertionnaireResult().getQuestionnairename());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class InquireViiewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_name;
        private final TextView tv_famle;
        private final TextView tv_age;
        private final TextView tv_idcard;
        private final TextView tv_time;
        private final TextView tv_question;

        public InquireViiewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.item_inquire_tv_name);
            tv_famle = (TextView) itemView.findViewById(R.id.item_inquire_tv_famle);
            tv_age = (TextView) itemView.findViewById(R.id.item_inquire_tv_age);
            tv_idcard = (TextView) itemView.findViewById(R.id.item_inquire_tv_idcard);
            tv_time = (TextView) itemView.findViewById(R.id.item_inquire_tv_time);
            tv_question = (TextView) itemView.findViewById(R.id.item_inquire_tv_question);

        }

    }


}
