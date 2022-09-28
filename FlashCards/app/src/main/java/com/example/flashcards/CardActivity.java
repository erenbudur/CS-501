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

    public int submissions = 0;
    public int correct = 0;
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
        setContentView(R.layout.activity_card);
        Configuration config = getResources().getConfiguration();


        //modifyLayout(config, true);
        valOne = (TextView) findViewById(R.id.valOneText);
        valTwo = (TextView) findViewById(R.id.valTwoText);
        operator = (TextView) findViewById(R.id.opText);
        message = (TextView) findViewById(R.id.messageText);
        answer = (EditText) findViewById(R.id.editTextNumber);
        button = (Button) findViewById(R.id.button);


        if(savedInstanceState == null){
            String correctUser = getIntent().getStringExtra("username");
            Toast.makeText(getBaseContext(), "Welcome " + correctUser + "to flash cards", Toast.LENGTH_LONG).show();
            findRand();
        }else{
            submissions =  savedInstanceState.getInt("count");
            correct = savedInstanceState.getInt("correct");
            valOneInt = savedInstanceState.getInt("num1");
            valTwoInt = savedInstanceState.getInt("num2");
            curOp = savedInstanceState.getString("op");


        }
        setVals();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submissions++;
                int int1 = Integer.valueOf(valOne.getText().toString());
                int int2 = Integer.valueOf(valTwo.getText().toString());
                int ans = !answer.getText().toString().matches("") ? Integer.parseInt(answer.getText().toString()) : 0;
                String op = operator.getText().toString();
                double curr;
                if (op.equals("+")) {
                    curr = int1 + int2;
                }
                else {
                    curr = int1 - int2;
                }
                if (ans == curr) {
                    correct++;
                }
                if (submissions == 10) {
                    String score = "Score: " + correct + " / " + submissions;
                    Toast.makeText(getBaseContext(), score, Toast.LENGTH_LONG).show();
                    submissions = 0;
                    correct = 0;
                }
                answer.setText("");
                findRand();
                setVals();
            }
        });

    }

//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        modifyLayout(newConfig, false);
//    }
    public void findRand() {
        valOneInt = (int)(Math.random()*99+1);
        valTwoInt = (int)(Math.random()*20+1);
        int decision = (int)(Math.random()*99+1);
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


    @Override
    public void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("count",submissions);
        outState.putInt("correct", correct);
        outState.putInt("num1", valOneInt);
        outState.putInt("num2", valTwoInt);
        outState.putString("op", curOp);


    }

//    public void modifyLayout(Configuration newConfig, boolean firstRun) {
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            setContentView(R.layout.activity_card_landscape);
//        }
//        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
//            setContentView(R.layout.activity_card);
//        }
//        if (!firstRun) {
//            setVals();
//        }
//    }

}