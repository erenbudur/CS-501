package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.*;

import java.text.NumberFormat;

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

        enterAmount.setText("$0.00");

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
                if (enterAmount.getText().toString().endsWith("$") && (enterAmount.getText().toString().length() > 1)) {
                    enterAmount.setText("$" + enterAmount.getText().toString().substring(0,enterAmount.getText().toString().length()-1));
                }
                if (!enterAmount.getText().toString().startsWith("$")) {
                    enterAmount.setText("$" + enterAmount.getText().toString());
                }
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
        if (!enterAmount.getText().toString().equals("") && !enterAmount.getText().toString().endsWith(".") && (enterAmount.getText().toString().length() != 1)) {
            double tipValue = getEnterAmount() * percent;
            double totalValue = tipValue + getEnterAmount();
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String tipString = formatter.format(tipValue);
            String totalString = formatter.format(totalValue);
            tipAmount.setText(tipString);
            totalAmount.setText(totalString);
        }

    }

    public double getEnterAmount() {
        String noSign = enterAmount.getText().toString().substring(1);
        return Double.parseDouble(noSign);
    }
}