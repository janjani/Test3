package com.example.amlakdb_test.login;


import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.example.amlakdb_test.R;

public class Password extends AppCompatActivity {
    /* access modifiers changed from: private */
    public FloatingActionButton fab;
    /* access modifiers changed from: private */
    public View parent_view;
    /* access modifiers changed from: private */
    public ProgressBar progress_bar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_password);
        this.parent_view = findViewById(16908290);
        this.progress_bar = (ProgressBar) findViewById(R.id.progress_bar);
        this.fab = (FloatingActionButton) findViewById(R.id.fab);
        findViewById(R.id.sign_up_for_account).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Snackbar.make(Password.this.parent_view, (CharSequence) "Sign up for an account", -1).show();
            }
        });
        this.fab.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Password.this.searchAction();
            }
        });
    }

    /* access modifiers changed from: private */
    public void searchAction() {
        this.progress_bar.setVisibility(View.VISIBLE);
        this.fab.setAlpha(0.0f);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Password.this.progress_bar.setVisibility(View.GONE);
                Password.this.fab.setAlpha(1.0f);
                Snackbar.make(Password.this.parent_view, (CharSequence) "Login data submitted", -1).show();
            }
        }, 1000);
    }
}

