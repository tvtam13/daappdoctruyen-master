package com.example.appreadnovel.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appreadnovel.R;
import com.example.appreadnovel.entities.Truyen;

import java.util.List;

public class truyenAdapter extends ArrayAdapter<Truyen> {

    private Context context;
    private List<Truyen> truyens;

    public truyenAdapter(List<Truyen> truyens, Context context) {
        super(context, R.layout.truyen_layout, truyens);
        this.context = context;
        this.truyens = truyens;
    }

    @Override
    public Truyen getItem(int index) {
        return this.truyens.get(index);
    }

    @NonNull
    @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater LayoutInflater = android.view.LayoutInflater.from(context);
            convertView = LayoutInflater.inflate(R.layout.truyen_layout, parent,false);
            viewHolder.getTentruyen = convertView.findViewById(R.id.tentruyen);
            viewHolder.getTacgia = convertView.findViewById(R.id.tacgia);
            viewHolder.getTrangthai = convertView.findViewById(R.id.trangthai);
            viewHolder.getchuong = convertView.findViewById(R.id.chuong);
            viewHolder.getImageView = convertView.findViewById(R.id.imageView);
            viewHolder.getTheLoai = convertView.findViewById(R.id.theloai);
            viewHolder.getMota = convertView.findViewById(R.id.mota);
        }else {

            viewHolder = (ViewHolder) convertView.getTag();
        }
        Truyen truyen = truyens.get(position);
        Picasso.get().load(truyen.getHinh_anh()).into(viewHolder.getImageView);
        viewHolder.getTentruyen.setText(truyen.getTen_truyen());
        viewHolder.getTacgia.setText(truyen.getTac_gia());
        viewHolder.getTrangthai.setText(truyen.getTrang_thai());
        viewHolder.getchuong.setText(String.valueOf(truyen.getSo_chuong()));
        //viewHolder.getImageView.setText(truyen.getHinh_anh());
            return convertView;
        }
        private  static  class  ViewHolder{
            public static TextView getTentruyen;
            public static TextView getTacgia;
            public static TextView getTrangthai;
            public static TextView getchuong;
            public static ImageView getImageView;
            public static TextView getTheLoai;
            public static TextView getMota;
            public static EditText bitmap;
        }
}
