package com.example.mynews.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.mynews.listener.NoDataListener;
import com.example.mynews.model.NewsModel;
import com.example.mynews.repository.NewsItemDataSourceFactory;
import com.example.mynews.util.Constants;

import java.util.LinkedHashMap;

public class NewsFeedViewModel extends ViewModel {
    private LinkedHashMap<String,String> initialMap;
    private  NewsItemDataSourceFactory factory;
    private LiveData<PagedList<NewsModel.ArticlesBean>> articlesPagedList;
    private LiveData<PageKeyedDataSource<Integer, NewsModel.ArticlesBean>> liveArticles;

    public void init(NoDataListener listener){
        initialMap=new LinkedHashMap<>();
        initialMap.put("apiKey", Constants.API_KEY);
        initialMap.put("country", "in");
        factory =new NewsItemDataSourceFactory(initialMap,listener);
        liveArticles=factory.getItemLiveDataSource();
        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(20)
                        .build();
        articlesPagedList=(new LivePagedListBuilder(factory,config)).build();
    }
    public void changeMap(LinkedHashMap<String,String> map,NoDataListener listener){
        factory =new NewsItemDataSourceFactory(map, listener);
        liveArticles=factory.getItemLiveDataSource();
        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(20)
                        .build();
        articlesPagedList=(new LivePagedListBuilder(factory,config)).build();
    }

    public LiveData<PagedList<NewsModel.ArticlesBean>> getArticlesPagedList() {
        return articlesPagedList;
    }
}
