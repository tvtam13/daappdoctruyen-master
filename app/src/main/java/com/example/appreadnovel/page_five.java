package com.example.appreadnovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appreadnovel.api.APIClient;
import com.example.appreadnovel.api.NoidungApi;
import com.example.appreadnovel.entities.Noidung;
import com.example.appreadnovel.entities.Truyen;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class page_five extends AppCompatActivity {

    TextView tvten,tvnoidung;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_page_doctruyen_chuong1);
        tvten = findViewById(R.id.tennoidung);
        tvnoidung = findViewById(R.id.noidung);


        Intent intent = getIntent();
        Truyen truyen = (Truyen) intent.getSerializableExtra("idtruyen");
        id = truyen.getId_truyen();
        firstread();

    }

    private void firstread(){
        NoidungApi noidungApi = APIClient.getClient().create(NoidungApi.class);
        noidungApi.doctudau(id).enqueue(new Callback<List<Noidung>>() {
            @Override
            public void onResponse(Call<List<Noidung>> call, Response<List<Noidung>> response) {
                try {
                    if (response.isSuccessful()) {
                        List<Noidung> noidungs = response.body();

                    } else {
                        Toast.makeText(getApplication(), response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Noidung>> call, Throwable t) {
                Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}