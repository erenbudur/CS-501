package com.example.a4_p33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText enteredText;
    private TextView shiftText;
    private Button btn;
    private int shiftAmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredText = (EditText) findViewById(R.id.editText);
        shiftText = (TextView) findViewById(R.id.result);
        btn = (Button) findViewById(R.id.button);

        if (savedInstanceState == null) {
            shiftAmt = 0;
        }
        else {
            shiftAmt = savedInstanceState.getInt("shiftedAmt");
        }

        Intent intent = new Intent(this, ShiftActivity.class);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                shiftText();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };


        enteredText.addTextChangedListener(textWatcher);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch second activity
                intent.putExtra("curShift", shiftAmt);
                setResult(RESULT_OK, intent);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int newShift = data.getIntExtra("newShift", 0);
        shiftAmt = newShift;
        shiftText();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("shiftedAmt", shiftAmt);
    }

    public void shiftText() {
        String inputStr = enteredText.getText().toString();
        String res = "";
        for (int i = 0; i < inputStr.length(); i++) {
            int oldPos = inputStr.charAt(i) - 'a';
            int newPos = (oldPos + shiftAmt) % 26;
            char newChar = (char) ('a' + newPos);
            res += (newChar);
        }
        shiftText.setText(res);
    }
}