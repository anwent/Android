package com.example.toastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.toastdemo.util.ZToast;

public class MainActivity extends AppCompatActivity {

    Button toastButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toastButton = (Button) findViewById(R.id.btn_1);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZToast.showMessage(getApplicationContext(), "showMessage");
            }
        });

    }
}
