package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    GridLayout gridKeys ;
    TextView OutputScreen ;
    String value="";
    StringBuilder inputContent = new StringBuilder();

    boolean doubleoperator=false;
    boolean newInput=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        gridKeys = findViewById(R.id.gridKeys);
        OutputScreen =findViewById(R.id.OutputScreen);
    }

    //    Number inputs
    public void number(View view)
    {
        Button button=(Button) view;
        value=button.getText().toString();
        if (value.equals(".")) {

            String currentText = inputContent.toString();
            int lastOp = Math.max(
                    Math.max(currentText.lastIndexOf('+'), currentText.lastIndexOf('-')),
                    Math.max(currentText.lastIndexOf('x'), Math.max(currentText.lastIndexOf('/'), currentText.lastIndexOf('%')))
            );
            String lastNumber = currentText.substring(lastOp + 1);
            if (lastNumber.contains(".")) return;
            if (lastNumber.length() == 0) {
                inputContent.append("0");
            }
        }
        inputContent.append(value);
        OutputScreen.setText(inputContent);
        doubleoperator=false;
    }

    // Ac button
    public void allClear(View view)
    {
        inputContent.setLength(0);
        OutputScreen.setText("");
    }

    // Delete button
    public void delete(View view) {
        int len = inputContent.length();
        if (len > 0) {
            inputContent.deleteCharAt(len - 1);
            OutputScreen.setText(inputContent.toString());
        }
    }

    // handle operator input button
    public void operator(View view)
    {
        if(doubleoperator || inputContent.length()==0) return;
        Button button=(Button) view;
        value=button.getText().toString();
        inputContent.append(value);
        OutputScreen.setText(inputContent);
        doubleoperator=true;
    }

    private double evaluateExpression(String input) {

        java.util.Stack<Double> stack = new java.util.Stack<>();
        char sign = '+';
        double num = 0;

        boolean isDecimal = false;
        double decimalPlace = 0.1;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (Character.isDigit(ch)) {
                if (!isDecimal) {
                    num = num * 10 + (ch - '0');
                } else {
                    num = num + (ch - '0') * decimalPlace;
                    decimalPlace /= 10;
                }
            }
            else if (ch == '.') {
                isDecimal = true;
            }

            if ((!Character.isDigit(ch) && ch != '.') || i == input.length() - 1) {

                switch (sign) {
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;
                    case 'x': stack.push(stack.pop() * num); break;
                    case '/':
                        if (num == 0) throw new ArithmeticException();
                        stack.push(stack.pop() / num);
                        break;
                    case '%': stack.push(stack.pop() % num); break;
                }

                sign = ch;
                num = 0;
                isDecimal = false;
                decimalPlace = 0.1;
            }
        }

        double result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
    // calculate
    public void calculate(View view) {

        if (inputContent.length() == 0) return;

        try {
            String expression = inputContent.toString();

            double result = evaluateExpression(expression);

            OutputScreen.setText(String.valueOf(result));

            // so user can continue calculation
            inputContent.setLength(0);
            inputContent.append(result);

            doubleoperator = false;

        } catch (Exception e) {
            Toast.makeText(this, "Invalid Expression", Toast.LENGTH_SHORT).show();
        }
    }

}