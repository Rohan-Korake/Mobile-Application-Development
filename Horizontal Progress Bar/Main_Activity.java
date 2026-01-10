package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView progressStatus;
    int progress = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        progressStatus = findViewById(R.id.progressStatus);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
        if (progress < 100)
                {
                    progress+=5;
                    progressBar.setProgress(progress);
                    progressStatus.setText(progress + "%");
                    handler.postDelayed(this, 1000);
                }
            }
        },1000);
    }
}