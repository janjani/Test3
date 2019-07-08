package com.example.amlakdb_test.recycler;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.PopupMenu.OnMenuItemClickListener;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.amlakdb_test.Edit.EditActivity;
import com.example.amlakdb_test.fileShow.File_Show_Activity;
import com.example.amlakdb_test.model.da.File_Methods;
import com.example.amlakdb_test.model.to.FileHa;
import com.example.amlakdb_test.R;
import java.util.ArrayList;
import java.util.List;

public class RecyAdapPish extends Adapter<RecyAdapPish.MyViewHolder> {
    /* access modifiers changed from: private */
    public Context context;
    private ArrayList<File_Methods> dbList;
    int id;
    int idView;

    class MyViewHolder extends ViewHolder {
        ImageButton item_Menu;
        LinearLayout layoutClick;
        TextView price;
        TextView txtDisc;
        TextView txtmeter;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.item_Menu = (ImageButton) itemView.findViewById(R.id.menu_item1);
            this.price = (TextView) itemView.findViewById(R.id.txtPrice1);
            this.txtmeter = (TextView) itemView.findViewById(R.id.txtmeter1);
            this.layoutClick = (LinearLayout) itemView.findViewById(R.id.layoutClick1);
        }
    }

    public RecyAdapPish(Context context2, ArrayList<File_Methods> dbList2) {
        this.context = context2;
        this.dbList = dbList2;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.item_all_big, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final File_Methods fileDa = new File_Methods(this.context);
        List<FileHa> fileHas = fileDa.getPishFiles();
        this.id = ((FileHa) fileHas.get(position)).getID();
        TextView textView = holder.price;
        StringBuilder sb = new StringBuilder();
        sb.append(((FileHa) fileHas.get(position)).getMALEK());
        sb.append("\nمتراژ:");
        sb.append(((FileHa) fileHas.get(position)).getMETREZ());
        sb.append("\nقیمت:");
        sb.append(((FileHa) fileHas.get(position)).getPRICE_Total());
        textView.setText(sb.toString());
        TextView textView2 = holder.txtmeter;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((FileHa) fileHas.get(position)).getKIND());
        sb2.append("\n");
        textView2.setText(sb2.toString());
        holder.layoutClick.setId(position);
        holder.layoutClick.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                RecyAdapPish.this.idView = v.getId();
                Intent intent = new Intent(RecyAdapPish.this.context, File_Show_Activity.class);
                intent.putExtra(FileHa.KEY_ID, RecyAdapPish.this.idView);
                intent.putExtra("type", "Pish");
                RecyAdapPish.this.context.startActivity(intent);
            }
        });
        ImageButton imageButton = holder.item_Menu;
        final MyViewHolder myViewHolder = holder;
        final List list = fileHas;
        final int i = position;
        holder.item_Menu . setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(RecyAdapPish.this.context, myViewHolder.item_Menu);
                popup.inflate(R.menu.menu_item);
                popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.delete_item_menu /*2131296366*/:
                                fileDa.deletFile(((FileHa) list.get(i)).getID());
                                list.remove(i);
                                RecyAdapPish.this.notifyItemRemoved(i);
                                RecyAdapPish.this.notifyItemRangeChanged(i, list.size());
                                return true;
                            case R.id.edit_itm_menu /*2131296378*/:
                                Intent intent = new Intent(RecyAdapPish.this.context, EditActivity.class);
                                intent.putExtra(FileHa.KEY_ID, RecyAdapPish.this.idView);
                                RecyAdapPish.this.context.startActivity(intent);
                                return true;
                            case R.id.plane_itm_menu /*2131296503*/:
                                Toast.makeText(RecyAdapPish.this.context, "plane_itm_menu", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.share_itm_menu /*2131296539*/:
                                Intent i = new Intent();
                                i.setAction("android.intent.action.SEND");
                                i.putExtra("android.intent.extra.TEXT", "Ø¯ÙØªØ± ÙØ§ÛŒÙ„");
                                i.setType("text/plain");
                                RecyAdapPish.this.context.startActivity(i);
                                return true;
                            case R.id.takepic_itm_menu /*2131296567*/:
                                Toast.makeText(RecyAdapPish.this.context, "takepic_itm_menu", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.telegran_itm_menu /*2131296569*/:
                                Toast.makeText(RecyAdapPish.this.context, "telegran_itm_menu", Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popup.show();
            }
        });
    }

    public int getItemCount() {
        return new File_Methods(this.context).getPishFiles().size();
    }
}


