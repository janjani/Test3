package com.example.amlakdb_test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "nameDB";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_FILE = "table_file";

    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE IF NOT EXISTS table_file ( ID INTEGER PRIMARY KEY AUTOINCREMENT , PRICETotal INTEGER, METER INTEGER, salesakht INTEGER, RAHNBAHA INTEGER, EJAREBAHA INTEGER, PRICEMETER INTEGER, room INTEGER, kind TEXT, MALEK TEXT, TEL TEXT, MOBILE TEXT, tabaghe TEXT, PARKING TEXT, AMBARI TEXT, BALKON TEXT, LOCATION TEXT, DIRECTION TEXT, STREET TEXT, ADDRESS TEXT, EXTERA TEXT, ASANSOR TEXT, NUMBERVAHED TEXT, NUMBERFLOOR TEXT, NUBERTOTAL TEXT, DATE_TIME TEXT, SHOMINE TEXT )");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS table_file");
    }

    public void Counting(SQLiteDatabase db) {
        db.execSQL("SELECT COUNT(*) AS fileCount FROM TABLE_FILE");
    }
}

