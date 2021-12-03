package com.example.mmmut;
import com.google.firebase.firestore.Exclude;

import java.io.Serializable;

public class RatingData implements Serializable {

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Exclude
    private String id;
    private String ratingno,ratingview;
    public RatingData() {
    }
    public RatingData(String ratingno, String ratingview) {
       this.ratingno=ratingno;
       this.ratingview=ratingview;
    }
    public String getRatingno() {
        return ratingno;
    }
    public void setRatingno(String ratingno) {
        this.ratingno = ratingno;
    }
    public String getRatingview() {
        return ratingview;
    }
    public void setRatingview(String ratingview) { this.ratingview = ratingview; }
}
