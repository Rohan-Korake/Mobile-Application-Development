package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
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

        CheckBox reading = findViewById(R.id.reading);
        CheckBox writing = findViewById(R.id.writing);
        CheckBox coding = findViewById(R.id.coding);
        CheckBox gaming = findViewById(R.id.gaming);
        TextView output = findViewById(R.id.output);
        Button reset = findViewById(R.id.reset);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counter=0;
              String result="Selected Hobbies are";

                if (reading.isChecked()) {
                    counter++;
                  result += "Reading ";
                }
                if (writing.isChecked()) {
                    counter++;
                    result += "Writing  ";
                }
                if (coding.isChecked()) {
                    counter++;
                    result += "Coding  ";
                }
                if (gaming.isChecked()) {
                    counter++;
                    result += "Gaming ";
                }
                if(!reading.isChecked() && !writing.isChecked() && !coding.isChecked() && !gaming.isChecked())
                {
                    result += "none ";
                }
                output.setText("Total select checkbox is "+result +"and "+counter+" checkBox selected");
            }
        });


    }
}