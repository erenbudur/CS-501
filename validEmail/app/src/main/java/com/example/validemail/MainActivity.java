package com.example.validemail;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText email;
    private TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        email = (EditText) findViewById(R.id.email);
        label = (TextView) findViewById(R.id.textView);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().contains("@")) {
                    label.setText("VALID");
                    label.setTextColor(Color.GREEN);
                } else {
                    label.setText("INVALID");
                    label.setTextColor(Color.RED);
                }
            }
        });

    }
}