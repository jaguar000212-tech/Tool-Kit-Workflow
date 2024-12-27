package com.jaguar.toolkit.data;

import com.jaguar.toolkit.R;
import com.jaguar.toolkit.objects.Tool;
import com.jaguar.toolkit.tools.AverageCalculator;
import com.jaguar.toolkit.tools.LoanCalculator;

import java.util.Arrays;
import java.util.List;

public class ToolList {
    static private List<Tool> tools = Arrays.asList(new Tool[]{
            new Tool("Average Calculator", "Calculate average with some other interesting results.", R.mipmap.ic_tool_average, AverageCalculator.class),
            new Tool("Interest Calculator", "Calculates both simple and compound interests.", R.mipmap.ic_tool_loan, LoanCalculator.class),
    });

    public static List<Tool> getTools() {
        return tools;
    }
}
