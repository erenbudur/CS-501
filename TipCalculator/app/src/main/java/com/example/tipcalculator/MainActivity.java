package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    SeekBar tipSeekBar;
    EditText enterAmount;
    TextView tipPercent;
    TextView tipLabel;
    TextView totalLabel;
    TextView tipAmount;
    TextView totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipSeekBar = (SeekBar) findViewById(R.id.tipSeekBar);
        enterAmount = (EditText) findViewById(R.id.enterAmount);
        tipPercent = (TextView) findViewById(R.id.tipPercent);
        tipLabel = (TextView) findViewById(R.id.tipLabel);
        totalLabel = (TextView) findViewById(R.id.totalLabel);
        tipAmount = (TextView) findViewById(R.id.tipAmount);
        totalAmount = (TextView) findViewById(R.id.totalAmount);

        enterAmount.setText("0");

        tipSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tipPercent.setText(Integer.toString(i) + " %");
                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                update();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        enterAmount.addTextChangedListener(textWatcher);
    }

    public void update() {
        double percent = tipSeekBar.getProgress() / 100.0;
        if (!enterAmount.getText().toString().equals("")) {
            double tipValue = Integer.parseInt(enterAmount.getText().toString()) * percent;
            tipAmount.setText(Double.toString(tipValue));
            totalAmount.setText(Double.toString(tipValue + Integer.parseInt(enterAmount.getText().toString())));
        }

    }
}