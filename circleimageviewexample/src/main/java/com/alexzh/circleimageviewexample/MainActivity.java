package com.alexzh.circleimageviewexample;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        setUpToolbar();
        ((NavigationView)findViewById(R.id.navigation)).setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ProfileFragment())
                .commit();
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        menuItem.setChecked(true);
        switch (menuItem.getItemId()) {
            case R.id.item_profile:
                mDrawerLayout.closeDrawers();
                Snackbar.make(findViewById(R.id.container), R.string.action_profile, Snackbar.LENGTH_SHORT).show();
                return true;
            case R.id.item_settings:
                mDrawerLayout.closeDrawers();
                Snackbar.make(findViewById(R.id.container), R.string.action_settings, Snackbar.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}

