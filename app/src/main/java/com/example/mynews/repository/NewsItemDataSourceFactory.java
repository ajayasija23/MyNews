package com.example.mynews.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.mynews.listener.NoDataListener;
import com.example.mynews.model.NewsModel;

import java.util.LinkedHashMap;

public class NewsItemDataSourceFactory extends DataSource.Factory {
    private final LinkedHashMap<String, String> map;
    private final NoDataListener listener;
    private MutableLiveData<PageKeyedDataSource<Integer, NewsModel.ArticlesBean>> itemLiveDataSource
            =new MutableLiveData<>();

    public NewsItemDataSourceFactory(LinkedHashMap<String, String> map, NoDataListener listener) {
        this.map=map;
        this.listener=listener;
    }

    @NonNull
    @Override
    public DataSource create() {
        NewsItemDataSource itemDataSource = new NewsItemDataSource(map,listener);
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public LiveData<PageKeyedDataSource<Integer, NewsModel.ArticlesBean>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
