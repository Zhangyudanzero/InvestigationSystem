package com.investigation.investigationsystem.common.utils;

import android.os.Build;
import android.util.Log;

/**
 * 调试日志
 *
 */
public final class DebugLog {

    /**
     * 调试日志的开关，一般Debug版本中打开，便于开发人员观察日志，Release版本中关闭
     */
    public static final boolean ENABLED = true;

    /**
     * 崩溃日志
     */
    private static final String FILE_UNCAUGHT_EXCEPITON_LOG = "UncaughtException.log";

    /**
     * 网络异常日志
     */
    public static final String FILE_HTTP_EXCEPTION_LOG = "HttpException.log";

    // private static final int MAX_FILE_SIZE = 5 * 1024 * 1024; //日志最大5M

    /**
     * TAG的前缀，便于过滤
     */
    private static final String PREFIX = "AOQI_";

    private DebugLog() {
    }


    public static int v(String tag, String msg) {
        return ENABLED ? Log.v(PREFIX + tag, "" + msg) : 0;
    }

    public static int v(String tag, String msg, Throwable throwable) {
        return ENABLED ? Log.v(PREFIX + tag, msg, throwable) : 0;
    }

    public static int d(String tag, String msg) {
        //华为的这款手机只能打印information信息
        if ("GEM-703L".equals(Build.MODEL)
                || "H60-L11".equals(Build.MODEL)) {
            return i(tag, msg);
        }
        return ENABLED ? Log.d(PREFIX + tag, "" + msg) : 0;
    }

    public static int d(String tag, String msg, Throwable throwable) {
        return ENABLED ? Log.d(PREFIX + tag, msg, throwable) : 0;
    }

    public static int i(String tag, String msg) {
        return ENABLED ? Log.i(PREFIX + tag, "" + msg) : 0;
    }

    public static int i(String tag, String msg, Throwable tr) {
        return ENABLED ? Log.i(PREFIX + tag, msg, tr) : 0;
    }

    public static int w(String tag, String msg) {
        return ENABLED ? Log.w(PREFIX + tag, "" + msg) : 0;
    }

    public static int w(String tag, String msg, Throwable tr) {
        return ENABLED ? Log.w(PREFIX + tag, msg, tr) : 0;
    }

    public static int w(String tag, Throwable tr) {
        return ENABLED ? Log.w(PREFIX + tag, tr) : 0;
    }

    public static int e(String tag, String msg) {
        return ENABLED ? Log.e(PREFIX + tag, "" + msg) : 0;
    }

    public static int e(String tag, String msg, Throwable tr) {
        return ENABLED ? Log.e(PREFIX + tag, msg, tr) : 0;
    }

//    /**
//     * 保存异常堆栈信息
//     *
//     * @param e
//     * @return
//     */
//    public static String getExceptionTrace(Throwable e) {
//        if (e != null) {
//            StringWriter stringWriter = new StringWriter();
//            PrintWriter printWriter = new PrintWriter(stringWriter);
//            e.printStackTrace(printWriter);
//            return stringWriter.toString();
//        }
//        return null;
//    }

//    /**
//     * 同步保存异常堆栈信息到文件
//     */
//    public static void syncSaveFile(String fileName, String content) {
//        if (TextUtils.isEmpty(fileName) || TextUtils.isEmpty(content)) {
//            return;
//        }
//
//        File file = new File(getDebugLogDir(), fileName);
//
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(file, true);
//            fos.write(content.getBytes("utf-8"));
//            fos.write('\n');
//            fos.flush();
//        } catch (Exception ex) {
//            e("", "", ex);
//        } finally {
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException ex) {
//                    e("", "", ex);
//                }
//            }
//        }
//    }

//    /**
//     * 组装基本信息
//     */
//    public static StringBuilder getBaseInfo() {
//        Environment environment = Environment.getInstance();
//
//        StringBuilder info = new StringBuilder();
//        info.append("time = ").append(getFormatDateTime()).append("\n");
//        info.append("versionName = ").append(environment.getMyVersionName()).append("\n");
//        info.append("channelId = ").append("").append("\n");
//        info.append(environment.getAllInfo().toString()).append("\n");
//
//        return info;
//    }



//    /**
//     * 获取保存日志的路径
//     */
//    private static File getDebugLogDir() {
//        Environment environment = Environment.getInstance();
//        File debugLogDir = new File(environment.getMyDir() + "/log");
//        if (!debugLogDir.exists()) {
//            debugLogDir.mkdirs();
//        }
//        return debugLogDir;
//    }

//    /**
//     * 获取崩溃日志文件
//     */
//    public static File getUncaughtExceptionFile() {
//        return new File(getDebugLogDir(), FILE_UNCAUGHT_EXCEPITON_LOG);
//    }
//
//    /**
//     * 获取HTTP异常日志文件
//     */
//    public static File getHttpExceptionFile() {
//        return new File(getDebugLogDir(), FILE_HTTP_EXCEPTION_LOG);
//    }


//    /**
//     * 注册未捕获异常处理器
//     */
//    public static void registerUncaughtExceptionHandler(Context context) {
//        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler(
//                context));
//    }

//    /**
//     * 未捕获异常处理器
//     */
//    private static class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
//
//        private Context context;
//
//        public MyUncaughtExceptionHandler(Context context) {
//            this.context = context;
//        }
//
//        @Override
//        public void uncaughtException(Thread thread, final Throwable ex) {
//            // 使用 Toast 来显示异常信息
//            new Thread() {
//
//                @Override
//                public void run() {
//                    Looper.prepare();
//
//                    if (!new PermissionManager(null, null).hasAllPermission()) {
//                        Toast.makeText(context, "权限不足，正在重启", Toast.LENGTH_LONG).show();
//                    } else {
//                        Toast.makeText(context, "程序异常，正要退出", Toast.LENGTH_LONG).show();
//                    }
//                    Looper.loop();
//                }
//            }.start();
//
//            ThreadPoolManager.EXECUTOR.execute(new Runnable() {
//
//                @Override
//                public void run() {
//                    SystemClock.sleep(2000);
//
//                    String content = getBaseInfo().append(getExceptionTrace(ex)).toString();
//                    // 保存堆栈信息
//                    syncSaveFile(FILE_UNCAUGHT_EXCEPITON_LOG, content);
//
//                    Intent intent = new Intent(MainApplication.getInstance(), SplashActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    MainApplication.getInstance().startActivity(intent);
//                    // 杀死进程
//                    Process.killProcess(Process.myPid());
//                }
//            });
//        }
//    }
}
