package com.example.mike.firebaseexample;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Bitmap.Config;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAddress;
    private TextView textViewPersons;
    private Button buttonSave;

    //        DatabaseReference.setAndroidContext(this);
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        buttonSave = (Button) findViewById(R.id.buttonSave);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);

        textViewPersons = (TextView) findViewById(R.id.textViewPersons);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating firebase object
//                ContactsContract.Data ref = new DatabaseReference(Config.FIREBASE_URL);

//                //Getting values to store
//                String name = editTextName.getText().toString().trim();
//                String address = editTextAddress.getText().toString().trim();
//
//                //Creating Person object
//                Person person = new Person();
//
//                //Adding values
//                person.setName(name);
//                person.setAddress(address);

                //Storing values to firebase
//                ref.child("Person").setValue(person);


                //Value event listener for realtime data update
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                            //Getting the data from snapshot
                            Person person = postSnapshot.getValue(Person.class);

                            //Adding it to a string
                            String string = "Name: "+person.getfirstName()+"\nAddress: "+person.getEmail()+"\n\n";

                            //Displaying it on textview
                            textViewPersons.setText(string);
                            Log.d("myTag", person.getfirstName());

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError firebaseError) {
                        System.out.println("The read failed: " + firebaseError.getMessage());
                    }
                });

            }
        });
    }


}
