package com.example.login_screen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button login;
    TextView signup;
    EditText lemail;
    EditText lpassword;



FirebaseAuth firebaseAuth;

ProgressBar progressBar;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        firebaseAuth=FirebaseAuth.getInstance();
        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        lemail=(EditText)findViewById(R.id.lemail);
        lpassword=(EditText)findViewById(R.id.lpassword);
login=(Button)findViewById(R.id.btn_login);

signup=(TextView) findViewById(R.id.signup_tbtn);
        final Intent intent= new Intent(getApplicationContext(), signupp.class);
      if(firebaseAuth.getCurrentUser()!=null)
        {
            Intent intent1=new Intent(MainActivity.this,WelcomeScreen.class);
            startActivity(intent1);
            MainActivity.this.finish();
        }



login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String usr_email=lemail.getText().toString();
        String usr_password=lpassword.getText().toString();

        if(TextUtils.isEmpty(usr_email)||TextUtils.isEmpty(usr_password)){

            lemail.setError("This Field cannot be empty.");
            lpassword.setError("This field cannot be empty.");
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(usr_email,usr_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressBar.setVisibility(View.VISIBLE);
                    Intent intent1=new Intent(MainActivity.this,WelcomeScreen.class);
                    startActivity(intent1);
                    MainActivity.this.finish();
                    Toast.makeText(MainActivity.this,"User logged in.",Toast.LENGTH_SHORT).show();

                }else Toast.makeText(MainActivity.this,"E-mail and password doesn't match.",Toast.LENGTH_SHORT).show();
            }
        });
    }
});




        signup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        signup.setTextColor(Color.WHITE);
        startActivity(intent);

    }
});




    }

}