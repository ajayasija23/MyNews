package com.example.mynews.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mynews.activities.MainActivity;
import com.example.mynews.adapters.CountryAdapter;
import com.example.mynews.databinding.BottomSheetCountryBinding;
import com.example.mynews.databinding.BottomSheetSourceBinding;
import com.example.mynews.listener.BottomSheetListener;
import com.example.mynews.util.FrequentFuctions;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class CountryBottomSheetFragment extends BottomSheetDialogFragment {

    private BottomSheetCountryBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding= BottomSheetCountryBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        showCountries();
        return view;
    }

    private void showCountries() {
        List<String> countries= FrequentFuctions.getCountryNames();
        BottomSheetListener listener=((MainActivity)getActivity()).getListener();
        binding.rvCountry
            .setAdapter(new CountryAdapter(countries,getActivity(),listener));
    }

}
