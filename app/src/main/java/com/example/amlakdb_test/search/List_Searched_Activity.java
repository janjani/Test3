package com.example.amlakdb_test.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;
import com.example.amlakdb_test.model.da.File_Methods;
import com.example.amlakdb_test.recycler.RecyAdapSearch;
import com.example.amlakdb_test.utils.SpacingItemDecoration;
import com.example.amlakdb_test.utils.Tools;
import com.example.amlakdb_test.R;
import java.util.ArrayList;

public class List_Searched_Activity extends AppCompatActivity {
    public RecyclerView RecyVieSearch;
    File_Methods file_methods;
    private ArrayList<File_Methods> getSearchFiles;
    TextView textView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_list__searched);
        this.textView = (TextView) findViewById(R.id.textView11);
        File_Methods file_Methods = this.file_methods;
        if (File_Methods.text != null) {
            this.textView.setText(" هیچ موردی پیدا نشد ! ");
        }
        this.RecyVieSearch = (RecyclerView) findViewById(R.id.RecyVieSearch);
        new LinearLayoutManager(this, 1, false);
        new StaggeredGridLayoutManager(2, 1);
        RecyAdapSearch adapter = new RecyAdapSearch(this, this.getSearchFiles);
        this.RecyVieSearch.setLayoutManager(new GridLayoutManager(this, 2));
        this.RecyVieSearch.addItemDecoration(new SpacingItemDecoration(2, Tools.dpToPx(this, 8), true));
        this.RecyVieSearch.setHasFixedSize(true);
        this.RecyVieSearch.setAdapter(adapter);
        this.RecyVieSearch.setItemAnimator(new DefaultItemAnimator());
    }
}
