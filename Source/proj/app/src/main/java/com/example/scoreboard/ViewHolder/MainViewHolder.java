package com.example.scoreboard.ViewHolder;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scoreboard.R;

public class MainViewHolder extends RecyclerView.ViewHolder {

    public Button scoreButton;

    public MainViewHolder(@NonNull View itemView) {
        super(itemView);

        scoreButton = (Button) itemView.findViewById(R.id.scoreboard_item_button);

    }
}
