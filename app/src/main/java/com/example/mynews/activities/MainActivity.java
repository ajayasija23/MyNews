package com.example.mynews.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mynews.R;
import com.example.mynews.adapters.NewsAdapter;
import com.example.mynews.databinding.ActivityMainBinding;
import com.example.mynews.fragment.CountryBottomSheetFragment;
import com.example.mynews.fragment.SourceBottomSheetFragment;
import com.example.mynews.listener.BottomSheetListener;
import com.example.mynews.model.NewsModel;
import com.example.mynews.util.Constants;
import com.example.mynews.viewmodel.NewsViewModel;

import java.util.LinkedHashMap;

public class MainActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, BottomSheetListener {

    private ActivityMainBinding binding;
    private NewsViewModel viewModel;
    private LinkedHashMap map;
    private BottomSheetListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        listener=this;
        fetchNews();
        setListener();
    }

    private void setListener() {
        binding.spinnerSort.setOnItemSelectedListener(this);
        binding.btnFilter.setOnClickListener(this);
        binding.tvLocation.setOnClickListener(this);
    }

    private void fetchNews() {
        showProgress();
        viewModel= ViewModelProviders.of(this).get(NewsViewModel.class);
        map=new LinkedHashMap();
        map.put("apiKey", Constants.API_KEY);
        map.put("country","in");
        viewModel.fetchNews(map);
        viewModel.getNews().observe(this, new Observer<NewsModel>() {
            @Override
            public void onChanged(NewsModel newsModel) {
                if (newsModel!=null){
                    hideProgress();
                    binding.rvNews
                        .setAdapter(
                            new NewsAdapter(newsModel.getArticles(),MainActivity.this)
                        );
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        map.put("sortBy",parent.getSelectedItem().toString().toLowerCase());
        showProgress();
        viewModel.fetchNews(map);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFilter:
                showSourceBottomSheet();
                break;
            case R.id.tvLocation:
                showCountryDialog();
                break;
        }
    }

    private void showCountryDialog() {
        CountryBottomSheetFragment countryBottomSheetFragment=
                new CountryBottomSheetFragment();
        countryBottomSheetFragment.show(getSupportFragmentManager(),"Country");
    }

    private void showSourceBottomSheet() {
        SourceBottomSheetFragment bottomsheet=new SourceBottomSheetFragment();
        bottomsheet.show(getSupportFragmentManager(),"Source");
    }

    @Override
    public void onSelectSources(String sources) {
        //apply source filter
    }

    @Override
    public void onSelectCountry(String county) {
        //apply country filter
    }

    public BottomSheetListener getListener() {
        return listener;
    }
}