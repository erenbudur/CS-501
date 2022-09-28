package com.example.w3_p3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    SeekBar celsius;
    SeekBar fahrenheit;

    TextView celValue;
    TextView fahValue;
    TextView interesting;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        celsius = (SeekBar) findViewById(R.id.celsius);
        fahrenheit = (SeekBar) findViewById(R.id.fahrenheit);
        celValue = (TextView) findViewById(R.id.celVal);
        fahValue = (TextView) findViewById(R.id.fahVal);
        interesting = (TextView) findViewById(R.id.interesting);
        Resources res = getBaseContext().getResources();

        celsius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                double celDouble = ((double)i )/10;
                double fahDouble = Math.round((celDouble*1.8 +32) *10.0) /10.0;
                fahValue.setText(Double.toString(fahDouble));
                celValue.setText(Double.toString(celDouble));
                fahrenheit.setProgress(((int)Math.round(fahDouble))  * 10 );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int val = seekBar.getProgress();
                if (val <20){
                    interesting.setText(res.getText(R.string.warm));
                }else{
                    interesting.setText(res.getText(R.string.cold));
                }

            }
        });


        fahrenheit.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                double fahDouble = ((double)i )/10;
                double celDouble =Math.round((fahDouble-32)*(5.0/9) *10.0) /10.0;



                fahValue.setText(Double.toString(fahDouble));
                if (fahDouble>32.0){
                    celValue.setText(Double.toString(celDouble));
                    celsius.setProgress(((int)Math.round(celDouble))  * 10 );
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                double fahDouble = ((double)seekBar.getProgress())/10;
                double celDouble =Math.round((fahDouble-32)*(5.0/9) *10.0) /10.0;
                if (fahDouble<32.0){
                    fahrenheit.setProgress((int)Math.round((fahDouble+32) * 10) );
                    celsius.setProgress(0);
                }

                if (celDouble <20){
                    interesting.setText(res.getText(R.string.warm));
                }else{
                    interesting.setText(res.getText(R.string.cold));
                }

            }
        });


    }
}