package com.example.amlakdb_test.add;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.amlakdb_test.AllActivity;
import com.example.amlakdb_test.MyDBHelper;
import com.example.amlakdb_test.model.da.File_Methods;
import com.example.amlakdb_test.model.to.FileHa;
import com.example.amlakdb_test.utils.NumberTextWatcherForThousand;
import com.example.amlakdb_test.R;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;


public class Add_Activity extends AppCompatActivity {
    String[] Dir = {"شمالی", "جنوبی", "شرقی", "غربی"};
    String[] Loc = {"مسکونی","تجاری", "2کله", "2بر", "شمالی", "جنوبی", "شرقی", "غربی"};
    int EJARE_BAHA, Int_meter, Int_tprice_Total;
    private EditText address, age;
    private CheckBox ambari,asansor,balkon;

    private TextView date,ejareBaha;
    private Spinner dir;
    private EditText extera;
    private File_Methods fileDa;
    private EditText floor, floorTotal;
    String kind;
    private LinearLayout lay_Date;
    private Spinner loc;
    private EditText meter;
    private EditText mobile;
    private EditText mprice;
    MyDBHelper myDBHelper;
    private EditText name;
    private EditText number;
    private EditText numberTotal;
    private CheckBox parking;
    private Button pish;
    private TextView rahnBaha;
    private Button rent;
    private EditText room;
    private Button sabt;
    String saddress;
    int sage;
    String sambari;
    String sasansor;
    String sbalkon;
    String sdir;
    private Button sell;
    String sextera;
    String sfloor;
    String sfloorTotal;
    String sloc;
    String smobile;
    int smprice;
    String sname;
    String snumber;
    String snumberTotal;
    String sparking;
    int sroom;
    String sstreet;
    String st_date;
    String stel;
    private EditText street;
    private EditText tel;
    private EditText tprice;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_add_);
        find();
        initComponent();
        takeDate();
        EditText editText = this.tprice;
        editText.addTextChangedListener(new NumberTextWatcherForThousand(editText));
        EditText editText2 = this.mprice;
        editText2.addTextChangedListener(new NumberTextWatcherForThousand(editText2));
        this.sabt.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Add_Activity.this.getValevS();
                if (Add_Activity.this.getValevS()) {
                    Add_Activity.this.set();
                    Add_Activity.this.clearInPutS();
                    Toast.makeText(Add_Activity.this.getApplicationContext(), " ثبت موفق ", Toast.LENGTH_LONG).show();
                    Add_Activity.this.startActivity(new Intent(Add_Activity.this.getApplicationContext(), AllActivity.class));
                }
            }
        });
        this.lay_Date.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Add_Activity.this.takeDate();
            }
        });
    }

    private void find() {
        this.name = (EditText) findViewById(R.id.name);
        this.mobile = (EditText) findViewById(R.id.mobile);
        this.tel = (EditText) findViewById(R.id.tel);
        this.tprice = (EditText) findViewById(R.id.tprice);
        this.mprice = (EditText) findViewById(R.id.mprice);
        this.meter = (EditText) findViewById(R.id.meter);
        this.room = (EditText) findViewById(R.id.room);
        this.floorTotal = (EditText) findViewById(R.id.floorTotal);
        this.numberTotal = (EditText) findViewById(R.id.numberTotal);
        this.floor = (EditText) findViewById(R.id.floor);
        this.number = (EditText) findViewById(R.id.number);
        this.street = (EditText) findViewById(R.id.street);
        this.age = (EditText) findViewById(R.id.age);
        this.address = (EditText) findViewById(R.id.address);
        this.extera = (EditText) findViewById(R.id.extera);
        this.dir = (Spinner) findViewById(R.id.dir);
        this.loc = (Spinner) findViewById(R.id.loc);
        ArrayAdapter<String> adapterdir = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, this.Dir);
        adapterdir.setDropDownViewResource(android.R.layout.simple_spinner_item);
        this.dir.setAdapter(adapterdir);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, this.Loc);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        this.loc.setAdapter(arrayAdapter);
        this.parking = (CheckBox) findViewById(R.id.parking);
        this.ambari = (CheckBox) findViewById(R.id.ambari);
        this.balkon = (CheckBox) findViewById(R.id.balkon);
        this.asansor = (CheckBox) findViewById(R.id.asansor);
        this.rahnBaha = (TextView) findViewById(R.id.rahn);
        this.ejareBaha = (TextView) findViewById(R.id.ejarebaha);
        this.date = (TextView) findViewById(R.id.dateeee);
        this.sabt = (Button) findViewById(R.id.sabt);
        this.lay_Date = (LinearLayout) findViewById(R.id.lay_Date);
    }

    public void takeDate() {
        PersianDatePickerDialog picker = new PersianDatePickerDialog(this)
                .setPositiveButtonString("باشه")
                .setNegativeButton("بیخیال")
                .setTodayButton("امروز")
                .setTodayButtonVisible(true)
               // .setInitDate(initDate)
                .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                .setMinYear(1300)
                .setActionTextColor(Color.GRAY)
           //     .setTypeFace(typeface)
                .setListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {
                //        Toast.makeText(getApplicationContext(), persianCalendar.getPersianYear() + "/" + persianCalendar.getPersianMonth() + "/" + persianCalendar.getPersianDay(), Toast.LENGTH_SHORT).show();
                        Add_Activity.this.setDate(persianCalendar);
                    }

                    @Override
                    public void onDismissed() {

                    }
                });

        picker.show();
    }

    public void setDate(PersianCalendar persianCalendar2) {
        this.st_date = persianCalendar2.getPersianLongDate();
        this.date.setText(this.st_date);
    }



    /* access modifiers changed from: private */
    public void set() {
        File_Methods fileDaDA = new File_Methods(getApplicationContext());
        fileDaDA.open();
        FileHa fileHa = new FileHa();
        fileHa.setKIND(this.kind);
        fileHa.setPRICE_Total(this.Int_tprice_Total);
        fileHa.setPRICEMETER(this.smprice);
        fileHa.setMETREZ(this.Int_meter);
        fileHa.setMALEK(this.sname);
        fileHa.setTel(this.stel);
        fileHa.setMOBILE(this.smobile);
        fileHa.setROOM(this.sroom);
        fileHa.setTABAGHE(this.sfloor);
        fileHa.setSALEAKHT(this.sage);
        fileHa.setPARKING(this.sparking);
        fileHa.setAMBARI(this.sambari);
        fileHa.setBALKON(this.sbalkon);
        fileHa.setSHOMINE(null);
        fileHa.setNUMBER_Totol_vahed(this.snumberTotal);
        fileHa.setNUBER_TOTAL_FLOOR(this.sfloorTotal);
        fileHa.setLOCATION(this.sloc);
        fileHa.setDIRECTION(this.sdir);
        fileHa.setSTREET(this.sstreet);
        fileHa.setADDREES(this.saddress);
        fileHa.setEXTERA(this.sextera);
        fileHa.setASANSOR(this.sasansor);
        fileHa.setEJARE_BAHA(this.EJARE_BAHA);
        fileHa.setNUMBER_VAHED(this.snumber);
        fileHa.setDATE_TIME(this.st_date);
        fileDaDA.addFile(fileHa);
    }

    /* access modifiers changed from: private */
    public boolean getValevS() {
        if (this.name.length() < 1) {
            Toast.makeText(getApplicationContext(), " اسم مالک ار وارد کنید!", Toast.LENGTH_SHORT).show();
            this.name.requestFocus();
            return false;
        }
        this.sname = this.name.getText().toString().trim();
        if (this.mobile.length() < 10) {
            Toast.makeText(getApplicationContext(), " شماره موبایل مالک را وارد کنید!", Toast.LENGTH_SHORT).show();
            this.mobile.requestFocus();
            return false;
        }
        this.smobile = this.mobile.getText().toString().trim();
        if (this.tprice.length() < 1) {
            Toast.makeText(getApplicationContext(), "قیمت کل را وارد کنید!", Toast.LENGTH_SHORT).show();
            this.tprice.requestFocus();
            return false;
        }
        this.Int_tprice_Total = Integer.parseInt(NumberTextWatcherForThousand.trimCommaOfString(this.tprice.getText().toString()));
        if (this.meter.length() < 1) {
            Toast.makeText(getApplicationContext(), " متراژ را وارد کنید!", Toast.LENGTH_SHORT).show();
            this.meter.requestFocus();
            return false;
        }
        this.Int_meter = Integer.parseInt(this.meter.getText().toString().trim());
        if (this.mprice.length() < 1) {
            this.smprice = -1;
        } else {
            this.smprice = Integer.parseInt(NumberTextWatcherForThousand.trimCommaOfString(this.mprice.getText().toString()));
        }
        if (this.mprice.length() < 1) {
            this.EJARE_BAHA = -1;
        } else {
            this.EJARE_BAHA = Integer.parseInt(NumberTextWatcherForThousand.trimCommaOfString(this.mprice.getText().toString()));
        }
        if (this.room.length() < 1) {
            this.sroom = -1;
        } else {
            this.sroom = Integer.parseInt(this.room.getText().toString());
        }
        if (this.age.length() < 1) {
            this.sage = -1;
        } else {
            this.sage = Integer.parseInt(this.age.getText().toString().trim());
        }
        if (this.tel.length() > 10 || this.tel.length() == 0) {
            this.stel = this.tel.getText().toString().trim();
            this.sfloorTotal = this.floorTotal.getText().toString().trim();
            this.snumberTotal = this.numberTotal.getText().toString().trim();
            this.sfloor = this.floor.getText().toString().trim();
            this.snumber = this.number.getText().toString().trim();
            this.sextera = this.extera.getText().toString().trim();
            this.sstreet = this.street.getText().toString().trim();
            this.saddress = this.address.getText().toString().trim();
            this.st_date = this.date.getText().toString().trim();
            this.sdir = this.dir.getSelectedItem().toString();
            this.sloc = this.loc.getSelectedItem().toString();
            if (this.parking.isChecked()) {
                this.sparking = " دارای پارکینگ ";
            } else {
                this.sparking = " بدون پارکینگ ";
            }
            if (this.ambari.isChecked()) {
                this.sambari = " دارای انباری ";
            } else {
                this.sambari = " بدون انباری ";
            }
            if (this.balkon.isChecked()) {
                this.sbalkon = " دارای بالکن ";
            } else {
                this.sbalkon = " بدون بالکن ";
            }
            if (this.asansor.isChecked()) {
                this.sasansor = " دارای آسانسور ";
            } else {
                this.sasansor = " بدون آسانسور ";
            }
            return true;
        }
        Toast.makeText(getApplicationContext(), " ØªÙ„ÙÙ† Ø«Ø§Ø¨Øª Ø±Ø§ Ø¨Ù‡Ù…Ø±Ø§Ù‡ Ú©Ø¯ Ùˆ Ú©Ø§Ù…Ù„ ÙˆØ§Ø±Ø¯ Ú©Ù†ÛŒØ¯", Toast.LENGTH_SHORT).show();
        this.tel.requestFocus();
        return false;
    }

    private void initComponent() {
        this.pish = (Button) findViewById(R.id.bt_pish);
        this.rent = (Button) findViewById(R.id.bt_rent);
        this.sell = (Button) findViewById(R.id.bt_sell);
        actionClickButton(this.sell);
        this.pish.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Add_Activity.this.actionClickButton(v);
            }
        });
        this.rent.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Add_Activity.this.actionClickButton(v);
            }
        });
        this.sell.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Add_Activity.this.actionClickButton(v);
            }
        });
    }

    /* access modifiers changed from: private */
    public void actionClickButton(View view) {
        this.pish.setSelected(false);
        this.rent.setSelected(false);
        this.sell.setSelected(false);
        selectedButton(this.pish);
        selectedButton(this.rent);
        selectedButton(this.sell);
        view.setSelected(true);
        selectedButton(view);
        selectedEjare();
    }

    private void selectedEjare() {
        if (this.rent.isSelected()) {
            this.rahnBaha.setText("مبلغ رهن");
            this.ejareBaha.setText("مبلغ اجاره");
            this.kind = "اجاره";
        } else if (this.sell.isSelected()) {
            this.rahnBaha.setText("قیمت کل");
            this.ejareBaha.setText("قیمت هر متر");
            this.kind = "فروش";
        } else if (this.pish.isSelected()) {
            this.rahnBaha.setText("قیمت کل");
            this.ejareBaha.setText("قیمت هر متر");
            this.kind = "پیش فروش";
        }
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

    /* access modifiers changed from: private */
    public void clearInPutS() {
        this.name.setText("");
        this.mobile.setText("");
        this.tel.setText("");
        this.tprice.setText("");
        this.mprice.setText("");
        this.meter.setText("");
        this.room.setText("");
        this.floorTotal.setText("");
        this.extera.setText("");
        this.numberTotal.setText("");
        this.street.setText("");
        this.age.setText("");
        this.address.setText("");
        this.number.setText("");
        this.floor.setText("");
    }
}

