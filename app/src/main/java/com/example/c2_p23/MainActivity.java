package com.example.c2_p23;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        TextView light = findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = light.getCurrentTextColor();
                if (color == Color.YELLOW){
                    light.setTextColor(Color.RED);
                    light.setText("RED");
                }else if(color == Color.GREEN){
                    light.setTextColor(Color.YELLOW);
                    light.setText("YELLOW");
                }else{
                    light.setTextColor(Color.GREEN);
                    light.setText("GREEN");
                }

            }
        });

    }
}