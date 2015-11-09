package com.example.xps.v02;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
MainFragment maf;
    static int preItemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBar actionBar=getSupportActionBar();

        actionBar.setDisplayShowHomeEnabled(true);

        maf=new MainFragment();
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.add(R.id.Activitycontainer,maf);
        ft.commit();

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
        preItemId=item.getItemId();
        if (id == R.id.nav_Home) {

        } else if (id == R.id.nav_Alarm) {
                if(preItemId!=id) {
                    emptyBackStack();
                    AlarmFragment alf = new AlarmFragment();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.Activitycontainer, alf);
                    ft.addToBackStack(null);
                    Toast.makeText(this, id + "+" + R.id.Activitycontainer, Toast.LENGTH_SHORT).show();
                    ft.commit();

                }
        } else if (id == R.id.nav_Basket) {
            emptyBackStack();
            BasketFragment bsf = new BasketFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.Activitycontainer, bsf);
            ft.addToBackStack(null);
            Toast.makeText(this,id+"+"+R.id.Activitycontainer,Toast.LENGTH_SHORT).show();
            ft.commit();

        } else if (id == R.id.nav_Buymanage) {
            emptyBackStack();
            BuymanageFragment buf = new BuymanageFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.Activitycontainer, buf);
            ft.addToBackStack(null);
            Toast.makeText(this,id+"+"+R.id.Activitycontainer,Toast.LENGTH_SHORT).show();
            ft.commit();
        } else if (id == R.id.nav_Buyrequestlist) {
            emptyBackStack();
            BuyrequestlistFragment brf = new BuyrequestlistFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.Activitycontainer, brf);
            ft.addToBackStack(null);
            Toast.makeText(this,id+"+"+R.id.Activitycontainer,Toast.LENGTH_SHORT).show();
            ft.commit();
        } else if (id == R.id.nav_Setting) {
            emptyBackStack();
            SettingFragment stf = new SettingFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.Activitycontainer, stf);
            ft.addToBackStack(null);
            Toast.makeText(this,id+"+"+R.id.Activitycontainer,Toast.LENGTH_SHORT).show();
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void emptyBackStack(){
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }
}
