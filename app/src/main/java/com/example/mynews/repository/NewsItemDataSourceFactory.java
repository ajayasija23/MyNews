package com.example.mynews.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.mynews.model.NewsModel;

import java.util.LinkedHashMap;

public class NewsItemDataSourceFactory extends DataSource.Factory {
    private final LinkedHashMap<String, String> map;
    private MutableLiveData<PageKeyedDataSource<Integer, NewsModel.ArticlesBean>> itemLiveDataSource
            =new MutableLiveData<>();

    public NewsItemDataSourceFactory(LinkedHashMap<String, String> map) {
        this.map=map;
    }

    @NonNull
    @Override
    public DataSource create() {
        NewsItemDataSource itemDataSource = new NewsItemDataSource(map);
        itemLiveDataSource.postValue(itemDataSource);
        return itemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, NewsModel.ArticlesBean>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }
}
