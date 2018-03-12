package com.example.jinhui.androiddemo.day19.customcontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import static com.example.jinhui.androiddemo.day20.contact.MySqliteOpenHelper.TABLE_NAME;


/**
 * Created by jinhui on 2018/3/12.
 * Email:1004260403@qq.com
 */

public class MyContentProvider extends ContentProvider {

    private static final String TAG = "MyContentProvider";
    SQLiteDatabase database;

    @Override
    public boolean onCreate() {
        Log.e(TAG, "onCreate");  // E/MyContentProvider: onCreate
        MySqliteOpenHelper mySqliteOpenHelper = new MySqliteOpenHelper(this.getContext(), "contact.db", null, 1);
        database = mySqliteOpenHelper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Log.e(TAG, "query");
        Cursor cursor = database.query(TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        Log.e(TAG, "getType");
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Log.e(TAG, "insert");
        database.insert(TABLE_NAME, null, values);  // 插入数据时执行：E/MyContentProvider: insert
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.e(TAG, "delete");
        return database.delete(TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.e(TAG, "update");
        return database.update(TABLE_NAME, values, selection, selectionArgs);
    }
}
