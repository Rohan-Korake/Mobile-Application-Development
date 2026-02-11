package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText inputTemp,inputMoney;
    TextView outputTemp,outputMoney;

    Button fahrenheit,celsius,inr,usd;

    String value;
    double celsiusValue,fahrenheitValue,usdValue,inrValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inputTemp=findViewById(R.id.inputTemp);
        inputMoney=findViewById(R.id.inputMoney);

        outputTemp=findViewById(R.id.outputTemp);
        outputMoney=findViewById(R.id.outputMoney);

        fahrenheit=findViewById(R.id.fahrenheit);
        celsius=findViewById(R.id.celsius);
        inr=findViewById(R.id.inr);
        usd=findViewById(R.id.usd);

        fahrenheit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value= inputTemp.getText().toString();
                if (!value.isEmpty())
                { try{
                     celsiusValue=Double.parseDouble(value);
                     fahrenheitValue=(celsiusValue * 9/5)+32;
                    outputTemp.setText("Celsius to Fahrenheit : "+String.format("%.2f",fahrenheitValue));
                } catch (NumberFormatException e) {
                    outputTemp.setText("Invalid input");
                }
                }
            }
        });

        celsius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value= inputTemp.getText().toString();
                if (!value.isEmpty()) {
                    try{
                     fahrenheitValue=Double.parseDouble(value);
                     celsiusValue=(fahrenheitValue - 32) * 5/9;
                    outputTemp.setText("Fahrenheit to Celsius : "+String.format("%.2f",celsiusValue));
                } catch (NumberFormatException e) {
                        outputTemp.setText("Invalid input");
                }
                }

            }
        });

        inr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value=inputMoney.getText().toString();
                if (!value.isEmpty())
                { try{
                    inrValue=Double.parseDouble(value);
                    usdValue = inrValue /83;
                    outputMoney.setText("US Dollars to Indian Rupees : "+String.format("%.2f", usdValue));
                } catch (NumberFormatException e) {
                    outputMoney.setText("Invalid input");
                }}
            }
        });

        usd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value=inputMoney.getText().toString();
                if (!value.isEmpty())
                { try{
                    usdValue=Double.parseDouble(value);
                    inrValue = usdValue * 83;
                    outputMoney.setText("Indian Rupees to US Dollars : "+String.format("%.2f", inrValue));
                } catch (NumberFormatException e) {
                    outputMoney.setText("Invalid input");
                }}
            }
        });
    }

}