package com.example.lect2_simplemath_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private Button modBtn;
    private TextView tvAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  tvAnswer = new TextView(null);

        tvAnswer = (TextView) findViewById(R.id.tvAnswer);
        num1 = (EditText) findViewById(R.id.decimal1);
        num2 = (EditText) findViewById(R.id.decimal2);
        addBtn  = (Button) findViewById(R.id.addButton);
        subBtn  = (Button) findViewById(R.id.subButton);
        mulBtn  = (Button) findViewById(R.id.mulButton);
        divBtn  = (Button) findViewById(R.id.divButton);
        modBtn  = (Button) findViewById(R.id.modButton);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double result;
                result = Double.parseDouble(num1.getText().toString()) +
                        Double.parseDouble(num2.getText().toString());
                tvAnswer.setText(result.toString());
            }
        });

        btnCalculate.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Double result;
                result = Double.parseDouble(num1.getText().toString()) -
                        Double.parseDouble(num2.getText().toString());
                tvAnswer.setText(result.toString());

                return true;
            }
        });

    }

    public void onClick(View view) {
        Double result;
        result = Double.parseDouble(num1.getText().toString()) +
                Double.parseDouble(num2.getText().toString());
        tvAnswer.setText(result.toString());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}