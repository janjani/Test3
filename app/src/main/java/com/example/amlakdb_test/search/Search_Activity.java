package com.example.amlakdb_test.search;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.amlakdb_test.model.da.File_Methods;
import com.example.amlakdb_test.utils.NumberTextWatcherForThousand;
import com.example.amlakdb_test.R;

public class Search_Activity extends AppCompatActivity {
    public static String S_et_name;
    public static String S_et_street;
    public static int int_age;
    public static String kind;
    public static int max_mprice_ejareBaha;
    public static int max_tprice_rentBaha;
    public static String meter_MaX;
    public static String meter_MiN;
    public static int min_mprice_ejareBaha;
    public static int min_tprice_rentBaha;
    public static int room;
    private EditText MAXmeter;
    private EditText MINmeterx;
    private Button bt_pish;
    private Button bt_rent;
    private Button bt_search;
    private Button bt_sell;
    private EditText et_age;
    private EditText et_name;
    private EditText et_room;
    private EditText et_street;
    private LinearLayout linear_rent;
    private EditText max_ejareBaha;
    private EditText max_rentBaha;
    private TextView max_rentBaha_txt;
    private EditText min_ejareBaha;
    private EditText min_rentBaha;
    private TextView min_rentBaha_txt;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_search_);
        this.linear_rent = (LinearLayout) findViewById(R.id.linear_rent);
        this.min_ejareBaha = (EditText) findViewById(R.id.min_ejare_edit);
        this.max_ejareBaha = (EditText) findViewById(R.id.max_ejare_edit);
        this.min_rentBaha = (EditText) findViewById(R.id.min_rent_edit);
        this.max_rentBaha = (EditText) findViewById(R.id.max_rent_edit);
        this.et_age = (EditText) findViewById(R.id.et_age);
        this.et_street = (EditText) findViewById(R.id.et_street);
        this.et_name = (EditText) findViewById(R.id.et_name);
        this.et_room = (EditText) findViewById(R.id.et_room);
        this.MAXmeter = (EditText) findViewById(R.id.max_meter);
        this.MINmeterx = (EditText) findViewById(R.id.min_meter);
        this.min_rentBaha_txt = (TextView) findViewById(R.id.min_tprice_rahn);
        this.max_rentBaha_txt = (TextView) findViewById(R.id.max_tprice_rentBaha);
        this.bt_search = (Button) findViewById(R.id.bt_search);
        this.bt_search.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Search_Activity.this.getValueS();
                Search_Activity.this.setValueS();
                Search_Activity.this.startActivity(new Intent(Search_Activity.this.getApplicationContext(), List_Searched_Activity.class));
            }
        });
        initComponent();
        EditText editText = this.min_ejareBaha;
        editText.addTextChangedListener(new NumberTextWatcherForThousand(editText));
        EditText editText2 = this.max_ejareBaha;
        editText2.addTextChangedListener(new NumberTextWatcherForThousand(editText2));
        EditText editText3 = this.min_rentBaha;
        editText3.addTextChangedListener(new NumberTextWatcherForThousand(editText3));
        EditText editText4 = this.max_rentBaha;
        editText4.addTextChangedListener(new NumberTextWatcherForThousand(editText4));
    }

    /* access modifiers changed from: private */
    public boolean getValueS() {
        meter_MaX = this.MAXmeter.getText().toString().trim();
        meter_MiN = this.MINmeterx.getText().toString().trim();
        S_et_street = this.et_street.getText().toString().trim();
        S_et_name = this.et_name.getText().toString().trim();
        if (this.max_rentBaha.length() >= 1) {
            max_tprice_rentBaha = Integer.parseInt(NumberTextWatcherForThousand.trimCommaOfString(this.max_rentBaha.getText().toString()));
        }
        if (this.max_rentBaha.length() == 0) {
            max_tprice_rentBaha = -1;
        }
        if (this.min_rentBaha.length() >= 1) {
            min_tprice_rentBaha = Integer.parseInt(NumberTextWatcherForThousand.trimCommaOfString(this.min_rentBaha.getText().toString()));
        }
        if (this.min_rentBaha.length() == 0) {
            min_tprice_rentBaha = -1;
        }
        if (this.min_ejareBaha.length() >= 1) {
            min_mprice_ejareBaha = Integer.parseInt(NumberTextWatcherForThousand.trimCommaOfString(this.min_ejareBaha.getText().toString()));
        }
        if (this.min_ejareBaha.length() == 0) {
            min_mprice_ejareBaha = -1;
        }
        if (this.max_ejareBaha.length() >= 1) {
            max_mprice_ejareBaha = Integer.parseInt(NumberTextWatcherForThousand.trimCommaOfString(this.max_ejareBaha.getText().toString()));
        }
        if (this.max_ejareBaha.length() == 0) {
            max_mprice_ejareBaha = -1;
        }
        if (this.et_age.length() >= 1) {
            int_age = Integer.parseInt(this.et_age.getText().toString().trim());
        }
        if (this.et_age.length() == 0) {
            int_age = -1;
        }
        if (this.et_room.length() >= 1) {
            room = Integer.parseInt(this.et_room.getText().toString().trim());
        }
        if (this.et_room.length() == 0) {
            room = -1;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void setValueS() {
        new File_Methods(this).getSearchFiles(kind, int_age, room, S_et_name,
                min_tprice_rentBaha, max_tprice_rentBaha, min_mprice_ejareBaha,
                max_mprice_ejareBaha, S_et_street, meter_MaX, meter_MiN);
    }

    private void initComponent() {
        this.bt_pish = (Button) findViewById(R.id.bt_pish);
        this.bt_rent = (Button) findViewById(R.id.bt_rent);
        this.bt_sell = (Button) findViewById(R.id.bt_sell);
        actionClickButton(this.bt_rent);
        this.bt_pish.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Search_Activity.this.actionClickButton(v);
            }
        });
        this.bt_rent.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Search_Activity.this.actionClickButton(v);
            }
        });
        this.bt_sell.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Search_Activity.this.actionClickButton(v);
            }
        });
    }

    /* access modifiers changed from: private */
    public void actionClickButton(View view) {
        this.bt_pish.setSelected(false);
        this.bt_rent.setSelected(false);
        this.bt_sell.setSelected(false);
        selectedButton(this.bt_pish);
        selectedButton(this.bt_rent);
        selectedButton(this.bt_sell);
        view.setSelected(true);
        selectedButton(view);
        selectedEjare();
    }

    public void selectedButton(View view) {
        if (view instanceof Button) {
            Button b = (Button) view;
            if (b.isSelected()) {
                b.setTextColor(-1);
            } else {
                b.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
        }
    }

    private void selectedEjare() {
        if (this.bt_rent.isSelected()) {
            this.min_rentBaha_txt.setText("کمترین مبلغ رهن");
            this.max_rentBaha_txt.setText("بیشترین مبلغ رهن");
            this.linear_rent.setVisibility(View.VISIBLE);
            kind = "اجاره";
        } else if (this.bt_sell.isSelected()) {
            this.linear_rent.setVisibility(View.GONE);
            this.min_rentBaha_txt.setText("کمترین قیمت");
            this.max_rentBaha_txt.setText("بیشترین قیمت");
            kind = "فروش";
        } else if (this.bt_pish.isSelected()) {
            this.linear_rent.setVisibility(View.GONE);
            this.min_rentBaha_txt.setText("کمترین قیمت");
            this.max_rentBaha_txt.setText("بیشترین قیمت");
            kind = "پیش فروش";
        }
    }
}

