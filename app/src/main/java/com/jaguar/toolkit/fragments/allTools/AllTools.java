package com.jaguar.toolkit.fragments.allTools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jaguar.toolkit.adapters.ToolsRecyclerAdapter;
import com.jaguar.toolkit.data.ToolList;
import com.jaguar.toolkit.databinding.FragmentAllToolsBinding;
import com.jaguar.toolkit.objects.Tool;

import java.util.List;

public class AllTools extends Fragment {
    private FragmentAllToolsBinding binding;
    private List<Tool> toolList = ToolList.getTools();
    private ToolsRecyclerAdapter adapter;

    public static AllTools newInstance() {
        return new AllTools();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAllToolsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView ToolsView = binding.allToolsView;
        adapter = new ToolsRecyclerAdapter(getContext(), toolList);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        ToolsView.setLayoutManager(layoutManager);
        ToolsView.setItemAnimator(new DefaultItemAnimator());
        ToolsView.setAdapter(adapter);
    }
}