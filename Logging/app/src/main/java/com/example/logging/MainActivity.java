package com.example.logging;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    Button helloButton;
    TextView exTextView;
    EditText exEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.w("TRACKING_CALLS","Call made to onCreate");

        helloButton = (Button) findViewById(R.id.helloButton);
        exTextView =  (TextView) findViewById(R.id.exTextView);
        exEditText = (EditText) findViewById(R.id.exEditText);

        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exTextView.setText("Hello");
                exEditText.setText("Hello");
            }
        });
    }

    @Override
    protected void onStart() {

        super.onStart();
        Log.w("TRACKING_CALLS", "Call made to onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.w("TRACKING_CALLS", "Call made to onRestart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w("TRACKING_CALLS", "Call made to onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w("TRACKING_CALLS", "Call made to onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w("TRACKING_CALLS", "Call made to onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w("TRACKING_CALLS", "Call made to onDestroy");
    }
}