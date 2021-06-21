package com.example.quiz_app.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    EditText email;
    EditText password;
    TextView btnSignUp;

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = findViewById(R.id.btnLogin);
        email = findViewById(R.id.etEmailAddressLogin);
        password = findViewById(R.id.etPasswordLogin);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
        auth = FirebaseAuth.getInstance();

        // Checking if user is already logged in !
        if(auth.getCurrentUser() != null){
            Log.i("TAG", "onCreate: UserLoggedIN "+auth.getCurrentUser().getEmail());

        }
        // User SignIn function will be called

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSignIn();;
            }
        });

    }
    public void userSignIn(){
        String email_val = email.getText().toString().trim();
        String password_val = password.getText().toString().trim();

        if(email_val.isEmpty() || password_val.isEmpty()){
            Toast.makeText(LoginActivity.this,"Empty Fields!",Toast.LENGTH_SHORT).show();
            return;
        }
        auth.signInWithEmailAndPassword(email_val,password_val).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()){
                    // failed
                    Toast.makeText(LoginActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this,"Login Success!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }

            }
        });

    }
}