package com.example.appreadnovel.api;

import com.example.appreadnovel.entities.Truyen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TruyenApi {

    @GET("v3/6d6b4d12-b80d-4964-971e-6f79f3cddf78")
    Call<List<Truyen>> findAll();
    @GET("truyen/search/{keyword}")
    Call<List<Truyen>>search(@Path("keyword") String keyword);
    @DELETE("truyen/delete/{id}")
    Call<Void>delete(@Path("id")int id);


}

