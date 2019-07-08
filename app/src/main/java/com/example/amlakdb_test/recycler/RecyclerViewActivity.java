package com.example.amlakdb_test.recycler;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;
import com.example.amlakdb_test.AllActivity;
import com.example.amlakdb_test.model.da.File_Methods;
import com.example.amlakdb_test.model.to.FileHa;
import com.example.amlakdb_test.R;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private ArrayList<File_Methods> dblist;
    List<FileHa> fileDas = new ArrayList();
    String kindSshow;
    public RecyclerView recyclerView;
    TextView txtEmptyFile;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_recycler_view);
        this.kindSshow = getIntent().getExtras().getString(FileHa.KEY_SHOMINE);
        this.recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        new LinearLayoutManager(this, 1, false);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, 1);
        if (this.kindSshow.matches("All")) {
            RecyAdapAll adapter = new RecyAdapAll(this, this.dblist);
            this.recyclerView.setLayoutManager(sglm);
            this.recyclerView.setAdapter(adapter);
            this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
        if (this.kindSshow.matches("Sell")) {
            RecyAdapFrosh adapter1 = new RecyAdapFrosh(this, this.dblist);
            this.recyclerView.setLayoutManager(sglm);
            this.recyclerView.setAdapter(adapter1);
            this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
        if (this.kindSshow.matches("Rent")) {
            RecyAdapRent adapter12 = new RecyAdapRent(this, this.dblist);
            this.recyclerView.setLayoutManager(sglm);
            this.recyclerView.setAdapter(adapter12);
            this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
        if (this.kindSshow.matches("Pish")) {
            RecyAdapPish adapter13 = new RecyAdapPish(this, this.dblist);
            this.recyclerView.setLayoutManager(sglm);
            this.recyclerView.setAdapter(adapter13);
            this.recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
    }

    public void onBackPressed() {
        startActivity(new Intent(this, AllActivity.class));
        super.onBackPressed();
    }
}

