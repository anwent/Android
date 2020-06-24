package com.example.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MyViewModel vm;

    TextView textView;
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vm = ViewModelProviders.of(this).get(MyViewModel.class);
        textView = findViewById(R.id.textView);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.num++;
                textView.setText(String.valueOf(vm.num));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.num += 2;
                textView.setText(String.valueOf(vm.num));
            }
        });

    }
}
