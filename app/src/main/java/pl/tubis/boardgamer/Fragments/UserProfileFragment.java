package pl.tubis.boardgamer.Fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pl.tubis.boardgamer.Model.User;
import pl.tubis.boardgamer.R;

import static pl.tubis.boardgamer.Activities.MainActivity.myUid;

/**
 * Created by mike on 05.12.2016.
 */

public class UserProfileFragment extends Fragment {

    public UserProfileFragment() {
        // Required empty public constructor
    }

    public ProgressDialog mProgressDialog;
    private TextView textViewPersons;
    private Button buttonLogout;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference("users");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_profile, container, false);

        textViewPersons = (TextView) view.findViewById(R.id.textViewPersons);
        buttonLogout = (Button) view.findViewById(R.id.logout_button);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                (getActivity()).onBackPressed();
            }
        });

        showProgressDialog();
//        Value event listener for realtime data update
        Bundle args = getArguments();
        String uid = args.getString("uid", "");
        ref.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot
                    User person = snapshot.getValue(User.class);

                    //Adding it to a string
                    String string = "\nName: " + person.getfirstName() + "\n\nAddress: " + person.getEmail() + "\n\nUID: " + person.getUid() +
                            "\n\nAbout me: " + person.getAbout() + "\n\nOneSignalID: " + person.getOneSignalID() + "\n\nPrivacy Agreement: "
                            + person.getPrivacyAgreement() + "\n";

                    //Displaying it on textview
                    textViewPersons.setText(string);
                    Log.d("myTag", person.getfirstName());
                    hideProgressDialog();
                }
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
        return view;
    }

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }

}