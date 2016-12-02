package com.example.mike.firebaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import android.util.Log;

public class ProfileActivity extends AppCompatActivity {

    private TextView textViewPersons;
    private Button buttonLogout;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        buttonLogout = (Button) findViewById(R.id.logout_button);

        textViewPersons = (TextView) findViewById(R.id.textViewPersons);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent loginIntent = new Intent(ProfileActivity.this, LoginActivity.class);
                startActivity(loginIntent);
            }
        });

                //Value event listener for realtime data update
//                ref.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot snapshot) {
//                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
//                            //Getting the data from snapshot
//                            User person = postSnapshot.getValue(User.class);
//
//                            //Adding it to a string
//                            String string = "\nName: " + person.getfirstName() + "\n\nAddress: " + person.getEmail() + "\n\nUID: " + person.getUid() +
//                                    "\n\nAbout me: " + person.getAbout() + "\n\nOneSignalID: " + person.getOneSignalID() + "\n\nPrivacy Agreement: "
//                                    + person.getPrivacyAgreement() +"\n";
//
//                            //Displaying it on textview
//                            textViewPersons.setText(string);
//                            Log.d("myTag", person.getfirstName());
//
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError firebaseError) {
//                        System.out.println("The read failed: " + firebaseError.getMessage());
//                    }
//                });
    }
}
