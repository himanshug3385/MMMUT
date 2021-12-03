package com.example.mmmut;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class TimeTable extends AppCompatActivity {
    ImageView tabletableimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);
        tabletableimg=findViewById(R.id.timetbimg);


    }


    boolean zoomed=false;
    public void zoomtoggle(View view) {


        if(!zoomed){
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
            tabletableimg.startAnimation(animation);
            zoomed=true;
            return;
        }
        else{
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
            tabletableimg.startAnimation(animation);
            zoomed=false;
            return;
        }

    }
}