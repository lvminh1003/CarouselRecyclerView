package com.lvminh.carouselrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CarouselActivity extends AppCompatActivity {
    private RecyclerView carouselRecyclerView;
    private CarouselAdapter carouselAdapter;
    private CarouselLayoutManager carouselLayoutManager;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel);
        carouselRecyclerView = findViewById(R.id.carouse_recycle_view);
        carouselAdapter = new CarouselAdapter();
        carouselLayoutManager = new CarouselLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, true);
        carouselRecyclerView.setAdapter(carouselAdapter);
        carouselRecyclerView.setLayoutManager(carouselLayoutManager);
        List<Integer> carouselItems = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            carouselItems.add(i);
        }
        carouselAdapter.setData(carouselItems);
    }
}