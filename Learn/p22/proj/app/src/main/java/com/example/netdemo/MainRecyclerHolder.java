package com.example.netdemo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainRecyclerHolder extends RecyclerView.ViewHolder {

    public ImageView iamgeView;
    public TextView mainTitle, subTitle;

    public MainRecyclerHolder(@NonNull View itemView) {
        super(itemView);
        this.iamgeView = itemView.findViewById(R.id.main_recycler_item_image);
        this.mainTitle = itemView.findViewById(R.id.main_recycler_item_maintitle);
        this.subTitle = itemView.findViewById(R.id.main_recycler_item_subtitle);
    }

}
