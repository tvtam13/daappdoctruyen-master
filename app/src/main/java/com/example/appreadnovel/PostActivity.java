package com.example.appreadnovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appreadnovel.api.APIClient;
import com.example.appreadnovel.api.TruyenApi;
import com.example.appreadnovel.entities.Truyen;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    EditText editTen, editAnh,editTacgia,editMota,editTrangthai,editSochuong,editTheloai,editLuotxemtuan;
    Button addbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        initview();
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add(view);
            }
        });
    }

    private void initview(){
        editTen = findViewById(R.id.addettentruyen);
        editAnh = findViewById(R.id.addethinhanh);
        editSochuong=findViewById(R.id.addetsochuong);
        editTheloai=findViewById(R.id.addettheloai);
        editLuotxemtuan=findViewById(R.id.addetluotxemtuan);
        editTacgia=findViewById(R.id.addettacgia);
        editMota=findViewById(R.id.addetmota);
        editTrangthai=findViewById(R.id.addettrangthai);
        addbtn = findViewById(R.id.btnAdd);
    }
    private void Add(View view){
        Truyen truyen = new Truyen();
        truyen.setTen_truyen(editTen.getText().toString());
        truyen.setHinh_anh(editAnh.getText().toString());
        truyen.setTac_gia(editTacgia.getText().toString());
        truyen.setMo_ta(editMota.getText().toString());
        truyen.setTrang_thai(editTrangthai.getText().toString());
        truyen.setSo_chuong(Integer.parseInt(editSochuong.getText().toString()));
        truyen.setThe_loai(editTheloai.getText().toString());
        truyen.setLuot_xem_tuan((editLuotxemtuan.getText().toString()));
        TruyenApi truyenApi = APIClient.getClient().create(TruyenApi.class);
        truyenApi.save(truyen).enqueue(new Callback<Truyen>() {
            @Override
            public void onResponse(Call<Truyen> call, Response<Truyen> response) {
                try {
                    if (response.isSuccessful()) {
                        Toast.makeText(getApplication(), "thêm thành công ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(PostActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplication(), response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Truyen> call, Throwable t) {
                Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}