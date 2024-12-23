package com.jaguar.toolkit.data;

import com.jaguar.toolkit.R;
import com.jaguar.toolkit.objects.Tool;
import com.jaguar.toolkit.tools.AverageCalculator;

import java.util.Arrays;
import java.util.List;

public class ToolList {
    static List<Tool> tools = Arrays.asList(new Tool[]{
            new Tool("Average Calculator", "Calculate average with some other interesting results.", R.mipmap.ic_tool_average, AverageCalculator.class),
            new Tool("Tool 2", "This is tool 2", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 3", "This is tool 3", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 4", "This is tool 4", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 5", "This is tool 5", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 6", "This is tool 6", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 7", "This is tool 7", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 8", "This is tool 8", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 9", "This is tool 9", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 10", "This is tool 10", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 11", "This is tool 11", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 12", "This is tool 12", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 13", "This is tool 13", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 14", "This is tool 14", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 15", "This is tool 15", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 16", "This is tool 16", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 17", "This is tool 17", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 18", "This is tool 18", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 19", "This is tool 19", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 20", "This is tool 20", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 21", "This is tool 21", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 22", "This is tool 22", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 23", "This is tool 23", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 24", "This is tool 24", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
            new Tool("Tool 25", "This is tool 25", R.mipmap.ic_logo_monochrome, AverageCalculator.class),
    });

    public static List<Tool> getTools() {
        return tools;
    }
}
