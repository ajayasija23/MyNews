package com.example.mynews.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mynews.R;
import com.example.mynews.activities.NewsDetailsActivity;
import com.example.mynews.model.NewsModel;
import com.example.mynews.util.Constants;

public class NewsFeedAdapter extends PagedListAdapter<NewsModel.ArticlesBean,NewsFeedAdapter.MyViewHolder> {

    private Context context;
    public NewsFeedAdapter(Context context) {
        super(diffCallback);
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_news,parent,false);
        return new NewsFeedAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        NewsModel.ArticlesBean item=getItem(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, NewsDetailsActivity.class);
                intent.putExtra(Constants.IMAGE,item.getUrlToImage());
                intent.putExtra(Constants.TITLE,item.getTitle());
                intent.putExtra(Constants.SOURCE,item.getSource().getName());
                intent.putExtra(Constants.PUBLISH_DATE,item.getPublishedAt());
                intent.putExtra(Constants.DESC,item.getDescription());
                intent.putExtra(Constants.URL,item.getUrl());
                context.startActivity(intent);
            }
        });
        String url=item.getUrlToImage();
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .into(holder.ivNews);
        holder.tvSource.setText(item.getSource().getName());
        holder.tvDescription.setText(item.getDescription());
        String date=item
                .getPublishedAt()
                .replace('T',' ')
                .replace('Z',' ');
        holder.tvPublishDate.setText(date);
    }
    private static DiffUtil.ItemCallback<NewsModel.ArticlesBean> diffCallback=new DiffUtil.ItemCallback<NewsModel.ArticlesBean>() {
        @Override
        public boolean areItemsTheSame(@NonNull NewsModel.ArticlesBean oldItem, @NonNull NewsModel.ArticlesBean newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull NewsModel.ArticlesBean oldItem, @NonNull NewsModel.ArticlesBean newItem) {
            return false;
        }
    };

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivNews;
        private TextView tvSource,tvDescription,tvPublishDate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivNews=itemView.findViewById(R.id.ivNews);
            tvSource=itemView.findViewById(R.id.tvSource);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            tvPublishDate=itemView.findViewById(R.id.tvPublishDate);
        }
    }
}
