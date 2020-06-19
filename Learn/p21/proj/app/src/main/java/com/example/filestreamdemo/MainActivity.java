package com.example.filestreamdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void save(String fileName, String ctx) throws IOException {
        FileOutputStream stream = null;
        try {
           stream = openFileOutput(fileName, MODE_PRIVATE);
           stream.write(ctx.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stream.close();
        }
    }


    private String read(String fileName) {
        FileInputStream stream = null;
        try {
            stream = openFileInput(fileName);
            byte[] buffer = new byte[1024];
            StringBuilder sb = new StringBuilder();
            int len = 0;
            while ((len = stream.read(buffer)) > 0) {
                sb.append(new String(buffer, 0 , len));
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
