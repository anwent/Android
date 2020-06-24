package com.example.livedatatest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;
    TextView textView;
    ImageButton btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);
        btn1 = findViewById(R.id.imageButton);
        btn2 = findViewById(R.id.imageButton2);

        viewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel.class);

        viewModel
                .getNum()
                .observe(this, new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        textView.setText(String.valueOf(integer));
                    }
                });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.accpet(1);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.accpet(-1);
            }
        });

    }
}
