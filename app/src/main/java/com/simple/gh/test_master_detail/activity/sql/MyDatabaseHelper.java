package com.simple.gh.test_master_detail.activity.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gh on 2017-08-08.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper{
    public static final String CREATE_PROVINCE = "create table Province (" +
            "id integer primary key autoincrement, " +
            "idval integer unique, " +
            "name text unique, " +
            "provinceCode integer" +
            ")";

    private Context context;

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MyDatabaseHelper.CREATE_PROVINCE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Province");

        onCreate(db);
    }
}
