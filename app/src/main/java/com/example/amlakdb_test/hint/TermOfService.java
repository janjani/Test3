package com.example.amlakdb_test.hint;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.amlakdb_test.login.Password;
import com.example.amlakdb_test.R;

public class TermOfService extends AppCompatActivity {
    Button B1;
    Button B2;
    Button B3;
    Button B4;
    Button B5;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_term_of_service);
        this.B1 = (Button) findViewById(R.id.button);
        this.B2 = (Button) findViewById(R.id.button2);
        this.B3 = (Button) findViewById(R.id.button3);
        this.B4 = (Button) findViewById(R.id.button4);
        this.B5 = (Button) findViewById(R.id.button5);
        this.B1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                TermOfService.this.showTermServicesDialog();
            }
        });
        this.B2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                TermOfService.this.showCustomDialogA();
            }
        });
        this.B3.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                TermOfService.this.showCustomDialogB();
            }
        });
        this.B4.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                TermOfService.this.startActivity(new Intent(TermOfService.this.getApplicationContext(), Password.class));
            }
        });
        this.B5.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                TermOfService.this.startActivity(new Intent(TermOfService.this.getApplicationContext(), AboutApp.class));
            }
        });
    }

    public void showTermServicesDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dialog_term_of_services);
        dialog.setCancelable(true);
        LayoutParams lp = new LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = -1;
        lp.height = -1;
        ((ImageButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        ((Button) dialog.findViewById(R.id.bt_accept)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

    /* access modifiers changed from: private */
    public void showCustomDialogA() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dialog_info);
        dialog.setCancelable(true);
        LayoutParams lp = new LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = -1;
        lp.height = -1;
        ((AppCompatButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Context applicationContext = TermOfService.this.getApplicationContext();
                StringBuilder sb = new StringBuilder();
                sb.append(((AppCompatButton) v).getText().toString());
                sb.append(" Clicked");
                Toast.makeText(applicationContext, sb.toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

    /* access modifiers changed from: private */
    public void showCustomDialogB() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(1);
        dialog.setContentView(R.layout.dialog_warning);
        dialog.setCancelable(true);
        LayoutParams lp = new LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = -1;
        lp.height = -1;
        ((AppCompatButton) dialog.findViewById(R.id.bt_close)).setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Context applicationContext = TermOfService.this.getApplicationContext();
                StringBuilder sb = new StringBuilder();
                sb.append(((AppCompatButton) v).getText().toString());
                sb.append(" Clicked");
                Toast.makeText(applicationContext, sb.toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }
}

