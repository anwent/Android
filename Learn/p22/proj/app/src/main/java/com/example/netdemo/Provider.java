package com.example.netdemo;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Provider {

    private static class BaseInfo {
        private static final String cook_base_url = "http://apis.juhe.cn/cook/query";
        private static final String cook_key = "6f76489cea4c4860d26fc96e05adb9f9";
        private static final String max_length = "20";
    }

    public static void requestCook(String menu, Callback handler) {
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder ub = HttpUrl.parse(BaseInfo.cook_base_url).newBuilder();
        ub.addQueryParameter("menu", menu);
        ub.addQueryParameter("key", BaseInfo.cook_key);
        ub.addQueryParameter("rn", BaseInfo.max_length);
        String url = ub.build().toString();
        Request req = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(req);
        call.enqueue(handler);
    }

}
