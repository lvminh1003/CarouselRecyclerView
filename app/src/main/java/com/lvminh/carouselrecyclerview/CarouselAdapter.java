package com.lvminh.carouselrecyclerview;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder> {
    private List<Integer> carouselList;

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Integer> carouselList) {
        this.carouselList = carouselList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carousel, parent, false);
        return new CarouselViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
        Integer carouselNumber = carouselList.get(position);

        holder.carouselItemNumber.setText(Integer.toString(carouselNumber));
    }

    @Override
    public int getItemCount() {
        return carouselList.size();
    }

    public static class CarouselViewHolder extends RecyclerView.ViewHolder {
        private TextView carouselItemNumber;

        public CarouselViewHolder(@NonNull View itemView) {
            super(itemView);
            carouselItemNumber = itemView.findViewById(R.id.carousel_item_number);
        }
    }
}
