package com.example.mmmut;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RatingDataAdapter extends RecyclerView.Adapter<RatingDataAdapter.ViewHolder> {
    // creating variables for our ArrayList and context
    private ArrayList<RatingData> ratingArrayList;
    private Context context;
    private StorageReference mstorageReference;


    // creating constructor for our adapter class
    public RatingDataAdapter(ArrayList<RatingData> coursesArrayList, Context context) {
        this.ratingArrayList = coursesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RatingDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.rating_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RatingDataAdapter.ViewHolder holder, int position) {
        // setting data to our text views from our modal class.
        RatingData courses = ratingArrayList.get(position);
       holder.userratingno.setText(courses.getRatingno());
       holder.ratingdesc.setText(courses.getRatingview());
        holder.username.setText("klhk");


    }

    @Override
    public int getItemCount() {
        // returning the size of our array list.
        return ratingArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private final TextView username;
        private final TextView userratingno;
        private final TextView ratingdesc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            username = itemView.findViewById(R.id.userName);
            userratingno = itemView.findViewById(R.id.userratingno);
            ratingdesc = itemView.findViewById(R.id.userratingdesc);


//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                    // after clicking of the item of recycler view.
//                    // we are passing our course object to the new activity.
//                    RatingData courses = coursesArrayList.get(getAdapterPosition());
//
//                    // below line is creating a new intent.
//                    Intent i = new Intent(context, UpdateCourse.class);
//
//                    // below line is for putting our course object to our next activity.
//                    i.putExtra("course", courses);
//
//                    // after passing the data we are starting our activity.
//                    context.startActivity(i);
//                }
//            });
        }
    }
}
