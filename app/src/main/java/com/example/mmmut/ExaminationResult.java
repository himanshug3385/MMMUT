package com.example.mmmut;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ExaminationResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examination_result);
    }
    public void first(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/pdf/Examination%20Manual_MMMUT.pdf"));
        startActivity(intent);
    }
    public void second(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://govexams.com/mmmut/oneview/Default.aspx"));
        startActivity(intent);
    }
    public void third(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/ResultVerification.aspx"));
        startActivity(intent);
    }
    public void fourth(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/ExaminationSchedule.aspx"));
        startActivity(intent);
    }
    public void fivth(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/ModelPapers.aspx"));
        startActivity(intent);
    }
    public void sixth(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://nad.digitallocker.gov.in/students"));
        startActivity(intent);
    }

    public void goback(View view) {
        Intent ii = new Intent(ExaminationResult.this, DashBoard.class);
        startActivity(ii);
    }
}