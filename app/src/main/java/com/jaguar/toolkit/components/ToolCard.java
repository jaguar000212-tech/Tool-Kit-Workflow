package com.jaguar.toolkit.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
        card.setRadius(20);
        card.setCardElevation(10);
        LinearLayout.LayoutParams cardViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        card.setLayoutParams(cardViewParams);
        ViewGroup.MarginLayoutParams cardViewMarginParams = (ViewGroup.MarginLayoutParams) card.getLayoutParams();
        cardViewMarginParams.setMargins(20, 20, 20, 20);
        card.requestLayout();
        view = LayoutInflater.from(context).inflate(R.layout.card_tool, null);
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

    public CardView build() {
        return card;
    }
}
