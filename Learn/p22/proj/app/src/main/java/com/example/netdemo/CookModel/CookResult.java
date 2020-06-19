package com.example.netdemo.CookModel;

import java.util.List;

public class CookResult {
    private List<CookData> data;

    private String totalNum;

    private int pn;

    private String rn;

    public void setData(List<CookData> data) {
        this.data = data;
    }

    public List<CookData> getData() {
        return this.data;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public String getTotalNum() {
        return this.totalNum;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }

    public int getPn() {
        return this.pn;
    }

    public void setRn(String rn) {
        this.rn = rn;
    }

    public String getRn() {
        return this.rn;
    }
}
