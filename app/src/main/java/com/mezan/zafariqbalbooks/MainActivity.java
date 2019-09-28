package com.mezan.zafariqbalbooks;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListAdapter adapter;
    String[] categoryName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView();


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
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            mainListView();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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

        if (id == R.id.nav_all) {
            mainListView();
        } else if (id == R.id.nav_science_fiction) {
            ScienceFictionView();
        } else if (id == R.id.nav_math_and_science) {
                MathAndScienceView();
        } else if (id == R.id.nav_stories) {
            StoriesView();
        }else if (id == R.id.nav_auto_biography) {
            AutoBiographyView();
        }else if (id == R.id.nav_others) {
            OthersView();
        }
        else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void mainListView(){
       ListView main_list = findViewById(R.id.book_list);
        categoryName = getResources().getStringArray(R.array.category);
        adapter = new ListAdapter(categoryName, this);
        main_list.setAdapter(adapter);

        main_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    ScienceFictionView();
                }else if (i == 1){
                    MathAndScienceView();
                }else if (i == 2){
                    StoriesView();
                }else if(i == 3){
                    AutoBiographyView();
                }else if (i == 4){
                    OthersView();
                }else {
                    /*Do Nothing*/
                }
            }
        });

    }
    private void ScienceFictionView(){
      ListView  main_list = findViewById(R.id.book_list);
        categoryName = getResources().getStringArray(R.array.ScienceFictionList);
        adapter = new ListAdapter(categoryName, this);
        main_list.setAdapter(adapter);
    }
    private void MathAndScienceView(){
       ListView main_list = findViewById(R.id.book_list);
        categoryName = getResources().getStringArray(R.array.mathscience);
        adapter = new ListAdapter(categoryName, this);
        main_list.setAdapter(adapter);
    }
    private void StoriesView(){
       ListView main_list = findViewById(R.id.book_list);
        categoryName = getResources().getStringArray(R.array.stories);
        adapter = new ListAdapter(categoryName, this);
        main_list.setAdapter(adapter);
    }
    private void AutoBiographyView(){
      ListView  main_list = findViewById(R.id.book_list);
        categoryName = getResources().getStringArray(R.array.autobiography);
        adapter = new ListAdapter(categoryName, this);
        main_list.setAdapter(adapter);
    }
    private void OthersView(){
       ListView main_list = findViewById(R.id.book_list);
        categoryName = getResources().getStringArray(R.array.others);
        adapter = new ListAdapter(categoryName, this);
        main_list.setAdapter(adapter);
    }


}
