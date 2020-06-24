package com.example.databindingtest;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> num;

    public MutableLiveData<Integer> getNum() {
        if (num == null) {
            num = new MutableLiveData<>();
            num.setValue(0);
        }
        return num;
    }

    public void add() {
        num.setValue(getNum().getValue() + 1);
    }
}
