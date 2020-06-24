package com.example.scoreboard.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scoreboard.Adapter.MainAdapter;
import com.example.scoreboard.R;
import com.example.scoreboard.ViewHolder.MainViewHolder;

import java.util.ArrayList;

public class ScoreboardFragment extends Fragment {

    private TextView scoreText;

    private RecyclerView addScoreBoard;

    public static ScoreboardFragment newInstance(ArrayList<String> ds) {
        ScoreboardFragment sf = new ScoreboardFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("data", ds);
        sf.setArguments(bundle);
        return sf;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_scoreboard_main_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        scoreText = (TextView) view.findViewById(R.id.fragment_main_textview);
        addScoreBoard = (RecyclerView) view.findViewById(R.id.fragment_main_recyclerview);

        addScoreBoard.setLayoutManager(new LinearLayoutManager(getActivity()));
        MainAdapter adp = new MainAdapter(getActivity(),
                getArguments().getStringArrayList("data"),
                new MainAdapter.RecyclerViewItemClickListener() {
                    @Override
                    public void onClick(MainViewHolder holder, int position) {

                    }
                });
        addScoreBoard.setAdapter(adp);
    }

}
