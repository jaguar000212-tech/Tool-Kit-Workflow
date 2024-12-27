package com.jaguar.toolkit.components;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;

import com.jaguar.toolkit.databinding.CardToolBinding;

public class ToolCard {
    final private CardToolBinding binding;
    final private CardView card;
    private String description;


    public ToolCard(Context context) {
        binding = CardToolBinding.inflate(LayoutInflater.from(context));
        card = new CardView(context);
        card.setRadius(20);
        card.setCardElevation(10);
        LinearLayout.LayoutParams cardViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        card.setLayoutParams(cardViewParams);
        ViewGroup.MarginLayoutParams cardViewMarginParams = (ViewGroup.MarginLayoutParams) card.getLayoutParams();
        cardViewMarginParams.setMargins(20, 20, 20, 20);
        card.requestLayout();
        card.addView(binding.getRoot());
    }

    public ToolCard setName(String name) {
        binding.toolName.setText(name);
        return this;
    }

    public ToolCard setDescription(String description) {
        this.description = description;
        return this;
    }

    public ToolCard setIcon(int iconID) {
        binding.toolBtn.setImageResource(iconID);
        return this;
    }

    public CardView build() {
        return card;
    }
}
