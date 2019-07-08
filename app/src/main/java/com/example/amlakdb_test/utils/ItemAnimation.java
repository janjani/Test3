package com.example.amlakdb_test.utils;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

public class ItemAnimation {
    public static final int BOTTOM_UP = 1;
    private static final long DURATION_IN_BOTTOM_UP = 150;
    private static final long DURATION_IN_FADE_ID = 500;
    private static final long DURATION_IN_LEFT_RIGHT = 150;
    private static final long DURATION_IN_RIGHT_LEFT = 150;
    public static final int FADE_IN = 2;
    public static final int LEFT_RIGHT = 3;
    public static final int NONE = 0;
    public static final int RIGHT_LEFT = 4;

    public static void animate(View view, int position, int type) {
        switch (type) {
            case 1:
                animateBottomUp(view, position);
                return;
            case 2:
                animateFadeIn(view, position);
                return;
            case 3:
                animateLeftRight(view, position);
                return;
            case 4:
                animateRightLeft(view, position);
                return;
            default:
                return;
        }
    }

    private static void animateBottomUp(View view, int position) {
        boolean not_first_item = position == -1;
        int position2 = position + 1;
        float f = 800.0f;
        view.setTranslationY(not_first_item ? 800.0f : 500.0f);
        view.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        String str = "translationY";
        float[] fArr = new float[2];
        if (!not_first_item) {
            f = 500.0f;
        }
        fArr[0] = f;
        fArr[1] = 0.0f;
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(view, str, fArr);
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f});
        animatorTranslateY.setStartDelay(not_first_item ? 0 : ((long) position2) * 150);
        animatorTranslateY.setDuration(((long) (not_first_item ? 3 : 1)) * 150);
        animatorSet.playTogether(new Animator[]{animatorTranslateY, animatorAlpha});
        animatorSet.start();
    }

    private static void animateFadeIn(View view, int position) {
        boolean not_first_item = position == -1;
        int position2 = position + 1;
        view.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 0.5f, 1.0f});
        ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f}).start();
        animatorAlpha.setStartDelay(not_first_item ? 250 : (((long) position2) * DURATION_IN_FADE_ID) / 3);
        animatorAlpha.setDuration(DURATION_IN_FADE_ID);
        animatorSet.play(animatorAlpha);
        animatorSet.start();
    }

    private static void animateLeftRight(View view, int position) {
        boolean not_first_item = position == -1;
        int position2 = position + 1;
        view.setTranslationX(-400.0f);
        view.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(view, "translationX", new float[]{-400.0f, 0.0f});
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f});
        ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f}).start();
        animatorTranslateY.setStartDelay(not_first_item ? 150 : ((long) position2) * 150);
        animatorTranslateY.setDuration(((long) (not_first_item ? 2 : 1)) * 150);
        animatorSet.playTogether(new Animator[]{animatorTranslateY, animatorAlpha});
        animatorSet.start();
    }

    private static void animateRightLeft(View view, int position) {
        boolean not_first_item = position == -1;
        int position2 = position + 1;
        view.setTranslationX(view.getX() + 400.0f);
        view.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(view, "translationX", new float[]{view.getX() + 400.0f, 0.0f});
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f});
        ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f}).start();
        animatorTranslateY.setStartDelay(not_first_item ? 150 : ((long) position2) * 150);
        animatorTranslateY.setDuration(((long) (not_first_item ? 2 : 1)) * 150);
        animatorSet.playTogether(new Animator[]{animatorTranslateY, animatorAlpha});
        animatorSet.start();
    }
}

