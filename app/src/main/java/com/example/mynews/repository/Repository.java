package com.example.mynews.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mynews.model.NewsModel;
import com.example.mynews.web.ApiService;
import com.example.mynews.web.Webservices;

import java.util.LinkedHashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private MutableLiveData<NewsModel> news;
    private ApiService apiService;

    public Repository(){
        apiService= Webservices.getApiService();
        news=new MutableLiveData<>();
    }

    public void fetchNews(LinkedHashMap<String, String> map){
        Call <NewsModel> call=apiService.getNews(map,1);
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                if (response.isSuccessful()){
                    news.postValue(response.body());
                }
                else {
                    news.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                news.postValue(null);
            }
        });
    }

    public LiveData<NewsModel> getNews(){
        return news;
    }
}
