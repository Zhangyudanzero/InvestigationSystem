package com.investigation.investigationsystem.common.base;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/13  16:00
 * <p/>
 * 描    述 ：
 * recyclerView 的viewholder的抽象基类,提供根据id生成view，根据id查找控件，设置数据等
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public abstract class BaseViewHold<M, I extends IBaseAdapterClick> extends RecyclerView.ViewHolder {

    public BaseViewHold(ViewGroup parent, @LayoutRes int resId) {
        super(LayoutInflater.from(parent.getContext()).inflate(resId, parent, false));
    }

    protected <T extends View> T getView(@IdRes int viewId) {
        return (T) (itemView.findViewById(viewId));
    }

    protected abstract void setData(M data);

    protected abstract void setClick(I click, M m, int position);

}
