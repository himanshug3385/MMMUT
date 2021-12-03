package com.example.mmmut;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText emailTextView, passwordTextView;
    private TextView Btn,forgetbtn;
    private ProgressBar progressbar;
    ProgressDialog loadingBar;
    public ProgressDialog loginprogress;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        loginprogress=new ProgressDialog(this);
        emailTextView = findViewById(R.id.email);
        passwordTextView = findViewById(R.id.password);
        Btn = findViewById(R.id.login);
        progressbar = findViewById(R.id.progressBar);
        forgetbtn=findViewById(R.id.forgetpass);
        forgetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRecoverPasswordDialog();
            }
        });
    }
    private void showRecoverPasswordDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Recover Password");
        LinearLayout linearLayout=new LinearLayout(this);
        final EditText emailet= new EditText(this);
        emailet.setHint("Enter recovery email");
        emailet.setMinEms(16);
        emailet.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        linearLayout.addView(emailet);
        linearLayout.setPadding(10,10,10,10);
        builder.setView(linearLayout);
        builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String email=emailet.getText().toString().trim();
                beginRecovery(email);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    private void beginRecovery(String email) {
        loadingBar=new ProgressDialog(this);
        loadingBar.setMessage("Sending Link....");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    loadingBar.dismiss();
                    Toast.makeText(LoginActivity.this,"Done sent",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(LoginActivity.this,"Error Occured",Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                loadingBar.dismiss();
                Toast.makeText(LoginActivity.this,"Error Failed",Toast.LENGTH_LONG).show();
            }
        });

    }
    public void loginUser(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(
                                    @NonNull Task<AuthResult> task)
                            {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(),
                                            "Login successful!!",
                                            Toast.LENGTH_LONG)
                                            .show();

                                    // hide the progress bar
                                    progressbar.setVisibility(View.GONE);

                                    // if sign-in is successful
                                    // intent to home activity
                                    Intent intent
                                            = new Intent(LoginActivity.this, DashBoard.class);
                                    startActivity(intent);
                                    finish();
                                }

                                else {

                                    // sign-in failed
                                    Toast.makeText(getApplicationContext(),
                                            "Login failed!!",
                                            Toast.LENGTH_LONG)
                                            .show();

                                    // hide the progress bar
                                    progressbar.setVisibility(View.GONE);
                                }
                            }
                        });
//        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if(task.isSuccessful()){
//                    loginprogress.dismiss();
//                    Intent mainIntent = new Intent(LoginActivity.this,DashBoard.class);
//                    mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(mainIntent);
//                    finish();
//                } else {
//                    loginprogress.hide();
//                    Toast.makeText(LoginActivity.this,"Cannot Sign In..Plaese Try Again",Toast.LENGTH_LONG);
//                }
//            }
//        });
       // progressbar.setVisibility(View.GONE);
    }
    public void sigup(View view) {
        Intent intent
                = new Intent(LoginActivity.this,
                RegistrationActivity.class);
        startActivity(intent);
    }

    public void login(View view) {
        progressbar.setVisibility(View.VISIBLE);
        String email,passw;
        email=emailTextView.getText().toString();
        passw=passwordTextView.getText().toString();
        loginUser(email,passw);
    }
}
//    private void loginUserAccount()
//    {
//
//        // show the visibility of progress bar to show loading
//        progressbar.setVisibility(View.VISIBLE);
//        // Take the value of two edit texts in Strings
//        String email, password;
//        email = emailTextView.getText().toString();
//        password = passwordTextView.getText().toString();
//
//        // validations for input email and password
//        if (TextUtils.isEmpty(email)) {
//            Toast.makeText(getApplicationContext(),
//                    "Please enter email!!",
//                    Toast.LENGTH_LONG)
//                    .show();
//            return;
//        }
//
//        if (TextUtils.isEmpty(password)) {
//            Toast.makeText(getApplicationContext(),
//                    "Please enter password!!",
//                    Toast.LENGTH_LONG)
//                    .show();
//            return;
//        }
//
//        // signin existing user
//        mAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(
//                        new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(
//                                    @NonNull Task<AuthResult> task)
//                            {
//                                if (task.isSuccessful()) {
//                                    Toast.makeText(getApplicationContext(),
//                                            "Login successful!!",
//                                            Toast.LENGTH_LONG)
//                                            .show();
//
//                                    // hide the progress bar
//                                    progressbar.setVisibility(View.GONE);
//
//                                    // if sign-in is successful
//                                    // intent to home activity
//                                    Intent intent
//                                            = new Intent(LoginActivity.this, DashBoard.class);
//                                    startActivity(intent);
//                                    finish();
//                                }
//
//                                else {
//
//                                    // sign-in failed
//                                    Toast.makeText(getApplicationContext(),
//                                            "Login failed!!",
//                                            Toast.LENGTH_LONG)
//                                            .show();
//
//                                    // hide the progress bar
//                                    progressbar.setVisibility(View.GONE);
//                                }
//                            }
//                        });
//    }

