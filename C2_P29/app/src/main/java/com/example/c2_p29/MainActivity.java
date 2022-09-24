package com.example.c2_p29;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText servings1;
    EditText servings2;
    EditText servings3;

    TextView totalCalories;

    protected int num(String s) {
        if (s.equals("")) {
            return 0;
        }
        return Integer.parseInt(s);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        servings1 = (EditText) findViewById(R.id.editTextNumber);
        servings2 = (EditText) findViewById(R.id.editTextNumber2);
        servings3 = (EditText) findViewById(R.id.editTextNumber3);
        totalCalories = (TextView) findViewById(R.id.total);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Resources stringRes = getBaseContext().getResources();

                int c1 = num(servings1.getText().toString()) * Integer.parseInt(stringRes.getString(R.string.orangeJuice));
                int c2 = num(servings2.getText().toString()) * Integer.parseInt(stringRes.getString(R.string.bread));
                int c3 = num(servings3.getText().toString()) * Integer.parseInt(stringRes.getString(R.string.coffee));

                totalCalories.setText(Integer.toString(c1 + c2 + c3));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        servings1.addTextChangedListener(textWatcher);
        servings2.addTextChangedListener(textWatcher);
        servings3.addTextChangedListener(textWatcher);

    }
}