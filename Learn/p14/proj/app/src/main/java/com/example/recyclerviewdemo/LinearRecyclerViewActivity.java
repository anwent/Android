package com.example.recyclerviewdemo;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_linear_recycler_activity);


        mRvMain = (RecyclerView) findViewById(R.id.rv_main);
        mRvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        // 分割线
        mRvMain.addItemDecoration(new MyDecoration());

        LinearAdapter adp = new LinearAdapter(new LinearAdapter.OnItemClickListenner() {
            @Override
            public void didSelect(@NonNull LinearAdapter.LinearViewHolder holder, int position) {
                Toast
                        .makeText(LinearRecyclerViewActivity.this, "callback click :" + position, Toast.LENGTH_SHORT)
                        .show();
            }
        }, LinearRecyclerViewActivity.this);
        mRvMain.setAdapter(adp);


    }


    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
//            outRect.set(0, 0,0, 1);
        }
    }
}
