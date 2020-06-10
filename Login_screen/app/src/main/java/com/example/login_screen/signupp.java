package com.example.login_screen;

import android.app.Activity;
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


import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.widget.Toast.makeText;

public class signupp extends Activity {

    Button rsignup;
    TextView already_signed_up;
    EditText rusername;
    EditText new_password;
    EditText re_password;
    EditText remail;

    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    FirebaseFirestore firebaseFirestore;
    String UserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

setContentView(R.layout.signup);

firebaseAuth=FirebaseAuth.getInstance();
firebaseFirestore=FirebaseFirestore.getInstance();
progressBar=(ProgressBar)findViewById(R.id.progressBar);

        rsignup=(Button)findViewById(R.id.btn_signup);
        already_signed_up=(TextView)findViewById(R.id.already_signed_tbtn);
        rusername=(EditText)findViewById(R.id.username);
        new_password=(EditText)findViewById(R.id.r_password);
        re_password=(EditText)findViewById(R.id.r_repassword);
        remail=(EditText)findViewById(R.id.r_email);
        final Intent intent= new Intent(getApplicationContext(), MainActivity.class);
        already_signed_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                already_signed_up.setTextColor(Color.WHITE);

                startActivity(intent);
                signupp.this.finish();

            }
        });

rsignup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        final String email=remail.getText().toString();
        String password1=new_password.getText().toString();
        String password2=re_password.getText().toString();
        final String username=rusername.getText().toString();
        String password;

        if(TextUtils.isEmpty(email)||TextUtils.isEmpty(password1)||TextUtils.isEmpty(password2)||TextUtils.isEmpty(username)){
            remail.setError("This Field cannot be empty.");
            new_password.setError("This Field cannot be empty.");
            re_password.setError("This Field cannot be empty.");
            rusername.setError("This Field cannot be empty.");
            return;
        }
        if(!(password1.equals(password2))){
            new_password.setError("Password doesn't match");
            re_password.setError("Password doesn't match");
        }else password=password1;
       if(password1.length()<6){
           new_password.setError("Password must be minumum 6 characters long");
       }

       //Backend Process
        firebaseAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressBar.setVisibility(View.VISIBLE);
                    Toast.makeText(signupp.this,"Registeration was succesfull",Toast.LENGTH_SHORT).show();
                   UserId=firebaseAuth.getCurrentUser().getUid();
                    DocumentReference documentReference=firebaseFirestore.collection("users").document(UserId);
                    Map<String,Object> user=new HashMap<>();
                    user.put("Username",username);
                    user.put("E-mail",email);
                   documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                       @Override
                       public void onSuccess(Void aVoid) {
                           Intent intent1=new Intent(signupp.this,WelcomeScreen.class);
                           startActivity(intent1);
                           signupp.this.finish();
                       }
                   });

                }else {

                  Toast.makeText(signupp.this,"Error"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
});
    }
}
