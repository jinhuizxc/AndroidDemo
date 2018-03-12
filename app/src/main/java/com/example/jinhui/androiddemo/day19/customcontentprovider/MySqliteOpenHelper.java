package com.example.jinhui.androiddemo.day19.customcontentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jinhui on 2018/3/12.
 * Email:1004260403@qq.com
 *
 * SQLiteOpenHelper
 *
 *   db.execSQL("create table " + TABLE_NAME
 + " (id integer primary key autoincrement, " + FIELD_NAME
 + " char(10), "+FIELD_PHONE+" char(11));");

 建表时需要严格按照cmd里面加空格，否则报错：
 java.lang.RuntimeException:
 Unable to get provider com.example.jinhui.androiddemo.day19.customcontentprovider.MyContentProvider:
 android.database.sqlite.SQLiteException: near "tableinfo": syntax error (code 1): ,
 while compiling: create tableinfo(id integer primary key autoincrement,namechar(10),phonechar(11));
 */

public class MySqliteOpenHelper extends SQLiteOpenHelper {

    // 字段
    private String TABLE_NAME = "info";
    private String FIELD_NAME = "name";
    private String FIELD_PHONE = "phone";


    public MySqliteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(id integer primary key autoincrement, "
                + FIELD_NAME + " char(10), " + FIELD_PHONE + " char(11));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
