package com.example.appreadnovel.api;

import com.example.appreadnovel.entities.Truyen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TruyenApi {

    @GET("truyen/findall")
    Call<List<Truyen>> findAll();
}
