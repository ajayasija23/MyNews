package com.example.mynews.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.R;
import com.example.mynews.listener.BottomSheetListener;
import com.example.mynews.util.FrequentFuctions;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {
    private List<String> data;
    private Context context;
    private BottomSheetListener listener;

    public CountryAdapter(List<String> data, Context context,BottomSheetListener listener) {
        this.data = data;
        this.context = context;
        this.listener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_coutry,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvSource.setText(data.get(position));
        holder.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSelectCountry(
                        data.get(position)
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private RadioButton radioButton;
        private TextView tvSource;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            radioButton =itemView.findViewById(R.id.rbCountry);
            tvSource=itemView.findViewById(R.id.tvCountryName);
        }
    }
}
