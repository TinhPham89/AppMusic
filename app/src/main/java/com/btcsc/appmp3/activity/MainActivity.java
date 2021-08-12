package com.btcsc.appmp3.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.btcsc.appmp3.R;
import com.btcsc.appmp3.fragment.HomeFragment;
import com.btcsc.appmp3.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                showFragment(item.getItemId());
                return true;
            }
        });
        showFragment(R.id.home);
    }

    public void showFragment(int itemId) {

        Fragment fragment = null;
        switch (itemId)
        {
            case R.id.home:
            {
                fragment = new HomeFragment();
                break;
            }
            case R.id.search :
            {
                fragment = new SearchFragment();
                break;
            }
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment,"TAG").commit();

    }
}