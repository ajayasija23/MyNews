package com.example.mynews.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.widget.SearchView;
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
import com.example.mynews.util.FrequentFuctions;
import com.example.mynews.viewmodel.NewsViewModel;
import com.google.android.material.button.MaterialButton;

import java.util.LinkedHashMap;

public class MainActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, BottomSheetListener, SearchView.OnQueryTextListener {

    private ActivityMainBinding binding;
    private NewsViewModel viewModel;
    private LinkedHashMap map;
    private BottomSheetListener listener;
    private CountryBottomSheetFragment countryBottomSheetFragment;
    private SourceBottomSheetFragment bottomsheet;
    private MaterialButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();
    }

    private void setView() {
        if (isNetworkConnected()){
            //device is connected to the internet inflate activity main
            binding= ActivityMainBinding.inflate(getLayoutInflater());
            View view=binding.getRoot();
            setContentView(view);
            listener=this;
            fetchNews();
            setListener();
        }
        else {
            //device is not connected to the internet inflate activity activity_no_internet.xml
            setContentView(R.layout.activity_no_internet);
            button=findViewById(R.id.btnTryAgain);
            button.setOnClickListener(this);
        }
    }

    private void setListener() {
        binding.spinnerSort.setOnItemSelectedListener(this);
        binding.btnFilter.setOnClickListener(this);
        binding.llCountry.setOnClickListener(this);
        binding.searchView.setOnQueryTextListener(this);
        binding.ivSearch.setOnClickListener(this);
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
                hideProgress();
                binding.searchView.clearFocus();
                if (newsModel!=null){
                    if (newsModel.getTotalResults()!=0){
                        binding.rlSort.setVisibility(View.VISIBLE);
                        binding.rvNews.setVisibility(View.VISIBLE);
                        binding.llNoresult.setVisibility(View.GONE);
                        binding.rvNews
                                .setAdapter(
                                        new NewsAdapter(newsModel.getArticles(),MainActivity.this)
                                );
                    }
                    else {
                        binding.rlSort.setVisibility(View.GONE);
                        binding.rvNews.setVisibility(View.GONE);
                        binding.llNoresult.setVisibility(View.VISIBLE);
                    }
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
            case R.id.llCountry:
                showCountryDialog();
                break;
            case R.id.ivSearch:
                onQueryTextSubmit(binding.searchView.getQuery().toString());
                break;
            case R.id.btnTryAgain:
                setView();
                break;
        }
    }

    private void showCountryDialog() {
        countryBottomSheetFragment=
                new CountryBottomSheetFragment();
        countryBottomSheetFragment.show(getSupportFragmentManager(),"Country");
    }

    private void showSourceBottomSheet() {
        bottomsheet=new SourceBottomSheetFragment();
        bottomsheet.show(getSupportFragmentManager(),"Source");
    }

    @Override
    public void onSelectSources(String sources) {
        //apply source filter
        bottomsheet.dismiss();
        if (map.containsKey("country"))
            map.remove("country");
        map.put("sources",sources);
        showProgress();
        viewModel.fetchNews(map);
    }

    @Override
    public void onSelectCountry(String country) {
        //apply country filter
        countryBottomSheetFragment.dismiss();
        binding.tvLocation.setText(country);
        map.put("country", FrequentFuctions.getCountryCodes(country));
        showProgress();
        viewModel.fetchNews(map);
    }

    public BottomSheetListener getListener() {
        return listener;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        map.put("q",query);
        if (map.containsKey("country"))
            map.remove("country");
        showProgress();
        viewModel.fetchNews(map);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.isEmpty()){
            map.put(
                    "country",
                    FrequentFuctions.getCountryCodes(binding.tvLocation.getText().toString())
            );
            if (map.containsKey("q"))
                map.remove("q");
            showProgress();
            viewModel.fetchNews(map);
        }
        return false;
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}