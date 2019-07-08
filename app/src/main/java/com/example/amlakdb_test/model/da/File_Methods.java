package com.example.amlakdb_test.model.da;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.amlakdb_test.MyDBHelper;
import com.example.amlakdb_test.model.to.FileHa;
import java.util.ArrayList;
import java.util.List;

public class File_Methods {
    public static String text;
    private SQLiteDatabase database;
    private String[] fileColumns = {FileHa.KEY_ID, FileHa.KEY_KIND, FileHa.KEY_PRICE_Total, FileHa.KEY_PRICE_METER, FileHa.KEY_METER, FileHa.KEY_MALEK, FileHa.KEY_TEL, FileHa.KEY_MOBILE, FileHa.KEY_ROOM, FileHa.KEY_TABAGHE, FileHa.KEY_SALEAKHT, FileHa.KEY_PARKING, FileHa.KEY_AMBARI, FileHa.KEY_BALKON, FileHa.KEY_SHOMINE, FileHa.KEY_NUMBER_TOTAL_VAHED, FileHa.KEY_NUBER_TOTAL_FLOOR, FileHa.KEY_LOCATION, FileHa.KEY_DIRECTION, FileHa.KEY_STREET, FileHa.KEY_ADDREES, FileHa.KEY_EXTERA, FileHa.KEY_ASANSOR, FileHa.KEY_RAHN_BAHA, FileHa.KEY_EJARE_BAHA, FileHa.KEY_NUMBER_VAHED, FileHa.KEY_DATE_TIME};
    private SQLiteOpenHelper sqLiteOpenHelper;

    public File_Methods(Context context) {
        this.sqLiteOpenHelper = new MyDBHelper(context);
    }

    public void addFile(FileHa fileHa) {
        open();
        ContentValues value = new ContentValues();
        value.put(FileHa.KEY_KIND, fileHa.getKIND());
        value.put(FileHa.KEY_PRICE_Total, Integer.valueOf(fileHa.getPRICE_Total()));
        value.put(FileHa.KEY_PRICE_METER, Integer.valueOf(fileHa.getPRICEMETER()));
        value.put(FileHa.KEY_METER, Integer.valueOf(fileHa.getMETREZ()));
        value.put(FileHa.KEY_MALEK, fileHa.getMALEK());
        value.put(FileHa.KEY_TEL, fileHa.getTel());
        value.put(FileHa.KEY_MOBILE, fileHa.getMOBILE());
        value.put(FileHa.KEY_ROOM, Integer.valueOf(fileHa.getROOM()));
        value.put(FileHa.KEY_TABAGHE, fileHa.getTABAGHE());
        value.put(FileHa.KEY_SALEAKHT, Integer.valueOf(fileHa.getSALEAKHT()));
        value.put(FileHa.KEY_PARKING, fileHa.getPARKING());
        value.put(FileHa.KEY_AMBARI, fileHa.getAMBARI());
        value.put(FileHa.KEY_BALKON, fileHa.getBALKON());
        value.put(FileHa.KEY_SHOMINE, fileHa.getSHOMINE());
        value.put(FileHa.KEY_ADDREES, fileHa.getADDREES());
        value.put(FileHa.KEY_NUMBER_TOTAL_VAHED, fileHa.getNUMBER_Totol_vahed());
        value.put(FileHa.KEY_NUBER_TOTAL_FLOOR, fileHa.getNUBER_TOTAL_FLOOR());
        value.put(FileHa.KEY_LOCATION, fileHa.getLOCATION());
        value.put(FileHa.KEY_DIRECTION, fileHa.getDIRECTION());
        value.put(FileHa.KEY_STREET, fileHa.getSTREET());
        value.put(FileHa.KEY_EXTERA, fileHa.getEXTERA());
        value.put(FileHa.KEY_ASANSOR, fileHa.getASANSOR());
        value.put(FileHa.KEY_RAHN_BAHA, Integer.valueOf(fileHa.getRAHN_BAHA()));
        value.put(FileHa.KEY_EJARE_BAHA, Integer.valueOf(fileHa.getEJARE_BAHA()));
        value.put(FileHa.KEY_SHOMINE, fileHa.getSHOMINE());
        value.put(FileHa.KEY_NUMBER_VAHED, fileHa.getNUMBER_VAHED());
        value.put(FileHa.KEY_DATE_TIME, fileHa.getDATE_TIME());
        this.database.insert(MyDBHelper.TABLE_FILE, null, value);
    }

    public List<FileHa> getAllFiles() {
        List<FileHa> fileHas = new ArrayList<>();
        open();
        Cursor cursor = this.database.query(MyDBHelper.TABLE_FILE, this.fileColumns, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                FileHa fileHa = new FileHa();
                fileHa.setID(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_ID)));
                fileHa.setKIND(cursor.getString(cursor.getColumnIndex(FileHa.KEY_KIND)));
                fileHa.setPRICE_Total(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_PRICE_Total)));
                fileHa.setPRICEMETER(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_PRICE_METER)));
                fileHa.setMETREZ(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_METER)));
                fileHa.setMALEK(cursor.getString(cursor.getColumnIndex(FileHa.KEY_MALEK)));
                fileHa.setTel(cursor.getString(cursor.getColumnIndex(FileHa.KEY_TEL)));
                fileHa.setMOBILE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_MOBILE)));
                fileHa.setROOM(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_ROOM)));
                fileHa.setTABAGHE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_TABAGHE)));
                fileHa.setSALEAKHT(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_SALEAKHT)));
                fileHa.setPARKING(cursor.getString(cursor.getColumnIndex(FileHa.KEY_PARKING)));
                fileHa.setAMBARI(cursor.getString(cursor.getColumnIndex(FileHa.KEY_AMBARI)));
                fileHa.setBALKON(cursor.getString(cursor.getColumnIndex(FileHa.KEY_BALKON)));
                fileHa.setSHOMINE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_SHOMINE)));
                fileHa.setNUMBER_Totol_vahed(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUMBER_TOTAL_VAHED)));
                fileHa.setNUBER_TOTAL_FLOOR(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUBER_TOTAL_FLOOR)));
                fileHa.setLOCATION(cursor.getString(cursor.getColumnIndex(FileHa.KEY_LOCATION)));
                fileHa.setDIRECTION(cursor.getString(cursor.getColumnIndex(FileHa.KEY_DIRECTION)));
                fileHa.setSTREET(cursor.getString(cursor.getColumnIndex(FileHa.KEY_STREET)));
                fileHa.setADDREES(cursor.getString(cursor.getColumnIndex(FileHa.KEY_ADDREES)));
                fileHa.setEXTERA(cursor.getString(cursor.getColumnIndex(FileHa.KEY_EXTERA)));
                fileHa.setASANSOR(cursor.getString(cursor.getColumnIndex(FileHa.KEY_ASANSOR)));
                fileHa.setRAHN_BAHA(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_RAHN_BAHA)));
                fileHa.setEJARE_BAHA(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_EJARE_BAHA)));
                fileHa.setNUMBER_VAHED(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUMBER_VAHED)));
                fileHa.setDATE_TIME(cursor.getString(cursor.getColumnIndex(FileHa.KEY_DATE_TIME)));
                fileHas.add(fileHa);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return fileHas;
    }

    public List<FileHa> getSellFiles() {
        List<FileHa> fileHas = new ArrayList<>();
        open();
        Cursor cursor = this.database.rawQuery("SELECT  * FROM table_file WHERE kind =? ", new String[]{"فروش"});
        if (cursor.moveToFirst()) {
            do {
                FileHa fileHa = new FileHa();
                fileHa.setID(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_ID)));
                fileHa.setKIND(cursor.getString(cursor.getColumnIndex(FileHa.KEY_KIND)));
                fileHa.setPRICE_Total(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_PRICE_Total)));
                fileHa.setPRICEMETER(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_PRICE_METER)));
                fileHa.setMETREZ(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_METER)));
                fileHa.setMALEK(cursor.getString(cursor.getColumnIndex(FileHa.KEY_MALEK)));
                fileHa.setTel(cursor.getString(cursor.getColumnIndex(FileHa.KEY_TEL)));
                fileHa.setMOBILE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_MOBILE)));
                fileHa.setROOM(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_ROOM)));
                fileHa.setTABAGHE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_TABAGHE)));
                fileHa.setSALEAKHT(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_SALEAKHT)));
                fileHa.setPARKING(cursor.getString(cursor.getColumnIndex(FileHa.KEY_PARKING)));
                fileHa.setAMBARI(cursor.getString(cursor.getColumnIndex(FileHa.KEY_AMBARI)));
                fileHa.setBALKON(cursor.getString(cursor.getColumnIndex(FileHa.KEY_BALKON)));
                fileHa.setSHOMINE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_SHOMINE)));
                fileHa.setNUMBER_Totol_vahed(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUMBER_TOTAL_VAHED)));
                fileHa.setNUBER_TOTAL_FLOOR(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUBER_TOTAL_FLOOR)));
                fileHa.setLOCATION(cursor.getString(cursor.getColumnIndex(FileHa.KEY_LOCATION)));
                fileHa.setDIRECTION(cursor.getString(cursor.getColumnIndex(FileHa.KEY_DIRECTION)));
                fileHa.setSTREET(cursor.getString(cursor.getColumnIndex(FileHa.KEY_STREET)));
                fileHa.setADDREES(cursor.getString(cursor.getColumnIndex(FileHa.KEY_ADDREES)));
                fileHa.setEXTERA(cursor.getString(cursor.getColumnIndex(FileHa.KEY_EXTERA)));
                fileHa.setASANSOR(cursor.getString(cursor.getColumnIndex(FileHa.KEY_ASANSOR)));
                fileHa.setRAHN_BAHA(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_RAHN_BAHA)));
                fileHa.setEJARE_BAHA(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_EJARE_BAHA)));
                fileHa.setNUMBER_VAHED(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUMBER_VAHED)));
                fileHa.setDATE_TIME(cursor.getString(cursor.getColumnIndex(FileHa.KEY_DATE_TIME)));
                fileHas.add(fileHa);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return fileHas;
    }

    public List<FileHa> getRentFiles() {
        List<FileHa> fileHas = new ArrayList<>();
        open();
        Cursor cursor = this.database.rawQuery("SELECT  * FROM table_file WHERE kind =? ", new String[]{"اجاره"});
        if (cursor.moveToFirst()) {
            do {
                FileHa fileHa = new FileHa();
                fileHa.setID(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_ID)));
                fileHa.setKIND(cursor.getString(cursor.getColumnIndex(FileHa.KEY_KIND)));
                fileHa.setPRICE_Total(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_PRICE_Total)));
                fileHa.setPRICEMETER(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_PRICE_METER)));
                fileHa.setMETREZ(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_METER)));
                fileHa.setMALEK(cursor.getString(cursor.getColumnIndex(FileHa.KEY_MALEK)));
                fileHa.setTel(cursor.getString(cursor.getColumnIndex(FileHa.KEY_TEL)));
                fileHa.setMOBILE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_MOBILE)));
                fileHa.setROOM(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_ROOM)));
                fileHa.setTABAGHE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_TABAGHE)));
                fileHa.setSALEAKHT(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_SALEAKHT)));
                fileHa.setPARKING(cursor.getString(cursor.getColumnIndex(FileHa.KEY_PARKING)));
                fileHa.setAMBARI(cursor.getString(cursor.getColumnIndex(FileHa.KEY_AMBARI)));
                fileHa.setBALKON(cursor.getString(cursor.getColumnIndex(FileHa.KEY_BALKON)));
                fileHa.setSHOMINE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_SHOMINE)));
                fileHa.setNUMBER_Totol_vahed(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUMBER_TOTAL_VAHED)));
                fileHa.setNUBER_TOTAL_FLOOR(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUBER_TOTAL_FLOOR)));
                fileHa.setLOCATION(cursor.getString(cursor.getColumnIndex(FileHa.KEY_LOCATION)));
                fileHa.setDIRECTION(cursor.getString(cursor.getColumnIndex(FileHa.KEY_DIRECTION)));
                fileHa.setSTREET(cursor.getString(cursor.getColumnIndex(FileHa.KEY_STREET)));
                fileHa.setADDREES(cursor.getString(cursor.getColumnIndex(FileHa.KEY_ADDREES)));
                fileHa.setEXTERA(cursor.getString(cursor.getColumnIndex(FileHa.KEY_EXTERA)));
                fileHa.setASANSOR(cursor.getString(cursor.getColumnIndex(FileHa.KEY_ASANSOR)));
                fileHa.setRAHN_BAHA(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_RAHN_BAHA)));
                fileHa.setEJARE_BAHA(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_EJARE_BAHA)));
                fileHa.setNUMBER_VAHED(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUMBER_VAHED)));
                fileHa.setDATE_TIME(cursor.getString(cursor.getColumnIndex(FileHa.KEY_DATE_TIME)));
                fileHas.add(fileHa);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return fileHas;
    }

    public List<FileHa> getPishFiles() {
        List<FileHa> fileHas = new ArrayList<>();
        open();
        Cursor cursor = this.database.rawQuery("SELECT  * FROM table_file WHERE kind =? ", new String[]{"پیش فروش"});
        if (cursor.moveToFirst()) {
            do {
                FileHa fileHa = new FileHa();
                fileHa.setID(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_ID)));
                fileHa.setKIND(cursor.getString(cursor.getColumnIndex(FileHa.KEY_KIND)));
                fileHa.setPRICE_Total(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_PRICE_Total)));
                fileHa.setPRICEMETER(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_PRICE_METER)));
                fileHa.setMETREZ(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_METER)));
                fileHa.setMALEK(cursor.getString(cursor.getColumnIndex(FileHa.KEY_MALEK)));
                fileHa.setTel(cursor.getString(cursor.getColumnIndex(FileHa.KEY_TEL)));
                fileHa.setMOBILE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_MOBILE)));
                fileHa.setROOM(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_ROOM)));
                fileHa.setTABAGHE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_TABAGHE)));
                fileHa.setSALEAKHT(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_SALEAKHT)));
                fileHa.setPARKING(cursor.getString(cursor.getColumnIndex(FileHa.KEY_PARKING)));
                fileHa.setAMBARI(cursor.getString(cursor.getColumnIndex(FileHa.KEY_AMBARI)));
                fileHa.setBALKON(cursor.getString(cursor.getColumnIndex(FileHa.KEY_BALKON)));
                fileHa.setSHOMINE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_SHOMINE)));
                fileHa.setNUMBER_Totol_vahed(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUMBER_TOTAL_VAHED)));
                fileHa.setNUBER_TOTAL_FLOOR(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUBER_TOTAL_FLOOR)));
                fileHa.setLOCATION(cursor.getString(cursor.getColumnIndex(FileHa.KEY_LOCATION)));
                fileHa.setDIRECTION(cursor.getString(cursor.getColumnIndex(FileHa.KEY_DIRECTION)));
                fileHa.setSTREET(cursor.getString(cursor.getColumnIndex(FileHa.KEY_STREET)));
                fileHa.setADDREES(cursor.getString(cursor.getColumnIndex(FileHa.KEY_ADDREES)));
                fileHa.setEXTERA(cursor.getString(cursor.getColumnIndex(FileHa.KEY_EXTERA)));
                fileHa.setASANSOR(cursor.getString(cursor.getColumnIndex(FileHa.KEY_ASANSOR)));
                fileHa.setRAHN_BAHA(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_RAHN_BAHA)));
                fileHa.setEJARE_BAHA(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_EJARE_BAHA)));
                fileHa.setNUMBER_VAHED(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUMBER_VAHED)));
                fileHa.setDATE_TIME(cursor.getString(cursor.getColumnIndex(FileHa.KEY_DATE_TIME)));
                fileHas.add(fileHa);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return fileHas;
    }

    public void upDateFile(int id, FileHa fileHa) {
        open();
        ContentValues value = new ContentValues();
        value.put(FileHa.KEY_KIND, fileHa.getKIND());
        value.put(FileHa.KEY_PRICE_Total, Integer.valueOf(fileHa.getPRICE_Total()));
        value.put(FileHa.KEY_PRICE_METER, Integer.valueOf(fileHa.getPRICEMETER()));
        value.put(FileHa.KEY_METER, Integer.valueOf(fileHa.getMETREZ()));
        value.put(FileHa.KEY_MALEK, fileHa.getMALEK());
        value.put(FileHa.KEY_TEL, fileHa.getTel());
        value.put(FileHa.KEY_MOBILE, fileHa.getMOBILE());
        value.put(FileHa.KEY_ROOM, Integer.valueOf(fileHa.getROOM()));
        value.put(FileHa.KEY_TABAGHE, fileHa.getTABAGHE());
        value.put(FileHa.KEY_SALEAKHT, Integer.valueOf(fileHa.getSALEAKHT()));
        value.put(FileHa.KEY_PARKING, fileHa.getPARKING());
        value.put(FileHa.KEY_AMBARI, fileHa.getAMBARI());
        value.put(FileHa.KEY_BALKON, fileHa.getBALKON());
        value.put(FileHa.KEY_SHOMINE, fileHa.getSHOMINE());
        value.put(FileHa.KEY_ADDREES, fileHa.getADDREES());
        value.put(FileHa.KEY_NUMBER_TOTAL_VAHED, fileHa.getNUMBER_Totol_vahed());
        value.put(FileHa.KEY_NUBER_TOTAL_FLOOR, fileHa.getNUBER_TOTAL_FLOOR());
        value.put(FileHa.KEY_LOCATION, fileHa.getLOCATION());
        value.put(FileHa.KEY_DIRECTION, fileHa.getDIRECTION());
        value.put(FileHa.KEY_STREET, fileHa.getSTREET());
        value.put(FileHa.KEY_EXTERA, fileHa.getEXTERA());
        value.put(FileHa.KEY_ASANSOR, fileHa.getASANSOR());
        value.put(FileHa.KEY_RAHN_BAHA, Integer.valueOf(fileHa.getRAHN_BAHA()));
        value.put(FileHa.KEY_EJARE_BAHA, Integer.valueOf(fileHa.getEJARE_BAHA()));
        value.put(FileHa.KEY_SHOMINE, fileHa.getSHOMINE());
        value.put(FileHa.KEY_NUMBER_VAHED, fileHa.getNUMBER_VAHED());
        value.put(FileHa.KEY_DATE_TIME, fileHa.getDATE_TIME());
        this.database.update(MyDBHelper.TABLE_FILE, value, "ID =? ", new String[]{String.valueOf(id)});
    }

    public void deletFile(int id) {
        open();
        this.database.delete(MyDBHelper.TABLE_FILE, "ID =? ", new String[]{String.valueOf(id)});
    }

    public long getFilesCount() {
        open();
        long count = DatabaseUtils.queryNumEntries(this.database, MyDBHelper.TABLE_FILE);
        this.database.close();
        return count;
    }

    public int getForoshiCount() {
        open();
        Cursor cursor = this.database.rawQuery("SELECT  * FROM table_file WHERE kind =? ", new String[]{"فروش"});
        int countFroshi = cursor.getCount();
        cursor.close();
        return countFroshi;
    }

    public int getEjareCount() {
        open();
        Cursor cursor = this.database.rawQuery("SELECT  * FROM table_file WHERE kind =? ", new String[]{"اجاره"});
        int countFroshi = cursor.getCount();
        cursor.close();
        return countFroshi;
    }

    public int getPishfrosh() {
        open();
        Cursor cursor = this.database.rawQuery("SELECT  * FROM table_file WHERE kind =? ", new String[]{"پیش فروش"});
        int countPishfrosh = cursor.getCount();
        cursor.close();
        return countPishfrosh;
    }

    public int getMinPriceFroshi() {
        open();
        int MinPriceFroshi = 0;
        Cursor cursor = this.database.rawQuery("SELECT  MIN(PRICETotal)AS MINN FROM table_file WHERE kind =? ", new String[]{"فروش"});
        while (cursor.moveToNext()) {
            MinPriceFroshi = cursor.getInt(0);
        }
        cursor.close();
        return MinPriceFroshi;
    }

    public int getMaxPriceFroshi() {
        open();
        int MaxPriceFroshi = 0;
        Cursor cursor = this.database.rawQuery("SELECT  MAX(PRICETotal)AS MINN FROM table_file WHERE kind =? ", new String[]{"فروش"});
        while (cursor.moveToNext()) {
            MaxPriceFroshi = cursor.getInt(0);
        }
        cursor.close();
        return MaxPriceFroshi;
    }

    public int getMinEjare() {
        open();
        int MinPriceEjare = 0;
        Cursor cursor = this.database.rawQuery("SELECT  MIN(PRICETotal)AS MINN FROM table_file WHERE kind =? ", new String[]{"اجاره"});
        while (cursor.moveToNext()) {
            MinPriceEjare = cursor.getInt(0);
        }
        cursor.close();
        return MinPriceEjare;
    }

    public int getMaxEjare() {
        open();
        int MaxPriceEjare = 0;
        Cursor cursor = this.database.rawQuery("SELECT  MAX(PRICETotal)AS MINN FROM table_file WHERE kind =? ", new String[]{"اجاره"});
        while (cursor.moveToNext()) {
            MaxPriceEjare = cursor.getInt(0);
        }
        cursor.close();
        return MaxPriceEjare;
    }

    public int getMinPricePishFrosh() {
        open();
        int MinPricePishFrosh = 0;
        Cursor cursor = this.database.rawQuery("SELECT  MIN(PRICETotal)AS MINN FROM table_file WHERE kind =? ", new String[]{"پیش فروش"});
        while (cursor.moveToNext()) {
            MinPricePishFrosh = cursor.getInt(0);
        }
        cursor.close();
        return MinPricePishFrosh;
    }

    public int getMaxPricePishFrosh() {
        open();
        int MaxPricePishFrosh = 0;
        Cursor cursor = this.database
        .rawQuery("SELECT  MAX(PRICETotal)AS MINN FROM table_file WHERE kind =? ", new String[]{"پیش فروش"});
        while (cursor.moveToNext()) {
            MaxPricePishFrosh = cursor.getInt(0);
        }
        cursor.close();
        return MaxPricePishFrosh;
    }

    public void open() {
        this.database = this.sqLiteOpenHelper.getWritableDatabase();
    }

    public void close() {
        this.database.close();
    }

    public List<FileHa> getmeter() {
        List<FileHa> fileHas = new ArrayList<>();
        open();
        Cursor cursor = this.database.query(MyDBHelper.TABLE_FILE, this.fileColumns, "METER <?  AND METER >? ", new String[]{"100", "50"}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                FileHa fileHa = new FileHa();
                fileHa.setID(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_ID)));
                fileHa.setKIND(cursor.getString(cursor.getColumnIndex(FileHa.KEY_KIND)));
                fileHa.setPRICE_Total(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_PRICE_Total)));
                fileHa.setPRICEMETER(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_PRICE_METER)));
                fileHa.setMETREZ(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_METER)));
                fileHa.setMALEK(cursor.getString(cursor.getColumnIndex(FileHa.KEY_MALEK)));
                fileHa.setTel(cursor.getString(cursor.getColumnIndex(FileHa.KEY_TEL)));
                fileHa.setMOBILE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_MOBILE)));
                fileHa.setROOM(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_ROOM)));
                fileHa.setTABAGHE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_TABAGHE)));
                fileHa.setSALEAKHT(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_SALEAKHT)));
                fileHa.setPARKING(cursor.getString(cursor.getColumnIndex(FileHa.KEY_PARKING)));
                fileHa.setAMBARI(cursor.getString(cursor.getColumnIndex(FileHa.KEY_AMBARI)));
                fileHa.setBALKON(cursor.getString(cursor.getColumnIndex(FileHa.KEY_BALKON)));
                fileHa.setSHOMINE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_SHOMINE)));
                fileHa.setNUMBER_Totol_vahed(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUMBER_TOTAL_VAHED)));
                fileHa.setNUBER_TOTAL_FLOOR(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUBER_TOTAL_FLOOR)));
                fileHa.setLOCATION(cursor.getString(cursor.getColumnIndex(FileHa.KEY_LOCATION)));
                fileHa.setDIRECTION(cursor.getString(cursor.getColumnIndex(FileHa.KEY_DIRECTION)));
                fileHa.setSTREET(cursor.getString(cursor.getColumnIndex(FileHa.KEY_STREET)));
                fileHa.setADDREES(cursor.getString(cursor.getColumnIndex(FileHa.KEY_ADDREES)));
                fileHa.setEXTERA(cursor.getString(cursor.getColumnIndex(FileHa.KEY_EXTERA)));
                fileHa.setASANSOR(cursor.getString(cursor.getColumnIndex(FileHa.KEY_ASANSOR)));
                fileHa.setRAHN_BAHA(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_RAHN_BAHA)));
                fileHa.setEJARE_BAHA(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_EJARE_BAHA)));
                fileHa.setNUMBER_VAHED(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUMBER_VAHED)));
                fileHa.setDATE_TIME(cursor.getString(cursor.getColumnIndex(FileHa.KEY_DATE_TIME)));
                fileHas.add(fileHa);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return fileHas;
    }

    public List<FileHa> getSearchFiles(String kind, int age, int room, String S_et_name,
                                       int min_tprice_rentBaha, int max_tprice_rentBaha,
                                       int min_mprice_ejareBaha, int max_mprice_ejareBaha,
                                       String S_et_street, String meter_MaX, String meter_MiN) {
        String smax_meter;
        int i = age;
        int i2 = room;
        int i3 = min_tprice_rentBaha;
        int i4 = max_tprice_rentBaha;
        int i5 = min_mprice_ejareBaha;
        int i6 = max_mprice_ejareBaha;
        open();
        String sage = "";
        if (i >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(" AND salesakht <= ");
            sb.append(i);
            sage = sb.toString();
        }
        String sroom = "";
        if (i2 >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" AND room <= ");
            sb2.append(i2);
            sroom = sb2.toString();
        }
        String sname = "";
        if (S_et_name.length() >= 1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" AND MALEK LIKE '");
            sb3.append(S_et_name);
            sb3.append("'");
            sname = sb3.toString();
        } else {
            String str = S_et_name;
        }
        String sstreet = "";
        if (S_et_street.length() >= 1) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(" AND salesakht LIKE '");
            sb4.append(S_et_street);
            sb4.append("'");
            sstreet = sb4.toString();
        } else {
            String str2 = S_et_street;
        }
        String smin_tprice = "";
        if (i3 > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" AND PRICETotal >= '");
            sb5.append(i3);
            sb5.append("'");
            smin_tprice = sb5.toString();
        }
        String smax_tprice = "";
        if (i4 > 0) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(" AND PRICETotal <= '");
            sb6.append(i4);
            sb6.append("'");
            smax_tprice = sb6.toString();
        }
        String smin_mprice = "";
        if (i5 > 0) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(" AND PRICEMETER >= '");
            sb7.append(i5);
            sb7.append("'");
            smin_mprice = sb7.toString();
        }
        String smax_mprice = "";
        if (i6 > 0) {
            StringBuilder sb8 = new StringBuilder();
            String str3 = smax_mprice;
            sb8.append(" AND PRICEMETER <= '");
            sb8.append(i6);
            sb8.append("'");
            smax_mprice = sb8.toString();
        }
        String smin_meter = "";
        if (meter_MaX.length() >= 1) {
            StringBuilder sb9 = new StringBuilder();
            sb9.append(" AND METER <= '");
            sb9.append(meter_MaX);
            sb9.append("'");
            smin_meter = sb9.toString();
        }
        String smax_meter2 = "";
        if (meter_MiN.length() >= 1) {
            StringBuilder sb10 = new StringBuilder();
            sb10.append(" AND METER >= '");
            sb10.append(meter_MiN);
            sb10.append("'");
            smax_meter = sb10.toString();
        } else {
            smax_meter = smax_meter2;
        }
        StringBuilder sb11 = new StringBuilder();
        sb11.append(" select * from table_file where kind = ? ");
        sb11.append(sage);
        sb11.append(sroom);
        sb11.append(sname);
        sb11.append(sstreet);
        sb11.append(smin_tprice);
        sb11.append(smax_tprice);
        sb11.append(smin_mprice);
        sb11.append(smax_mprice);
        sb11.append(smin_meter);
        sb11.append(smax_meter);
        String selectQuery = sb11.toString();
        String str4 = smax_mprice;
        String str5 = smax_meter;
        Cursor cursor = this.database.rawQuery(selectQuery, new String[]{String.valueOf(kind)});
        List<FileHa> fileHas = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (true) {
                FileHa fileHa = new FileHa();
                String selectQuery2 = selectQuery;
                FileHa fileHa2 = fileHa;
                fileHa2.setID(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_ID)));
                fileHa2.setKIND(cursor.getString(cursor.getColumnIndex(FileHa.KEY_KIND)));
                fileHa2.setPRICE_Total(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_PRICE_Total)));
                fileHa2.setPRICEMETER(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_PRICE_METER)));
                fileHa2.setMETREZ(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_METER)));
                fileHa2.setMALEK(cursor.getString(cursor.getColumnIndex(FileHa.KEY_MALEK)));
                fileHa2.setTel(cursor.getString(cursor.getColumnIndex(FileHa.KEY_TEL)));
                fileHa2.setMOBILE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_MOBILE)));
                fileHa2.setROOM(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_ROOM)));
                fileHa2.setTABAGHE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_TABAGHE)));
                fileHa2.setSALEAKHT(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_SALEAKHT)));
                fileHa2.setPARKING(cursor.getString(cursor.getColumnIndex(FileHa.KEY_PARKING)));
                fileHa2.setAMBARI(cursor.getString(cursor.getColumnIndex(FileHa.KEY_AMBARI)));
                fileHa2.setBALKON(cursor.getString(cursor.getColumnIndex(FileHa.KEY_BALKON)));
                fileHa2.setSHOMINE(cursor.getString(cursor.getColumnIndex(FileHa.KEY_SHOMINE)));
                fileHa2.setNUMBER_Totol_vahed(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUMBER_TOTAL_VAHED)));
                fileHa2.setNUBER_TOTAL_FLOOR(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUBER_TOTAL_FLOOR)));
                fileHa2.setLOCATION(cursor.getString(cursor.getColumnIndex(FileHa.KEY_LOCATION)));
                fileHa2.setDIRECTION(cursor.getString(cursor.getColumnIndex(FileHa.KEY_DIRECTION)));
                fileHa2.setSTREET(cursor.getString(cursor.getColumnIndex(FileHa.KEY_STREET)));
                fileHa2.setADDREES(cursor.getString(cursor.getColumnIndex(FileHa.KEY_ADDREES)));
                fileHa2.setEXTERA(cursor.getString(cursor.getColumnIndex(FileHa.KEY_EXTERA)));
                fileHa2.setASANSOR(cursor.getString(cursor.getColumnIndex(FileHa.KEY_ASANSOR)));
                fileHa2.setRAHN_BAHA(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_RAHN_BAHA)));
                fileHa2.setEJARE_BAHA(cursor.getInt(cursor.getColumnIndex(FileHa.KEY_EJARE_BAHA)));
                fileHa2.setNUMBER_VAHED(cursor.getString(cursor.getColumnIndex(FileHa.KEY_NUMBER_VAHED)));
                fileHa2.setDATE_TIME(cursor.getString(cursor.getColumnIndex(FileHa.KEY_DATE_TIME)));
                fileHas.add(fileHa2);
                if (!cursor.moveToNext()) {
                    break;
                }
                selectQuery = selectQuery2;
            }
        } else {
            text = "1";
        }
        cursor.close();
        close();
        return fileHas;
    }
}
