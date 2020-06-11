package com.example.textviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TextViewActivity extends AppCompatActivity {

    TextView tv4, tv5, tv6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        tv4 = (TextView) findViewById(R.id.tv_4);
        // 中划线
        tv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        // 取消锯齿
        tv4.getPaint().setAntiAlias(true);

        tv5 = (TextView) findViewById(R.id.tv_5);
        // 下划线
        tv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);

        tv6 = (TextView) findViewById(R.id.tv_6);
        tv6.setText(Html.fromHtml("<u>HTML 下划线</u>"));
    }
}
