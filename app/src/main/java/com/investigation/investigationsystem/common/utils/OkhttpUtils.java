package com.investigation.investigationsystem.common.utils;


import android.os.Handler;
import android.os.Looper;

import com.investigation.investigationsystem.common.constants.StringConstants;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * okhttp封装方法
 * post异步
 * get异步
 * Created by Administrator on 2016/5/31.
 */
public class OkhttpUtils {

    private static final String TAG = StringConstants.TAG + OkhttpUtils.class.getName();
    private static OkhttpUtils mInstance;
    private OkHttpClient mOkHttpClient;
    private static final int SECOND = 10;//各种超时的时间限制
    private String authorization = "";
    private Handler mDelivery;
//    private BaseActivity baseActivity;
//    private ProgressDialog progressDialog;//进度圈

    private OkhttpUtils() {
        mOkHttpClient = new OkHttpClient();
        //设置连接超时请求超时
        mOkHttpClient.newBuilder().connectTimeout(SECOND, TimeUnit.SECONDS);
        mOkHttpClient.newBuilder().readTimeout(SECOND, TimeUnit.SECONDS);
        mOkHttpClient.newBuilder().writeTimeout(SECOND, TimeUnit.SECONDS);
//        this.baseActivity = baseActivity;
        mDelivery = new Handler(Looper.getMainLooper());
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static OkhttpUtils getInstance() {
        if (mInstance == null) {
            synchronized (OkhttpUtils.class) {
                if (mInstance == null) {
                    mInstance = new OkhttpUtils();
                }
            }
        }
        return mInstance;
    }

    /**
     * 异步get
     *
     * @param url
     * @param requestCallback
     */
    public void AsynGet(String url, final RequestCallback requestCallback) {
//        showprogressDialog();
        //获取用户令牌
        Request request = new Request.Builder()
                .url(url)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                processFail(requestCallback);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                dismissProgressdialog();
                if (response.code() == 200) {
                    String result = response.body().string();
                    if (!result.isEmpty()) {
                        processSuccess(result, requestCallback);
                    } else {
                        processSuccess(result, requestCallback);
                    }
                } else {//返回码不是200
//                    DebugLog.i(Constant.commentTAG , "---数据返回错误---response.code()---" + response.code());
                }
            }
        });
    }

    /**
     * 异步post 带body参数
     *
     * @param url
     * @param formBody
     * @param requestCallback
     */
    public void AsynPost(String url, FormBody formBody, final RequestCallback requestCallback) {
//        showprogressDialog();
        //获取用户令牌
        Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                processFail(requestCallback);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200) {
                    String result = response.body().string();
                    if (!result.isEmpty()) {
                        processSuccess(result, requestCallback);
                    } else {
                        processSuccess(result, requestCallback);
                    }
                }
            }
        });
    }

    /**
     * 异步post 不带参数
     *
     * @param url
     * @param requestCallback
     */
    public void AsynPostNoParams(String url, final RequestCallback requestCallback) {
//        showprogressDialog();
        //获取用户令牌
        FormBody formBody = new FormBody.Builder()
                .build();

        //request需求
        final Request request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();

        //异步执行
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                dismissProgressdialog();
                processFail(requestCallback);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                dismissProgressdialog();
                if (response.code() == 200) {
                    String result = response.body().string();

                    if (!result.isEmpty()) {
                        processSuccess(result, requestCallback);
                    } else {
                        processSuccess(result, requestCallback);
                    }
                }
            }
        });
    }

    /**
     * 异步post 传递json串
     *
     * @param url
     * @param requestCallback
     */
    public void AsynPostJson(String url, String jsonStr, final RequestCallback requestCallback) {

        DebugLog.i(TAG, StringConstants.NET_REQUESTDATA + jsonStr);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, jsonStr);
        //request需求
        final Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        DebugLog.i(TAG, StringConstants.FORMAT + "异步执行");
        //异步执行
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 连接超时
                DebugLog.i(TAG, StringConstants.NET_TIMEOUT);
                ToastUtils.showMessage(StringConstants.NET_TIMEOUT);
                processTimeOut(requestCallback);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                //获取到数据
                DebugLog.i(TAG, StringConstants.NET_GETDATA + result);
                try {
                    if (response.code() == 200) {
                        JSONObject jsonObject = new JSONObject(result);
                        String code = jsonObject.getString("result");
                        if ("1".equals(code)) {
                            // 请求成功
                            processSuccess(result, requestCallback);
                            jsonObject = null;
                            result = null;
                            code = null;
                        } else {
                            // 请求失败
                            ToastUtils.showMessage(StringConstants.NET_DATAERROR);
                            processFail(requestCallback);
                            jsonObject = null;
                            result = null;
                            code = null;
                        }
                    } else {
                        // 请求失败
                        ToastUtils.showMessage(StringConstants.NET_DATAERROR);
                        processFail(requestCallback);
                        result = null;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    // 请求失败
                    processFail(requestCallback);
                    result = null;
                }
            }
        });
    }


    /**
     * 上传图片
     */
    public void updateImage(String url, String filepath, final RequestCallback requestCallback) {

        MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
        File file = new File(filepath);
        MultipartBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("img", file.getName(), RequestBody.create(MEDIA_TYPE_PNG, file)).build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                dismissProgressdialog();
                processFail(requestCallback);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == 200) {
                    String result = response.body().string();
                    if (!result.isEmpty()) {
                        if (result != null) {
                            processSuccess(result, requestCallback);
                        }
                    } else {
                        processSuccess(result, requestCallback);
                    }
                }
            }
        });
    }

    //处理连接超时
    private void processTimeOut(final RequestCallback requestCallback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                requestCallback.onTimeOut();
            }
        });
    }

    //处理数据返回失败
    private void processFail(final RequestCallback requestCallback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                requestCallback.onError();
            }
        });
    }

    //处理数据返回成功
    private void processSuccess(final String result, final RequestCallback requestCallback) {
        mDelivery.post(new Runnable() {
            @Override
            public void run() {
                try {
                    requestCallback.onSuccess(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //异步获取数据传递的接口
    public interface RequestCallback {

        void onTimeOut();

        void onError();

        void onSuccess(String result) throws IOException;
    }


}
