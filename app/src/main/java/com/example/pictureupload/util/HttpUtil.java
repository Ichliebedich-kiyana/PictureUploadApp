package com.example.pictureupload.util;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/*
 * 网络请求处理工具类
 *  */
public class HttpUtil {

    private static volatile HttpUtil httpUtil;
    public static String BASE_URL = "https://api-store.openguet.cn/api/member/photo";

    public static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build();
    private static final MediaType TYPE_JSON = MediaType.parse("application/json;charset=utf-8");
    private static final MediaType UPLOAD_FILE = MediaType.parse("application/octet-stream");


    public static HttpUtil getInstance() {
        if (httpUtil == null) {
            httpUtil = new HttpUtil();
        }
        return httpUtil;
    }

    public void doGet(String url, OkCallBack okCallBack) {
        Headers headers = new Headers.Builder()
                .add("appId", "aaa8b9bb0a554115bd9c873b490eb8df")
                .add("appSecret", "482206a078404db5446c9bf56175d3cb03708")
                .add("Accept", "application/json, text/plain, */*")
                .build();
        Request build = new Request.Builder()
                .url(BASE_URL + url)
                .headers(headers)
                .get()
                .build();
        doRequest(build, okCallBack);
    }

    public void doPost(String url, HashMap<String, Object> map, OkCallBack okCallBack) {
        Headers headers = new Headers.Builder()
                .add("appId", "aaa8b9bb0a554115bd9c873b490eb8df")
                .add("appSecret", "482206a078404db5446c9bf56175d3cb03708")
                .add("Accept", "application/json, text/plain, */*")
                .build();
        String json = new Gson().toJson(map);
        RequestBody requestBody = RequestBody.create(TYPE_JSON, json);
        Request build = new Request.Builder()
                .url(BASE_URL + url)
                .headers(headers)
                .post(requestBody)
                .build();
        doRequest(build, okCallBack);
    }

    public void doDelete(String url, OkCallBack okCallBack) {
        Request build = new Request.Builder().url(BASE_URL + url).delete().build();
        doRequest(build, okCallBack);
    }

    /**
     * 上传图片
     *
     * @param url        接口
     * @param imgPath    文件路径
     * @param okCallBack
     */
    public void uploadImage(String url, ArrayList<String> imgPath, OkCallBack okCallBack) {
        Headers headers = new Headers.Builder()
                .add("appId", "aaa8b9bb0a554115bd9c873b490eb8df")
                .add("appSecret", "482206a078404db5446c9bf56175d3cb03708")
                .add("Accept", "application/json, text/plain, */*")
                .build();
        //构建RequestBody对象，用于封装请求报文
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("file", file.getName(),
//                        RequestBody.create(MediaType.parse("image/*"), file))
//                .build();
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        for (String s : imgPath) {
            File file = new File(s);
            builder.addFormDataPart("fileList", file.getName(),
                    RequestBody.create(MediaType.parse("image/*"), file));
        }
        RequestBody requestBody = builder.build();
        //构建请求
        Request build = new Request.Builder()
                .url(BASE_URL + url)
                .headers(headers)
                .post(requestBody)
                .build();
        doRequest(build, okCallBack);
    }


    private void doRequest(Request request, final OkCallBack okCallBack) {
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("zzz", "onFailure: " + e.getMessage());
            }

            // 通过OkHttp的异步enqueue方式发起网络请求
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful() && response.body() != null) {
                    String string = response.body().string();
                    try {
                        JSONObject jsonObject = new JSONObject(string);
                        if (jsonObject.getInt("code") == 200) {
                            okCallBack.onSuccess(string);
                        } else {
                            okCallBack.onFail(string);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        okCallBack.onFail(e.getMessage());
                    }
                } else if (!response.isSuccessful()) {
                    okCallBack.onFail(response.body().string());
                } else {
                    okCallBack.onFail("返回为空！");
                }
            }
        });
    }

}
