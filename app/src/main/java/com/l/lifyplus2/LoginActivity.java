package com.l.lifyplus2;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText mEmail,mPassword;
    Button mloginBtn;
    TextView mCreateBtn,forgottextLink;
    ProgressBar progressBar;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.inputEmail);
        mPassword = findViewById((R.id.inputPassword1));
        progressBar = findViewById(R.id.progressBar1);
        fAuth=FirebaseAuth.getInstance();
        mloginBtn = findViewById(R.id.login3);
        mCreateBtn = findViewById(R.id.signup02);
        forgottextLink = findViewById(R.id.forgotPassword);

        mloginBtn.setOnClickListener(v -> {
            String email = mEmail.getText().toString().trim();
            String password = mPassword.getText().toString().trim();

            if(TextUtils.isEmpty(email)){
                mEmail.setError("Email is Required.");
                return;
            }

            if(TextUtils.isEmpty(password)){
                mPassword.setError("Password is Required.");
                return;
            }

            if(password.length()< 6){
                mPassword.setError("Password must be >= 6 characters");
                return;
            }
            progressBar.setVisibility(View.VISIBLE);

            //Authenticate
            fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),Form2.class));

                }else{
                    Toast.makeText(LoginActivity.this, "Error"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);
                }

            });
        });
        mCreateBtn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(),RegisterActivity.class)));


        forgottextLink.setOnClickListener(v -> {
            EditText resetMail = new EditText((v.getContext()));
            AlertDialog.Builder passwordResetDialogue = new AlertDialog.Builder(v.getContext());
            passwordResetDialogue.setTitle("Reset Password?");
            passwordResetDialogue.setMessage("Enter Your Email:");
            passwordResetDialogue.setView(resetMail);

            passwordResetDialogue.setPositiveButton("Yes", (dialog, which) -> {
                //Extract the mail and request link
                String mail = resetMail.getText().toString();
                fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(aVoid -> Toast.makeText(LoginActivity.this,"Reset link sent to your mail",Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Toast.makeText(LoginActivity.this,"Error ! Reset Link Is Not Sent"+ e.getMessage(),Toast.LENGTH_SHORT).show());


            });
            passwordResetDialogue.setNegativeButton("No", (dialog, which) -> {
                //close the dialog

            });
            passwordResetDialogue.create().show();
        });


}}