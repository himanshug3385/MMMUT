package com.example.mmmut;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.Viewholder> {

    private Context context;
    private ArrayList<CardModal> courseModelArrayList;
private  Cardclicklistener cardclicklistener;
    // Constructor
    public CourseAdapter(Context context, ArrayList<CardModal> courseModelArrayList,Cardclicklistener cardclicklistener) {
        this.context = context;
        this.courseModelArrayList = courseModelArrayList;
        this.cardclicklistener=cardclicklistener;
    }

    @NonNull
    @Override
    public CourseAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new Viewholder(view,cardclicklistener);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        CardModal model = courseModelArrayList.get(position);
        holder.courseNameTV.setText(model.getCourse_name());
        holder.courseRatingTV.setText("" + model.getCourse_rating());
        holder.courseIV.setImageResource(model.getCourse_image());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return courseModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView courseIV;
        private TextView courseNameTV, courseRatingTV;
Cardclicklistener cardclicklistener;
        public Viewholder(@NonNull View itemView,Cardclicklistener c) {
            super(itemView);
            courseIV = itemView.findViewById(R.id.imgcard);
            courseNameTV = itemView.findViewById(R.id.albumtitle);
            courseRatingTV = itemView.findViewById(R.id.albumdesc);
            this.cardclicklistener=c;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
cardclicklistener.onCardClick(getAdapterPosition());
        }
    }
    public interface Cardclicklistener{
        void onCardClick(int position);
    }
}