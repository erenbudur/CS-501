package com.example.a4_p33;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShiftActivity extends AppCompatActivity {

    private TextView title;
    private EditText value;
    private Button changeBtn;
    private int curShift;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift);

        title = (TextView) findViewById(R.id.titleView);
        value = (EditText) findViewById(R.id.enterValue);
        changeBtn = (Button) findViewById(R.id.changeBtn);


        if (savedInstanceState == null) {
            curShift = getIntent().getIntExtra("curShift", 0);;
        }
        else {
            curShift = savedInstanceState.getInt("shiftedAmt");
        }

        value.setText("" + curShift);;

        changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newShift;
                try {
                    newShift = Integer.parseInt(value.getText().toString());
                    if (newShift < 1 || newShift > 25) {
                        throw new Exception();
                    }
                }
                catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Value must be between 1 and 25", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent returnIntent = new Intent();
                returnIntent.putExtra("newShift", newShift);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curShift", curShift);
    }
}