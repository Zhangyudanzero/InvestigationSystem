package com.investigation.investigationsystem.common.base;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
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
 * 创建日期 ： on 2016/7/13  11:12
 * <p/>
 * 描    述 ：
 * RecyclerView adapter 的抽象基类，M 是数据的泛型，H 是viewhold的泛型
 * <p/>
 * <p/>
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public abstract class BaseAdapter<M, I extends IBaseAdapterClick, H extends BaseViewHold<M, I>> extends RecyclerView.Adapter<H> {

    protected List<M> data;
    protected I click;

    @Override
    public void onBindViewHolder(final H holder, int position) {
        holder.setData(data.get(position));
        holder.setClick(click, data.get(position), position);
    }

    @Override
    public int getItemCount() {
        if (data == null) {
            return 0;
        }
        return data.size();
    }

    protected void setClick(I i) {
        this.click = i;
    }

    protected void setData(List<M> data) {
        if (data == null) {
            this.data = new ArrayList<>();
            return;
        }
        this.data = data;
        this.notifyDataSetChanged();
    }

    protected void addData(List<M> data) {
        if (data == null) {
            this.data = data;
            return;
        }
        this.data.addAll(data);
        this.notifyDataSetChanged();
    }

    protected void addData(M m) {
        if (data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(m);
        this.notifyDataSetChanged();
    }

    protected void clean() {
        if (data == null) {
            data = new ArrayList<>();
        }
        data.clear();
        this.notifyDataSetChanged();
    }

    protected void remove(int position) {
        if (data == null) {
            data = new ArrayList<>();
        }
        data.remove(position);
        this.notifyDataSetChanged();
    }

    protected void remove(M m) {
        if (data == null) {
            data = new ArrayList<>();
        }
        data.remove(m);
        this.notifyDataSetChanged();
    }

}
