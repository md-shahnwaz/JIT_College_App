package com.shahnwaz.jitcollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import fragments.AboutUs;
import fragments.Admission;
import fragments.Career;
import fragments.Contact;
import fragments.Courses;
import fragments.Feedback;
import fragments.Home;
import fragments.LifeAtJit;
import fragments.Login;
import fragments.Palacements;
import fragments.Registration;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navView;
    FrameLayout frameLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frameLayout = findViewById(R.id.frameLayout);


        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.itemHome){
                    loadFragment(new Home());
                }
                else if (id == R.id.courses){
                    loadFragment(new Courses());
                }
                else if (id == R.id.admission){
                    loadFragment(new Admission());
                }
                else if (id == R.id.life){
                    loadFragment(new LifeAtJit());
                }
                else if (id == R.id.placement){
                    loadFragment(new Palacements());
                }
                else if (id == R.id.career){
                    loadFragment(new Career());
                }
                else if (id == R.id.aboutUs){
                    loadFragment(new AboutUs());
                }
                else if (id == R.id.contact){
                    loadFragment(new Contact());
                }
                else if (id == R.id.feedback){
                    loadFragment(new Feedback());
                }
                else if (id == R.id.registration){
                    loadFragment(new Registration());
                }
                else if (id == R.id.login){
                    loadFragment(new Login());
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        loadFragment(new Home());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void loadFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

}
