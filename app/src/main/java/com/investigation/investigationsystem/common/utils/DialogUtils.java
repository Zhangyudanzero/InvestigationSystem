package com.investigation.investigationsystem.common.utils;

import android.content.Context;

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


    public static SweetAlertDialog getloadingDialog(Context context, String text) {
        SweetAlertDialog alertDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)
                .setTitleText(text);
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        return alertDialog;
    }

}
