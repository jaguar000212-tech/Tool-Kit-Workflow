package com.jaguar.toolkit.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.jaguar.toolkit.R;
import com.jaguar.toolkit.components.ToolCard;
import com.jaguar.toolkit.objects.Tool;

import java.util.List;

public class ToolsRecyclerAdapter extends RecyclerView.Adapter<ToolsRecyclerAdapter.ViewHolder> {
    private List<Tool> toolsList;

    public ToolsRecyclerAdapter(Context context, List<Tool> toolsList) {
        this.toolsList = toolsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ToolCard toolCard = new ToolCard(parent.getContext());
        CardView ToolCard = toolCard.build();
        return new ViewHolder(ToolCard);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tool tool = toolsList.get(position);
        holder.toolName.setText(tool.getName());
        holder.toolBtn.setImageResource(tool.getIcon());
        holder.setTool(tool);
    }

    @Override
    public int getItemCount() {
        return toolsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView toolName;
        final ImageButton toolBtn;
        public Tool tool;

        public ViewHolder(View itemView) {
            super(itemView);
            toolName = itemView.findViewById(R.id.tool_name);
            toolBtn = itemView.findViewById(R.id.tool_btn);
            toolBtn.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), tool.getActivity());
                itemView.getContext().startActivity(intent);
            });
            toolBtn.setOnLongClickListener(v -> {
                Toast.makeText(itemView.getContext(), tool.getDescription(), Toast.LENGTH_SHORT).show();
                return true;
            });
        }

        public void setTool(Tool tool) {
            this.tool = tool;
        }
    }
}
