package com.jaguar.toolkit.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.jaguar.toolkit.R;

public class ToolCard {
    Context context;
    CardView card;
    View view;
    String name;
    String description;


    public ToolCard(Context context) {
        this.context = context;
        card = new CardView(context);
        view = LayoutInflater.from(context).inflate(R.layout.card_tool, null);
        view.setOnLongClickListener(v -> {
            Toast.makeText(context, description, Toast.LENGTH_SHORT).show();
            return true;
        });
        card.addView(view);
    }

    public ToolCard setName(String name) {
        this.name = name;
        TextView nameView = view.findViewById(R.id.tool_name);
        nameView.setText(name);
        return this;
    }

    public ToolCard setDescription(String description) {
        this.description = description;
        return this;
    }

    public ToolCard setIcon(int iconID) {
        ImageButton iconView = view.findViewById(R.id.tool_btn);
        iconView.setImageResource(iconID);
        return this;
    }

    public ToolCard setOnClickListener(View.OnClickListener listener) {
        view.setOnClickListener(listener);
        return this;
    }

    public CardView build() {
        return card;
    }
}
