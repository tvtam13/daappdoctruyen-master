package com.example.appreadnovel.entities;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Truyen implements Serializable {


    @SerializedName("id_truyen")
    private int id_truyen;
    @SerializedName("ten_truyen")
    private String ten_truyen;
    @SerializedName("hinh_anh")
    private String hinh_anh;
    @SerializedName("tac_gia")
    private String tac_gia;
    @SerializedName("mo_ta")
    private String mo_ta;
    @SerializedName("trang_thai")
    private String trang_thai;
    @SerializedName("so_chuong")
    private int so_chuong;
    @SerializedName("the_loai")
    private String the_loai;
    @SerializedName("luot_xem_tuan")
    private String luot_xem_tuan;

    public Truyen() {
    }

    public int getId_truyen() {
        return id_truyen;
    }

    public void setId_truyen(int id_truyen) {
        this.id_truyen = id_truyen;
    }

    public String getTen_truyen() {
        return ten_truyen;
    }

    public void setTen_truyen(String ten_truyen) {
        this.ten_truyen = ten_truyen;
    }

    public String getHinh_anh() {
        return hinh_anh;
    }

    public void setHinh_anh(String hinh_anh) {
        this.hinh_anh = hinh_anh;
    }

    public String getTac_gia() {
        return tac_gia;
    }

    public void setTac_gia(String tac_gia) {
        this.tac_gia = tac_gia;
    }

    public String getMo_ta() {
        return mo_ta;
    }

    public void setMo_ta(String mo_ta) {
        this.mo_ta = mo_ta;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    public int getSo_chuong() {
        return so_chuong;
    }

    public void setSo_chuong(int so_chuong) {
        this.so_chuong = so_chuong;
    }

    public String getThe_loai() {
        return the_loai;
    }

    public void setThe_loai(String the_loai) {
        this.the_loai = the_loai;
    }

    public String getLuot_xem_tuan() {
        return luot_xem_tuan;
    }

    public void setLuot_xem_tuan(String luot_xem_tuan) {
        this.luot_xem_tuan = luot_xem_tuan;
    }
}
