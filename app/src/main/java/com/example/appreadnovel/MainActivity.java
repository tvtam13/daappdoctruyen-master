package com.example.appreadnovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appreadnovel.adapters.truyenAdapter;
import com.example.appreadnovel.api.APIClient;
import com.example.appreadnovel.api.TruyenApi;
import com.example.appreadnovel.entities.Truyen;

import java.io.BufferedInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    ListView listViewTruyen;

    truyenAdapter truyenAdapters;
    Button btnadd;
    EditText timkiem;
    Button timkiem2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        timkiem2 = findViewById(R.id.timkiem2);
        timkiem = findViewById(R.id.timkiem);
        timkiem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timkiem(v);
            }
        });
        listViewTruyen = findViewById(R.id.listview);
        btnadd = findViewById(R.id.addtruyen);

    }

    //kêu trí vào, cái search nó đâu mất r
    private void loadData() {
        TruyenApi truyenApi = APIClient.getClient().create(TruyenApi.class);
        truyenApi.findAll().enqueue(new Callback<List<Truyen>>() {
            @Override
            public void onResponse(Call<List<Truyen>> call, Response<List<Truyen>> response) {
                try {
                    if (response.isSuccessful()) {
                        List<Truyen> truyens = response.body();
                        truyenAdapters = new truyenAdapter(truyens, getApplication());
                        listViewTruyen.setAdapter(truyenAdapters);
                        listViewTruyen.setOnItemClickListener((parent, view, position, id) -> {
                            Intent intent = new Intent(MainActivity.this, page_third.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("article", truyenAdapters.getItem(position));
                            intent.putExtras(bundle);
                            startActivity(intent);
                        });
                    } else {
                        Toast.makeText(getApplication(), response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Truyen>> call, Throwable t) {
                Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void timkiem(View v) {
        String keyword = timkiem.getText().toString();
        TruyenApi truyenApi = APIClient.getClient().create(TruyenApi.class);
        truyenApi.search(keyword).enqueue(new Callback<List<Truyen>>() {
            @Override
            public void onResponse(Call<List<Truyen>> call, Response<List<Truyen>> response) {
                try {
                    if (response.isSuccessful()) {
                        List<Truyen> truyens = response.body();
                        truyenAdapters = new truyenAdapter(truyens, getApplication());
                        listViewTruyen.setAdapter(truyenAdapters);
                        listViewTruyen.setOnItemClickListener((parent, view, position, id) -> {
                            Intent intent = new Intent(MainActivity.this, page_third.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("article", truyenAdapters.getItem(position));

                            intent.putExtras(bundle);
                            startActivity(intent);
                        });
                    } else {
                        Toast.makeText(getApplication(), response.errorBody().toString(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplication(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Truyen>> call, Throwable t) {
                Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}