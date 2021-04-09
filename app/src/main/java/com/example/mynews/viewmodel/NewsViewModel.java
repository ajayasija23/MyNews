package com.example.mynews.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mynews.model.NewsModel;
import com.example.mynews.repository.Repository;

import java.util.LinkedHashMap;

public class NewsViewModel extends ViewModel {
    private LiveData<NewsModel> news;
    private Repository repository;
    public NewsViewModel(){
        repository=new Repository();
        news=repository.getNews();
    }
    public void fetchNews(LinkedHashMap<String,String> map){
        repository.fetchNews(map);
    }

    public LiveData<NewsModel> getNews() {
        return news;
    }
}
