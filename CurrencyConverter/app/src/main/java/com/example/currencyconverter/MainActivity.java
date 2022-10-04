package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.*;
import android.widget.*;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private GestureDetectorCompat gestureDetector;
    private EditText enterAmount;
    private TextView usdLabel;
    private TextView eurLabel;
    private TextView gbpLabel;
    private TextView audLabel;
    private TextView yenLabel;
    private TextView eurValue;
    private TextView gbpValue;
    private TextView audValue;
    private TextView yenValue;
    private static final double eurConv = 1.02;
    private static final double gbpConv = 0.90;
    private static final double audConv = 1.56;
    private static final double yenConv = 144.53;

    private enum directions {
        FLINGUP, FLINGDOWN, SWIPEUP, SWIPEDOWN;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAmount = (EditText) findViewById(R.id.enterAmount);
        usdLabel = (TextView) findViewById(R.id.usdLabel);
        eurLabel = (TextView) findViewById(R.id.eurLabel);
        gbpLabel = (TextView) findViewById(R.id.gbpLabel);
        audLabel = (TextView) findViewById(R.id.audLabel);
        yenLabel = (TextView) findViewById(R.id.yenLabel);
        eurValue = (TextView) findViewById(R.id.eurValue);
        gbpValue = (TextView) findViewById(R.id.gbpValue);
        audValue = (TextView) findViewById(R.id.audValue);
        yenValue = (TextView) findViewById(R.id.yenValue);

        enterAmount.setText("$0.00");

        gestureDetector = new GestureDetectorCompat(this, new GestureListener());

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

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.w("FLING MADE", "Moved with xValue " + velocityX + " and with yValue " + velocityY);
            float absX = Math.abs(velocityX);
            float absY = Math.abs(velocityY);
            boolean verticalFling = ((absY - absX) > 0);
            if (verticalFling) {
                if (velocityY < 0) {
                    // perform north activity
                    //Toast.makeText(MainActivity.this, "North Fling", Toast.LENGTH_SHORT).show();
                    if (absY > 10000) {
                        changeEnteredAmount(directions.FLINGUP);
                    }
                    else {
                        changeEnteredAmount(directions.SWIPEUP);
                    }
                }
                else {
                    // perform south activity
                    //Toast.makeText(MainActivity.this, "South Fling", Toast.LENGTH_SHORT).show();
                    if (absY > 10000) {
                        changeEnteredAmount(directions.FLINGDOWN);
                    }
                    else {
                        changeEnteredAmount(directions.SWIPEDOWN);
                    }
                }
            }
//            else {
//                if (velocityX < 0) {
//                    // perform west activity
//                    Toast.makeText(MainActivity.this, "West Fling", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    // perform east activity
//                    Toast.makeText(MainActivity.this, "East Fling", Toast.LENGTH_SHORT).show();
//                }
//            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }

//        @Override
//        public boolean onScroll (MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
//            Toast.makeText(MainActivity.this, "Scroll made with xDistance " + distanceX + " and yDistance " + distanceY, Toast.LENGTH_SHORT).show();
//            return false;
//        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public double getEnterAmount() {
        String noSign = enterAmount.getText().toString().substring(1);
        return Double.parseDouble(noSign);
    }

    public void update() {
        if (!enterAmount.getText().toString().equals("") && !enterAmount.getText().toString().endsWith(".") && (enterAmount.getText().toString().length() != 1)) {
            double enteredVal = getEnterAmount();
            double newEUR = enteredVal * eurConv;
            double newGBP = enteredVal * gbpConv;
            double newAUD = enteredVal * audConv;
            double newYEN = enteredVal * yenConv;

            NumberFormat formatter = NumberFormat.getCurrencyInstance();

            String eurString = "€" + formatter.format(newEUR).substring(1);
            String gbpString = "£" + formatter.format(newGBP).substring(1);
            String audString = "A" + formatter.format(newAUD);
            String yenString = "¥" + formatter.format(newYEN).substring(1);

            eurValue.setText(eurString);
            gbpValue.setText(gbpString);
            audValue.setText(audString);
            yenValue.setText(yenString);
        }
    }

    public void changeEnteredAmount(directions direction) {
        if (!enterAmount.getText().toString().equals("") && !enterAmount.getText().toString().endsWith(".") && (enterAmount.getText().toString().length() != 1)) {
            double enteredVal = getEnterAmount();
            switch (direction) {
                case FLINGUP:
                    enteredVal += 1;
                    break;
                case FLINGDOWN:
                    enteredVal -= 1;
                    break;
                case SWIPEUP:
                    enteredVal += 0.1;
                    break;
                case SWIPEDOWN:
                    enteredVal -= 0.1;
                    break;
                default:
                    break;
            }
            if (enteredVal < 0) {
                enterAmount.setText("$0.00");
                update();
                return;
            }
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String newVal = formatter.format(enteredVal);
            enterAmount.setText(newVal);
            update();
        }
    }


}