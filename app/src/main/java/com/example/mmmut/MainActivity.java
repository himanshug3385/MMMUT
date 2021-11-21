package com.example.mmmut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {
    MediaController mediaControls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        handler.postDelayed(run, 6000);
        VideoView videoView =(VideoView)findViewById(R.id.videoView1);

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vnvid));
        if (mediaControls == null) {
            // create an object of media controller class
            mediaControls = new MediaController(MainActivity.this);
            mediaControls.setAnchorView(videoView);
            mediaControls.setVisibility(View.GONE);
        }

        // set the media controller for video view
        videoView.setMediaController(mediaControls);
        // set the uri for the video view
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vnvid));
        // start a video
        videoView.start();
        videoView.seekTo(-1);
    }
    Handler handler = new Handler();

    Runnable run = new Runnable() {

        public void run() {
            // TODO Auto-generated method stub
            startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            overridePendingTransition(0, 0);
            finish();
        }
    };


}