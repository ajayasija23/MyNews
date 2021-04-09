package com.example.mynews.web;

import com.example.mynews.util.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Webservices {
    private static ApiService apiService;
    private static Gson gson;

    public static ApiService getApiService(){
        if (apiService==null){
            //create Logging interceptor to log request data
            HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            // Create Http Client
            OkHttpClient client=
                    new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .callTimeout(2, TimeUnit.MINUTES)
                    .readTimeout(2,TimeUnit.MINUTES)
                    .build();

            //create gson object  to parse response
            gson=new GsonBuilder().setLenient().create();

            apiService=new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build().create(ApiService.class);
        }
        return apiService;
    }
}
