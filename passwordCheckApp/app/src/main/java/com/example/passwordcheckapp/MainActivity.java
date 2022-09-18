package com.example.passwordcheckapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btn ;
    private EditText pass1 ;
    private EditText pass2 ;
    private TextView label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button);
        pass1 = (EditText) findViewById(R.id.passwordID);
        pass2 = (EditText) findViewById(R.id.passwordID2);
        label = (TextView) findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pass1.getText().toString().equals(pass2.getText().toString())){
                    label.setText("THANK YOU");
                }else{
                    label.setText("PASSWORDS MUST MATCH");
                }
            }
        });
    }
}