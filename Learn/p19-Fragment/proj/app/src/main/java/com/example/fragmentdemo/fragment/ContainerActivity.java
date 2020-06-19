package com.example.fragmentdemo.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.fragmentdemo.R;
import com.example.fragmentdemo.fragment.A_Fragment;

public class ContainerActivity extends AppCompatActivity {

    A_Fragment aF;
//    B_Fragment bF;
//    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        aF = A_Fragment.newInstance("这是传递的参数噢");
//        bF = new B_Fragment();

//        initButton();
        // init aFragment

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fg_1, aF, "aF")
                .commitAllowingStateLoss();


    }

    //    private void initButton() {
//        btn = (Button) findViewById(R.id.mod_btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                getSupportFragmentManager()
//                        .beginTransaction()
//                        .replace(R.id.fg_1, bF)
//                        .commitAllowingStateLoss();
//
//            }
//        });
//    }
}
