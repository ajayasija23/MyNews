package com.example.mynews.web;

import com.example.mynews.model.NewsModel;
import com.example.mynews.util.Constants;

import java.util.LinkedHashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET(Constants.END_POINT)
    Call<NewsModel> getNews(@QueryMap LinkedHashMap<String,String> map,
                            @Query("page") Integer page);
}
