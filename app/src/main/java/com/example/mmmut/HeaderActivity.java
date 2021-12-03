package com.example.mmmut;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class HeaderActivity extends AppCompatActivity {
    private CircleImageView circleImageView;
    private static final int PICK_IMAGE=1;
    Uri imageuri;
    ImageView uploadImg;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);
        circleImageView=findViewById(R.id.profile_image);
        TextView textView = findViewById(R.id.himanshu);
        navigationView=findViewById(R.id.navigationView);
        uploadImg=findViewById(R.id.uploadImg);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.item1:
                        final BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(HeaderActivity.this,R.style.BottomSheetDialogtheme);
                        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.layout_bottom_sheet,(LinearLayout)findViewById(R.id.bottomSheetContainer));
                        bottomSheetView.findViewById(R.id.buttonshare).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(HeaderActivity.this,"Share...",Toast.LENGTH_SHORT).show();
                                bottomSheetDialog.dismiss();
                            }
                        });
                        bottomSheetDialog.setContentView(bottomSheetView);
                        bottomSheetDialog.show();
                        return true;
                    case R.id.item2:
                        startActivity(new Intent(HeaderActivity.this,TimeTable.class));
                        return true;
                    case R.id.item9879:
                        startActivity(new Intent(HeaderActivity.this,RatingBarActivity.class));
                        return true;

                    case R.id.item3:
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse("https://govexams.com/mmmut/oneview/Default.aspx"));
                        startActivity(intent);
                        return true;
                       // https://govexams.com/mmmut/oneview/Default.aspx

                    case R.id.item4:
                        startActivity(new Intent(HeaderActivity.this,UploadDocss.class));
                        return true;
                    case R.id.item5:
                        startActivity(new Intent(HeaderActivity.this,Poper.class));
                        return true;
                    case R.id.item558:
                        Intent intentp = new Intent();
                        intentp.setAction(Intent.ACTION_VIEW);
                        intentp.addCategory(Intent.CATEGORY_BROWSABLE);
                        intentp.setData(Uri.parse("https://www.onlinesbi.com/sbicollect/icollecthome.htm"));
                        startActivity(intentp);
                        return true;
                }
                return true;
            }
        });

        Typeface typeface = ResourcesCompat.getFont(
                this,
                R.font.font1);
        textView.setTypeface(typeface);
        uploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery=new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gallery,"Select Picture"),PICK_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE && resultCode==RESULT_OK){
            imageuri= data.getData();
            try{
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(),imageuri);
                circleImageView.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    boolean zoomed=false;
    public void zoomtoggle(View view) {

        if(!zoomed){
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
            circleImageView.startAnimation(animation);
            zoomed=true;
            return;
        }
        else{
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
            circleImageView.startAnimation(animation);
            zoomed=false;
            return;
        }

    }

    public void sendemail(View view) {
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ "himanshugupta3385@gmail.com"});
        //need this to prompts email client only
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }
}
