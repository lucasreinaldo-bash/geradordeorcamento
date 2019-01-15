package vostore.orcamentoragonezi.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;

import vostore.orcamentoragonezi.Firebase.ConfiguracaoFirebase;
import vostore.orcamentoragonezi.Login;
import vostore.orcamentoragonezi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ArtFragment extends Fragment implements GoogleApiClient.OnConnectionFailedListener {
    private View myFragment;
    FirebaseAuth mAuth, auth;
    GoogleApiClient googleApiClient1;


    public static ArtFragment newInstance(int instance){
        Bundle args = new Bundle();
        args.putInt("argsInstance", instance);
        ArtFragment artFragment = new ArtFragment();
        artFragment.setArguments(args);
        return artFragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_art,
                container, false);




        auth = FirebaseAuth.getInstance();



        //FacebookSdk.sdkInitialize(getApplicationContext());



        return rootView;
    }

    private void signOut() {
        // Firebase sign out

        mAuth = ConfiguracaoFirebase.getFirebaseAutenticacao();
        mAuth.signOut();


        // Google sign out




    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    @Override
    public void onStart() {
        super.onStart();

    }


}
