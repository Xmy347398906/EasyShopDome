package com.example.administrator.taoex.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2016/11/17 0017.
 */

public class EasyShopClient {
    private static EasyShopClient easyShopClient;
    private OkHttpClient okHttpClient;
    private EasyShopClient(){
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient=new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    public static EasyShopClient getEasyShopClient(){
        if (easyShopClient==null)
        {
            easyShopClient=new EasyShopClient();
        }
        return easyShopClient;
    }

}
