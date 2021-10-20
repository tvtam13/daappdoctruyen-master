package com.example.appreadnovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class page_third extends AppCompatActivity {
    Button btn1, btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_page_third);
        btn1 = findViewById(R.id.buttondt);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page_third.this, page_chuongtruyen.class);
                startActivity(intent);
            }
        });
        btn2 = findViewById(R.id.buttonds);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page_third.this, page_five.class);
                startActivity(intent);
            }
        });

    }

    public void onclickimageview4(View view) {
        ImageView imageView4;
        imageView4 = findViewById(R.id.imageview4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page_third.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}