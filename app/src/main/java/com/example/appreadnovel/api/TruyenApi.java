package com.example.appreadnovel.api;

import com.example.appreadnovel.entities.Truyen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface TruyenApi {

    @GET("truyen/findall")
    Call<List<Truyen>> findAll();
    @GET("truyen/search/{keyword}")
    Call<List<Truyen>>search(@Path("keyword") String keyword);
    @DELETE("truyen/delete/{id}")
    Call<Void>delete(@Path("id")int id);
    @PUT("truyen/update")
    Call<Truyen>update(@Body Truyen truyen);
    @POST("truyen/save")
    Call<Truyen> save (@Body Truyen truyen);


    // chờ tí viết tiếp api doc truyenko bit
// xoay nội dung ntn ?
    // kêu trí đưa code

}

