package com.simple.gh.test_master_detail.activity.objs;

/**
 * Created by gh on 2017-07-27.
 */

public class City {
    public int id;
    public String name;
    public int cityCode;
    public int provinceCode;

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProvinceCode() {
        return provinceCode;
    }
}
