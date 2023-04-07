package com.androidwavelength.calculatorv1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private String currentOperation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.ResultText);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        currentOperation += button.getText().toString();
        resultText.setText(currentOperation);
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        currentOperation += " " + button.getText().toString() + " ";
        resultText.setText(currentOperation);
    }

    public void onEqualsClick(View view) {
        double result = calculateResult();
        currentOperation = Double.toString(result);
        resultText.setText(currentOperation);
    }

    public void onClearClick(View view) {
        currentOperation = "";
        resultText.setText("");
    }

    private double calculateResult() {
        String[] parts = currentOperation.split(" ");
        double num1 = Double.parseDouble(parts[0]);
        String operator = parts[1];
        double num2 = Double.parseDouble(parts[2]);
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "%":
                result = num1 % num2;
        }

        return result;
    }
}
