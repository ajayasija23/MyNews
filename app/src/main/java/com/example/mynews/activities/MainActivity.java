package com.example.mynews.activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;

import com.example.mynews.R;
import com.example.mynews.adapters.NewsAdapter;
import com.example.mynews.adapters.NewsFeedAdapter;
import com.example.mynews.databinding.ActivityMainBinding;
import com.example.mynews.fragment.CountryBottomSheetFragment;
import com.example.mynews.fragment.SourceBottomSheetFragment;
import com.example.mynews.listener.BottomSheetListener;
import com.example.mynews.listener.NoDataListener;
import com.example.mynews.model.NewsModel;
import com.example.mynews.util.Constants;
import com.example.mynews.util.FrequentFuctions;
import com.example.mynews.viewmodel.NewsFeedViewModel;
import com.example.mynews.viewmodel.NewsViewModel;
import com.google.android.material.button.MaterialButton;

import java.util.LinkedHashMap;

public class MainActivity extends BaseActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener, BottomSheetListener, SearchView.OnQueryTextListener, NoDataListener {

    private ActivityMainBinding binding;
    private NewsFeedViewModel viewModel;
    private LinkedHashMap<String,String> map;
    private BottomSheetListener listener;
    private CountryBottomSheetFragment countryBottomSheetFragment;
    private SourceBottomSheetFragment bottomsheet;
    private MaterialButton button;
    private NewsFeedAdapter adapter;

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
            viewModel=ViewModelProviders.of(this).get(NewsFeedViewModel.class);
            showProgress();
            viewModel.init(this);
            setObserver();
            initializeNews();
            setListener();
        }
        else {
            //device is not connected to the internet inflate activity activity_no_internet.xml
            setContentView(R.layout.activity_no_internet);
            button=findViewById(R.id.btnTryAgain);
            button.setOnClickListener(this);
        }
    }

    private void setObserver() {
        viewModel.getArticlesPagedList().observe(this, new Observer<PagedList<NewsModel.ArticlesBean>>() {
            @Override
            public void onChanged(PagedList<NewsModel.ArticlesBean> articlesBeans) {
                binding.llNoresult.setVisibility(View.GONE);
                binding.rlSort.setVisibility(View.VISIBLE);
                binding.rvNews.setVisibility(View.VISIBLE);
                binding.searchView.clearFocus();
                adapter.submitList(articlesBeans);
            }
        });
    }

    private void initializeNews() {
        //initializing news
        adapter=new NewsFeedAdapter(this);
        binding.rvNews.setAdapter(adapter);
    }

    private void setListener() {
        binding.spinnerSort.setOnItemSelectedListener(this);
        binding.btnFilter.setOnClickListener(this);
        binding.llCountry.setOnClickListener(this);
        binding.searchView.setOnQueryTextListener(this);
        binding.ivSearch.setOnClickListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

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
        bottomsheet.dismiss();
        map=new LinkedHashMap<>();
        map.put("apiKey",Constants.API_KEY);
        map.put("sources",sources);
        showProgress();
        viewModel.changeMap(map,this);
        setObserver();
    }

    @Override
    public void onSelectCountry(String country) {
        //apply country filter
        countryBottomSheetFragment.dismiss();
        map=new LinkedHashMap<>();
        binding.tvLocation.setText(country);
        map.put("country",FrequentFuctions.getCountryCodes(country));
        map.put("apiKey",Constants.API_KEY);
        showProgress();
        viewModel.changeMap(map,this);
        setObserver();
    }

    public BottomSheetListener getListener() {
        return listener;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        map=new LinkedHashMap<>();
        map.put("q",query);
        map.put("apiKey",Constants.API_KEY);
        showProgress();
        viewModel.changeMap(map,this);
        setObserver();
       return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.isEmpty()){
            map=new LinkedHashMap<>();
            map.put("country",FrequentFuctions.getCountryCodes(binding.tvLocation.getText().toString()));
            map.put("apiKey",Constants.API_KEY);
            showProgress();
            viewModel.changeMap(map,this);
            setObserver();
        }
        return false;
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    @Override
    public void noData() {
        binding.llNoresult.setVisibility(View.VISIBLE);
        binding.rlSort.setVisibility(View.GONE);
        binding.rvNews.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        super.hideProgress();
    }
}