package com.example.flashcards;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView usernameLabel;
    private TextView passwordLabel;
    private EditText usernameInput;
    private EditText passwordInput;
    private Button btn;
    private String correctUser = "user1";
    private String correctPW = "pass";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameLabel = (TextView) findViewById(R.id.usernameLabel);
        passwordLabel = (TextView) findViewById(R.id.passwordLabel);
        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (usernameInput.getText().toString().equals(correctUser) && passwordInput.getText().toString().equals(correctPW)) {
                    switchActivities();
                }
                else {
                    // Toast incorrect login / try again
                    Toast.makeText(getBaseContext(), "The credentials provided are incorrect. Please try again", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, CardActivity.class);
        switchActivityIntent.putExtra("username", correctUser);
        startActivity(switchActivityIntent);
    }
}
