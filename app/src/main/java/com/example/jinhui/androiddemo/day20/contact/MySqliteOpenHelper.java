package com.example.jinhui.androiddemo.day20.contact;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class MySqliteOpenHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "info";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_PHONE = "phone";

    public MySqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME
                + " (id integer primary key autoincrement, " + FIELD_NAME
                + " char(10), "+FIELD_PHONE+" char(11));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
