package com.example.jinhui.androiddemo.day18;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day18.fileinoutstream.FileInOutStreamActivity;
import com.example.jinhui.androiddemo.day18.filestore.FileStoreActivity;
import com.example.jinhui.androiddemo.day18.shared.SavePasswordActivity;
import com.example.jinhui.androiddemo.day18.shared.SharedPreferencesActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/12.
 * Email:1004260403@qq.com
 * <p>
 * 5种数据存储方式：
 * 1.文件存储
 * 2.sharedpreferences；
 * 3.sqlite存储；
 * 4.contentprovider；
 * 5.网络存储；
 */

public class DataStoreActivity extends AppCompatActivity {

    private static final String TAG = "DataStoreActivity";
    @BindView(R.id.bt_filestore)
    Button btFilestore;
    @BindView(R.id.bt_sharedprefernces)
    Button btSharedprefernces;
    @BindView(R.id.bt_sqlite)
    Button btSqlite;
    @BindView(R.id.bt_contentprovider)
    Button btContentprovider;
    @BindView(R.id.bt_internetstore)
    Button btInternetstore;
    @BindView(R.id.bt_fileinoutstore)
    Button btFileinoutstore;
    @BindView(R.id.bt_savepassword)
    Button btSavepassword;
    @BindView(R.id.bt_readshared)
    Button btReadshared;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datastore);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_filestore, R.id.bt_fileinoutstore, R.id.bt_sharedprefernces,
            R.id.bt_savepassword, R.id.bt_readshared,
            R.id.bt_sqlite, R.id.bt_contentprovider, R.id.bt_internetstore})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_filestore:
                startActivity(new Intent(this, FileStoreActivity.class));
                break;
            case R.id.bt_fileinoutstore:
                startActivity(new Intent(this, FileInOutStreamActivity.class));
                break;
            case R.id.bt_sharedprefernces:
                startActivity(new Intent(this, SharedPreferencesActivity.class));
                break;
            case R.id.bt_savepassword:
                startActivity(new Intent(this, SavePasswordActivity.class));
                break;
            case R.id.bt_readshared:
                readShared();
                break;
            case R.id.bt_sqlite:
                break;
            case R.id.bt_contentprovider:
                // 可能会在之后与本day合并在一起
                Toast.makeText(this, "见day19的contentprovider例子", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_internetstore:
                break;
        }
    }

    /**
     * 读取其他应用的shared对象
     *
     * 这个晚上在处理
     */
    private void readShared() {
        SharedPreferences share;
        try {
            Context context = this.createPackageContext("com.example.jinhui.androiddemo.day18.shared", Context.CONTEXT_IGNORE_SECURITY);
            share = context.getSharedPreferences("a", Context.MODE_PRIVATE);
            String name = share.getString("name", "");
            Log.e(TAG, name);
            Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
