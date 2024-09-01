package com.example.pictureupload.util;

import java.io.IOException;

public interface OkCallBack {

    // 请求成功回调
    void onSuccess(String response) throws IOException;

    // 请求失败回调
    void onFail(String response);

}
