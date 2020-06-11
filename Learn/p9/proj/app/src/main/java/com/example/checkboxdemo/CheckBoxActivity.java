package com.example.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox ll_cb1, ll_cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);


        ll_cb1 = (CheckBox) findViewById(R.id.ll_cb_1);
        ll_cb2 = (CheckBox) findViewById(R.id.ll_cb_2);


        ll_cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this, buttonView.isChecked() ? "wow true" : "wow false", Toast.LENGTH_SHORT)
                        .show();
            }
        });


    }
}
