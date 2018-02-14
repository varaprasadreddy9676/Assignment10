package com.example.sdc.assignment10;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public TextView title;
    public TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

        title =findViewById(R.id.text_view_title);
        desc = findViewById(R.id.text_desc);
        title.setText(getString(R.string.home_title));
        desc.setText(getString(R.string.home_description));
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            title.setText(getString(R.string.home_title));
            desc.setText(getString(R.string.home_description));
        } else if (id == R.id.nav_aboutus) {
            title.setText(getString(R.string.about_us_title));
            desc.setText(Html.fromHtml(getString(R.string.about_us_description)));

        } else if (id == R.id.nav_academics) {
            title.setText(getString(R.string.academics_title));
            desc.setText(Html.fromHtml(getString(R.string.academics_des)));

        } else if (id == R.id.nav_admissions) {
            title.setText(getString(R.string.admissions_title));
            desc.setText(Html.fromHtml(getString(R.string.admissions_desc)));

        } else if (id == R.id.nav_departments) {
            title.setText(getString(R.string.departments_title));
            desc.setText(Html.fromHtml(getString(R.string.departments_desc)));

        } else if (id == R.id.nav_nirf) {
            title.setText(getString(R.string.nirf_title));
            desc.setText(Html.fromHtml(getString(R.string.nirf_desc)));


        }else if (id == R.id.nav_placements) {
            title.setText(getString(R.string.placements_title));
            desc.setText(Html.fromHtml(getString(R.string.placement_desc)));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
