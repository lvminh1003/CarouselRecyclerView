package com.lvminh.carouselrecyclerview;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CarouselLayoutManager extends LinearLayoutManager {
    public CarouselLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        setUpLayout((float)getHeight()/2);
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int scrolled = super.scrollVerticallyBy(dy, recycler, state);
        setUpLayout((float)getHeight()/2);
        return scrolled;
    }

    public void setUpLayout(float d1) {
        float minifyAmount = 0.25f;
        float minifyDistance = 0.75f;

        float parentMidpoint = getWidth() / 2.f;
        float d0 = 0.f;
        d1 = d1 * minifyDistance;
        float s0 = 1.f;
        float s1 = 1.f - minifyAmount;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (null != child) {
                float childMidpoint = (getDecoratedTop(child) + getDecoratedBottom(child)) / 2.f;
                float d = Math.min(d1, Math.abs(parentMidpoint - childMidpoint));
                float scaleFactor = s0 + (s1 - s0) * (d - d0) / (d1 - d0);
                child.setScaleX(scaleFactor);
                child.setScaleY(scaleFactor);
            }
        }
    }
}
