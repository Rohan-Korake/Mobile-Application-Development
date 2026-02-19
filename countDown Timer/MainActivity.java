package com.example.myapplication;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button start, reset;
    TextView status, timerDisplay;

    EditText userInput;
    long inputTime;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput=findViewById(R.id.userInput);
        start = findViewById(R.id.start);
        reset = findViewById(R.id.reset);

        status = findViewById(R.id.status);
        timerDisplay = findViewById(R.id.timerDisplay);

        start.setOnClickListener(v -> startTimer());
        reset.setOnClickListener(v -> resetTimer());
    }

    public void startTimer() {
        String value = userInput.getText().toString().trim();
        if (!value.isEmpty()) {
            inputTime = Long.parseLong(value) * 1000;
        }

        timer = new CountDownTimer(inputTime, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                inputTime = millisUntilFinished;
                long seconds = millisUntilFinished / 1000;
                timerDisplay.setText(String.format("%02d", seconds));
                status.setText("Running...");
            }

            @Override
            public void onFinish() {
                timerDisplay.setText("00");
                status.setText("Time's Up!");
            }
        }.start();
    }

    public void resetTimer() {
        if (timer != null) {
            timer.cancel();
        }
        timerDisplay.setText("00");
        status.setText("Timer Reset");
        userInput.setText("");
    }
}