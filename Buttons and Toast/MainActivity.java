package com.example.exp2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button normalButton = findViewById(R.id.normalButton);
        ImageButton imageButton = findViewById(R.id.imageButton);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
          TextView textview = findViewById(R.id.textview);

        normalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Normal Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Image Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        toggleButton.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean isCheked) {
                        if (isCheked)
                        {
                            Toast.makeText(MainActivity.this, "Toggle Button On", Toast.LENGTH_SHORT).show();
                            textview.setText("Toggle Button ON!");
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Toggle Button Off", Toast.LENGTH_SHORT).show();
                             textview.setText("Toggle Button OFF!");
                        }
                    }
                }
        );
    }
}