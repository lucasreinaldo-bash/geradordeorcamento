package vostore.orcamentoragonezi.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

import vostore.orcamentoragonezi.Firebase.ConfiguracaoFirebase;
import vostore.orcamentoragonezi.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RevestimentoFragment extends Fragment implements GoogleApiClient.OnConnectionFailedListener {
    private View myFragment;
    FirebaseAuth mAuth, auth;
    GoogleApiClient googleApiClient1;


    public static RevestimentoFragment newInstance(int instance){
        Bundle args = new Bundle();
        args.putInt("argsInstance", instance);
        RevestimentoFragment revestimentoFragment = new RevestimentoFragment();
        revestimentoFragment.setArguments(args);
        return revestimentoFragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_revestimento,
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
