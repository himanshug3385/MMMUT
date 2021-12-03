package com.example.mmmut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class TandP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tand_p);
    }

    public void overview(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/Training_Placement.aspx"));
        startActivity(intent);
    }
    public void second(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/Pdf/Placement%20Broucher%2020-21%20N.pdf"));
        startActivity(intent);
    }
    public void third(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/Pdf/Placement_Policy-MMMUT.pdf"));
        startActivity(intent);
    }
    public void fourth(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/Corporate_Linkages.aspx"));
        startActivity(intent);
    }
    public void fivth(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/View_PlacedStudentManagement.aspx"));
        startActivity(intent);
    }
    public void sixth(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/GATEResult.aspx"));
        startActivity(intent);
    }
    public void seventh(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/TrainingActivities.aspx"));
        startActivity(intent);
    }
    public void eight(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/pdf/TNPContact.pdf"));
        startActivity(intent);
    }

    public void goback(View view) {
        Intent ii = new Intent(TandP.this, DashBoard.class);
        startActivity(ii);
    }
}