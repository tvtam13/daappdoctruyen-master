package com.example.appreadnovel.api;

import com.example.appreadnovel.entities.Truyen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TruyenApi {

    @GET("truyen/findall")
    Call<List<Truyen>> findAll();
    @GET("truyen/search/{keyword}")
    Call<List<Truyen>>search(@Path("keyword") String keyword);

}

