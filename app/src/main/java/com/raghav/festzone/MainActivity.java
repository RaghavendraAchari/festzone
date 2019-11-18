package com.raghav.festzone;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.raghav.festzone.screens.AboutUsFragment;
import com.raghav.festzone.screens.HomeFragment;
import com.raghav.festzone.screens.MyAccountFragment;
import com.raghav.festzone.screens.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        final Fragment homeFragment = new HomeFragment();
        final Fragment regFragment = new RegisterFragment();
        final Fragment myAccountFragment = new MyAccountFragment();
        final Fragment aboutUsFragment = new AboutUsFragment();

        fragmentManager.beginTransaction().add(R.id.fragment_container, homeFragment)
                .add(R.id.fragment_container, regFragment)
                .add(R.id.fragment_container, myAccountFragment)
                .add(R.id.fragment_container, aboutUsFragment).commit();

        fragmentManager.beginTransaction().show(homeFragment).commit();

        NavigationView navigationView = new NavigationView(getApplicationContext());
        navigationView.inflateHeaderView(R.layout.nav_header);
        navigationView.inflateMenu(R.menu.drawer_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.drawer_home:
                        fragmentManager.beginTransaction().show(homeFragment).commit();
                        break;
                    case R.id.drawer_register:
                            fragmentManager.beginTransaction().show(regFragment).commit();
                        break;
                    case R.id.drawer_myaccount:
                            fragmentManager.beginTransaction().show(myAccountFragment).commit();
                        break;
                    case R.id.drawer_about_us:
                            fragmentManager.beginTransaction().show(aboutUsFragment).commit();
                        break;
                }
                return true;
            }
        });
    }
}
