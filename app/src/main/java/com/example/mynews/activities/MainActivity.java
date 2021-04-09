package com.example.mynews.activities;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mynews.adapters.NewsAdapter;
import com.example.mynews.databinding.ActivityMainBinding;
import com.example.mynews.model.NewsModel;
import com.example.mynews.util.Constants;
import com.example.mynews.viewmodel.NewsViewModel;

import java.util.LinkedHashMap;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    private NewsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        fetchNews();
    }

    private void fetchNews() {
        showProgress();
        viewModel= ViewModelProviders.of(this).get(NewsViewModel.class);
        LinkedHashMap map=new LinkedHashMap();
        map.put("apiKey", Constants.API_KEY);
        map.put("country","in");
        viewModel.fetchNews(map);
        viewModel.getNews().observe(this, new Observer<NewsModel>() {
            @Override
            public void onChanged(NewsModel newsModel) {
                hideProgress();
                if (newsModel!=null){
                    binding.rvNews
                        .setAdapter(
                            new NewsAdapter(newsModel.getArticles(),MainActivity.this)
                        );
                }
            }
        });
    }
}