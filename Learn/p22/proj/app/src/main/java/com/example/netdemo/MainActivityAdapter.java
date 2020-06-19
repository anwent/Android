package com.example.netdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netdemo.CookModel.CookData;
import com.example.netdemo.CookModel.CookResult;
import com.example.netdemo.CookModel.CookRoot;
import com.bumptech.glide.Glide;

public class MainActivityAdapter extends RecyclerView.Adapter<MainRecyclerHolder> {

    private CookRoot dataSource = null;

    private Context ctx;

    private DidSelectedListenner listenner;

    public MainActivityAdapter(Context mContext, DidSelectedListenner lis) {
        this.ctx = mContext;
        this.listenner = lis;
    }

    public void setContent(CookRoot ds) {
        this.dataSource = ds;
    }

    @NonNull
    @Override
    public MainRecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(ctx).inflate(R.layout.layout_main_recycler_item, parent, false);
        MainRecyclerHolder holder = new MainRecyclerHolder(itemview);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MainRecyclerHolder holder, final int position) {

        if (dataSource == null) {
            return;
        }

        CookData ds = dataSource.getResult().getData().get(position);

        if (ds.getAlbums().size() > 0) {
            Glide
                    .with(holder.iamgeView)
                    .load(ds.getAlbums().get(0))
                    .into(holder.iamgeView);
        }

        String title = (position+1) + "-" + ds.getTitle();
        holder.mainTitle.setText(title);
        holder.subTitle.setText(ds.getTags());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenner.didSelected(holder, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (dataSource == null) {
            return 0;
        }
        return dataSource.getResult().getData().size();
    }

    public interface DidSelectedListenner {
        void didSelected(MainRecyclerHolder holder, int position);
    }
}
