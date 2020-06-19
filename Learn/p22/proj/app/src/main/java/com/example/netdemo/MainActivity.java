package com.example.netdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.netdemo.CookModel.CookData;
import com.example.netdemo.CookModel.CookRoot;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    Button requestButton;

    RecyclerView recyclerView;
    MainActivityAdapter adapter;

    Handler mainHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
    }

    private void loadView() {
        requestButton = findViewById(R.id.main_request_button);
        requestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 网络请求
                Provider.requestCook("回锅肉", new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Toast
                                .makeText(MainActivity.this, "错误"+e.getMessage(), Toast.LENGTH_SHORT)
                                .show();
                    }
                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        String rspData = response.body().string();
                        CookRoot cr = JSON.parseObject(rspData, CookRoot.class);
                        adapter.setContent(cr);
                        mainHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }
                });
            }
        });

        // recycleview
        recyclerView = findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new MainActivityAdapter(MainActivity.this, new MainActivityAdapter.DidSelectedListenner() {
            @Override
            public void didSelected(MainRecyclerHolder holder, int position) {
                Toast
                        .makeText(MainActivity.this, position + "-", Toast.LENGTH_SHORT)
                        .show();
            }
        });
        recyclerView.setAdapter(adapter);
    }

}
