package com.example.mynews.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mynews.databinding.BottomSheetSourceBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SourceBottomSheetFragment extends BottomSheetDialogFragment {

    private BottomSheetSourceBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= BottomSheetSourceBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        return view;
    }

}
