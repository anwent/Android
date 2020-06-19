package com.example.recyclerviewdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context mContext;

    private OnItemClickListenner mListenner;

    public LinearAdapter(OnItemClickListenner listenner, Context ctx) {
        this.mContext = ctx;
        this.mListenner = listenner;
    }

    @NonNull
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearViewHolder holder = new LinearViewHolder(
                LayoutInflater
                        .from(mContext)
                        .inflate(R.layout.layout_linear_item, parent, false)
        );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final LinearAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("第" + position + "行");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListenner.didSelect(holder, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListenner {
        void didSelect(@NonNull LinearAdapter.LinearViewHolder holder, final int position);
    }
}
