package com.example.appreadnovel.entities;

import java.io.Serializable;

public class Noidung implements Serializable {

    private int id_nd;
    private String noi_dung_chuong;
    private String noi_dung_truyen;
    private int id_truyen;

    public int getId_nd() {
        return id_nd;
    }

    public void setId_nd(int id_nd) {
        this.id_nd = id_nd;
    }

    public String getNoi_dung_chuong() {
        return noi_dung_chuong;
    }

    public void setNoi_dung_chuong(String noi_dung_chuong) {
        this.noi_dung_chuong = noi_dung_chuong;
    }

    public String getNoi_dung_truyen() {
        return noi_dung_truyen;
    }

    public void setNoi_dung_truyen(String noi_dung_truyen) {
        this.noi_dung_truyen = noi_dung_truyen;
    }

    public int getId_truyen() {
        return id_truyen;
    }

    public void setId_truyen(int id_truyen) {
        this.id_truyen = id_truyen;
    }
}
