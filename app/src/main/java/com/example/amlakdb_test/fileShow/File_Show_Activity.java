package com.example.amlakdb_test.fileShow;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.balysv.materialripple.MaterialRippleLayout;
import com.example.amlakdb_test.Edit.EditActivity;
import com.example.amlakdb_test.model.Image;
import com.example.amlakdb_test.model.da.File_Methods;
import com.example.amlakdb_test.model.to.FileHa;
import com.example.amlakdb_test.recycler.RecyclerViewActivity;
import com.example.amlakdb_test.search.Search_Activity;
import com.example.amlakdb_test.utils.Tools;
import com.example.amlakdb_test.utils.ViewAnimation;
import com.example.amlakdb_test.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.example.amlakdb_test.search.Search_Activity.S_et_name;
import static com.example.amlakdb_test.search.Search_Activity.S_et_street;
import static com.example.amlakdb_test.search.Search_Activity.int_age;
import static com.example.amlakdb_test.search.Search_Activity.kind;
import static com.example.amlakdb_test.search.Search_Activity.max_mprice_ejareBaha;
import static com.example.amlakdb_test.search.Search_Activity.max_tprice_rentBaha;
import static com.example.amlakdb_test.search.Search_Activity.meter_MaX;
import static com.example.amlakdb_test.search.Search_Activity.meter_MiN;
import static com.example.amlakdb_test.search.Search_Activity.min_mprice_ejareBaha;
import static com.example.amlakdb_test.search.Search_Activity.min_tprice_rentBaha;

public class File_Show_Activity extends AppCompatActivity {
    private static final int PERM_REQ_CODE = 1111;
    private static int[] array_image_product = {R.drawable.image_shop_9, R.drawable.image_shop_10, R.drawable.image_shop_11, R.drawable.image_shop_12, R.drawable.image_shop_13};
    private static final int code_capture = 20;
    private static final int code_select = 10;
    int EJARE_BAHA;
    String Smobile;
    String ad;
    /* access modifiers changed from: private */
    public AdapterImageSlider adapterImageSlider;
    String ambari;
    String asansor;
    String balkon;
    ImageButton btnCall;
    ImageButton btnCallMobile;
    int cFile = 0;
    public Context context;
    String dis;
    String floor;
    int id;
    ImageView image;
    String kindPrice;
    /* access modifiers changed from: private */
    public LinearLayout layout_dots;
    boolean mExternalStorageAvailable = false;
    boolean mExternalStorageWriteable = false;
    String malek;
    String malek_kind;
    int meter;
    int num = 0;
    private View parent_vieA;
    String parking;
    int price;
    /* access modifiers changed from: private */
    public ProgressDialog progressBar;
    /* access modifiers changed from: private */
    public int progressBarStatus = 0;
    /* access modifiers changed from: private */
    public Handler progressBarbHandler = new Handler();
    RecyclerView recyclerView;
    int room;
    /* access modifiers changed from: private */
    public boolean rotate = false;
    String state = Environment.getExternalStorageState();
    String street;
    String tel;
    Bitmap thumbnail;
    TextView tvaddress;
    TextView tvambari;
    TextView tvasansor;
    TextView tvdisc;
    TextView tvmeter;
    TextView tvmobile;
    TextView tvparking;
    TextView tvprice;
    TextView tvroom;
    TextView tvtel;
    TextView txtDate;
    String typeList;
    private ViewPager viewPager;
    String x;

    private static class AdapterImageSlider extends PagerAdapter {
        private Activity act;
        private List<Image> items;
        /* access modifiers changed from: private */
        public OnItemClickListener onItemClickListener;

        private interface OnItemClickListener {
            void onItemClick(View view, Image image);
        }

        public void setOnItemClickListener(OnItemClickListener onItemClickListener2) {
            this.onItemClickListener = onItemClickListener2;
        }

        private AdapterImageSlider(Activity activity, List<Image> items2) {
            this.act = activity;
            this.items = items2;
        }

        public int getCount() {
            return this.items.size();
        }

        public Image getItem(int pos) {
            return (Image) this.items.get(pos);
        }

        public void setItems(List<Image> items2) {
            this.items = items2;
            notifyDataSetChanged();
        }

        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        public Object instantiateItem(ViewGroup container, int position) {
            final Image o = (Image) this.items.get(position);
            View v = ((LayoutInflater) this.act.getSystemService(LAYOUT_INFLATER_SERVICE))
                    .inflate(R.layout.item_slider_image, container, false);
            MaterialRippleLayout lyt_parent = (MaterialRippleLayout) v.findViewById(R.id.lyt_parent);
            Tools.displayImageOriginal((Context) this.act, (ImageView) v.findViewById(R.id.image), o.image);
            lyt_parent.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    if (AdapterImageSlider.this.onItemClickListener != null) {
                        AdapterImageSlider.this.onItemClickListener.onItemClick(v, o);
                    }
                }
            });
            ((ViewPager) container).addView(v);
            return v;
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((RelativeLayout) object);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_file__show_);
        this.context = this.context;
        initComponent();
        this.x = "1";
        this.btnCall = (ImageButton) findViewById(R.id.btnCall);
        this.btnCallMobile = (ImageButton) findViewById(R.id.btnCallmobile);
        this.tvmeter = (TextView) findViewById(R.id.meter1);
        this.tvprice = (TextView) findViewById(R.id.price);
        this.tvroom = (TextView) findViewById(R.id.jahat);
        this.tvdisc = (TextView) findViewById(R.id.disc);
        this.tvparking = (TextView) findViewById(R.id.parking);
        this.tvasansor = (TextView) findViewById(R.id.asansor);
        this.tvambari = (TextView) findViewById(R.id.ambari);
        this.tvtel = (TextView) findViewById(R.id.txtTel);
        this.tvmobile = (TextView) findViewById(R.id.txtMobile);
        this.tvaddress = (TextView) findViewById(R.id.txtAddress);
        this.txtDate = (TextView) findViewById(R.id.txtDate);
        this.image = (ImageView) findViewById(R.id.image);
        Bundle bundle = getIntent().getExtras();
        this.id = bundle.getInt(FileHa.KEY_ID);
        this.typeList = bundle.getString("type");
        File_Methods file_methods = new File_Methods(this);
        file_methods.open();
        if (this.typeList.equals("Search")) {//////////////////////////////////////////////////////////
            List<FileHa> fileSearch = file_methods.getSearchFiles(
                    kind, int_age, room,
                    S_et_name,
                    min_tprice_rentBaha, max_tprice_rentBaha,
                    min_mprice_ejareBaha, max_mprice_ejareBaha, S_et_street,
                    meter_MaX, meter_MiN
            );
            this.kindPrice = ((FileHa) fileSearch.get(this.id)).getKIND();
            this.price = ((FileHa) fileSearch.get(this.id)).getPRICE_Total();
            this.floor = ((FileHa) fileSearch.get(this.id)).getTABAGHE();
            this.room = ((FileHa) fileSearch.get(this.id)).getROOM();
            this.meter = ((FileHa) fileSearch.get(this.id)).getMETREZ();
            this.malek = ((FileHa) fileSearch.get(this.id)).getMALEK();
            this.parking = ((FileHa) fileSearch.get(this.id)).getPARKING();
            this.asansor = ((FileHa) fileSearch.get(this.id)).getASANSOR();
            this.ambari = ((FileHa) fileSearch.get(this.id)).getAMBARI();
            this.street = ((FileHa) fileSearch.get(this.id)).getSTREET();
            this.balkon = ((FileHa) fileSearch.get(this.id)).getBALKON();
            this.Smobile = ((FileHa) fileSearch.get(this.id)).getMOBILE();
            this.tel = ((FileHa) fileSearch.get(this.id)).getTel();
            this.ad = ((FileHa) fileSearch.get(this.id)).getADDREES();
            StringBuilder sb = new StringBuilder();
            sb.append(((FileHa) fileSearch.get(this.id)).getMALEK());
            sb.append("\n");
            sb.append(((FileHa) fileSearch.get(this.id)).getKIND());
            this.malek_kind = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("قیمت متری:");
            sb2.append(((FileHa) fileSearch.get(this.id)).getPRICEMETER());
            sb2.append("\n");
            this.x = sb2.toString();
            if (this.kindPrice.equals("اجاره")) {
                TextView textView = this.tvprice;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("رهن: ");
                sb3.append(String.valueOf(this.price));
                sb3.append("\n اجاره: ");
                sb3.append(String.valueOf(this.EJARE_BAHA));
                textView.setText(sb3.toString());
                this.x = "";
            } else {
                TextView textView2 = this.tvprice;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(" قیمت کل: ");
                sb4.append(String.valueOf(this.price));
                textView2.setText(sb4.toString());
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("تاریخ ثبت:");
            sb5.append(((FileHa) fileSearch.get(this.id)).getDATE_TIME());
            sb5.append("\n جهت واحد:");
            sb5.append(((FileHa) fileSearch.get(this.id)).getDIRECTION());
            sb5.append("\n موقعیت ملک:");
            sb5.append(((FileHa) fileSearch.get(this.id)).getLOCATION());
            sb5.append("\n سن ساختمان:");
            sb5.append(((FileHa) fileSearch.get(this.id)).getSALEAKHT());
            sb5.append("\n تعداد کل طبقات: ");
            sb5.append(((FileHa) fileSearch.get(this.id)).getNUBER_TOTAL_FLOOR());
            sb5.append("\n تعداد کل واحدها: ");
            sb5.append(((FileHa) fileSearch.get(this.id)).getNUMBER_Totol_vahed());
            sb5.append("\n خیابان یا محله: ");
            sb5.append(((FileHa) fileSearch.get(this.id)).getSTREET());
            sb5.append("\n توضیحات بیشتر: ");
            sb5.append(((FileHa) fileSearch.get(this.id)).getEXTERA());
            sb5.append(((FileHa) fileSearch.get(this.id)).getBALKON());
            sb5.append("\n");
            sb5.append(this.floor);
            sb5.append("\n");
            sb5.append(this.x);
            this.dis = sb5.toString();
        }///////////////////////////////////////////////////////////////////////////////////////////
        if (this.typeList.equals("All")) {
            List<FileHa> fileHas = file_methods.getAllFiles();
            this.kindPrice = ((FileHa) fileHas.get(this.id)).getKIND();
            this.floor = ((FileHa) fileHas.get(this.id)).getTABAGHE();
            this.price = ((FileHa) fileHas.get(this.id)).getPRICE_Total();
            this.room = ((FileHa) fileHas.get(this.id)).getROOM();
            this.meter = ((FileHa) fileHas.get(this.id)).getMETREZ();
            this.malek = ((FileHa) fileHas.get(this.id)).getMALEK();
            this.parking = ((FileHa) fileHas.get(this.id)).getPARKING();
            this.asansor = ((FileHa) fileHas.get(this.id)).getASANSOR();
            this.ambari = ((FileHa) fileHas.get(this.id)).getAMBARI();
            this.street = ((FileHa) fileHas.get(this.id)).getSTREET();
            this.balkon = ((FileHa) fileHas.get(this.id)).getBALKON();
            this.Smobile = ((FileHa) fileHas.get(this.id)).getMOBILE();
            this.tel = ((FileHa) fileHas.get(this.id)).getTel();
            this.ad = ((FileHa) fileHas.get(this.id)).getADDREES();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(((FileHa) fileHas.get(this.id)).getMALEK());
            sb6.append("\n");
            sb6.append(((FileHa) fileHas.get(this.id)).getKIND());
            this.malek_kind = sb6.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append("قیمت متری:");
            sb7.append(((FileHa) fileHas.get(this.id)).getPRICEMETER());
            sb7.append("\n");
            this.x = sb7.toString();
            if (this.kindPrice.equals("اجاره")) {
                TextView textView3 = this.tvprice;
                StringBuilder sb8 = new StringBuilder();
                sb8.append(" رهن: ");
                sb8.append(String.valueOf(this.price));
                sb8.append("\n اجاره: ");
                sb8.append(String.valueOf(this.EJARE_BAHA));
                textView3.setText(sb8.toString());
                this.x = "";
            } else {
                TextView textView4 = this.tvprice;
                StringBuilder sb9 = new StringBuilder();
                sb9.append("قیمت کل: ");
                sb9.append(String.valueOf(this.price));
                textView4.setText(sb9.toString());
            }
            StringBuilder sb10 = new StringBuilder();
            sb10.append("تاریخ ثبت:");
            sb10.append(((FileHa) fileHas.get(this.id)).getDATE_TIME());
            sb10.append("\n جهت واحد:");
            sb10.append(((FileHa) fileHas.get(this.id)).getDIRECTION());
            sb10.append("\n موقعیت ملک:");
            sb10.append(((FileHa) fileHas.get(this.id)).getLOCATION());
            sb10.append("\n سن ساختمان:");
            sb10.append(((FileHa) fileHas.get(this.id)).getSALEAKHT());
            sb10.append("\n تعداد کل طبقات: ");
            sb10.append(((FileHa) fileHas.get(this.id)).getNUBER_TOTAL_FLOOR());
            sb10.append("\n تعداد کل واحدها: ");
            sb10.append(((FileHa) fileHas.get(this.id)).getNUMBER_Totol_vahed());
            sb10.append("\n محله یا خیابان: ");
            sb10.append(((FileHa) fileHas.get(this.id)).getSTREET());
            sb10.append("\n توضیحات: ");
            sb10.append(((FileHa) fileHas.get(this.id)).getEXTERA());
            sb10.append(((FileHa) fileHas.get(this.id)).getBALKON());
            sb10.append("\nطبقه واحد:");
            sb10.append(this.floor);
            sb10.append("\n");
            sb10.append(this.x);
            this.dis = sb10.toString();
        }///////////////////////////////////////////////////////////////////////////////
        if (this.typeList.equals("Frosh")) {
            List<FileHa> fileFrosh = file_methods.getSellFiles();
            this.price = ((FileHa) fileFrosh.get(this.id)).getPRICE_Total();
            this.floor = ((FileHa) fileFrosh.get(this.id)).getTABAGHE();
            this.room = ((FileHa) fileFrosh.get(this.id)).getROOM();
            this.meter = ((FileHa) fileFrosh.get(this.id)).getMETREZ();
            this.malek = ((FileHa) fileFrosh.get(this.id)).getMALEK();
            this.parking = ((FileHa) fileFrosh.get(this.id)).getPARKING();
            this.asansor = ((FileHa) fileFrosh.get(this.id)).getASANSOR();
            this.ambari = ((FileHa) fileFrosh.get(this.id)).getAMBARI();
            this.street = ((FileHa) fileFrosh.get(this.id)).getSTREET();
            this.balkon = ((FileHa) fileFrosh.get(this.id)).getBALKON();
            this.Smobile = ((FileHa) fileFrosh.get(this.id)).getMOBILE();
            this.tel = ((FileHa) fileFrosh.get(this.id)).getTel();
            this.ad = ((FileHa) fileFrosh.get(this.id)).getADDREES();
            StringBuilder sb11 = new StringBuilder();
            sb11.append(((FileHa) fileFrosh.get(this.id)).getMALEK());
            sb11.append("\n");
            sb11.append(((FileHa) fileFrosh.get(this.id)).getKIND());
            this.malek_kind = sb11.toString();
            StringBuilder sb12 = new StringBuilder();
            sb12.append("تاریخ ثبت:");
            sb12.append(((FileHa) fileFrosh.get(this.id)).getDATE_TIME());
            sb12.append("\nقیمت هر متر:");
            sb12.append(((FileHa) fileFrosh.get(this.id)).getPRICEMETER());
            sb12.append("\nجهت واحد:");
            sb12.append(((FileHa) fileFrosh.get(this.id)).getDIRECTION());
            sb12.append("\nموقعیت ملک:");
            sb12.append(((FileHa) fileFrosh.get(this.id)).getLOCATION());
            sb12.append("\nسن ساختمان:");
            sb12.append(((FileHa) fileFrosh.get(this.id)).getSALEAKHT());
            sb12.append("\n تعداد کل طبقات: ");
            sb12.append(((FileHa) fileFrosh.get(this.id)).getNUBER_TOTAL_FLOOR());
            sb12.append("\n تعداد کل واحد: ");
            sb12.append(((FileHa) fileFrosh.get(this.id)).getNUMBER_Totol_vahed());
            sb12.append("\n محله یا خیابان: ");
            sb12.append(((FileHa) fileFrosh.get(this.id)).getSTREET());
            sb12.append("\n توضیحات بیشتر: ");
            sb12.append(((FileHa) fileFrosh.get(this.id)).getEXTERA());
            sb12.append(((FileHa) fileFrosh.get(this.id)).getBALKON());
            sb12.append("\nطبقه واحد:");
            sb12.append(this.floor);
            sb12.append("\n");
            this.dis = sb12.toString();
            TextView textView5 = this.tvprice;
            StringBuilder sb13 = new StringBuilder();
            sb13.append("قیمت کل: ");
            sb13.append(String.valueOf(this.price));
            textView5.setText(sb13.toString());
        }////////////////////////////////////////////////////////////////////////////
        if (this.typeList.equals("Pish")) {
            List<FileHa> filePish = file_methods.getPishFiles();
            this.price = ((FileHa) filePish.get(this.id)).getPRICE_Total();
            this.floor = ((FileHa) filePish.get(this.id)).getTABAGHE();
            this.room = ((FileHa) filePish.get(this.id)).getROOM();
            this.meter = ((FileHa) filePish.get(this.id)).getMETREZ();
            this.malek = ((FileHa) filePish.get(this.id)).getMALEK();
            this.parking = ((FileHa) filePish.get(this.id)).getPARKING();
            this.asansor = ((FileHa) filePish.get(this.id)).getASANSOR();
            this.ambari = ((FileHa) filePish.get(this.id)).getAMBARI();
            this.street = ((FileHa) filePish.get(this.id)).getSTREET();
            this.balkon = ((FileHa) filePish.get(this.id)).getBALKON();
            this.Smobile = ((FileHa) filePish.get(this.id)).getMOBILE();
            this.tel = ((FileHa) filePish.get(this.id)).getTel();
            this.ad = ((FileHa) filePish.get(this.id)).getADDREES();
            StringBuilder sb14 = new StringBuilder();
            sb14.append(((FileHa) filePish.get(this.id)).getMALEK());
            sb14.append("\n");
            sb14.append(((FileHa) filePish.get(this.id)).getKIND());
            this.malek_kind = sb14.toString();
            StringBuilder sb15 = new StringBuilder();
            sb15.append("تاریخ ثبت:");
            sb15.append(((FileHa) filePish.get(this.id)).getDATE_TIME());
            sb15.append("\nقیمت هر متر:");
            sb15.append(((FileHa) filePish.get(this.id)).getPRICEMETER());
            sb15.append("\n جهت واحد:");
            sb15.append(((FileHa) filePish.get(this.id)).getDIRECTION());
            sb15.append("\n موقعیت ملک:");
            sb15.append(((FileHa) filePish.get(this.id)).getLOCATION());
            sb15.append("\n سن ساختمان:");
            sb15.append(((FileHa) filePish.get(this.id)).getSALEAKHT());
            sb15.append("\n تعدادکل طبقات: ");
            sb15.append(((FileHa) filePish.get(this.id)).getNUBER_TOTAL_FLOOR());
            sb15.append("\n تعدادکل واحدها: ");
            sb15.append(((FileHa) filePish.get(this.id)).getNUMBER_Totol_vahed());
            sb15.append("\n محله یا خیابان: ");
            sb15.append(((FileHa) filePish.get(this.id)).getSTREET());
            sb15.append("\nتوضیحات بیشتر: ");
            sb15.append(((FileHa) filePish.get(this.id)).getEXTERA());
            sb15.append(((FileHa) filePish.get(this.id)).getBALKON());
            sb15.append("\nشماره واحد:");
            sb15.append(this.floor);
            sb15.append("\n");
            this.dis = sb15.toString();
            TextView textView6 = this.tvprice;
            StringBuilder sb16 = new StringBuilder();
            sb16.append("قیمت کل:");
            sb16.append(String.valueOf(this.price));
            textView6.setText(sb16.toString());
        }///////////////////////////////////////////////////////////////////////////////////
        if (this.typeList.equals("Rent")) {
            List<FileHa> fileRent = file_methods.getRentFiles();
            this.kindPrice = ((FileHa) fileRent.get(this.id)).getKIND();
            this.floor = ((FileHa) fileRent.get(this.id)).getTABAGHE();
            this.price = ((FileHa) fileRent.get(this.id)).getPRICE_Total();
            this.EJARE_BAHA = ((FileHa) fileRent.get(this.id)).getEJARE_BAHA();
            this.room = ((FileHa) fileRent.get(this.id)).getROOM();
            this.meter = ((FileHa) fileRent.get(this.id)).getMETREZ();
            this.malek = ((FileHa) fileRent.get(this.id)).getMALEK();
            this.parking = ((FileHa) fileRent.get(this.id)).getPARKING();
            this.asansor = ((FileHa) fileRent.get(this.id)).getASANSOR();
            this.ambari = ((FileHa) fileRent.get(this.id)).getAMBARI();
            this.street = ((FileHa) fileRent.get(this.id)).getSTREET();
            this.balkon = ((FileHa) fileRent.get(this.id)).getBALKON();
            this.Smobile = ((FileHa) fileRent.get(this.id)).getMOBILE();
            this.tel = ((FileHa) fileRent.get(this.id)).getTel();
            this.ad = ((FileHa) fileRent.get(this.id)).getADDREES();
            StringBuilder sb17 = new StringBuilder();
            sb17.append(((FileHa) fileRent.get(this.id)).getMALEK());
            sb17.append("\n");
            sb17.append(((FileHa) fileRent.get(this.id)).getKIND());
            this.malek_kind = sb17.toString();
            StringBuilder sb18 = new StringBuilder();
            sb18.append("تاریخ ثبت:");
            sb18.append(((FileHa) fileRent.get(this.id)).getDATE_TIME());
            sb18.append("\n جهت واحد:");
            sb18.append(((FileHa) fileRent.get(this.id)).getDIRECTION());
            sb18.append("\n موقعیت ملک:");
            sb18.append(((FileHa) fileRent.get(this.id)).getLOCATION());
            sb18.append("\n سن ساختمان:");
            sb18.append(((FileHa) fileRent.get(this.id)).getSALEAKHT());
            sb18.append("\n تعداد کل واحدها: ");
            sb18.append(((FileHa) fileRent.get(this.id)).getNUBER_TOTAL_FLOOR());
            sb18.append("\n تعداد کل طبقات: ");
            sb18.append(((FileHa) fileRent.get(this.id)).getNUMBER_Totol_vahed());
            sb18.append("\n محله یا خیابان: ");
            sb18.append(((FileHa) fileRent.get(this.id)).getSTREET());
            sb18.append("\n توضیحات: ");
            sb18.append(((FileHa) fileRent.get(this.id)).getEXTERA());
            sb18.append(((FileHa) fileRent.get(this.id)).getBALKON());
            sb18.append("\nشماره واحد:");
            sb18.append(this.floor);
            sb18.append("\n");
            this.dis = sb18.toString();
            TextView textView7 = this.tvprice;
            StringBuilder sb19 = new StringBuilder();
            sb19.append(" رهن: ");
            sb19.append(String.valueOf(this.price));
            sb19.append("\n اجاره: ");
            sb19.append(String.valueOf(this.EJARE_BAHA));
            textView7.setText(sb19.toString());
        }//////////////////////////////////////////////////////////////////////////////////////////
        TextView textView8 = this.tvmeter;
        StringBuilder sb20 = new StringBuilder();
        sb20.append(" متراژ: ");
        sb20.append(String.valueOf(this.meter));
        textView8.setText(sb20.toString());
        TextView textView9 = this.tvroom;
        StringBuilder sb21 = new StringBuilder();
        sb21.append("تعداد خواب: ");
        sb21.append(String.valueOf(this.room));
        textView9.setText(sb21.toString());
        this.tvparking.setText(this.parking);
        this.tvasansor.setText(this.asansor);
        this.tvambari.setText(this.ambari);
        TextView textView10 = this.tvmobile;
        StringBuilder sb22 = new StringBuilder();
        sb22.append("موبایل: ");
        sb22.append(this.Smobile);
        textView10.setText(sb22.toString());
        TextView textView11 = this.tvtel;
        StringBuilder sb23 = new StringBuilder();
        sb23.append("تلفن: ");
        sb23.append(this.tel);
        textView11.setText(sb23.toString());
        this.tvaddress.setText(this.ad);
        this.tvdisc.setText(this.dis);
        this.txtDate.setText(this.malek_kind);
        this.btnCall.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent callIntent = new Intent("android.intent.action.CALL");
                StringBuilder sb = new StringBuilder();
                sb.append("tel:");
                sb.append(File_Show_Activity.this.tel);
                callIntent.setData(Uri.parse(sb.toString()));
                File_Show_Activity.this.startActivity(callIntent);
            }
        });
        this.btnCallMobile.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent callIntent = new Intent("android.intent.action.CALL");
                StringBuilder sb = new StringBuilder();
                sb.append("tel:");
                sb.append(File_Show_Activity.this.Smobile);
                callIntent.setData(Uri.parse(sb.toString()));
                File_Show_Activity.this.startActivity(callIntent);
            }
        });
        fab();
    }

    private void fab() {
        final File_Methods file_methods = new File_Methods(this);
        final List<FileHa> fileHas = file_methods.getAllFiles();
        this.parent_vieA = findViewById(R.id.coordinator_lyt);
        final FloatingActionButton fab_takepic = (FloatingActionButton) findViewById(R.id.fab_takepic);
        FloatingActionButton fab_send = (FloatingActionButton) findViewById(R.id.fab_send);
        FloatingActionButton fab_delete = (FloatingActionButton) findViewById(R.id.fab_delete);
        FloatingActionButton fab_edit = (FloatingActionButton) findViewById(R.id.fab_edit);
        ViewAnimation.initShowOut(fab_takepic);
        ViewAnimation.initShowOut(fab_send);
        ViewAnimation.initShowOut(fab_delete);
        ViewAnimation.initShowOut(fab_edit);
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_addOn);
        final FloatingActionButton floatingActionButton2 = fab_takepic;
        final FloatingActionButton floatingActionButton3 = fab_send;
        final FloatingActionButton floatingActionButton4 = fab_delete;
        final FloatingActionButton floatingActionButton5 = fab_edit;
       floatingActionButton . setOnClickListener(new OnClickListener() {
        // AnonymousClass3 r3 = new OnClickListener() {
            public void onClick(View v) {
                File_Show_Activity file_Show_Activity = File_Show_Activity.this;
                file_Show_Activity.rotate = ViewAnimation.rotateFab(v, !file_Show_Activity.rotate);
                if (File_Show_Activity.this.rotate) {
                    ViewAnimation.showIn(floatingActionButton2);
                    ViewAnimation.showIn(floatingActionButton3);
                    ViewAnimation.showIn(floatingActionButton4);
                    ViewAnimation.showIn(floatingActionButton5);
                    return;
                }
                ViewAnimation.showOut(floatingActionButton2);
                ViewAnimation.showOut(floatingActionButton3);
                ViewAnimation.showOut(floatingActionButton4);
                ViewAnimation.showOut(floatingActionButton5);
            }
        });

        fab_takepic.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(File_Show_Activity.this, fab_takepic);
               // popup.getMenuInflater().inflate(R.menu.menu_image, popup.getMenu());
                popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().equals("Ú¯Ø§Ù„Ø±ÛŒ")) {
                            Intent photoPickerIntent = new Intent("android.intent.action.PICK");
                            photoPickerIntent.setType("image/*");
                            File_Show_Activity.this.startActivityForResult(photoPickerIntent, 10);
                        } else if (item.getTitle().equals("Ø¯ÙˆØ±Ø¨ÛŒÙ†")) {
                            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                            if (intent.resolveActivity(File_Show_Activity.this.getPackageManager()) != null) {
                                File_Show_Activity.this.startActivityForResult(intent, 20);
                            }
                        }
                        return true;
                    }
                });
                popup.show();
            }
        });
        fab_send.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                StringBuilder sb = new StringBuilder();
                sb.append("Ù‚ÛŒÙ…Øª:");
                sb.append(File_Show_Activity.this.price);
                sb.append("\nÙ…ØªØ±Ø§Ú˜:");
                sb.append(File_Show_Activity.this.meter);
                sb.append("\nØªØ¹Ø¯Ø§Ø¯ Ø®ÙˆØ§Ø¨:");
                sb.append(File_Show_Activity.this.room);
                sb.append("\nÙ¾Ø§Ø±Ú©ÛŒÙ†Ú¯:");
                sb.append(File_Show_Activity.this.parking);
                sb.append("\nØ§Ù†Ø¨Ø§Ø±ÛŒ:");
                sb.append(File_Show_Activity.this.ambari);
                sb.append("\nØ¨Ø§Ù„Ú©Ù†:");
                sb.append(File_Show_Activity.this.balkon);
                sb.append("\nÙ…Ø­Ù„Ù‡:");
                sb.append(File_Show_Activity.this.street);
                sb.append("\n");
                intent.putExtra("android.intent.extra.TEXT", sb.toString());
                intent.setType("text/plain");
                File_Show_Activity.this.startActivity(intent);
            }
        });
        fab_edit.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(File_Show_Activity.this, EditActivity.class);
                intent.putExtra(FileHa.KEY_ID, File_Show_Activity.this.id);
                File_Show_Activity.this.startActivity(intent);
            }
        });
        fab_delete.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                file_methods.deletFile(((FileHa) fileHas.get(File_Show_Activity.this.id)).getID());
                Intent intent = new Intent(File_Show_Activity.this, RecyclerViewActivity.class);
                intent.putExtra(FileHa.KEY_SHOMINE, "All");
                File_Show_Activity.this.startActivity(intent);
                Toast.makeText(File_Show_Activity.this.getApplicationContext(), "ÙØ§ÛŒÙ„ Ù…ÙˆØ±Ø¯ Ù†Ø¸Ø± Ø­Ø°Ù Ø´Ø¯", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 10) {
            if (resultCode == -1) {
                try {
                    Uri imageUri = data.getData();
                    InputStream openInputStream = getContentResolver().openInputStream(imageUri);
                    Bitmap selectedImage = Media.getBitmap(getContentResolver(), imageUri);
                    setProgressBar();
                    this.image.setImageBitmap(selectedImage);
                    checkFile();
                    MakeFolder();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (requestCode == 20 && resultCode == -1) {
            onCaptureImageResult(data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void onCaptureImageResult(Intent data) {
        this.thumbnail = (Bitmap) data.getExtras().get("data");
        setProgressBar();
        this.image.setMaxHeight(Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        this.image.setMaxWidth(Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        this.image.setImageBitmap(this.thumbnail);
    }

    private void checkFile() {
        String fileName = "1.jpg";
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getPath());
        sb.append("Ø¯ÙØªØ± ÙØ§ÛŒÙ„");
        String baseDir = sb.toString();
        String pathDir = baseDir;
        if (new File(getFilename()).exists()) {
            Toast.makeText(getApplicationContext(), "File Vojud Darad", Toast.LENGTH_SHORT).show();
            this.num = 1;
            getFilename();
            checkFile();
            if (this.num >= 6) {
                this.cFile = 1;
            }
            Context applicationContext = getApplicationContext();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("num: ");
            sb2.append(this.num);
            Toast.makeText(applicationContext, sb2.toString(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "File Vojud Nadarad", Toast.LENGTH_SHORT).show();
            save();
        }
        TextView textView = this.tvtel;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(fileName);
        sb3.append(baseDir);
        sb3.append(pathDir);
        textView.setText(sb3.toString());
    }

    private void save() {
        Bitmap bitmap = ((BitmapDrawable) this.image.getDrawable()).getBitmap();
        if (this.cFile == 0) {
            try {
                bitmap.compress(CompressFormat.PNG, 100, new FileOutputStream(getFilename()));
                Toast.makeText(getApplicationContext(), " image saved ", Toast.LENGTH_LONG).show();
            } catch (FileNotFoundException e) {
                Toast.makeText(getApplicationContext(), " image saving fail ", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
        if (this.cFile == 1) {
            Toast.makeText(getApplicationContext(), " image saving fail ", Toast.LENGTH_LONG).show();
        }
    }

    private String getFilename() {
        String path = Environment.getExternalStorageDirectory().getPath();
        StringBuilder sb = new StringBuilder();
        sb.append("Ø¯ÙØªØ± ÙØ§ÛŒÙ„/ ");
        sb.append(this.malek);
        sb.append(" ");
        sb.append(this.meter);
        File file = new File(path, sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.getAbsolutePath());
        sb2.append("/");
        sb2.append(this.num);
        sb2.append(".jpg");
        return sb2.toString();
    }

    private void MakeFolder() {
        File root = Environment.getExternalStorageDirectory();
        StringBuilder sb = new StringBuilder();
        sb.append(root.getAbsolutePath());
        sb.append("/Ø¯ÙØªØ± ÙØ§ÛŒÙ„");
        File dir = new File(sb.toString());
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public void setProgressBar() {
        this.progressBar = new ProgressDialog(this);
        this.progressBar.setCancelable(true);
        this.progressBar.setMessage("Please wait...");
        this.progressBar.setProgressStyle(0);
        this.progressBar.setProgress(0);
        this.progressBar.setMax(100);
        this.progressBar.show();
        this.progressBarStatus = 0;
        new Thread(new Runnable() {
            public void run() {
                while (File_Show_Activity.this.progressBarStatus < 100) {
                    File_Show_Activity file_Show_Activity = File_Show_Activity.this;
                    file_Show_Activity.progressBarStatus = file_Show_Activity.progressBarStatus + 30;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    File_Show_Activity.this.progressBarbHandler.post(new Runnable() {
                        public void run() {
                            File_Show_Activity.this.progressBar.setProgress(File_Show_Activity.this.progressBarStatus);
                        }
                    });
                }
                if (File_Show_Activity.this.progressBarStatus >= 100) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    File_Show_Activity.this.progressBar.dismiss();
                }
            }
        }).start();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0 && grantResults.length > 0 && grantResults[0] == 0 && grantResults[1] == 0) {
            this.image.setEnabled(true);
        }
    }

    private void initComponent() {
        int[] iArr;
        this.layout_dots = (LinearLayout) findViewById(R.id.layout_dots);
        this.viewPager = (ViewPager) findViewById(R.id.pager);
        this.adapterImageSlider = new AdapterImageSlider(this, new ArrayList());
        List<Image> items = new ArrayList<>();
        for (int i : array_image_product) {
            Image obj = new Image();
            obj.image = i;
            obj.imageDrw = getResources().getDrawable(obj.image);
            items.add(obj);
        }
        this.adapterImageSlider.setItems(items);
        this.viewPager.setAdapter(this.adapterImageSlider);
        this.viewPager.setCurrentItem(0);
        addBottomDots(this.layout_dots, this.adapterImageSlider.getCount(), 0);
        this.viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrolled(int pos, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int pos) {
                File_Show_Activity file_Show_Activity = File_Show_Activity.this;
                file_Show_Activity.addBottomDots(file_Show_Activity.layout_dots, File_Show_Activity.this.adapterImageSlider.getCount(), pos);
            }

            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void addBottomDots(LinearLayout layout_dots2, int size, int current) {
        ImageView[] dots = new ImageView[size];
        layout_dots2.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            LayoutParams params = new LayoutParams(new ViewGroup.LayoutParams(15, 15));
            params.setMargins(10, 10, 10, 10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle);
            dots[i].setColorFilter(ContextCompat.getColor(this, R.color.overlay_dark_10), Mode.SRC_ATOP);
            layout_dots2.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[current].setColorFilter(ContextCompat.getColor(this, R.color.colorPrimaryLight), Mode.SRC_ATOP);
        }
    }
}

