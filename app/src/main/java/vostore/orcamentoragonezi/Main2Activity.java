package vostore.orcamentoragonezi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.ncapdevi.fragnav.FragNavController;

import java.util.ArrayList;
import java.util.List;

import vostore.orcamentoragonezi.ActivitysNavigation.Ajustes;
import vostore.orcamentoragonezi.ActivitysNavigation.Orcamentos;
import vostore.orcamentoragonezi.ActivitysNavigation.Parcelamento;
import vostore.orcamentoragonezi.ActivitysNavigation.Produtos;
import vostore.orcamentoragonezi.Firebase.ConfiguracaoFirebase;
import vostore.orcamentoragonezi.Fragments.ArtFragment;
import vostore.orcamentoragonezi.Fragments.DemolicaoFragment;
import vostore.orcamentoragonezi.Fragments.RevestimentoFragment;
import vostore.orcamentoragonezi.Servicos.Demolicao;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, GoogleApiClient.OnConnectionFailedListener {


    private ImageButton btn1, btn2,btn3,btn4,btn5,btn6;

    FirebaseAuth mAuth, auth;
    GoogleApiClient googleApiClient1;
    private final int TAB_FIRST = FragNavController.TAB1;
    private final int TAB_SECOND = FragNavController.TAB2;
    private final int TAB_THIRD = FragNavController.TAB3;
    private FragNavController fragNavController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Fazendo cast dos botões
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);






        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Demolicao.class);
                startActivity(intent);
                finish();
            }
        });

        auth = FirebaseAuth.getInstance();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Intent intent1 = new Intent(Main2Activity.this, Orcamentos.class);
        Intent intent2 = new Intent(Main2Activity.this, Parcelamento.class);
        Intent intent3 = new Intent(Main2Activity.this, Produtos.class);
        Intent intent4 = new Intent(Main2Activity.this, Ajustes.class);

        if (id == R.id.nav_orcamento) {
            Intent intent = new Intent(Main2Activity.this,Orcamentos.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_parcelamento) {

            startActivity(intent2);
            finish();
        } else if (id == R.id.nav_produtos) {
            Intent intentProdutos = new Intent(this,Produtos.class);
            startActivity(intentProdutos);
            finish();
        } else if (id == R.id.nav_ajustes) {
            startActivity(intent4);
            finish();
        } else if (id == R.id.nav_sair) {
            signOut();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void signOut() {
        // Firebase sign out

        mAuth = ConfiguracaoFirebase.getFirebaseAutenticacao();
        mAuth.signOut();



        // Google sign out
        Intent intent = new Intent(Main2Activity.this, Login.class);
        startActivity(intent);
        finish();



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
