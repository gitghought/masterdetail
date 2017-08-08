package com.simple.gh.test_master_detail.activity.sql;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import com.simple.gh.test_master_detail.activity.utils.MyContext;
import com.simple.gh.test_master_detail.activity.utils.MyShowUtil;

import org.litepal.LitePal;

public class MyContentProvider extends ContentProvider {
    private SQLiteDatabase db;
    private static final int PROVINCE = 0;
    public static final String AUTHORITIES =
            "com.simple.gh.test_master_detail.provider";
    public static UriMatcher matcher;

    static {
        matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(AUTHORITIES, "provinces", PROVINCE);
    }


    public MyContentProvider() {
        Log.d(MyShowUtil.TAG, "concreate: "+ "my content provider");
//        MyContext.getContext();
//        LitePal.initialize(this.getContext());
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        Log.d(MyShowUtil.TAG, "onCreate: "+ "my content provider");
        db = LitePal.getDatabase();

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        int mat = matcher.match(uri);
        Cursor cursor = null;
        switch (mat) {
            case PROVINCE:
                cursor = db.query("provinces", projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                break;

        }

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
