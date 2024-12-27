package com.jaguar.toolkit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jaguar.toolkit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = binding.incNavbar.navView;

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_all_tools, R.id.navigation_fav_tools, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.navhost);
        NavigationUI.setupWithNavController(binding.incNavbar.navView, navController);

        Toolbar toolbar = binding.incAppbar.materialToolbar;
        toolbar.setTitle(R.string.app_name);
        toolbar.setLogo(R.mipmap.ic_logo);
        setSupportActionBar(toolbar);
    }
}