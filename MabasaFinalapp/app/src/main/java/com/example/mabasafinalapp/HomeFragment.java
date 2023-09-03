package com.example.mabasafinalapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private TextView tv;
    private ImageView iv;
    private Spinner sp;
    private ListView lv;
    private String[] cityNames;
    private ArrayList<ArrayList<Cities>> allCities;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment, container, false);
        init();
        iv = v.findViewById(R.id.imageView);
        sp = v.findViewById(R.id.spinner);
        lv = v.findViewById(R.id.listview);
        ArrayAdapter<String> spAdapter = new ArrayAdapter<String>(v.getContext(), android.R.layout.simple_list_item_1, cityNames);
        sp.setAdapter(spAdapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Cities> currentCity = allCities.get(position);
                updateListView(currentCity);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                updateListViewItemAtPosition(position);
            }

        });
        return v;
    }
        private void updateListViewItemAtPosition(int position) {
            CityAdapter adapter = (CityAdapter) lv.getAdapter();
            Cities cities = adapter.getItem(position);
            iv.setImageResource(cities.getPicId());
        }
        private void updateListView(ArrayList<Cities> currentCity) {
            CityAdapter adap = new CityAdapter(getContext(), currentCity);
            lv.setAdapter(adap);
            updateListViewItemAtPosition(0);
        }
        private void init() {
            cityNames = new String[]{"Jinhua", "Hangzhou", "Chengdu"};
            allCities = new ArrayList<>();
            ArrayList<Cities> Jinhua = new ArrayList<>();
            Jinhua.add(new Cities("Zhejiang Normal University", R.drawable.zjnu));
            Jinhua.add(new Cities("Dragon Cave", R.drawable.dragon_cave));
            Jinhua.add(new Cities("Jinhua River", R.drawable.jinhua_river));
            allCities.add(Jinhua);
            ArrayList<Cities> Hangzhou = new ArrayList<>();
            Hangzhou.add(new Cities("West Lake", R.drawable.westlake));
            Hangzhou.add(new Cities("Wulin Square", R.drawable.wulin_square));
            Hangzhou.add(new Cities("Qianjiang city", R.drawable.hangzhoucity));
            allCities.add(Hangzhou);
            ArrayList<Cities> Chengdu = new ArrayList<>();
            Chengdu.add(new Cities("Panda Base", R.drawable.panda_base));
            Chengdu.add(new Cities("Pearl Tower", R.drawable.west_pearltower));
            Chengdu.add(new Cities("Giant Buddha", R.drawable.leshan_giant));
            allCities.add(Chengdu);
        }


    }

