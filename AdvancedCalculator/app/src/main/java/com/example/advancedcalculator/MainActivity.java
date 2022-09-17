package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText visibleValue;
    private double storedValue;
    private char storedOp;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private Button eqBtn;
    private Button decBtn;
    private Button sqrtBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storedValue = 0;
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.oneBtn);
        btn2 = (Button) findViewById(R.id.twoBtn);
        btn3 = (Button) findViewById(R.id.threeBtn);
        btn4 = (Button) findViewById(R.id.fourBtn);
        btn5 = (Button) findViewById(R.id.fiveBtn);
        btn6 = (Button) findViewById(R.id.sixBtn);
        btn7 = (Button) findViewById(R.id.sevenBtn);
        btn8 = (Button) findViewById(R.id.eightBtn);
        btn9 = (Button) findViewById(R.id.nineBtn);;
        addBtn = (Button) findViewById(R.id.addBtn);
        subBtn = (Button) findViewById(R.id.subBtn);
        mulBtn = (Button) findViewById(R.id.mulBtn);
        divBtn = (Button) findViewById(R.id.divBtn);
        eqBtn = (Button) findViewById(R.id.eqBtn);
        decBtn = (Button) findViewById(R.id.decBtn);
        sqrtBtn = (Button) findViewById(R.id.sqrtBtn);
        visibleValue = (EditText) findViewById(R.id.resText);

        visibleValue.setText("0");


//        visibleValue.addTextChangedListener(new TextWatcher() {
//            boolean _ignore = false; // indicates if the change was made by the TextWatcher itself.
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (_ignore)
//                    return;
//
//                _ignore = true; // prevent infinite loop
//                visibleValue.setText(Double.toString(Double.parseDouble(visibleValue.getText().toString()))  );
//                _ignore = false; // release, so the TextWatcher start to listen again.
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//
//        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0")) {
                    return;
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("0"));
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0")) {
                    visibleValue.setText("1");
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("1"));
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0")) {
                    visibleValue.setText("2");
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("2"));
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0")) {
                    visibleValue.setText("3");
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("3"));
                }
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0")) {
                    visibleValue.setText("4");
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("4"));
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0")) {
                    visibleValue.setText("5");
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("5"));
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0")) {
                    visibleValue.setText("6");
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("6"));
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0")) {
                    visibleValue.setText("7");
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("7"));
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0")) {
                    visibleValue.setText("8");
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("8"));
                }
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0")) {
                    visibleValue.setText("9");
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("9"));
                }
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (storedValue == 0 && storedOp.equals(null)) {
                    storedValue = Double.parseDouble(visibleValue.getText().toString());
                    storedOp = '+';
                }
                else if (!(storedOp.equals(null))) {

                }
             }
        });
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        eqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        decBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        sqrtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });



    }
    private Double performOp() {
        Double curValue = Double.parseDouble(visibleValue.getText().toString());
        switch (storedOp) {
            case '+':
                return 1.0;
            case '-':
                return 2.0;
            case '*':
                return 3.0;
            case '/':
                return 4.0;
            default:
                return 5.0;
        }
    }

}