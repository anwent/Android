package com.example.livedatatest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Integer> num;


    public MutableLiveData<Integer> getNum() {
        if (num == null) {
            num = new MutableLiveData<>();
            num.setValue(0);
        }
        return num;
    }

    public void accpet(int n) {
        num.setValue(getNum().getValue() + n);
    }

}
