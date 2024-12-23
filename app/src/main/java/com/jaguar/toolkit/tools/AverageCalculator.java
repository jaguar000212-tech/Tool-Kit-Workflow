package com.jaguar.toolkit.tools;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.jaguar.toolkit.R;

import java.util.Arrays;

public class AverageCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.tool_average_calculator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button calculateButton = findViewById(R.id.calculate);
        calculateButton.setOnClickListener(v -> {
            try {
                double[] numbers = getNumbers();
                double sum = calculateSum(numbers);
                double average = calculateAverage(numbers);
                double harmonicMean = harmonicMean(numbers);
                double geometricMean = geometricMean(numbers);
                int count = numbers.length;
                double largest = Arrays.stream(numbers).max().getAsDouble();
                double smallest = Arrays.stream(numbers).min().getAsDouble();
                TextView result = findViewById(R.id.outputText);
                result.setText(String.format("Result: %f\n\nGeometric Mean: %f\nHarmonic Mean: %f\n\nSum: %f\nCount: %d\nLargest: %f\nSmallest: %f", average, geometricMean, harmonicMean, sum, count, largest, smallest));
            } catch (NumberFormatException e) {
                TextView result = findViewById(R.id.outputText);
                result.setText("Error: Format is not correct. Separate numbers with commas.");
            }
        });

        Button clearButton = findViewById(R.id.clear);
        clearButton.setOnClickListener(v -> {
            TextView input = findViewById(R.id.inputText);
            input.setText("");
            TextView result = findViewById(R.id.outputText);
            result.setText("");
        });

        Button copyButton = findViewById(R.id.copyClp);
        copyButton.setOnClickListener(v -> {
            TextView result = findViewById(R.id.outputText);
            String text = result.getText().toString();
            android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
        });

        Button shareButton = findViewById(R.id.share);
        shareButton.setOnClickListener(v -> {
            TextView result = findViewById(R.id.outputText);
            String text = result.getText().toString();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, text);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        });
    }

    public double[] getNumbers() throws NumberFormatException {
        TextView numbers = findViewById(R.id.inputText);
        String[] numbersArray = numbers.getText().toString().split(",");
        double[] numbersDouble = new double[numbersArray.length];
        for (int i = 0; i < numbersArray.length; i++) {
            numbersDouble[i] = Double.parseDouble(numbersArray[i]);
        }
        return numbersDouble;
    }

    public double calculateSum(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    public double harmonicMean(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += 1 / number;
        }
        return numbers.length / sum;
    }

    public double geometricMean(double[] numbers) {
        double product = 1;
        for (double number : numbers) {
            product *= number;
        }
        return Math.pow(product, 1.0 / numbers.length);
    }

    public double calculateAverage(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }
}