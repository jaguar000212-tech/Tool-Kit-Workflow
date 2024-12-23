package com.jaguar.toolkit.data;

import com.jaguar.toolkit.R;
import com.jaguar.toolkit.objects.Tool;

import java.util.Arrays;
import java.util.List;

public class ToolList {
    static List<Tool> tools = Arrays.asList(new Tool[]{
            new Tool("Tool 1", "This is tool 1", R.drawable.ic_tool),
            new Tool("Tool 2", "This is tool 2", R.drawable.ic_tool),
            new Tool("Tool 3", "This is tool 3", R.drawable.ic_tool),
    });

    public static List<Tool> getTools() {
        return tools;
    }
}
