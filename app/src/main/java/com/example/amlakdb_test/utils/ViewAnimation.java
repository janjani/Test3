package com.example.amlakdb_test.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;

public class ViewAnimation {

    public interface AnimListener {
        void onFinish();
    }

    public static void expand(View v, final AnimListener animListener) {
        Animation a = expandAction(v);
        a.setAnimationListener(new AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                animListener.onFinish();
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        v.startAnimation(a);
    }

    public static void expand(View v) {
        v.startAnimation(expandAction(v));
    }

    private static Animation expandAction(final View v) {
        v.measure(-1, -2);
        final int targtetHeight = v.getMeasuredHeight();
        v.getLayoutParams().height = 0;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1.0f ? -2 : (int) (((float) targtetHeight) * interpolatedTime);
                v.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration((long) ((int) (((float) targtetHeight) / v.getContext().getResources().getDisplayMetrics().density)));
        v.startAnimation(a);
        return a;
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();
        Animation a = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1.0f) {
                    v.setVisibility(View.GONE);
                    return;
                }
                LayoutParams layoutParams = v.getLayoutParams();
                int i = initialHeight;
                layoutParams.height = i - ((int) (((float) i) * interpolatedTime));
                v.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration((long) ((int) (((float) initialHeight) / v.getContext().getResources().getDisplayMetrics().density)));
        v.startAnimation(a);
    }

    public static void flyInDown(View v, final AnimListener animListener) {
        v.setVisibility(View.VISIBLE);
        v.setAlpha(0.0f);
        v.setTranslationY(0.0f);
        v.setTranslationY((float) (-v.getHeight()));
        v.animate().setDuration(200)
                .translationY(0.0f)
                .setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                if (animListener != null) {
                    animListener.onFinish();
                }
                super.onAnimationEnd(animation);
            }
        }).alpha(1.0f).start();
    }

    public static void flyOutDown(View v, final AnimListener animListener) {
        v.setVisibility(View.VISIBLE);
        v.setAlpha(1.0f);
        v.setTranslationY(0.0f);
        v.animate()
                .setDuration(200)
                .translationY((float) v.getHeight()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                if (animListener != null) {
                    animListener.onFinish();
                }
                super.onAnimationEnd(animation);
            }
        }).alpha(0.0f).start();
    }

    public static void fadeIn(View v) {
        fadeIn(v, null);
    }

    public static void fadeIn(final View v, final AnimListener animListener) {
        v.setVisibility(View.GONE);
        v.setAlpha(0.0f);
        v.animate().setDuration(200).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                v.setVisibility(View.VISIBLE);
                if (animListener != null) {
                    animListener.onFinish();
                }
                super.onAnimationEnd(animation);
            }
        }).alpha(1.0f);
    }

    public static void fadeOut(View v) {
        fadeOut(v, null);
    }

    public static void fadeOut(View v, final AnimListener animListener) {
        v.setAlpha(1.0f);
        v.animate().setDuration(500).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                if (animListener != null) {
                    animListener.onFinish();
                }
                super.onAnimationEnd(animation);
            }
        }).alpha(0.0f);
    }

    public static void showIn(View v) {
        v.setVisibility(View.VISIBLE);
        v.setAlpha(0.0f);
        v.setTranslationY((float) v.getHeight());
        v.animate().setDuration(200).translationY(0.0f).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        }).alpha(1.0f).start();
    }

    public static void initShowOut(View v) {
        v.setVisibility(View.GONE);
        v.setTranslationY((float) v.getHeight());
        v.setAlpha(0.0f);
    }

    public static void showOut(final View v) {
        v.setVisibility(View.VISIBLE);
        v.setAlpha(1.0f);
        v.setTranslationY(0.0f);
        v.animate().setDuration(200).translationY((float) v.getHeight()).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                v.setVisibility(View.GONE);
                super.onAnimationEnd(animation);
            }
        }).alpha(0.0f).start();
    }

    public static boolean rotateFab(View v, boolean rotate) {
        v.animate().setDuration(200).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        }).rotation(rotate ? 135.0f : 0.0f);
        return rotate;
    }

    public static void fadeOutIn(View view) {
        view.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 0.5f, 1.0f});
        ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f}).start();
        animatorAlpha.setDuration(500);
        animatorSet.play(animatorAlpha);
        animatorSet.start();
    }

    public static void showScale(View v) {
        showScale(v, null);
    }

    public static void showScale(View v, final AnimListener animListener) {
        v.animate().scaleY(1.0f).scaleX(1.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                if (animListener != null) {
                    animListener.onFinish();
                }
                super.onAnimationEnd(animation);
            }
        }).start();
    }

    public static void hideScale(View v) {
        fadeOut(v, null);
    }

    public static void hideScale(View v, final AnimListener animListener) {
        v.animate().scaleY(0.0f).scaleX(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animation) {
                if (animListener != null) {
                    animListener.onFinish();
                }
                super.onAnimationEnd(animation);
            }
        }).start();
    }

    public static void hideFab(View fab) {
        fab.animate().translationY((float) (fab.getHeight() * 2)).setDuration(300).start();
    }

    public static void showFab(View fab) {
        fab.animate().translationY(0.0f).setDuration(300).start();
    }
}
