package com.example.buttondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.PrintStreamPrinter;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ButtonDemoActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_demo);

        tv = (TextView) findViewById(R.id.tv_1);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("点击了textView");

                showToast(tv);
            }
        });

    }

    public void showToast(View view) {
        Toast
                .makeText(this, "点击了4", Toast.LENGTH_SHORT)
                .show();
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }
}
