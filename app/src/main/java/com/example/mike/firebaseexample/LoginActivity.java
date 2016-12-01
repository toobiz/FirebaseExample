package com.example.mike.firebaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import android.util.Log;

/**
 * Created by mike on 01.12.2016.
 */

public class LoginActivity extends AppCompatActivity{

    private Button buttonSave;
    private Button buttonSignup;
    private Button buttonForgot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSignup = (Button) findViewById(R.id.sign_up_button);
        buttonForgot = (Button) findViewById(R.id.forgot_button);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("myTag", "Signin!");

                Intent profileIntent = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
            }
        });

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(signupIntent);
            }

        });

        buttonForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent passwordIntent = new Intent(LoginActivity.this, PasswordActivity.class);
                startActivity(passwordIntent);
            }

        });
    }
}
