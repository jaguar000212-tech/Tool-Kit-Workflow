package com.jaguar.toolkit.tools;

import static java.lang.String.format;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.jaguar.toolkit.R;
import com.jaguar.toolkit.databinding.ToolLoanCalculatorBinding;

public class LoanCalculator extends AppCompatActivity {

    private ToolLoanCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ToolLoanCalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MaterialToolbar toolbar = binding.incAppbar.materialToolbar;
        toolbar.setTitle("Loan Calculator");
        toolbar.setLogo(R.mipmap.ic_tool_loan);
        setSupportActionBar(toolbar);

        binding.calcBtn.setOnClickListener(view -> {
            String principalText = binding.principalText.getText().toString();
            String rateText = binding.rateText.getText().toString();
            String timeText = binding.timeText.getText().toString();

            if (principalText.isEmpty() || rateText.isEmpty() || timeText.isEmpty()) {
                binding.resultText.setText("Required fields are empty");
                return;
            }

            try {
                double loanAmount = Double.parseDouble(principalText);
                double interestRate = Double.parseDouble(rateText);
                double loanTerm = Double.parseDouble(timeText);

                double emi = calculateInstallment(loanAmount, interestRate, loanTerm);
                String result = getResult(emi, loanTerm, loanAmount);

                binding.resultText.setText(result);
            } catch (NumberFormatException e) {
                binding.resultText.setText("Invalid input");
            }
        });

        binding.clearBtn.setOnClickListener(view -> {
            binding.principalText.setText("");
            binding.rateText.setText("");
            binding.timeText.setText("");
            binding.resultText.setText("");
        });

        binding.copyBtn.setOnClickListener(view -> {
            String result = "Principal Amount: " + binding.principalText.getText().toString() + "\n" +
                    "Rate of Interest: " + binding.rateText.getText().toString() + "%\n" +
                    "Loan Term: " + binding.timeText.getText().toString() + "Years\n" +
                    binding.resultText.getText().toString();
            if (!binding.resultText.getText().toString().isEmpty()) {
                android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(android.content.Context.CLIPBOARD_SERVICE);
                android.content.ClipData clip = android.content.ClipData.newPlainText("Loan Calculator", result);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        binding.shareBtn.setOnClickListener(view -> {
            String result = "Principal Amount: " + binding.principalText.getText().toString() + "\n" +
                    "Rate of Interest: " + binding.rateText.getText().toString() + "%\n" +
                    "Loan Term: " + binding.timeText.getText().toString() + "Years\n" +
                    binding.resultText.getText().toString();
            if (!binding.resultText.getText().toString().isEmpty()) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(android.content.Intent.ACTION_SEND);
                sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, result);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }

    private static String getResult(double emi, double loanTerm, double loanAmount) {
        double totalAmount = emi * loanTerm * 12;
        double totalInterest = totalAmount - loanAmount;
        double interestPercentage = (totalInterest / totalAmount) * 100;

        return format("Monthly Installment: %.2f\nTotal Amount Repayable: %.2f\nTotal Interest Repayable: %.2f\nInterest Percentage: %.2f%%", emi, totalAmount, totalInterest, interestPercentage);
    }

    private double calculateInstallment(double loanAmount, double interestRate, double loanTerm) {
        double monthlyInterestRate = interestRate / 100 / 12;
        double tenure = loanTerm * 12;
        double monthlyInstallment = loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenure) / (Math.pow(1 + monthlyInterestRate, tenure) - 1);
        return monthlyInstallment;
    }
}