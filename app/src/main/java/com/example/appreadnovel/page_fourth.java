package com.example.appreadnovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class page_fourth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_page_fourth);
    }

    public void imageview2(View view) {
        ImageView imageView;
        imageView = findViewById(R.id.imageview1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page_fourth.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}