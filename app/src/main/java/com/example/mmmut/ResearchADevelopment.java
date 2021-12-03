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

 public class ResearchADevelopment extends AppCompatActivity {
     ImageButton arrow,arrow1,arrow2;
     LinearLayout hiddenView,hiddenView1,hiddenView2;
     CardView cardView,cardView1,cardView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_research_adevelopment);
        cardView = findViewById(R.id.base_cardview);
        arrow = findViewById(R.id.arrow_button);
        hiddenView = findViewById(R.id.hidden_view);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                //  to gone and change the expand less icon to expand more.
                if (hiddenView.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenView.setVisibility(View.GONE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenView.setVisibility(View.VISIBLE);
                    arrow.setImageResource(R.drawable.ic_baseline_expandless);
                }
            }
        });

    }

     public void researchpro(View view) {
         Intent intent = new Intent();
         intent.setAction(Intent.ACTION_VIEW);
         intent.addCategory(Intent.CATEGORY_BROWSABLE);
         intent.setData(Uri.parse("http://www.mmmut.ac.in/ViewSponsoredProjects.aspx"));
         startActivity(intent);
     }

     public void consultancy(View view) {
         Intent intent = new Intent();
         intent.setAction(Intent.ACTION_VIEW);
         intent.addCategory(Intent.CATEGORY_BROWSABLE);
         intent.setData(Uri.parse("http://www.mmmut.ac.in/ViewTestingConsultancyProjects.aspx"));
         startActivity(intent);
     }

     public void publication(View view) {
         Intent intent = new Intent();
         intent.setAction(Intent.ACTION_VIEW);
         intent.addCategory(Intent.CATEGORY_BROWSABLE);
         intent.setData(Uri.parse("http://www.mmmut.ac.in/ViewPublication.aspx"));
         startActivity(intent);
     }

     public void patents(View view) {
         Intent intent = new Intent();
         intent.setAction(Intent.ACTION_VIEW);
         intent.addCategory(Intent.CATEGORY_BROWSABLE);
         intent.setData(Uri.parse("http://www.mmmut.ac.in/IQAC#"));
         startActivity(intent);
     }

     public void phdawarded(View view) {
         Intent intent = new Intent();
         intent.setAction(Intent.ACTION_VIEW);
         intent.addCategory(Intent.CATEGORY_BROWSABLE);
         intent.setData(Uri.parse("http://www.mmmut.ac.in/PhDAwarded.aspx"));
         startActivity(intent);
     }

     public void icaq(View view) {
         Intent intent = new Intent();
         intent.setAction(Intent.ACTION_VIEW);
         intent.addCategory(Intent.CATEGORY_BROWSABLE);
         intent.setData(Uri.parse("http://www.mmmut.ac.in/IQAC.aspx"));
         startActivity(intent);
     }

     public void design(View view) {
         Intent intent = new Intent();
         intent.setAction(Intent.ACTION_VIEW);
         intent.addCategory(Intent.CATEGORY_BROWSABLE);
         intent.setData(Uri.parse("http://www.mmmut.ac.in/DIIC_Web"));
         startActivity(intent);
     }

     public void policies(View view) {
         Intent intent = new Intent();
         intent.setAction(Intent.ACTION_VIEW);
         intent.addCategory(Intent.CATEGORY_BROWSABLE);
         intent.setData(Uri.parse("http://www.mmmut.ac.in/PoliciesGuidelines.aspx"));
         startActivity(intent);
     }
     public void goback(View view) {
         Intent ii = new Intent(ResearchADevelopment.this, DashBoard.class);
         startActivity(ii);
     }
 }