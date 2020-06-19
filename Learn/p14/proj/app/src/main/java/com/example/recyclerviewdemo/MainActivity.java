package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button rcvBtn, mBtnHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvBtn = (Button) findViewById(R.id.rcv_1);
        rcvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnet = new Intent(MainActivity.this, LinearRecyclerViewActivity.class);
                startActivity(intnet);
            }
        });


        mBtnHor = (Button) findViewById(R.id.rcv_2);
        mBtnHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnet = new Intent(MainActivity.this, RecyclerHorActivity.class);
                startActivity(intnet);
            }
        });

    }
}
