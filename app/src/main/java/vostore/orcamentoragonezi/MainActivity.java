package vostore.orcamentoragonezi;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.ncapdevi.fragnav.FragNavController;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import java.util.ArrayList;
import java.util.List;

import vostore.orcamentoragonezi.Fragments.ArtFragment;
import vostore.orcamentoragonezi.Fragments.DemolicaoFragment;
import vostore.orcamentoragonezi.Fragments.RevestimentoFragment;

public class MainActivity extends AppCompatActivity {


    //Configuração do Bottom e do Navigation Drawer
    private BottomBar mBottomBar;
    private FragNavController fragNavController;
    private Button btnART,btnDemolicao,btnRevestimento,btnHidraulica,btnCalculadora,btnFinalizar;
    private LinearLayout linearART,linearDemolicao,linearRevestimento,linearHidraulica,linearFinalizar;
    //indices to fragments
    private final int TAB_FIRST = FragNavController.TAB1;
    private final int TAB_SECOND = FragNavController.TAB2;
    private final int TAB_THIRD = FragNavController.TAB3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





                }
    }

