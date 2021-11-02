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

    EditText edName, edImg,edTacgia,edMota,edTrangthai,edsochuong,edtheloai,edluotxemtuan;
    Button btnupdate;
    Integer id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        edName = findViewById(R.id.ettentruyen);
        edImg = findViewById(R.id.ethinhanh);
        edTacgia = findViewById(R.id.ettacgia);
        edMota = findViewById(R.id.etmota);
        edTrangthai = findViewById(R.id.ettrangthai);
        edsochuong = findViewById(R.id.etsochuong);
        edtheloai = findViewById(R.id.ettheloai);
        edluotxemtuan = findViewById(R.id.etluotxemtuan);
        btnupdate = findViewById(R.id.sua);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Update(view);
            }
        });
        loadData();
    }
    private void loadData(){
        Intent intent = getIntent();
        Truyen truyen = (Truyen) intent.getSerializableExtra("truyen");
        edName.setText(truyen.getTen_truyen());
        edImg.setText(truyen.getHinh_anh());
        edTacgia.setText(truyen.getTac_gia());
        edMota.setText(truyen.getTac_gia());
        edTrangthai.setText(truyen.getTrang_thai());
        edMota.setText(truyen.getMo_ta());
        edsochuong.setText(String.valueOf(truyen.getSo_chuong()));
        edtheloai.setText(truyen.getThe_loai());
        edluotxemtuan.setText(truyen.getLuot_xem_tuan());
        id = truyen.getId_truyen();
    }
    private Update(View view)
    {
        Truyen truyen = new Truyen();
        truyen.setId_truyen(Integer.parseInt(id.toString()));
        truyen.setTen_truyen(edName.getText().toString());
        truyen.setHinh_anh(edImg.getText().toString());
        truyen.setTac_gia(edTacgia.getText().toString());
        truyen.setMo_ta(edMota.getText().toString());
        truyen.setTrang_thai(edTrangthai.getText().toString());
        truyen.setMo_ta(edMota.getText().toString());
        truyen.setSo_chuong(Integer.parseInt(edsochuong.getText().toString()));
        truyen.setThe_loai(edtheloai.getText().toString());
        truyen.setLuot_xem_tuan((edluotxemtuan.getText().toString()));
        TruyenApi truyenApi = APIClient.getClient().create(TruyenApi.class);
        truyenApi.save(truyen).enqueue(new Callback<Truyen>() {
            @Override
            public void onResponse(Call<Truyen> call, Response<Truyen> response) {
                try {
                    if (response.isSuccessful()) {
                        Toast.makeText(getApplication(), "thêm thành công ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(PostActivity.this, page_third.class);
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