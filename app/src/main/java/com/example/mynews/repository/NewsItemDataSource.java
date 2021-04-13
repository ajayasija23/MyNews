package com.example.mynews.repository;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.mynews.listener.NoDataListener;
import com.example.mynews.model.NewsModel;
import com.example.mynews.util.Constants;
import com.example.mynews.web.ApiService;
import com.example.mynews.web.Webservices;

import java.util.HashMap;
import java.util.LinkedHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsItemDataSource extends PageKeyedDataSource<Integer, NewsModel.ArticlesBean> {

    private static final int fistPage=1;
    private final ApiService apiService;
    private final LinkedHashMap<String, String> map;
    private NoDataListener listener;

    public NewsItemDataSource(LinkedHashMap<String, String> map, NoDataListener listener){
        apiService= Webservices.getApiService();
        this.map=map;
        this.listener=listener;
    }
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, NewsModel.ArticlesBean> callback) {
        Call<NewsModel> call=apiService.getNews(map,fistPage);
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                listener.hideProgress();
                if (response.body()!=null){
                    if (response.body().getArticles().size()==0){
                        listener.noData();
                    }
                    else {
                        callback.onResult(response.body().getArticles(),null,fistPage+1);
                    }
                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, NewsModel.ArticlesBean> callback) {
        Call<NewsModel> call=apiService.getNews(map,params.key);
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                listener.hideProgress();
                if (response.body()!=null){
                    Integer key = (params.key > 1) ? params.key - 1 : null;
                    callback.onResult(response.body().getArticles(),key);
                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, NewsModel.ArticlesBean> callback) {
        Call<NewsModel> call=apiService.getNews(map,params.key);
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                listener.hideProgress();
                if (response.body()!=null){
                    Integer key = (response.body().getArticles().size()==20) ? params.key + 1 : null;
                    callback.onResult(response.body().getArticles(),key);
                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

            }
        });
    }
}
