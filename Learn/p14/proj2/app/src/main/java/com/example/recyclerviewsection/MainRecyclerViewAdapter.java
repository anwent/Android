package com.example.recyclerviewsection;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.acl.Group;
import java.util.ArrayList;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.MainItemViewHolder> {

    private ArrayList<MainActivity.Item> ds;

    private Context mCtx;

    public MainRecyclerViewAdapter(Context ctx, ArrayList<MainActivity.Item> data) {
        this.mCtx = ctx;
        this.ds = data;
    }

//    public void setDataSource(ArrayList<MainActivity.Item> datasource) {
//        this.ds = datasource;
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public MainItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MainItemViewHolder viewHolder = null;
        switch (viewType) {
            case MainActivity.TYPE_GROUP:
                View section = LayoutInflater
                        .from(mCtx)
                        .inflate(R.layout.layout_main_recyclerview_section, parent, false);
                viewHolder = new GroupViewHolder(section);
                break;

            case MainActivity.TYPE_CHILD:
                View cell = LayoutInflater
                        .from(mCtx)
                        .inflate(R.layout.layout_main_recyclerview_cell, parent, false);
                viewHolder = new ChildViewHolder(cell);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainItemViewHolder holder, int position) {
        if (ds == null) {
            return;
        }
        MainActivity.Item item = ds.get(position);
        switch (getItemViewType(position)) {
            case MainActivity.TYPE_GROUP:
                MainActivity.Group g = (MainActivity.Group) ds.get(position);
                GroupViewHolder gvh = (GroupViewHolder) holder;
                gvh.textView.setText("Section " + g.title);
                break;

            case MainActivity.TYPE_CHILD:
                MainActivity.Child c = (MainActivity.Child) ds.get(position);
                ChildViewHolder cvh = (ChildViewHolder) holder;
                cvh.textView.setText(c.toString());
                break;
        }

    }

    @Override
    public int getItemCount() {
        if (ds == null) {
            return 0;
        }
        return ds.size();
    }

    public abstract class MainItemViewHolder extends RecyclerView.ViewHolder {
        public MainItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public abstract int getType();

    }

    public class GroupViewHolder extends MainItemViewHolder {
        public TextView textView;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.id_main_recyclerview_section_textview);
        }

        @Override
        public int getType() {
            return MainActivity.TYPE_GROUP;
        }
    }

    public class ChildViewHolder extends MainItemViewHolder {
        public TextView textView;

        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.id_main_recyclerview_cell_textview);
        }

        @Override
        public int getType() {
            return MainActivity.TYPE_CHILD;
        }
    }
}
