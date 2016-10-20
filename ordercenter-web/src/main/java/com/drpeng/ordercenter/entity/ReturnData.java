package com.drpeng.ordercenter.entity;

import java.util.List;

/**
 * Created by yuyang on 2016/10/17 0017.
 */
public class ReturnData {
    private List data;
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }
}
