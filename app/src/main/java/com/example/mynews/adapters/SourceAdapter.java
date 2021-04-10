package com.example.mynews.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mynews.R;
import com.example.mynews.activities.NewsDetailsActivity;
import com.example.mynews.listener.BottomSheetListener;
import com.example.mynews.model.NewsModel;
import com.example.mynews.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.MyViewHolder> {
    private List<String> data;
    private Context context;
    private List<String> selectedSources;

    public SourceAdapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
        selectedSources=new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_source,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvSource.setText(data.get(position));
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!holder.checkBox.isChecked()){
                    selectedSources.remove(data.get(position));
                }
                else {
                   selectedSources.add(data.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public List<String> getSelectedSources() {
        return selectedSources;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkBox;
        private TextView tvSource;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox=itemView.findViewById(R.id.cbox);
            tvSource=itemView.findViewById(R.id.tvSourceName);
        }
    }
}
