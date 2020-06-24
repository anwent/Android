package com.example.scoreboard.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreboardViewModel extends ViewModel {

    private MutableLiveData<Integer> score;

    public MutableLiveData<Integer> getScore() {
        if (score == null) {
            score = new MutableLiveData<>();
            score.setValue(0);
        }
        return score;
    }

    public void accept(int s) {
        score.setValue(getScore().getValue() + s);
    }
}
