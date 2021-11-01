package com.example.appreadnovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appreadnovel.adapters.truyenAdapter;
import com.example.appreadnovel.api.APIClient;
import com.example.appreadnovel.api.TruyenApi;
import com.example.appreadnovel.entities.Truyen;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Retrofit;

public class page_third extends AppCompatActivity {
    Button btn1, btn2;
    TextView tvName,tvTheLoai,tvChuong,tvMota,tvTacgia;
    ImageView img;
    TruyenApi methods;
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

        tvName = findViewById(R.id.tentruyen);
        tvTheLoai = findViewById(R.id.theloai);
        tvChuong = findViewById(R.id.chuong);
        tvMota = findViewById(R.id.mota);
        tvTacgia = findViewById(R.id.tacgia);
        img = findViewById(R.id.imageView);
        methods = APIClient.getClient().create(TruyenApi.class);
        Truyen truyens =(Truyen) getIntent().getExtras().get("article");
        setData(truyens);
    }

    private void setData(Truyen truyens) {
        tvName.setText(truyens.getTen_truyen());
        tvTheLoai.setText(truyens.getThe_loai());
        tvChuong.setText(String.valueOf(truyens.getSo_chuong()));
        tvMota.setText(truyens.getMo_ta());
        tvTacgia.setText(truyens.getTac_gia());
        Picasso.get().load(truyens.getHinh_anh()).into(img);
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