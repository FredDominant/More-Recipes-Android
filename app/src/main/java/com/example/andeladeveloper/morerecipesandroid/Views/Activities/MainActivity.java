package com.example.andeladeveloper.morerecipesandroid.Views.Activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.andeladeveloper.morerecipesandroid.Models.Recipe;
import com.example.andeladeveloper.morerecipesandroid.Presenters.GetAllRecipesPresenter;
import com.example.andeladeveloper.morerecipesandroid.R;

import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        GetAllRecipesPresenter.IGetAllRecipesPresenterInterface {

    private GetAllRecipesPresenter getAllRecipesPresenter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ConstraintLayout constraintLayout;
    private List<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        initializeSwipeRefreshLayout();
        initializePresenter();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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

        if (id == R.id.nav_menu_user_profile) {
            // Handle the camera action
        } else if (id == R.id.nav_menu_user_recipes) {

        } else if (id == R.id.nav_menu_favourites) {

        } else if (id == R.id.nav_menu_settings) {

        } else if (id == R.id.nav_menu_logout) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void initializePresenter() {
        Log.i("", "initializePresenter: was called");
        if (getAllRecipesPresenter == null) {
            getAllRecipesPresenter = new GetAllRecipesPresenter(this);
        }
        getAllRecipesPresenter.getAllRecipesNetworkCall();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void initializeSwipeRefreshLayout() {
        swipeRefreshLayout = findViewById(R.id.main_activity_swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initializePresenter();
            }
        });
    }

        @Override
        public void onGetAllRecipesFailure(boolean status) {
        if (status) {
            constraintLayout = findViewById(R.id.main_activity_constraint_layout);
            Snackbar.make(constraintLayout, "Unable to connect", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            initializePresenter();
                        }
                    })
                    .show();
            }

         }

        @Override
        public void onGetAllRecipesSuccess(List<Recipe> recipes) {
            this.recipes = recipes;
        }
    }
