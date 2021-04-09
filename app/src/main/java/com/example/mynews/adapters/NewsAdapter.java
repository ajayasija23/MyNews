package com.example.mynews.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mynews.R;
import com.example.mynews.model.NewsModel;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private List<NewsModel.ArticlesBean> data;
    private Context context;

    public NewsAdapter(List<NewsModel.ArticlesBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_news,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String url=data.get(position).getUrlToImage();
        Glide.with(context)
            .load(url)
            .placeholder(R.drawable.placeholder)
            .into(holder.ivNews);
        holder.tvSource.setText(data.get(position).getSource().getName());
        holder.tvDescription.setText(data.get(position).getDescription());
        String date=data.get(position)
                .getPublishedAt()
                .replace('T',' ')
                .replace('Z',' ');
        holder.tvPublishDate.setText(date);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

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
