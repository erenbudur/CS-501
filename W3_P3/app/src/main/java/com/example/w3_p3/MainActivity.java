package com.example.w3_p3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    SeekBar celsius;
    SeekBar fahrenheit;

    TextView celValue;
    TextView fahValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsius = (SeekBar) findViewById(R.id.celsius);
        fahrenheit = (SeekBar) findViewById(R.id.fahrenheit);
        celValue = (TextView) findViewById(R.id.celVal);
        fahValue = (TextView) findViewById(R.id.fahVal);


        celsius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                double celDouble = i/10;
                double fahDouble = celDouble*1.8 +32;
                fahValue.setText(Double.toString(fahDouble));
                celValue.setText(Double.toString(celDouble));
                fahrenheit.setProgress(((int)Math.round(fahDouble))  * 10 );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}