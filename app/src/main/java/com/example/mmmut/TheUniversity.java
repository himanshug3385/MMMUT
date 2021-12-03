package com.example.mmmut;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class TheUniversity extends AppCompatActivity {
    ImageButton arrow,arrow11,arrow12;
    LinearLayout hiddenView,hiddenView11,hiddenView12;
    CardView cardView,cardView11,cardView12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_university);

        cardView11 = findViewById(R.id.base_cardview11);
        arrow11 = findViewById(R.id.arrow_button11);
        hiddenView11 = findViewById(R.id.hidden_view11);
        cardView12 = findViewById(R.id.base_cardview12);
        arrow12 = findViewById(R.id.arrow_button12);
        hiddenView12 = findViewById(R.id.hidden_view12);

        arrow11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView12.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView12,
                            new AutoTransition());
                    hiddenView12.setVisibility(View.GONE);
                    arrow12.setImageResource(R.drawable.ic_baseline_expand);
                }

                if (hiddenView11.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView11,
                            new AutoTransition());
                    hiddenView11.setVisibility(View.GONE);
                    arrow11.setImageResource(R.drawable.ic_baseline_expand);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView11,
                            new AutoTransition());
                    hiddenView11.setVisibility(View.VISIBLE);
                    arrow11.setImageResource(R.drawable.ic_baseline_expandless);
                }
            }
        });


        arrow12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hiddenView11.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView11,
                            new AutoTransition());
                    hiddenView11.setVisibility(View.GONE);
                    arrow11.setImageResource(R.drawable.ic_baseline_expand);
                }


                if (hiddenView12.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView12,
                            new AutoTransition());
                    hiddenView12.setVisibility(View.GONE);
                    arrow12.setImageResource(R.drawable.ic_baseline_expand);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView12,
                            new AutoTransition());
                    hiddenView12.setVisibility(View.VISIBLE);
                    arrow12.setImageResource(R.drawable.ic_baseline_expandless);
                }
            }
        });
    }

    public void goback(View view) {
        Intent i =new Intent(getApplicationContext(),DashBoard.class);
        startActivity(i);
    }

    public void aboutus(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/About.aspx"));
        startActivity(intent);
    }

    public void chancllor(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/Chancellor.aspx"));
        startActivity(intent);
    }

    public void adminstr(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/Administration.aspx"));
        startActivity(intent);
    }

    public void stragetuc(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/StrategicPlan.aspx"));
        startActivity(intent);
    }

    public void orgstr(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/OrganizationalStructure.aspx"));
        startActivity(intent);
    }

    public void actsta(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/Acts_Status.aspx"));
        startActivity(intent);
    }


    public void locationcam(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/LocationCampus.aspx"));
        startActivity(intent);
    }

    public void courtcases(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/pdf/MMMCourtCases.pdf"));
        startActivity(intent);
    }

    public void univlogo(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/images/largelogo.jpg"));
        startActivity(intent);
    }

    public void annualrepo(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/UniversityReports.aspx"));
        startActivity(intent);
    }

    public void uniaucerti(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/AuditCertificate.aspx"));
        startActivity(intent);
    }

    public void photoga(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/Photogallary1.aspx"));
        startActivity(intent);
    }

    public void videogall(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.mmmut.ac.in/video_youtube.aspx"));
        startActivity(intent);
    }
}