package com.example.mynews.activities;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.browser.customtabs.CustomTabsIntent;

import com.bumptech.glide.Glide;
import com.example.mynews.R;
import com.example.mynews.databinding.ActivityNewsDetailsBinding;
import com.example.mynews.util.Constants;

public class NewsDetailsActivity extends BaseActivity implements View.OnClickListener {

    private ActivityNewsDetailsBinding binding;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewsDetailsBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        setData();
        setListerners();
    }

    private void setListerners() {
        binding.ivBack.setOnClickListener(this);
        binding.tvFullStory.setOnClickListener(this);
    }

    private void setData() {
        Intent intent=getIntent();
        try {
            url=intent.getStringExtra(Constants.URL);
            Glide.with(this)
            .load(intent.getStringExtra(Constants.IMAGE))
            .placeholder(R.drawable.placeholder)
            .into(binding.ivNews);

            binding.tvTitle.setText(intent.getStringExtra(Constants.TITLE));
            binding.tvSource.setText(intent.getStringExtra(Constants.SOURCE));
            binding.tvPublishDate.setText(intent.getStringExtra(Constants.PUBLISH_DATE));
            binding.tvDescription.setText(intent.getStringExtra(Constants.DESC));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ivBack:
                finish();
                break;
            case R.id.tvFullStory:
                showNews();
                break;
        }
    }

    private void showNews() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        int colorInt = Color.parseColor("#FF0000"); //red
        builder.setToolbarColor(colorInt);
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }
}
