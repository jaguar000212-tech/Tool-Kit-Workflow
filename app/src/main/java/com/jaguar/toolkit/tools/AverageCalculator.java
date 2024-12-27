package com.jaguar.toolkit.tools;

import static java.lang.String.format;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.jaguar.toolkit.R;
import com.jaguar.toolkit.databinding.ToolAverageCalculatorBinding;

import java.util.Arrays;

public class AverageCalculator extends AppCompatActivity {
    private ToolAverageCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ToolAverageCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MaterialToolbar toolbar = binding.incAppbar.materialToolbar;
        toolbar.setTitle("Average Calculator");
        toolbar.setLogo(R.mipmap.ic_tool_average);
        setSupportActionBar(toolbar);

        binding.calculate.setOnClickListener(v -> {
            TextView result = binding.outputText;
            try {
                double[] numbers = getNumbers();
                double sum = calculateSum(numbers);
                double average = calculateAverage(numbers);
                double harmonicMean = harmonicMean(numbers);
                double geometricMean = geometricMean(numbers);
                int count = numbers.length;
                double largest = Arrays.stream(numbers).max().getAsDouble();
                double smallest = Arrays.stream(numbers).min().getAsDouble();
                result.setText(format("Result: %f\n\nGeometric Mean: %f\nHarmonic Mean: %f\n\nSum: %f\nCount: %d\nLargest: %f\nSmallest: %f", average, geometricMean, harmonicMean, sum, count, largest, smallest));
            } catch (NumberFormatException e) {
                result.setText("Error: Format is not correct. Separate numbers with commas.");
            }
        });

        binding.clear.setOnClickListener(v -> {
            binding.inputText.setText("");
            binding.outputText.setText("");
        });

        binding.copyClp.setOnClickListener(v -> {
            String input = binding.inputText.getText().toString();
            String output = binding.outputText.getText().toString();
            String text = "Input: " + input +
                    "\n" + output;
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
        });

        binding.share.setOnClickListener(v -> {
            String input = binding.inputText.getText().toString();
            String output = binding.outputText.getText().toString();
            String text = "Input: " + input +
                    "\n" + output;
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, text);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        });
    }

    private double[] getNumbers() throws NumberFormatException {
        String[] numbersArray = binding.inputText.getText().toString().split(",");
        double[] numbersDouble = new double[numbersArray.length];
        for (int i = 0; i < numbersArray.length; i++) {
            numbersDouble[i] = Double.parseDouble(numbersArray[i]);
        }
        return numbersDouble;
    }

    private double calculateSum(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    private double harmonicMean(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += 1 / number;
        }
        return numbers.length / sum;
    }

    private double geometricMean(double[] numbers) {
        double product = 1;
        for (double number : numbers) {
            product *= number;
        }
        return Math.pow(product, 1.0 / numbers.length);
    }

    private double calculateAverage(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }
}