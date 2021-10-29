package com.example.appreadnovel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.appreadnovel.adapters.truyenAdapter;
import com.example.appreadnovel.api.APIClient;
import com.example.appreadnovel.api.TruyenApi;
import com.example.appreadnovel.entities.Truyen;

import java.io.BufferedInputStream;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    String ulraddress= "http://192.168.1.8:9191/api/truyen/findall";
    ListView listViewTruyen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
    }
    private void initView(){
        listViewTruyen = findViewById(R.id.listview);
    }
    private void loadData(){
        TruyenApi truyenApi = APIClient.getClient().create(TruyenApi.class);
        truyenApi.findAll().enqueue(new Callback<List<Truyen>>(){
            @Override
            public void onResponse(Call<List<Truyen>> call, Response<List<Truyen>> response) {
                try {
                    if (response.isSuccessful()) {
                        List<Truyen> truyens = response.body();
                        listViewTruyen.setAdapter(new truyenAdapter(truyens,getApplication()));
                    } else {
                        Toast.makeText(getApplication(), response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        @Override
        public void onFailure(Call<List<Truyen>> call, Throwable t) {
            Toast.makeText(getApplication(),t.getMessage(), Toast.LENGTH_SHORT).show();
        }
        });
        }

}