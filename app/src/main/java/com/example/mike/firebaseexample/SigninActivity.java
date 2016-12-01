package com.example.mike.firebaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import android.util.Log;

/**
 * Created by mike on 01.12.2016.
 */

public class SigninActivity extends AppCompatActivity{

    private Button buttonSave;
    private Button buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSignup = (Button) findViewById(R.id.sign_up_button);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("myTag", "Signin!");

                Intent profileIntent = new Intent(SigninActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
            }
        });

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(profileIntent);
            }

        });
    }
}
