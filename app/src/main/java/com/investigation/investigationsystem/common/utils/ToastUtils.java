package com.investigation.investigationsystem.common.utils;

import android.widget.Toast;

import com.investigation.investigationsystem.MyApplication;

/**
 * ==========================================
 * <p/>
 * 版    权 ： 北京爱接力科技有限公司
 * <p/>
 * 作    者 ： iwen
 * <p/>
 * 版    本 ： 1.0
 * <p/>
 * 创建日期 ： on 2016/7/10  15:13
 * <p/>
 * 描    述 ：
 * toast提示的工具类
 * <p/>
 * <p/>
 * 修订历史 ：
 * <p/>
 * ==========================================
 */
public class ToastUtils {

    private static Toast toast;

    public static void showMessage(String message) {
        if (null == toast) {
            toast = Toast.makeText(MyApplication.getInstance().getApplicationContext(), message, Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        toast.cancel();
        toast = Toast.makeText(MyApplication.getInstance().getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
