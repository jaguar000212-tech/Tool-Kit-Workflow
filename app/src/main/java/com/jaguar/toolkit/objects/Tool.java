package com.jaguar.toolkit.objects;

import androidx.appcompat.app.AppCompatActivity;

public class Tool<T extends AppCompatActivity> {
    final private String name;
    final private String description;
    final private int icon;
    final private Class<T> activity;

    public Tool(String name, String description, int icon, Class<T> activity) {
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.activity = activity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getIcon() {
        return icon;
    }

    public Class<T> getActivity() {
        return activity;
    }


}
