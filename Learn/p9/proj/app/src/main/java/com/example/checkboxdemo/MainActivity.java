package com.example.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn_1);
        setListeners();
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        btn.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {

            Intent intent = null;

            switch (v.getId()) {
                case R.id.btn_1:
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
            }
            startActivity(intent);
        }

    }
}
