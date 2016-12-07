package pl.tubis.boardgamer.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import pl.tubis.boardgamer.Model.Marker;
import pl.tubis.boardgamer.Model.User;
import pl.tubis.boardgamer.R;

import static pl.tubis.boardgamer.Activities.MainActivity.myUid;

/**
 * Created by mike on 05.12.2016.
 */

public class MapFragment extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;
    Map<String, String> mMarkers = new HashMap<String, String>();


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference locationsRef = database.getReference("locations");
    DatabaseReference usersRef = database.getReference("users");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {


                // For showing a move to my location button
//                googleMap.setMyLocationEnabled(true);

                downloadLocations(mMap);

                // For adding a marker at a point on the Map
//                LatLng warsaw = new LatLng(52, 21);
//                mMap.addMarker(addNewMarker(warsaw));
//
////                 For zooming to the location of the user
//                CameraPosition cameraPosition = new CameraPosition.Builder().target(warsaw).zoom(8).build();
//                mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker) {

                        String uid = mMarkers.get(marker.getId());

                        downloadUserData(marker, uid);

                        return false;
                    }
                });

            }
        });

        return rootView;
    }

    private void downloadUserData(final com.google.android.gms.maps.model.Marker marker, final String uid){
        usersRef.child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot
                    User person = snapshot.getValue(User.class);


                    marker.setTitle(person.getfirstName());
                    marker.setSnippet(person.getAbout());

//                    //Adding it to a string
//                    String string = "\nName: " + person.getfirstName() + "\n\nAddress: " + person.getEmail() + "\n\nUID: " + person.getUid() +
//                            "\n\nAbout me: " + person.getAbout() + "\n\nOneSignalID: " + person.getOneSignalID() + "\n\nPrivacy Agreement: "
//                            + person.getPrivacyAgreement() + "\n";


//                    hideProgressDialog();
                }
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

    private MarkerOptions addNewMarker(LatLng location){
//        LatLng warsaw = new LatLng(52, 21);
        MarkerOptions marker = new MarkerOptions().position(location).icon
                (BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker));
        return marker;
    }

    private void downloadLocations(final GoogleMap mMap){
        locationsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    //Getting the data from snapshot
                    final Marker newMarker = postSnapshot.getValue(Marker.class);
                    LatLng location = new LatLng(newMarker.getLat(), newMarker.getLon());

                    com.google.android.gms.maps.model.Marker mkr = mMap.addMarker(addNewMarker(location));

                    mMarkers.put(mkr.getId(), newMarker.getUid());

                    Log.d("myTag", newMarker.getLat().toString());
//                    hideProgressDialog();
                }
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}