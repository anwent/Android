package com.example.flowrecyclerviewdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView myRcView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRcView = (RecyclerView) findViewById(R.id.rcv_1);
        myRcView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        myRcView.addItemDecoration(new FlowDecoration());
        myRcView.setAdapter(new StaggeredGridAdapter(MainActivity.this, new StaggeredGridAdapter.FlowCellDidSelectListener() {
            @Override
            public void didSelect(StaggeredGridAdapter.ViewHolder holder, int position) {
                Toast.makeText(MainActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        }));
    }


    class FlowDecoration extends RecyclerView.ItemDecoration {

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(10, 10, 10, 10);
        }
    }
}
