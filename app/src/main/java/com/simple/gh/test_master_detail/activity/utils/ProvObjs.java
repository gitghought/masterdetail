package com.simple.gh.test_master_detail.activity.utils;

import com.simple.gh.test_master_detail.activity.objs.Provinces;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by gh on 2017-08-04.
 */

public class ProvObjs {
    public static ArrayList<Provinces> provs = new ArrayList<>();
    public static ProvObjs provObjs;

    public ProvObjs() {
        provs = new ArrayList<>();
        for (int i = 0;i < 10; i++) {
            Provinces prov = new Provinces();
            provs.add(prov);
        }
    }

    public Provinces getProv (int id) {
        for (int i = 0; i < provs.size(); i++) {
           if (provs.get(i).getId() == id) {
               return provs.get(i);
           }
        }
        return null;
    }

    public ArrayList<Provinces> getProvs () {
        return provs;
    }

    public static ProvObjs getProvObjs() {
        if (provObjs == null) {
           return new ProvObjs();
        } else {
           return provObjs;
        }
    }
}
