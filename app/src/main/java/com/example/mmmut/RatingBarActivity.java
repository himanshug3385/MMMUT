package com.example.mmmut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class RatingBarActivity extends AppCompatActivity {
    RatingBar rt;
    TextView writereview;
    EditText writereviewedt;
    private RecyclerView courseRV;
    private ArrayList<RatingData> ratingArrayList;
    private RatingDataAdapter courseRVAdapter;
    FirebaseStorage storage;
    StorageReference storageReference;
    private FirebaseFirestore db;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;
    ProgressBar loadingPB;
    String ratingdatareviewstr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);
        rt = (RatingBar) findViewById(R.id.ratingBar);
        writereview=findViewById(R.id.writereviewetxt);
        writereviewedt=findViewById(R.id.writereviewedt);
        LayerDrawable stars=(LayerDrawable)rt.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);



        courseRV = findViewById(R.id.idRVCourses);
        loadingPB = findViewById(R.id.idProgressBar);
        db = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        firebaseDatabase=FirebaseDatabase.getInstance();
        reference=firebaseDatabase.getReference("RatingData");
        ratingArrayList = new ArrayList<>();
        courseRV.setHasFixedSize(true);
        courseRV.setLayoutManager(new LinearLayoutManager(this));
       courseRVAdapter = new RatingDataAdapter(ratingArrayList, this);
        courseRV.setAdapter(courseRVAdapter);


    }
    public void showdata(){
        db.collection("RatingData").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            loadingPB.setVisibility(View.GONE);
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                RatingData c = d.toObject(RatingData.class);
                                c.setId(d.getId());
                                ratingArrayList.add(c);
                            }
                            courseRVAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(RatingBarActivity.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RatingBarActivity.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void addDataToFirestore(String ratingno, String ratingview) {
        CollectionReference dbCourses = db.collection("RatingData");
        RatingData courses = new RatingData(ratingno, ratingview);
        dbCourses.add(courses).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(RatingBarActivity.this, "Rated", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RatingBarActivity.this, "Fail to add course \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        showdata();
        super.onStart();

    }

    public void Call(View v)
    {
        // This function is called when button is clicked.
        // Display ratings, which is required to be converted into string first.
       // TextView t = (TextView)findViewById(R.id.textView2);
       // t.setText("You Rated :"+String.valueOf(rt.getRating()));
        ratingdatareviewstr=writereviewedt.getText().toString();
        if(ratingdatareviewstr==null)
            ratingdatareviewstr="nullhaiji";

        addDataToFirestore(String.valueOf(rt.getRating()),ratingdatareviewstr);
        showdata();
        writereviewedt.setVisibility(View.GONE);
        rt.setRating(0);
    }

    public void openwritereview(View view) {
        writereviewedt.setVisibility(View.VISIBLE);
    }
}