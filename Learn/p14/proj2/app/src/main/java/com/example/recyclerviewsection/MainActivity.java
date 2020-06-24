package com.example.recyclerviewsection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int TYPE_GROUP = 0xa01;
    public static final int TYPE_CHILD = 0xa02;
    private String[] sectionNames = {"A", "B", "C", "D", "E"};
    private ArrayList<Item> dataSource;

    private XRecyclerView recyclerView;
    private MainRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setContent();
        initView();
//        reloadRecyclerView();


        for (Item i : dataSource) {
            Log.d("main", i.toString());
        }

    }

    private void setContent() {
        dataSource = new ArrayList<>();
        for (int i = 0; i < sectionNames.length; i++) {
            Group g = new Group();
            g.position = i;
            g.title = sectionNames[i];
            dataSource.add(g);

            int count = (int) (Math.random() * 10) % 4 + 1;
            for (int j = 0; j < count; j++) {
                Child c = new Child();
                c.position = j;
                c.groupPosition = i;
                c.groupName = g.title;
                dataSource.add(c);
            }
        }
    }

    private void initView() {
        recyclerView = (XRecyclerView) findViewById(R.id.id_main_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MainRecyclerViewAdapter(MainActivity.this, dataSource);
        recyclerView.setAdapter(adapter);
    }

//    private void reloadRecyclerView() {
//        adapter.setDataSource(dataSource);
//    }


    public abstract class Item {
        public int position;
        public abstract int getType();
    }

    public class Group extends Item {

        public String title;

        @Override
        public int getType() {
            return MainActivity.TYPE_GROUP;
        }

        @NonNull
        @Override
        public String toString() {
            return "Group: " + " pos: " + position + " title: " + title;
        }
    }

    public class Child extends Item {

        public int groupPosition;

        public String groupName;

        @Override
        public int getType() {
            return MainActivity.TYPE_CHILD;
        }

        @NonNull
        @Override
        public String toString() {
            return "Child: " + " pos: " + position + " groupPosition: " + groupPosition + " groupName: " + groupName;
        }
    }

}
