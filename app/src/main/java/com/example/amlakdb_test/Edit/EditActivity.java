package com.example.amlakdb_test.Edit;

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
import com.example.amlakdb_test.MyDBHelper;
import com.example.amlakdb_test.add.Add_Activity;
import com.example.amlakdb_test.model.da.File_Methods;
import com.example.amlakdb_test.model.to.FileHa;
import com.example.amlakdb_test.utils.NumberTextWatcherForThousand;
import com.example.amlakdb_test.R;
import java.util.List;

import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;

public class EditActivity extends AppCompatActivity {
    String[] Dir = {"شمالی", "جنوبی", "شرقی", "غربی"};
    String[] Loc = {"مسکونی","تجاری", "2کله", "2بر", "شمالی", "جنوبی", "شرقی", "غربی"};
    int Int_meter;
    int Int_tprice_Total;

    private EditText address;
    private EditText age;
    private CheckBox ambari;
    private CheckBox asansor;
    private CheckBox balkon;
    private TextView date;
    private Spinner dir;
    private TextView ejareBaha;
    private EditText extera;
    boolean fBoolean = false;
    private File_Methods fileDa;
    private EditText floor;
    private EditText floorTotal;
    int id;
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
    String sKind;
    String sabmari;
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
        setContentView((int) R.layout.activity_edit);
        this.id = getIntent().getExtras().getInt(FileHa.KEY_ID);
        takeDate();
        findElements();
        getDATA_From_DataBase();
        EditText editText = this.tprice;
        editText.addTextChangedListener(new NumberTextWatcherForThousand(editText));
        NumberTextWatcherForThousand.trimCommaOfString(this.tprice.getText().toString());
        EditText editText2 = this.meter;
        editText2.addTextChangedListener(new NumberTextWatcherForThousand(editText2));
        NumberTextWatcherForThousand.trimCommaOfString(this.meter.getText().toString());
        this.sabt.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                EditActivity.this.getValevS();
                if (EditActivity.this.fBoolean) {
                    EditActivity.this.setDATA_To_DATABASE();
                    EditActivity.this.clearInPutS();
                    Toast.makeText(EditActivity.this.getApplicationContext(), " ÙˆÛŒØ±Ø§ÛŒØ´ Ù…ÙˆÙÙ‚ ", Toast.LENGTH_LONG).show();
                    EditActivity.this.onBackPressed();
                }
            }
        });
        initComponent();
        this.lay_Date.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                EditActivity.this.takeDate();
            }
        });
    }

    private void findElements() {
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
        this.date = (TextView) findViewById(R.id.dateeee);
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
        this.sabt = (Button) findViewById(R.id.sabt);
        this.lay_Date = (LinearLayout) findViewById(R.id.lay_Date);
    }

    /* access modifiers changed from: private */
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
                        setDate(persianCalendar);
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
    public void setDATA_To_DATABASE() {
        File_Methods fileDaDA = new File_Methods(getApplicationContext());
        fileDaDA.open();
        FileHa fileHa = new FileHa();
        File_Methods file_methods = new File_Methods(this);
        file_methods.open();
        int idDB = ((FileHa) file_methods.getAllFiles().get(this.id)).getID();
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
        fileHa.setNUMBER_VAHED(this.snumber);
        fileHa.setDATE_TIME(this.st_date);
        fileDaDA.upDateFile(idDB, fileHa);
    }

    /* access modifiers changed from: private */
    public boolean getValevS() {
        if (this.tprice.length() < 1) {
            Toast.makeText(getApplicationContext(), "Ù‚ÛŒÙ…Øª Ú©Ù„ Ø±Ø§ ØµØ­ÛŒØ­ ÙˆØ§Ø±Ø¯ Ú©Ù†ÛŒØ¯", Toast.LENGTH_SHORT).show();
            this.tprice.requestFocus();
            this.fBoolean = false;
        } else {
            this.Int_tprice_Total = Integer.parseInt(this.tprice.getText().toString().trim());
            this.fBoolean = true;
        }
        if (this.meter.length() < 1) {
            Toast.makeText(getApplicationContext(), " Ù…ØªØ±Ø§Ú˜ Ø±Ø§ ØµØ­ÛŒØ­ ÙˆØ§Ø±Ø¯ Ú©Ù†ÛŒØ¯", Toast.LENGTH_SHORT).show();
            this.mprice.requestFocus();
            this.fBoolean = false;
        } else {
            this.Int_meter = Integer.parseInt(this.meter.getText().toString().trim());
            this.fBoolean = true;
        }
        if (this.name.length() < 1) {
            Toast.makeText(getApplicationContext(), " Ù†Ø§Ù… Ù…Ø§Ù„ Ø±Ø§ ØµØ­ÛŒØ­ ÙˆØ§Ø±Ø¯ Ú©Ù†ÛŒØ¯", Toast.LENGTH_SHORT).show();
            this.name.requestFocus();
            this.fBoolean = false;
        } else {
            this.sname = this.name.getText().toString().trim();
            this.fBoolean = true;
        }
        if (this.mobile.length() < 9) {
            Toast.makeText(getApplicationContext(), " Ø´Ù…Ø§Ø±Ù‡ Ù…Ø§Ù„Ú© Ø±Ø§ ØµØ­ÛŒØ­ ÙˆØ§Ø±Ø¯ Ú©Ù†ÛŒØ¯", Toast.LENGTH_SHORT).show();
            this.mobile.requestFocus();
            this.fBoolean = false;
        } else {
            this.smobile = this.mobile.getText().toString().trim();
            this.fBoolean = true;
        }
        this.stel = this.tel.getText().toString().trim();
        this.sroom = Integer.parseInt(this.room.getText().toString().trim());
        this.sfloorTotal = this.floorTotal.getText().toString().trim();
        this.snumberTotal = this.numberTotal.getText().toString().trim();
        this.sfloor = this.floor.getText().toString().trim();
        this.snumber = this.number.getText().toString().trim();
        this.sextera = this.extera.getText().toString().trim();
        this.sstreet = this.street.getText().toString().trim();
        this.saddress = this.address.getText().toString().trim();
        this.smprice = Integer.parseInt(this.mprice.getText().toString());
        this.sage = Integer.parseInt(this.age.getText().toString().trim());
        this.sdir = this.dir.getSelectedItem().toString();
        this.sloc = this.loc.getSelectedItem().toString();
        if (this.parking.isChecked()) {
            this.sparking = " Ù¾Ø§Ø±Ú©ÛŒÙ†Ú¯ Ø¯Ø§Ø±Ø¯ ";
        } else {
            this.sparking = " Ù¾Ø§Ø±Ú©ÛŒÙ†Ú¯ Ù†Ø¯Ø§Ø±Ø¯ ";
        }
        if (this.ambari.isChecked()) {
            this.sambari = " Ø§Ù†Ø¨Ø§Ø±ÛŒ Ø¯Ø§Ø±Ø¯ ";
        } else {
            this.sambari = " Ø§Ù†Ø¨Ø§Ø± Ù†Ø¯Ø§Ø±Ø¯ ";
        }
        if (this.balkon.isChecked()) {
            this.sbalkon = " Ø¨Ø§Ù„Ú©Ù† Ø¯Ø§Ø±Ø¯ ";
        } else {
            this.sbalkon = " Ø¨Ø§Ù„Ú©Ù† Ù†Ø¯Ø§Ø±Ø¯ ";
        }
        if (this.asansor.isChecked()) {
            this.sasansor = " Ø¢Ø³Ø§Ù†Ø³ÙˆØ± Ø¯Ø§Ø±Ø¯ ";
        } else {
            this.sasansor = " Ø¢Ø³Ø§Ù†Ø³ÙˆØ± Ù†Ø¯Ø§Ø±Ø¯ ";
        }
        return true;
    }

    private void initComponent() {
        this.pish = (Button) findViewById(R.id.bt_pish);
        this.rent = (Button) findViewById(R.id.bt_rent);
        this.sell = (Button) findViewById(R.id.bt_sell);
        actionClickButton(this.sell);
        this.pish.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                EditActivity.this.actionClickButton(v);
            }
        });
        this.rent.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                EditActivity.this.actionClickButton(v);
            }
        });
        this.sell.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                EditActivity.this.actionClickButton(v);
            }
        });
    }

    /* access modifiers changed from: private */
    public void actionClickButton(View view) {
        selectedButton(this.pish);
        selectedButton(this.rent);
        selectedButton(this.sell);
        view.setSelected(true);
        selectedButton(view);
        selected();
    }

    private void selected() {
        if (this.sKind.matches("Ø§Ø¬Ø§Ø±Ù‡")) {
            this.rent.setSelected(true);
            this.pish.setSelected(false);
            this.sell.setSelected(false);
        }
        if (this.sKind.matches("ÙØ±ÙˆØ´")) {
            this.sell.setSelected(true);
            this.rent.setSelected(false);
            this.pish.setSelected(false);
        }
        if (this.sKind.matches("Ù¾ÛŒØ´ ÙØ±ÙˆØ´")) {
            this.pish.setSelected(true);
            this.sell.setSelected(false);
            this.rent.setSelected(false);
        }
        if (this.rent.isSelected()) {
            this.rahnBaha.setText("Ù…Ø¨Ù„Øº Ø±Ù‡Ù†");
            this.ejareBaha.setText("Ù…Ø¨Ù„Øº Ø§Ø¬Ø§Ø±Ù‡");
            this.kind = "Ø§Ø¬Ø§Ø±Ù‡";
        } else if (this.sell.isSelected()) {
            this.rahnBaha.setText(" Ù‚ÛŒÙ…Øª Ú©Ù„ ");
            this.ejareBaha.setText("Ù‚ÛŒÙ…Øª Ù‡Ø± Ù…ØªØ±");
            this.kind = "ÙØ±ÙˆØ´";
        } else if (this.pish.isSelected()) {
            this.rahnBaha.setText(" Ù‚ÛŒÙ…Øª Ú©Ù„ ");
            this.ejareBaha.setText("Ù‚ÛŒÙ…Øª Ù‡Ø± Ù…ØªØ±");
            this.kind = "Ù¾ÛŒØ´ ÙØ±ÙˆØ´";
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

    private void getDATA_From_DataBase() {
        File_Methods file_methods = new File_Methods(this);
        file_methods.open();
        List<FileHa> fileHas = file_methods.getAllFiles();
        this.sname = ((FileHa) fileHas.get(this.id)).getMALEK();
        this.smobile = ((FileHa) fileHas.get(this.id)).getMOBILE();
        this.stel = ((FileHa) fileHas.get(this.id)).getTel();
        this.sroom = ((FileHa) fileHas.get(this.id)).getROOM();
        this.sfloorTotal = ((FileHa) fileHas.get(this.id)).getNUBER_TOTAL_FLOOR();
        this.snumberTotal = ((FileHa) fileHas.get(this.id)).getNUMBER_Totol_vahed();
        this.sstreet = ((FileHa) fileHas.get(this.id)).getSTREET();
        this.saddress = ((FileHa) fileHas.get(this.id)).getADDREES();
        this.sdir = ((FileHa) fileHas.get(this.id)).getDIRECTION();
        this.sloc = ((FileHa) fileHas.get(this.id)).getLOCATION();
        this.sparking = ((FileHa) fileHas.get(this.id)).getPARKING();
        this.sbalkon = ((FileHa) fileHas.get(this.id)).getBALKON();
        this.sasansor = ((FileHa) fileHas.get(this.id)).getASANSOR();
        this.sambari = ((FileHa) fileHas.get(this.id)).getAMBARI();
        this.sextera = ((FileHa) fileHas.get(this.id)).getEXTERA();
        this.snumber = ((FileHa) fileHas.get(this.id)).getNUMBER_VAHED();
        this.sfloor = ((FileHa) fileHas.get(this.id)).getTABAGHE();
        this.kind = ((FileHa) fileHas.get(this.id)).getKIND();
        this.sage = ((FileHa) fileHas.get(this.id)).getSALEAKHT();
        this.smprice = ((FileHa) fileHas.get(this.id)).getPRICEMETER();
        this.sKind = ((FileHa) fileHas.get(this.id)).getKIND();
        this.Int_tprice_Total = ((FileHa) fileHas.get(this.id)).getPRICE_Total();
        this.Int_meter = ((FileHa) fileHas.get(this.id)).getMETREZ();
        this.name.setText(this.sname);
        this.mobile.setText(this.smobile);
        this.tel.setText(this.stel);
        EditText editText = this.room;
        toString();
        editText.setText(String.valueOf(this.sroom));
        this.floorTotal.setText(this.sfloorTotal);
        this.numberTotal.setText(this.snumberTotal);
        this.street.setText(this.sstreet);
        this.address.setText(this.saddress);
        this.extera.setText(this.sextera);
        this.tprice.setText(String.valueOf(this.Int_tprice_Total));
        this.mprice.setText(String.valueOf(this.smprice));
        this.meter.setText(String.valueOf(this.Int_meter));
        EditText editText2 = this.age;
        toString();
        editText2.setText(String.valueOf(this.sage));
        this.number.setText(this.snumber);
        this.floor.setText(this.sfloor);
        if (this.sparking.matches(" Ù¾Ø§Ø±Ú©ÛŒÙ†Ú¯ Ø¯Ø§Ø±Ø¯ ")) {
            this.parking.setChecked(true);
        } else {
            this.parking.setChecked(false);
        }
        if (this.sambari.matches(" Ø§Ù†Ø¨Ø§Ø±ÛŒ Ø¯Ø§Ø±Ø¯ ")) {
            this.ambari.setChecked(true);
        } else {
            this.ambari.setChecked(false);
        }
        if (this.sbalkon.matches(" Ø¨Ø§Ù„Ú©Ù† Ø¯Ø§Ø±Ø¯ ")) {
            this.balkon.setChecked(true);
        } else {
            this.balkon.setChecked(false);
        }
        if (this.sasansor.matches(" Ø¢Ø³Ø§Ù†Ø³ÙˆØ± Ø¯Ø§Ø±Ø¯ ")) {
            this.asansor.setChecked(true);
        } else {
            this.asansor.setChecked(false);
        }
    }
}

