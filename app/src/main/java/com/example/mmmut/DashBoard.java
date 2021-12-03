package com.example.mmmut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class DashBoard extends AppCompatActivity implements CourseAdapter.Cardclicklistener{
    public DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView courseRV;
    Dialog dialog;
    private  ActionBarDrawerToggle t;
    TextView txtclose;
    Button btnfollow;
    // Arraylist for storing data
    private ArrayList<CardModal> courseModelArrayList;
    private  RecyclerView.LayoutManager layoutManager;
    private Toolbar toolbar;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    private FirebaseAuth firebaseAuth;
    private Context context=this;
    MenuItem item_your_choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        dialog = new Dialog(this);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);

        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.navigationdrawericon);




        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.nav_account:
                        Toast.makeText(getApplicationContext(),"gf1",Toast.LENGTH_SHORT).show();
                    case R.id.nav_logout:
                        Toast.makeText(getApplicationContext(),"gf2",Toast.LENGTH_SHORT).show();
                    case R.id.nav_settings:
                        Toast.makeText(getApplicationContext(),"gf3",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });


        courseRV = findViewById(R.id.recyclercard);
        courseModelArrayList = new ArrayList<>();
        courseModelArrayList.add(new CardModal("The University", "More..", R.drawable.mmmut1));
        courseModelArrayList.add(new CardModal("Acadmics", "More..", R.drawable.mmmut2));
        courseModelArrayList.add(new CardModal("Research & Development", "More..", R.drawable.mmmut3));
        courseModelArrayList.add(new CardModal("Campus Facities", "More..", R.drawable.mmmut4));
        courseModelArrayList.add(new CardModal("Training & Placement", "More..", R.drawable.mmmut5));
        courseModelArrayList.add(new CardModal("Examination & Result", "More..", R.drawable.mmmut6));
        courseModelArrayList.add(new CardModal("Careers", "More..", R.drawable.mmmut7));
        courseModelArrayList.add(new CardModal("Alumni", "More..", R.drawable.mmmut9));
        courseModelArrayList.add(new CardModal("NAAC", "More..", R.drawable.mmmut8));
        CourseAdapter courseAdapter = new CourseAdapter(this, courseModelArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        courseRV.setLayoutManager(linearLayoutManager);
        courseRV.setAdapter(courseAdapter);
//
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        item_your_choice = menu.findItem(R.id.nav_settings);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        finish();
    }


    public void gotoacadmics(View view) {
        Intent ii = new Intent(DashBoard.this, Acadmics.class);
        startActivity(ii);
    }

    public void gotoprofile(View view) {
        Intent ii = new Intent(DashBoard.this, ProfilePic.class);
        startActivity(ii);
    }

    @Override
    public void onCardClick(int position) {
if(position==1){
            Intent ii = new Intent(DashBoard.this, Acadmics.class);
            startActivity(ii);
        }
else if(position==7){
    dialog.setContentView(R.layout.aluminilayout);
    txtclose=dialog.findViewById(R.id.textclose);
    btnfollow=dialog.findViewById(R.id.btnfollow);

    txtclose.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dialog.dismiss();
        }
    });
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    dialog.show();
}
else if(position==8){
    Intent ii = new Intent(DashBoard.this, NAAC.class);
    startActivity(ii);
}
else if(position==6){
    Intent ii = new Intent(DashBoard.this, CarrerActivity.class);
    startActivity(ii);
}
else if(position==5){
    Intent ii = new Intent(DashBoard.this, ExaminationResult.class);
    startActivity(ii);
}
else if(position==4){
    Intent ii = new Intent(DashBoard.this, TandP.class);
    startActivity(ii);
}
else if(position==3){
    Intent ii = new Intent(DashBoard.this, CampusFacutly.class);
    startActivity(ii);
}
else if(position==2){
    Intent ii = new Intent(DashBoard.this, ResearchADevelopment.class);
    startActivity(ii);
}
else if(position==0){
    Intent ii = new Intent(DashBoard.this, TheUniversity.class);
    startActivity(ii);
}



    }

    public void facebook(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.facebook.com/mmmut.ac.in"));
        startActivity(intent);
    }

    public void twitter(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://twitter.com/MmmutOfficial"));
        startActivity(intent);
    }

    public void linkedin(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.linkedin.com/school/madan-mohan-malaviya-university-of-technology/"));
        startActivity(intent);
    }

    public void youtube(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.youtube.com/user/mmmut1"));
        startActivity(intent);
    }

    public void personactivity(View view) {
        Intent t=new Intent(getApplicationContext(),HeaderActivity.class);
        startActivity(t);
    }

    public void notification(View view) {
        Intent t=new Intent(getApplicationContext(),Notification.class);
        startActivity(t);
    }

    public void dashboardd(View view) {
        Intent t=new Intent(getApplicationContext(),DashBoard.class);
        startActivity(t);
    }

    public void gotomaa(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.alumni.mmmut.ac.in/Pdf/MAABy-Laws_21-08-2018.pdf"));
        startActivity(intent);
    }
    public void gotoac(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.alumni.mmmut.ac.in/Alumni_Chapters.aspx"));
        startActivity(intent);
    }
    public void gotoam(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.alumni.mmmut.ac.in/Forthcoming_Alumni_Meet.aspx"));
        startActivity(intent);
    }

    public void followme(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://www.facebook.com/profile.php?id=100065597281129"));
        startActivity(intent);
    }


}
