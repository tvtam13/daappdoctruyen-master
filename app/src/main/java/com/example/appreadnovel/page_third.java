package com.example.appreadnovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appreadnovel.api.APIClient;
import com.example.appreadnovel.api.NoidungApi;
import com.example.appreadnovel.api.TruyenApi;
import com.example.appreadnovel.entities.Noidung;
import com.example.appreadnovel.entities.Truyen;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class page_third extends AppCompatActivity {
    Button  btnds, btn3,btnpost,btnfirstread;
    TextView tvName, tvTheLoai, tvChuong, tvMota, tvTacgia;
    ImageView img;
    TruyenApi methods;
    String Trangthai,Hinhanh,Luotxemtuan;
    int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_page_third);
        btnfirstread = findViewById(R.id.btndoctudau);
        btn3 = findViewById(R.id.xoa);
        btnfirstread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Truyen truyen = new Truyen();
                truyen.setId_truyen(id);
                Intent intent = new Intent(page_third.this, page_five.class);
                intent.putExtra("idtruyen",truyen);
                startActivity(intent);
            }
        });
        btnds = findViewById(R.id.buttonds);
        btnds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(page_third.this, page_five.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Buttondeleteonclick(v);

            }
        });
        tvName = findViewById(R.id.tentruyen);
        tvTheLoai = findViewById(R.id.theloai);
        tvChuong = findViewById(R.id.chuong);
        tvMota = findViewById(R.id.mota);
        tvTacgia = findViewById(R.id.tacgia);
        img = findViewById(R.id.imageView);
        methods = APIClient.getClient().create(TruyenApi.class);
        Truyen truyens = (Truyen) getIntent().getExtras().get("article");
        setData(truyens);


        btnpost = findViewById(R.id.sua);
        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Postintentdata(view);
            }
        });

    }

    private void setData(Truyen truyens) {
        tvName.setText(truyens.getTen_truyen());
        tvTheLoai.setText(truyens.getThe_loai());
        tvChuong.setText(String.valueOf(truyens.getSo_chuong()));
        tvMota.setText(truyens.getMo_ta());
        tvTacgia.setText(truyens.getTac_gia());
        Picasso.get().load(truyens.getHinh_anh()).into(img);
        id = truyens.getId_truyen();
        Trangthai = truyens.getTrang_thai();
        Hinhanh = truyens.getHinh_anh();
        Luotxemtuan = truyens.getLuot_xem_tuan();

    }

    public void onclickimageview4(View view)
    {
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
    private void Buttondeleteonclick (View view)
    {
        TruyenApi truyenApi = APIClient.getClient().create(TruyenApi.class);
        truyenApi.delete(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                try {
                    if (response.isSuccessful()) {
                        Toast.makeText(getApplication(), "xoa thanh cong", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(page_third.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplication(), response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void Postintentdata(View view){
        Truyen truyen = new Truyen();
        truyen.setId_truyen(id);
        truyen.setTen_truyen((tvName.getText().toString()));
        truyen.setHinh_anh(Hinhanh.toString());
        truyen.setTac_gia(tvTacgia.getText().toString());
        truyen.setMo_ta(tvMota.getText().toString());
        truyen.setTrang_thai(Trangthai.toString());
        truyen.setSo_chuong(Integer.parseInt(tvChuong.getText().toString()));
        truyen.setThe_loai(tvTheLoai.getText().toString());
        truyen.setLuot_xem_tuan(Luotxemtuan.toString());
        Intent intent = new Intent(page_third.this, PutActivity.class);
        intent.putExtra("truyen",truyen);
        startActivity(intent);
    }

}