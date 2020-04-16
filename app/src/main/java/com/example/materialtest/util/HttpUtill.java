package com.example.materialtest.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;


// 和服务器交互（获取全国所有省市县的数据）
public class HttpUtill {
    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        // 发起一条HTTP请求只需要调用sendOkHttpRequest()方法，传入请求地址，并注册一个回调来处理服务器响应就可以了
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
