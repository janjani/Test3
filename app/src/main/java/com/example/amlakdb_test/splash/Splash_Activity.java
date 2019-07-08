package com.example.amlakdb_test.splash;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.amlakdb_test.AllActivity;
import com.example.amlakdb_test.R;

public class Splash_Activity extends AppCompatActivity {
    ImageView im1;
    ImageView im2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_splash);
        YoYo.with(Techniques.BounceInDown).duration(1000).repeat(1).playOn(findViewById(R.id.imageView));
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Splash_Activity.this.startActivity(new Intent(Splash_Activity.this, AllActivity.class));
                Splash_Activity.this.finish();
            }
        }, 1000);
    }
}

