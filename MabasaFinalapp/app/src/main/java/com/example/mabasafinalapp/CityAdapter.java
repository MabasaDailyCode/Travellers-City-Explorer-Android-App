package com.example.mabasafinalapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CityAdapter extends ArrayAdapter<com.example.mabasafinalapp.Cities> {
    private Context context;
    private ArrayList<com.example.mabasafinalapp.Cities> list;
    private ImageView iv;
    private TextView tv;
    public CityAdapter(@NonNull Context context, ArrayList<Cities> list) {
        super(context, android.R.layout.simple_list_item_1,list);
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v;
        if(convertView==null){
            v = LayoutInflater.from(context).inflate(R.layout.row_view,null,false);
        }
        else{
            v=convertView;
        }
        iv = v.findViewById(R.id.imageView2);
        tv = v.findViewById(R.id.textView2);
        Cities cities = list.get(position);
        iv.setImageResource(cities.getPicId());
        tv.setText(cities.getName());
        return v;
    }
}
