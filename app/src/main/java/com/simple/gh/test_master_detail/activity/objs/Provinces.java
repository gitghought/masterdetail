package com.simple.gh.test_master_detail.activity.objs;

/**
 * Created by gh on 2017-07-27.
 */

public class Provinces {
    private int id;
    private String name;
    private int provinceCode;

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {

        this.provinceCode = provinceCode;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

}
