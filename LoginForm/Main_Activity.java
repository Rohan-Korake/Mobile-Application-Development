package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button loginbutton;
    RadioGroup gender;
    ProgressBar progressBar;

    CheckBox remeberMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        loginbutton=findViewById(R.id.loginbutton);
        gender=findViewById(R.id.gender);
        progressBar=findViewById(R.id.progressBar);
        remeberMe=findViewById(R.id.rememberMe);
        progressBar.setVisibility(View.GONE);

        remeberMe.setOnCheckedChangeListener((buttonView,isChecked)->{
        if (isChecked){
            Toast.makeText(this, "Checkbox Checked", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Checkbox UnChecked", Toast.LENGTH_SHORT).show();
        }
        });

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectGender=gender.getCheckedRadioButtonId();
                String name=username.getText().toString();
                String pass = password.getText().toString();

                if (name.isEmpty() )
                {
                    Toast.makeText(MainActivity.this, "Please enter username", Toast.LENGTH_SHORT).show();
                }
                else if (pass.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                }
                else if (selectGender == -1)
                {
                    Toast.makeText(MainActivity.this, "Please select gender", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    progressBar.setVisibility(View.VISIBLE);
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(MainActivity.this, "Logged in successful", Toast.LENGTH_SHORT).show();
                        }
                    }, 4000);

                }
            }
        });
    }
}