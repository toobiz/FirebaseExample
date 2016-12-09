package pl.tubis.boardgamer.Activities;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import pl.tubis.boardgamer.R;
import pl.tubis.boardgamer.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.util.Log;
import android.widget.Toast;

/**
 * Created by mike on 30.11.2016.
 */

public class SignupActivity extends BaseActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextPassword;

    private Button buttonSave;
    private Button buttonSignin;

    private DatabaseReference mDatabase;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSignin = (Button) findViewById(R.id.sign_in_button);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                createUser(email, password);
            }
        });

        buttonSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("Sign in state", "onAuthStateChanged:signed_in:" + user.getUid());
                    uid = user.getUid();
                } else {
                    // User is signed out
                    Log.d("Sign in state", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }

    private void createUser(final String email, final String password) {
        // [START create_user_with_email]
        showProgressDialog();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

                        if (!task.isSuccessful()) {
                            Toast.makeText(SignupActivity.this, "Create user: Failed!",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignupActivity.this, "Create user: Success!",
                                    Toast.LENGTH_SHORT).show();

                            loginUser(email, password);

                        }

                        // [START_EXCLUDE]
//                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
    }

    private void loginUser(final String email, final String password) {
        showProgressDialog();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            // there was an error
                            Toast.makeText(SignupActivity.this, "Login: Failed!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(SignupActivity.this, "Login: Success!",
                                    Toast.LENGTH_SHORT).show();


                            saveUserData(email, password);

                            Intent profileIntent = new Intent(SignupActivity.this, ProfileActivity.class);
                            profileIntent.putExtra("uid", uid);
                            startActivity(profileIntent);
                        }
                        hideProgressDialog();
                    }
                });
    }

//    private void getUid(final String email, final String password) {
//
//    }

    private void saveUserData(String email, String password) {
        String name = editTextName.getText().toString().trim();

        User newUser = new User(name, email, " ", " ", uid, "password", " ");
        mDatabase.child("users").child(uid).setValue(newUser);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}