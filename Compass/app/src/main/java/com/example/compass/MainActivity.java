package com.example.compass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private TextView message;
    private ImageView image;

    private GestureDetectorCompat gestureDetector;

    private enum directions {
        NORTH, SOUTH, EAST, WEST;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureDetector = new GestureDetectorCompat(this, new GestureListener());
        message = (TextView) findViewById(R.id.message);
        image = (ImageView) findViewById(R.id.image);
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
                    switchActivities(directions.NORTH);
                    Toast.makeText(MainActivity.this, "North Fling", Toast.LENGTH_SHORT).show();
                }
                else {
                    // perform south activity
                    switchActivities(directions.SOUTH);
                    Toast.makeText(MainActivity.this, "South Fling", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                if (velocityX < 0) {
                    // perform west activity
                    switchActivities(directions.WEST);
                    Toast.makeText(MainActivity.this, "West Fling", Toast.LENGTH_SHORT).show();
                }
                else {
                    // perform east activity
                    switchActivities(directions.EAST);
                    Toast.makeText(MainActivity.this, "East Fling", Toast.LENGTH_SHORT).show();
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }


    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private void switchActivities(directions direction) {
        Intent switchActivityIntent;
        switch (direction) {
            case NORTH:
                switchActivityIntent = new Intent(this, NorthActivity.class);
                break;
            case SOUTH:
                switchActivityIntent = new Intent(this, SouthActivity.class);
                break;
            case EAST:
                switchActivityIntent = new Intent(this, EastActivity.class);
                break;
            case WEST:
                switchActivityIntent = new Intent(this, WestActivity.class);
                break;
            default:
                switchActivityIntent = new Intent(this, MainActivity.class);
                break;
        }
        startActivity(switchActivityIntent);
    }

}