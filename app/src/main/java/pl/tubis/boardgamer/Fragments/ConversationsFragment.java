package pl.tubis.boardgamer.Fragments;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pl.tubis.boardgamer.Activities.MainActivity;
import pl.tubis.boardgamer.Model.Conversation;
import pl.tubis.boardgamer.R;

import static pl.tubis.boardgamer.Activities.MainActivity.myUid;

/**
 * Created by mike on 05.12.2016.
 */

public class ConversationsFragment extends ListFragment {

    Map<String, Conversation> mConversations = new HashMap<String, Conversation>();
    ArrayList<String> conversationList = new ArrayList<String>();
    private ListView list ;
    private ArrayAdapter<String> adapter ;

    public ConversationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.conversation_list, container, false);

        downloadConversations(rootView);

        return rootView;
    }

    private void downloadConversations(final View rootView){

        ((MainActivity)getActivity()).usersRef.child(myUid).child("messages").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot
                    Conversation newConversation = postSnapshot.getValue(Conversation.class);
                    mConversations.put(newConversation.getId(), newConversation);

//                    com.google.android.gms.maps.model.Marker mkr = mMap.addMarker(addNewMarker(location));
//                    mMarkers.put(mkr.getId(), newMarker.getUid());

                    Log.d("myTag", newConversation.getDisplayName());
//                    hideProgressDialog();

                    list = (ListView) rootView.findViewById(R.id.listView);
                    final String displayName = newConversation.displayName;
                    conversationList.add(displayName);

                    adapter = new ArrayAdapter<String>(getActivity(), R.layout.conversation_list_item, conversationList);
                    list.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

}
