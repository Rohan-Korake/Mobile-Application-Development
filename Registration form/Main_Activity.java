package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText username,password,phone;

    Button button;

    RadioGroup genderGroup;

    RadioButton male,female;

    CheckBox termsCheckBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        genderGroup=findViewById(R.id.genderGroup);
        termsCheckBox=findViewById(R.id.termsCheckBox);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=username.getText().toString();
                String passWord=password.getText().toString();
                String phoneNo=phone.getText().toString();
                int selectedGender=genderGroup.getCheckedRadioButtonId();

                if (userName.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Username Required", Toast.LENGTH_SHORT).show();
                } else if (passWord.isEmpty()) {

                    Toast.makeText(MainActivity.this, "Password Required", Toast.LENGTH_SHORT).show();
                }
                else if (phoneNo.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Phone no Required", Toast.LENGTH_SHORT).show();
                }
                else if (phoneNo.length()!=10)
                {
                    Toast.makeText(MainActivity.this, "Invalid Phone no", Toast.LENGTH_SHORT).show();
                }
                else if (selectedGender==-1)
                {
                    Toast.makeText(MainActivity.this, "Select Gender", Toast.LENGTH_SHORT).show();
                }
                else if(!termsCheckBox.isChecked())
                {
                    Toast.makeText(MainActivity.this, "Accept Terms and Conditions", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}