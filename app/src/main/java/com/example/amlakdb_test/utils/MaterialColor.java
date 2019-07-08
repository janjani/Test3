package com.example.amlakdb_test.utils;

import android.content.Context;
import android.content.res.TypedArray;
import java.util.Random;

public class MaterialColor {
    private static Random r = new Random();

    public static int randInt(int max) {
        return r.nextInt(max);
    }

    public static int getColor(Context ctx) {
        int arrayId = ctx.getResources().getIdentifier("mdcolor_random", "array", ctx.getPackageName());
        if (arrayId == 0) {
            return -1;
        }
        TypedArray colors = ctx.getResources().obtainTypedArray(arrayId);
        double random = Math.random();
        double length = (double) colors.length();
        Double.isNaN(length);
        int returnColor = colors.getColor((int) (random * length), -7829368);
        colors.recycle();
        return returnColor;
    }

    public static int getColor(Context ctx, String str, int index) {
        int arrayId = ctx.getResources().getIdentifier("mdcolor_random", "array", ctx.getPackageName());
        if (arrayId == 0) {
            return -1;
        }
        TypedArray colors = ctx.getResources().obtainTypedArray(arrayId);
        int idx = index;
        while (idx >= colors.length()) {
            idx -= 5;
        }
        while (idx < 0) {
            idx += 2;
        }
        int returnColor = colors.getColor(idx, -7829368);
        colors.recycle();
        return returnColor;
    }
}
