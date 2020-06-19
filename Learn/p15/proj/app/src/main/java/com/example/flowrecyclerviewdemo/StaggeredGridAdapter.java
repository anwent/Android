package com.example.flowrecyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.ViewHolder> {

    private Context mCtx;

    private FlowCellDidSelectListener mListener;

    public StaggeredGridAdapter(Context ctx, FlowCellDidSelectListener lis) {
        this.mCtx = ctx;
        this.mListener = lis;
    }

    @NonNull
    @Override
    public StaggeredGridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StaggeredGridAdapter.ViewHolder holder = new StaggeredGridAdapter.ViewHolder(
                LayoutInflater.from(mCtx).inflate(
                        R.layout.layout_flow_recyclerview_cell,
                        parent,
                        false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final StaggeredGridAdapter.ViewHolder holder, final int position) {
        int rId = (position % 2 == 0) ? R.mipmap.h_img : R.mipmap.v_img;
        holder.imgview.setImageResource(rId);
//        mListener(holder, position);

        holder.imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.didSelect(holder, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.flow_cell_imageview);
        }
    }

    public interface FlowCellDidSelectListener {
        void didSelect(StaggeredGridAdapter.ViewHolder holder, int position);
    }
}
