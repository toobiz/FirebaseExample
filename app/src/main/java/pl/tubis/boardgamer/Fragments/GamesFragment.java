package pl.tubis.boardgamer.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import pl.tubis.boardgamer.Activities.MainActivity;
import pl.tubis.boardgamer.Model.Game;
import pl.tubis.boardgamer.Model.NewMarker;
import pl.tubis.boardgamer.R;

import static pl.tubis.boardgamer.Activities.MainActivity.myUid;

/**
 * Created by mike on 05.12.2016.
 */

public class GamesFragment extends Fragment {

    public GamesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_games, container, false);
        View rootView = inflater.inflate(R.layout.fragment_games, container, false);
        downloadGames();

        return rootView;
    }

    private void downloadGames(){
        ((MainActivity)getActivity()).gamesRef.child(myUid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot
                    Game newGame = postSnapshot.getValue(Game.class);
//                    LatLng location = new LatLng(newMarker.getLatitude(), newMarker.getLongitude());

//                    com.google.android.gms.maps.model.Marker mkr = mMap.addMarker(addNewMarker(location));
//                    mMarkers.put(mkr.getId(), newMarker.getUid());

                    Log.d("myTag", newGame.getGameID());
//                    hideProgressDialog();
                }
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }
}
