package com.investigation.investigationsystem.common.utils;

import android.content.Context;

import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/11  22:57
 * <p/>
 * 描    述 ：
 * 对话框工具，提供各种全局使用和定制的对话框l
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class DialogUtils {

    // 对话框点击接口
    public static interface OnClick {

        // 确认点击
        public void okClick();
    }

    /**
     * 获取等待对话框
     *
     * @param context
     * @param text
     * @return
     */
    public static SweetAlertDialog getloadingDialog(Context context, String text) {
        SweetAlertDialog alertDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)
                .setTitleText(text);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        return alertDialog;
    }

    /**
     * 获取带确认嗯哼却小按钮的对话框
     *
     * @param context
     * @param title
     * @param onClick
     * @return
     */
    public static SweetAlertDialog getOkAndNoDialog(Context context, String title, final OnClick onClick) {

        SweetAlertDialog alertDialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)
                .setConfirmText("  确定  ")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(final SweetAlertDialog sweetAlertDialog) {
                        // 执行确认的点击事件
                        onClick.okClick();
                    }
                })
                .setCancelText("  取消  ")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                    }
                });

        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);

        return alertDialog;
    }


}
