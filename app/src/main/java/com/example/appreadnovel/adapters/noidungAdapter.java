package com.example.appreadnovel.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.appreadnovel.R;
import com.example.appreadnovel.entities.Noidung;
import com.example.appreadnovel.entities.Truyen;

import java.util.List;

public class noidungAdapter extends ArrayAdapter<Noidung> {

    private Context context;
    private List<Noidung> noidungs;
// chưa dùng
    public noidungAdapter(List<Noidung> noidungs, Context context) {
        super(context, R.layout.truyen_layout, noidungs);
        this.context = context;
        this.noidungs = noidungs;
    }
}
