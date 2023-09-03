package com.example.mabasafinalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected( MenuItem item) {
            Fragment f = null;
            switch (item.getItemId()){
                case R.id.home:
                    f = new HomeFragment();
                    break;
                case R.id.camera:
                    f = new CameraFragment();
                    break;
                case R.id.my_location:
                    f = new LocationFragment();
                    break;
                case R.id.counter:
                    f = new CounterFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.for_fragments,f).commit();
            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.btn_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigation);
    }
}