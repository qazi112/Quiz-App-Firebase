package com.example.quiz_app.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quiz_app.R;
import com.google.firebase.auth.FirebaseAuth;

public class Loginintro extends AppCompatActivity {
    Button getStarted;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginintro);
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null){
            // User Exists
            startActivity(new Intent(Loginintro.this, MainActivity.class));
            // if logged in, no need to back
            finish();
        }

        getStarted = findViewById(R.id.loginGetStarted);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Loginintro.this, LoginActivity.class));
            }
        });
    }
}