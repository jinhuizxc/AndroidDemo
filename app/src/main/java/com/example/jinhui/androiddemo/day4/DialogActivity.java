package com.example.jinhui.androiddemo.day4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 *
 * 在实际开发中，有可能需要将Activity以对话框的形式显示出来，这个时
 候就可以直接在主配置文件中配置一下该Activity的主题就可以了。

 <activity
 android:name=".MainActivity"
 android:label="@string/app_name"
 android:theme="@android:style/Theme.Dialog">
 */

public class DialogActivity extends AppCompatActivity {

    /**
     * 设置android:theme="@android:style/Theme.Dialog"出现错误：
     * Caused by: java.lang.IllegalStateException: You need to use a Theme.AppCompat theme (or descendant) with this activity.
     * 现今这样配置：android:theme="@style/Theme.AppCompat.Dialog"
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

}
