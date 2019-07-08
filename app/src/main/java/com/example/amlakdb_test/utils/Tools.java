package com.example.amlakdb_test.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.amlakdb_test.R;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
    public static void setSystemBarColor(Activity act) {
        if (VERSION.SDK_INT >= 21) {
            Window window = act.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(act.getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    public static void setSystemBarColor(Activity act, @ColorRes int color) {
        if (VERSION.SDK_INT >= 21) {
            Window window = act.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(act.getResources().getColor(color));
        }
    }

    public static void setSystemBarColorDialog(Context act, Dialog dialog, @ColorRes int color) {
        if (VERSION.SDK_INT >= 21) {
            Window window = dialog.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(act.getResources().getColor(color));
        }
    }

    public static void setSystemBarLight(Activity act) {
        if (VERSION.SDK_INT >= 23) {
            View view = act.findViewById(android.R.id.content);
            view.setSystemUiVisibility(view.getSystemUiVisibility() | 8192);
        }
    }

    public static void setSystemBarLightDialog(Dialog dialog) {
        if (VERSION.SDK_INT >= 23) {
            View view = dialog.findViewById(android.R.id.content);
            view.setSystemUiVisibility(view.getSystemUiVisibility() | 8192);
        }
    }

    public static void clearSystemBarLight(Activity act) {
        if (VERSION.SDK_INT >= 23) {
            act.getWindow().setStatusBarColor(ContextCompat.getColor(act, R.color.colorPrimaryDark));
        }
    }

    public static void setSystemBarTransparent(Activity act) {
        if (VERSION.SDK_INT >= 21) {
            Window window = act.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public static void displayImageOriginal(Context ctx, ImageView img, @DrawableRes int drawable) {
        try {
            Glide.with(ctx).load(Integer.valueOf(drawable)).crossFade().diskCacheStrategy(DiskCacheStrategy.NONE).into(img);
        } catch (Exception e) {
        }
    }

    public static void displayImageRound(final Context ctx, final ImageView img, @DrawableRes int drawable) {
        try {
            Glide.with(ctx).load(Integer.valueOf(drawable)).asBitmap().centerCrop().into(new BitmapImageViewTarget(img) {
                /* access modifiers changed from: protected */
                public void setResource(Bitmap resource) {
                    RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(ctx.getResources(), resource);
                    circularBitmapDrawable.setCircular(true);
                    img.setImageDrawable(circularBitmapDrawable);
                }
            });
        } catch (Exception e) {
        }
    }

    public static void displayImageOriginal(Context ctx, ImageView img, String url) {
        try {
            Glide.with(ctx).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.NONE).into(img);
        } catch (Exception e) {
        }
    }

    public static String getFormattedDateSimple(Long dateTime) {
        return new SimpleDateFormat("MMMM dd, yyyy").format(new Date(dateTime.longValue()));
    }

    public static String getFormattedDateEvent(Long dateTime) {
        return new SimpleDateFormat("EEE, MMM dd yyyy").format(new Date(dateTime.longValue()));
    }

    public static String getFormattedTimeEvent(Long time) {
        return new SimpleDateFormat("h:mm a").format(new Date(time.longValue()));
    }

    public static String getEmailFromName(String name) {
        if (name == null || name.equals("")) {
            return name;
        }
        return name.replaceAll(" ", ".").toLowerCase().concat("@mail.com");
    }

    public static int dpToPx(Context c, int dp) {
        return Math.round(TypedValue.applyDimension(1, (float) dp, c.getResources().getDisplayMetrics()));
    }

    public static void copyToClipboard(Context context, String data) {
        ((ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", data));
        Toast.makeText(context, "Text copied to clipboard", Toast.LENGTH_SHORT).show();
    }

    public static void nestedScrollTo(final NestedScrollView nested, final View targetView) {
        nested.post(new Runnable() {
            public void run() {
                nested.scrollTo(500, targetView.getBottom());
            }
        });
    }

    public static int dip2px(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        return (int) ((pxValue / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean toggleArrow(View view) {
        if (view.getRotation() == 0.0f) {
            view.animate().setDuration(200).rotation(180.0f);
            return true;
        }
        view.animate().setDuration(200).rotation(0.0f);
        return false;
    }

    public static boolean toggleArrow(boolean show, View view) {
        return toggleArrow(show, view, true);
    }

    public static boolean toggleArrow(boolean show, View view, boolean delay) {
        long j = 200;
        if (show) {
            ViewPropertyAnimator animate = view.animate();
            if (!delay) {
                j = 0;
            }
            animate.setDuration(j).rotation(180.0f);
            return true;
        }
        ViewPropertyAnimator animate2 = view.animate();
        if (!delay) {
            j = 0;
        }
        animate2.setDuration(j).rotation(0.0f);
        return false;
    }

    public static void changeNavigateionIconColor(Toolbar toolbar, @ColorInt int color) {
        Drawable drawable = toolbar.getNavigationIcon();
        drawable.mutate();
        drawable.setColorFilter(color, Mode.SRC_ATOP);
    }

    public static void changeMenuIconColor(Menu menu, @ColorInt int color) {
        for (int i = 0; i < menu.size(); i++) {
            Drawable drawable = menu.getItem(i).getIcon();
            if (drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(color, Mode.SRC_ATOP);
            }
        }
    }

    public static void changeOverflowMenuIconColor(Toolbar toolbar, @ColorInt int color) {
        try {
            Drawable drawable = toolbar.getOverflowIcon();
            drawable.mutate();
            drawable.setColorFilter(color, Mode.SRC_ATOP);
        } catch (Exception e) {
        }
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static String toCamelCase(String input) {
        char[] charArray;
        String input2 = input.toLowerCase();
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;
        for (char c : input2.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }
            titleCase.append(c);
        }
        return titleCase.toString();
    }

    public static String insertPeriodically(String text, String insert, int period) {
        StringBuilder builder = new StringBuilder(text.length() + (insert.length() * (text.length() / period)) + 1);
        int index = 0;
        String prefix = "";
        while (index < text.length()) {
            builder.append(prefix);
            prefix = insert;
            builder.append(text.substring(index, Math.min(index + period, text.length())));
            index += period;
        }
        return builder.toString();
    }

    public static void rateAction(Activity activity) {
        StringBuilder sb = new StringBuilder();
        sb.append("market://details?id=");
        sb.append(activity.getPackageName());
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString())));
        } catch (ActivityNotFoundException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("http://play.google.com/store/apps/details?id=");
            sb2.append(activity.getPackageName());
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb2.toString())));
        }
    }
}
