package com.example.flashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;

public class CardActivity extends AppCompatActivity {

    public int submissions;
    public int correct;
    public TextView valOne;
    public TextView valTwo;
    public TextView operator;
    public TextView message;
    public EditText answer;
    public Button button;
    public int valOneInt;
    public int valTwoInt;
    public String curOp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration config = getResources().getConfiguration();
        submissions = 0;
        correct = 0;
        modifyLayout(config, true);
        valOne = (TextView) findViewById(R.id.valOneText);
        valTwo = (TextView) findViewById(R.id.valTwoText);
        operator = (TextView) findViewById(R.id.opText);
        message = (TextView) findViewById(R.id.messageText);
        answer = (EditText) findViewById(R.id.editTextNumber);
        button = (Button) findViewById(R.id.button);
        findRand();
        modifyLayout(config, false);
        String correctUser = getIntent().getStringExtra("username");
        Toast.makeText(getBaseContext(), "Welcome " + correctUser + "to flash cards", Toast.LENGTH_LONG).show();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submissions++;
                int int1 = Integer.valueOf(valOne.getText().toString());
                int int2 = Integer.valueOf(valTwo.getText().toString());
                double ans = Double.valueOf(answer.getText().toString());
                String op = operator.getText().toString();
                if (op.equals("+")) {
                    double curr = int1 + int2;
                    if (ans == curr) {
                        correct++;
                    }
                }
                else {
                    double curr = int1 - int2;
                    if (ans == curr) {
                        correct++;
                    }
                }
                if (submissions == 10) {
                    String score = "Score: " + Integer.toString(correct) + " / " + Integer.toString(submissions);
                    Toast.makeText(getBaseContext(), score, Toast.LENGTH_LONG).show();
                    submissions = 0;
                    correct = 0;
                }
                answer.setText("0");
                findRand();
                setVals();
            }
        });

    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        modifyLayout(newConfig, false);
    }
    public void findRand() {
        valOneInt = ThreadLocalRandom.current().nextInt(0, 100);
        valTwoInt = ThreadLocalRandom.current().nextInt(0, 20);
        int decision = ThreadLocalRandom.current().nextInt(0, 100);
        if (decision < 50) {
            curOp = "+";
        }
        else {
            curOp = "-";
        }
    }

    public void setVals() {
        valOne.setText(Integer.toString(valOneInt));
        valTwo.setText(Integer.toString(valTwoInt));
        operator.setText(curOp);
    }

    public void modifyLayout(Configuration newConfig, boolean firstRun) {
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(R.layout.activity_card_landscape);
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_card);
        }
        if (!firstRun) {
            setVals();
        }
    }

}