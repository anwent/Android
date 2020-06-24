package com.example.scoreboard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scoreboard.R;
import com.example.scoreboard.ViewHolder.MainViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private Context ctx;
    private ArrayList<String> ds;
    private RecyclerViewItemClickListener listener;

    public MainAdapter(Context context, ArrayList<String> dataSource, RecyclerViewItemClickListener handler) {
        this.ctx = context;
        this.ds = dataSource;
        this.listener = handler;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.layout_recycleritem_scoreboard_item, parent, false);
        MainViewHolder holder = new MainViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainViewHolder holder, final int position) {

        if (ds == null) { return; }

        holder.scoreButton.setText(ds.get(position));

        holder.scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(holder, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (ds == null) ? 0 : ds.size();
    }

    public interface RecyclerViewItemClickListener {
        void onClick(MainViewHolder holder, int position);
    }
}
