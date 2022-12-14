package com.example.advancedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.Math;

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
    private Button clrBtn;
    private boolean override;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storedValue = 0;
        storedOp = ' ';
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.oneBtn);
        btn2 = (Button) findViewById(R.id.twoBtn);
        btn3 = (Button) findViewById(R.id.threeBtn);
        btn4 = (Button) findViewById(R.id.fourBtn);
        btn5 = (Button) findViewById(R.id.fiveBtn);
        btn6 = (Button) findViewById(R.id.sixBtn);
        btn7 = (Button) findViewById(R.id.sevenBtn);
        btn8 = (Button) findViewById(R.id.eightBtn);
        btn9 = (Button) findViewById(R.id.nineBtn);
        btn0 = (Button) findViewById(R.id.zeroBtn);
        addBtn = (Button) findViewById(R.id.addBtn);
        subBtn = (Button) findViewById(R.id.subBtn);
        mulBtn = (Button) findViewById(R.id.mulBtn);
        divBtn = (Button) findViewById(R.id.divBtn);
        eqBtn = (Button) findViewById(R.id.eqBtn);
        decBtn = (Button) findViewById(R.id.decBtn);
        sqrtBtn = (Button) findViewById(R.id.sqrtBtn);
        visibleValue = (EditText) findViewById(R.id.resText);
        clrBtn = (Button) findViewById(R.id.clearBtn);
        override = true;
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
                if (visibleValue.getText().toString().equals("0") || override) {
                    visibleValue.setText("0");
                    override = false;
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("0"));
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0") || override) {
                    visibleValue.setText("1");
                    override = false;
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("1"));
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0") || override) {
                    visibleValue.setText("2");
                    override = false;
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("2"));
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0") || override) {
                    visibleValue.setText("3");
                    override = false;
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("3"));
                }
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0") || override) {
                    visibleValue.setText("4");
                    override = false;
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("4"));
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0") || override) {
                    visibleValue.setText("5");
                    override = false;
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("5"));
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0") || override) {
                    visibleValue.setText("6");
                    override = false;
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("6"));
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0") || override) {
                    visibleValue.setText("7");
                    override = false;
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("7"));
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0") || override) {
                    visibleValue.setText("8");
                    override = false;

                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("8"));
                }
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (visibleValue.getText().toString().equals("0") || override) {
                    visibleValue.setText("9");
                    override = false;
                } else {
                    visibleValue.setText(visibleValue.getText().toString().concat("9"));
                }
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                override = true;
                if (storedOp == ' ') {
                    storedValue = Double.parseDouble(visibleValue.getText().toString());
                    storedOp = '+';
                } else if (!(storedOp == '+')) {
                    storedOp = '+';
                } else {
                    performOp();
                    storedOp = '+';
                }
            }
        });
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                override = true;
                if (storedOp == ' ') {
                    storedValue = Double.parseDouble(visibleValue.getText().toString());
                    storedOp = '-';
                } else if (!(storedOp == '-')) {
                    storedOp = '-';
                } else {
                    performOp();
                    storedOp = '-';
                }
            }
        });
        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                override = true;
                if (storedOp == ' ') {
                    storedValue = Double.parseDouble(visibleValue.getText().toString());
                    storedOp = '*';
                } else if (!(storedOp == '*')) {
                    storedOp = '*';
                } else {
                    performOp();
                    storedOp = '*';
                }
            }
        });
        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                override = true;
                if (storedOp == ' ') {
                    storedValue = Double.parseDouble(visibleValue.getText().toString());
                    storedOp = '/';
                }
                else if (!(storedOp == '/')) {
                    storedOp = '/';
                }
                else {
                    performOp();
                    storedOp = '/';
                }
            }
        });
        eqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                override = true;
                if (storedOp != ' ') {
                    performOp();
                }
                storedOp = ' ';
            }
        });

        decBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!visibleValue.getText().toString().contains(".")) {
                    visibleValue.setText(visibleValue.getText().toString().concat("."));
                }

            }
        });
        sqrtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double curValue = Double.parseDouble(visibleValue.getText().toString());
                if (curValue < 0) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Error: Cannot take square root of a negative number. Clearing calculator", Toast.LENGTH_SHORT).show();
                    storedValue = 0;
                    visibleValue.setText("0");
                    storedOp = ' ';
                    return;
                }
                visibleValue.setText(Double.toString(Math.sqrt(curValue)));
            }
        });


        clrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storedValue = 0;
                visibleValue.setText("0");
                storedOp = ' ';
            }
        });


    }

    private void performOp() {
        Context context = getApplicationContext();
        Double curValue = Double.parseDouble(visibleValue.getText().toString());
        switch (storedOp) {
            case '+':
                storedValue += curValue;
                visibleValue.setText(Double.toString(storedValue));
                break;
            case '-':
                storedValue -= curValue;
                visibleValue.setText(Double.toString(storedValue));
                break;
            case '*':
                storedValue *= curValue;
                visibleValue.setText(Double.toString(storedValue));
                break;
            case '/':
                if (curValue == 0) {
                    Toast.makeText(context, "Error: Cannot divide by zero. Clearing calculator", Toast.LENGTH_SHORT).show();
                    storedValue = 0;
                    visibleValue.setText("0");
                    storedOp = ' ';
                    return;
                }
                storedValue /= curValue;
                visibleValue.setText(Double.toString(storedValue));
                break;

            default:
                break;
        }


    }

}