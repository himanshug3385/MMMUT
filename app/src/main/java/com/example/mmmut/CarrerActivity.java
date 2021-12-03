package com.example.mmmut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class CarrerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrer);
    }

    public void prpos(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/ViewAdvertismentforvaccantpositionPP.aspx"));
        startActivity(intent);
    }

    public void ntpos(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/ViewAdvertismentforvaccantpositionNTP.aspx"));
        startActivity(intent);
    }

    public void fapos(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/ViewAdvertismentforvaccantposition.aspx"));
        startActivity(intent);
    }

    public void goback(View view) {
        Intent ii = new Intent(CarrerActivity.this, DashBoard.class);
        startActivity(ii);
    }
}