package com.example.a7segmanetdisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.Timer;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {
int n;
Button btn,rst;
ImageView A,B,C,D,E,F,G;
EditText input;
String in;
TextView contact,abt;
ImageView instagram;
    boolean click=true;





    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instagram=(ImageView) findViewById(R.id.insta);
        instagram.setImageResource(R.drawable.insta);
        instagram.setVisibility(View.INVISIBLE);

        contact=(TextView) findViewById(R.id.contact);
        abt=(TextView) findViewById(R.id.about);
        input = (EditText) findViewById(R.id.num);
        A = (ImageView) findViewById(R.id.a);
        A = (ImageView) findViewById(R.id.a);
        F = (ImageView) findViewById(R.id.f);
        D = (ImageView) findViewById(R.id.d);
        G = (ImageView) findViewById(R.id.g);
        B = (ImageView) findViewById(R.id.b);
        C = (ImageView) findViewById(R.id.c);
        E = (ImageView) findViewById(R.id.e);
        rst = (Button) findViewById(R.id.rst);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                in = input.getText().toString();
                if (in.charAt(0) == '8') {
                    A.setImageResource(R.drawable.a);
                    F.setImageResource(R.drawable.f);
                    D.setImageResource(R.drawable.d);
                    G.setImageResource(R.drawable.g);
                    B.setImageResource(R.drawable.b);
                    C.setImageResource(R.drawable.c);
                    E.setImageResource(R.drawable.e);
                } else if (in.charAt(0) == '1') {
                    C.setImageResource(R.drawable.c);
                    F.setImageResource(R.drawable.f);

                } else if (in.charAt(0) == '2') {
                    A.setImageResource(R.drawable.a);
                    C.setImageResource(R.drawable.c);
                    D.setImageResource(R.drawable.d);
                    E.setImageResource(R.drawable.e);
                    G.setImageResource(R.drawable.g);
                } else if (in.charAt(0) == '3') {
                    A.setImageResource(R.drawable.a);
                    C.setImageResource(R.drawable.c);
                    D.setImageResource(R.drawable.d);
                    G.setImageResource(R.drawable.g);
                    F.setImageResource(R.drawable.f);

                } else if (in.charAt(0) == '4') {
                    B.setImageResource(R.drawable.b);
                    C.setImageResource(R.drawable.c);
                    D.setImageResource(R.drawable.d);
                    F.setImageResource(R.drawable.f);

                } else if (in.charAt(0) == '5') {
                    A.setImageResource(R.drawable.a);
                    F.setImageResource(R.drawable.f);
                    D.setImageResource(R.drawable.d);
                    G.setImageResource(R.drawable.g);
                    B.setImageResource(R.drawable.b);

                } else if (in.charAt(0) == '6') {
                    A.setImageResource(R.drawable.a);
                    F.setImageResource(R.drawable.f);
                    D.setImageResource(R.drawable.d);
                    G.setImageResource(R.drawable.g);
                    B.setImageResource(R.drawable.b);
                    E.setImageResource(R.drawable.e);
                } else if (in.charAt(0) == '7') {
                    C.setImageResource(R.drawable.c);
                    F.setImageResource(R.drawable.f);
                    A.setImageResource(R.drawable.a);
                } else if (in.charAt(0) == '9') {
                    A.setImageResource(R.drawable.a);
                    F.setImageResource(R.drawable.f);
                    D.setImageResource(R.drawable.d);
                    G.setImageResource(R.drawable.g);
                    B.setImageResource(R.drawable.b);
                    C.setImageResource(R.drawable.c);

                } else if (in.charAt(0) == '0') {
                    A.setImageResource(R.drawable.a);
                    F.setImageResource(R.drawable.f);

                    G.setImageResource(R.drawable.g);
                    B.setImageResource(R.drawable.b);
                    C.setImageResource(R.drawable.c);
                    E.setImageResource(R.drawable.e);
                }
                input.setEnabled(false);
                rst.setVisibility(View.VISIBLE);
                btn.setVisibility(View.INVISIBLE);
            }
        });

        rst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                input.setText(null);
                recreate();

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click==true)
                {instagram.setVisibility(View.VISIBLE);
                 click=false;}
                else
                {instagram.setVisibility(View.INVISIBLE);

                click=true;}




            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.instagram.com/harimancodes/"));
                startActivity(intent);
            }
        });



        abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Created by:"+"harimancodes." +
                        "\nVersion: 1.0.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
