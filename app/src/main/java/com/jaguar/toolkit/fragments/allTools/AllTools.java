package com.jaguar.toolkit.fragments.allTools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jaguar.toolkit.R;
import com.jaguar.toolkit.adapters.ToolsRecyclerAdapter;
import com.jaguar.toolkit.data.ToolList;
import com.jaguar.toolkit.objects.Tool;

import java.util.List;

public class AllTools extends Fragment {
    public List<Tool> toolList = ToolList.getTools();
    ToolsRecyclerAdapter adapter;

    public static AllTools newInstance() {
        return new AllTools();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_tools, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView ToolsView = view.findViewById(R.id.allToolsView);
        adapter = new ToolsRecyclerAdapter(getContext(), toolList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        ToolsView.setLayoutManager(layoutManager);
        ToolsView.setItemAnimator(new DefaultItemAnimator());
        ToolsView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayout.VERTICAL));
        ToolsView.setAdapter(adapter);
    }
}