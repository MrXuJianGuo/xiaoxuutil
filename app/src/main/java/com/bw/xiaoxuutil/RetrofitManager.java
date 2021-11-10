package com.bw.xiaoxuutil;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ProjectName: xiaoxuutil
 * @Package: com.bw.xiaoxuutil
 * @ClassName: RetrofitManagaer
 * @Description: java类作用描述写这里
 * @Author: Mr_xu
 * @CreateDate: 2021/11/10 13:22
 * @UpdateUser: Mr_xu
 * @UpdateDate: 2021/11/10 13:22
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class RetrofitManager {
    public static RetrofitManager manager;

    private RetrofitManager(){

    }

    public static RetrofitManager getInstance(){
        if(manager==null){
            manager = new RetrofitManager();
        }
        return manager;
    }

    public Retrofit getHttp(String str){
        return new Retrofit.Builder().baseUrl(str)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                .build();
    }
}
