package com.example.mmmut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class DashBoard extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    public ActionBarDrawerToggle actionBarDrawerToggle;
private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.DrawerLayout);
        toolbar=findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24);
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
//
//        // pass the Open and Close toggle for the drawer layout listener
//        // to toggle the button
//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_account:{
                        Intent i = new Intent(DashBoard.this, MYprofile.class);
                        startActivity(i);
                        return true;}
                    // break;
                    case R.id.nav_acadmics:{
                        Intent ii = new Intent(DashBoard.this, Acadmics.class);
                        startActivity(ii);
                        return true;}
                    // break;
                    case R.id.nav_settings:{
                        Intent iii = new Intent(DashBoard.this, Appsetting.class);
                        startActivity(iii);
                        return true;}
                    // break;
                    case R.id.nav_logout:{
                        firebaseAuth.signOut();
                        Intent io = new Intent(DashBoard.this, LoginActivity.class);
                        startActivity(io);
                        return true;}
                    // break;

                }
                return false;
            }
        });
    }
        @Override
        public void onBackPressed() {super.onBackPressed();
        finishAffinity();
        finish();

        }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.nav_acadmics:
                Intent intent = new Intent(this, Acadmics.class);
                this.startActivity(intent);
                break;
            case R.id.nav_account:
                // another startActivity, this is for item with id "menu_item2"
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    public void gotoacadmics(View view) {
        Intent ii = new Intent(DashBoard.this, Acadmics.class);
        startActivity(ii);
    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.app_bar:
//                drawerLayout.openDrawer(GravityCompat.START);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
// to make the Navigation drawer icon always appear on the action bar



    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//        switch (item.getItemId()) {
//            case R.id.nav_account:
//                logouthoja();
//                break;
//            case R.id.nav_acadmics:
//                showAcadmics();
//                break;
//            case R.id.nav_settings:
//                showHelp();
//                break;
//            case R.id.nav_logout:
//                logouthoja();
//                break;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//
//        if (id == R.id.nav_logout) {
//
//            firebaseAuth.signOut();
//            Intent i=new Intent(DashBoard.this,LoginActivity.class);
//            startActivity(i);
//            return  true;
//        }
//
//        if (id == R.id.nav_account) {
//            Intent i=new Intent(DashBoard.this,MYprofile.class);
//            startActivity(i);
//            return true;
//        }
//
//        if (id == R.id.nav_settings) {
//            Intent i=new Intent(DashBoard.this,Appsetting.class);
//            startActivity(i);
//            return true;
//        }
//         if (id == R.id.nav_acadmics) {
//            Intent i=new Intent(DashBoard.this,Acadmics.class);
//             startActivity(i);
//            return true;
//        }
//
//
//        return super.onOptionsItemSelected(item);
//    }
//

