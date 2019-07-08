package com.example.amlakdb_test.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

public class SpacingItemDecoration extends ItemDecoration {
    private boolean includeEdge;
    private int spacingPx;
    private int spanCount;

    public SpacingItemDecoration(int spanCount2, int spacingPx2, boolean includeEdge2) {
        this.spanCount = spanCount2;
        this.spacingPx = spacingPx2;
        this.includeEdge = includeEdge2;
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
        int position = parent.getChildAdapterPosition(view);
        int i = this.spanCount;
        int column = position % i;
        if (this.includeEdge) {
            int i2 = this.spacingPx;
            outRect.left = i2 - ((column * i2) / i);
            outRect.right = ((column + 1) * i2) / i;
            if (position < i) {
                outRect.top = i2;
            }
            outRect.bottom = this.spacingPx;
            return;
        }
        int i3 = this.spacingPx;
        outRect.left = (column * i3) / i;
        outRect.right = i3 - (((column + 1) * i3) / i);
        if (position >= i) {
            outRect.top = i3;
        }
    }
}
