package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.ArraySet;

import com.example.scoreboard.Fragment.ScoreboardFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ScoreboardFragment leftTeam, rightTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment();
    }


    private void loadFragment() {

        ArrayList<String> score = new ArrayList<String>(Arrays.asList("+1", "+2", "+3"));

        leftTeam = ScoreboardFragment.newInstance(score);
        rightTeam = ScoreboardFragment.newInstance(score);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.team_1, leftTeam, "left")
                .commitNowAllowingStateLoss();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.team_2, rightTeam, "right")
                .commitNowAllowingStateLoss();


    }
}
