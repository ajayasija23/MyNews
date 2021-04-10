package com.example.mynews.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mynews.activities.MainActivity;
import com.example.mynews.adapters.CountryAdapter;
import com.example.mynews.adapters.SourceAdapter;
import com.example.mynews.databinding.BottomSheetSourceBinding;
import com.example.mynews.listener.BottomSheetListener;
import com.example.mynews.listener.OkListener;
import com.example.mynews.util.FrequentFuctions;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class SourceBottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    private BottomSheetSourceBinding binding;
    private SourceAdapter adapter;
    private BottomSheetListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= BottomSheetSourceBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        showSources();
        binding.btnApply.setOnClickListener(this);
        return view;
    }

    private void showSources() {
        List<String> sources=FrequentFuctions.getSourceNames();
        listener=((MainActivity)getActivity()).getListener();
        adapter=new SourceAdapter(sources,getActivity());
        binding.rvSources
                .setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        List<String> selectedSources=adapter.getSelectedSources();
        String selectedSourcesString="";
        for (String key:selectedSources){
            selectedSourcesString=selectedSourcesString+FrequentFuctions.getSourceId(key);
        }
        if (selectedSourcesString.isEmpty()){
            messageDialog("Select Atleast one source");
        }
        else {
            listener.onSelectSources(selectedSourcesString);
        }
    }

    public void messageDialog(String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setMessage(message);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss(builder);
            }
        });
        builder.show();
    }
    private void dismiss(AlertDialog.Builder builder) {
        builder.create().dismiss();
    }
}
