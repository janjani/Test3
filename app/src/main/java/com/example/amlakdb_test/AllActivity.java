package com.example.amlakdb_test;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.amlakdb_test.add.Add_Activity;
import com.example.amlakdb_test.hint.MainHint;
import com.example.amlakdb_test.model.da.File_Methods;
import com.example.amlakdb_test.model.to.FileHa;
import com.example.amlakdb_test.recycler.RecyclerViewActivity;
import com.example.amlakdb_test.search.Search_Activity;
import com.example.amlakdb_test.R;

public class AllActivity extends AppCompatActivity {
    TextView FileEjareTxtView;
    TextView FileFroshiTxtView;
    TextView FilePishfroshTxtview;
    LinearLayout LayAdd;
    LinearLayout LayAllFiles;
    LinearLayout LayHint;
    LinearLayout LayPish;
    LinearLayout LayRent;
    LinearLayout LaySearch;
    LinearLayout LaySell;
    LinearLayout LayTermOfService;
    TextView MaxPriceEjareTxtVeiw;
    String MaxPriceFroshi;
    TextView MaxPriceFroshiTxtVeiw;
    TextView MaxPricePishTxtVeiw;
    TextView MinPriceEjareTxtVeiw;
    TextView MinPriceFroshiTxtVeiw;
    TextView MinPricePishTxtVeiw;
    TextView TotalFileTxtView;
    String MaxPricePishfrosh;
    String MinPriceEjare;
    String MinPriceFroshi;
    String MinPricePishfrosh;
    String TotalFile;
    String countFilePishfrosh,countFroshi,countFileEjare,MaxPriceEjare;
    /* access modifiers changed from: private */
    public boolean doubleBackToExitPressedOnce;
    long x1;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_all);
        this.LayAdd = (LinearLayout) findViewById(R.id.LayAdd);
        this.LaySearch = (LinearLayout) findViewById(R.id.LaySearch);
        this.LayAllFiles = (LinearLayout) findViewById(R.id.LayAllFiles);
        this.LaySell = (LinearLayout) findViewById(R.id.LaySell);
        this.LayPish = (LinearLayout) findViewById(R.id.LayPish);
        this.LayRent = (LinearLayout) findViewById(R.id.LayRent);
        this.LayHint = (LinearLayout) findViewById(R.id.LayHint);
        this.LayTermOfService = (LinearLayout) findViewById(R.id.LayTermOfService);
        this.TotalFileTxtView = (TextView) findViewById(R.id.TotalFile);
        this.FileFroshiTxtView = (TextView) findViewById(R.id.countFileFroshi);
        this.FileEjareTxtView = (TextView) findViewById(R.id.countFileEjare);
        this.FilePishfroshTxtview = (TextView) findViewById(R.id.countFilePishfrosh);
        this.MinPriceFroshiTxtVeiw = (TextView) findViewById(R.id.MinPriceFroshiTxtVeiw);
        this.MaxPriceFroshiTxtVeiw = (TextView) findViewById(R.id.MaxPriceFroshiTxtVeiw);
        this.MaxPriceEjareTxtVeiw = (TextView) findViewById(R.id.MaxPriceEjareTxtVeiw);
        this.MinPriceEjareTxtVeiw = (TextView) findViewById(R.id.MinPriceEjareTxtVeiw);
        this.MaxPricePishTxtVeiw = (TextView) findViewById(R.id.MaxPricePishTxtVeiw);
        this.MinPricePishTxtVeiw = (TextView) findViewById(R.id.MinPricePishTxtVeiw);
        getFilesCount();
        TextView textView = this.TotalFileTxtView;
        StringBuilder sb = new StringBuilder();
        sb.append("فایل موجود: ");
        sb.append(this.TotalFile);
        textView.setText(sb.toString());
        TextView textView2 = this.FileFroshiTxtView;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("فایل موجود: ");
        sb2.append(this.countFroshi);
        textView2.setText(sb2.toString());
        TextView textView3 = this.FileEjareTxtView;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("فایل موجود: ");
        sb3.append(this.countFileEjare);
        textView3.setText(sb3.toString());
        TextView textView4 = this.FilePishfroshTxtview;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("فایل موجود: ");
        sb4.append(this.countFilePishfrosh);
        textView4.setText(sb4.toString());
        TextView textView5 = this.MinPriceFroshiTxtVeiw;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("کمترین قیمت:");
        sb5.append(this.MinPriceFroshi);
        textView5.setText(sb5.toString());
        TextView textView6 = this.MaxPriceFroshiTxtVeiw;
        StringBuilder sb6 = new StringBuilder();
        sb6.append("بیشترین قیمت:");
        sb6.append(this.MaxPriceFroshi);
        textView6.setText(sb6.toString());
        TextView textView7 = this.MaxPriceEjareTxtVeiw;
        StringBuilder sb7 = new StringBuilder();
        sb7.append("بیشترین قیمت:");
        sb7.append(this.MaxPriceEjare);
        textView7.setText(sb7.toString());
        TextView textView8 = this.MinPriceEjareTxtVeiw;
        StringBuilder sb8 = new StringBuilder();
        sb8.append("کمترین قیمت:");
        sb8.append(this.MinPriceEjare);
        textView8.setText(sb8.toString());
        TextView textView9 = this.MaxPricePishTxtVeiw;
        StringBuilder sb9 = new StringBuilder();
        sb9.append("بیشترین قیمت:");
        sb9.append(this.MaxPricePishfrosh);
        textView9.setText(sb9.toString());
        TextView textView10 = this.MinPricePishTxtVeiw;
        StringBuilder sb10 = new StringBuilder();
        sb10.append("کمترین قیمت:");
        sb10.append(this.MinPricePishfrosh);
        textView10.setText(sb10.toString());
        if (this.x1 == 0) {
            this.LayAllFiles.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(AllActivity.this.getApplicationContext(), " ابتدا یک فایل ثبت کنید! ", Toast.LENGTH_SHORT).show();
                }
            });
            this.LaySearch.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(AllActivity.this.getApplicationContext(), " ابتدا یک فایل ثبت کنید! ", Toast.LENGTH_LONG).show();
                }
            });
            this.LaySell.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(AllActivity.this.getApplicationContext(), " ابتدا یک فایل ثبت کنید! ", Toast.LENGTH_LONG).show();
                }
            });
            this.LayRent.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(AllActivity.this.getApplicationContext(), " ابتدا یک فایل ثبت کنید! ", Toast.LENGTH_LONG).show();
                }
            });
            this.LayPish.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(AllActivity.this.getApplicationContext(), " ابتدا یک فایل ثبت کنید! ", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            this.LayAllFiles.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(AllActivity.this.getApplicationContext(), RecyclerViewActivity.class);
                    intent.putExtra(FileHa.KEY_SHOMINE, "All");
                    AllActivity.this.startActivity(intent);
                }
            });
            this.LaySearch.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    AllActivity.this.startActivity(new Intent(AllActivity.this.getApplicationContext(), Search_Activity.class));
                }
            });
            this.LaySell.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(AllActivity.this.getApplicationContext(), RecyclerViewActivity.class);
                    intent.putExtra(FileHa.KEY_SHOMINE, "Sell");
                    AllActivity.this.startActivity(intent);
                }
            });
            this.LayRent.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(AllActivity.this.getApplicationContext(), RecyclerViewActivity.class);
                    intent.putExtra(FileHa.KEY_SHOMINE, "Rent");
                    AllActivity.this.startActivity(intent);
                }
            });
            this.LayPish.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(AllActivity.this.getApplicationContext(), RecyclerViewActivity.class);
                    intent.putExtra(FileHa.KEY_SHOMINE, "Pish");
                    AllActivity.this.startActivity(intent);
                }
            });
        }
        this.LayAdd.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                AllActivity.this.startActivity(new Intent(AllActivity.this.getApplicationContext(), Add_Activity.class));
            }
        });
        this.LayHint.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                AllActivity.this.startActivity(new Intent(AllActivity.this.getApplicationContext(), MainHint.class));
            }
        });
        this.LayTermOfService.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                AllActivity.this.showTermServicesDialog();
            }
        });
    }

    private long getFilesCount() {
        File_Methods file_methods = new File_Methods(this);
        file_methods.open();
        this.x1 = file_methods.getFilesCount();
        this.TotalFile = String.valueOf(this.x1);
        this.countFroshi = String.valueOf(file_methods.getForoshiCount());
        this.countFileEjare = String.valueOf(file_methods.getEjareCount());
        this.countFilePishfrosh = String.valueOf(file_methods.getPishfrosh());
        this.MinPriceFroshi = String.valueOf(file_methods.getMinPriceFroshi());
        this.MaxPriceFroshi = String.valueOf(file_methods.getMaxPriceFroshi());
        this.MinPriceEjare = String.valueOf(file_methods.getMinEjare());
        this.MaxPriceEjare = String.valueOf(file_methods.getMaxEjare());
        this.MinPricePishfrosh = String.valueOf(file_methods.getMinPricePishFrosh());
        this.MaxPricePishfrosh = String.valueOf(file_methods.getMaxPricePishFrosh());
        return 0;
    }

    public void onBackPressed() {
        if (this.doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, " برای خروج یکبار دیگر کلیک کنید! ", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                AllActivity.this.doubleBackToExitPressedOnce = false;
            }
        }, 3000);
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
}

