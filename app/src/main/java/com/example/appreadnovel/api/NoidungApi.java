package com.example.appreadnovel.api;

import com.example.appreadnovel.entities.Noidung;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NoidungApi {

    @GET("noidung/first/{id}")
    Call<Noidung> doctudau(@Path("id") int id);
}
