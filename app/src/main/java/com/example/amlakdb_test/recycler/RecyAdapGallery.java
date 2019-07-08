package com.example.amlakdb_test.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import com.example.amlakdb_test.model.da.File_Methods;
import java.util.ArrayList;

public class RecyAdapGallery extends Adapter {
    private Context context;
    private ArrayList<File_Methods> dbList;

    public RecyAdapGallery(Context context2, ArrayList<File_Methods> dbList2) {
        this.context = context2;
        this.dbList = dbList2;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
    }

    public int getItemCount() {
        return 0;
    }
}

