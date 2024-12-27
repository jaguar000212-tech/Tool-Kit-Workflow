package com.jaguar.toolkit.fragments.favTools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jaguar.toolkit.databinding.FragmentFavouriteToolsBinding;

public class FavouriteTools extends Fragment {
    private FragmentFavouriteToolsBinding binding;

    public static FavouriteTools newInstance() {
        return new FavouriteTools();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentFavouriteToolsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

}