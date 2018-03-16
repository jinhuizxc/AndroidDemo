package com.example.jinhui.androiddemo.day18.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/12.
 * Email:1004260403@qq.com
 */

public class SharedPreferencesActivity extends AppCompatActivity {

    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);
        ButterKnife.bind(this);

        // 获取sharedPreferences的对象
        sharedPreferences = this.getSharedPreferences("a", Context.MODE_PRIVATE);
        // 读取数据
        String name = sharedPreferences.getString("name", null);
        editText1.setText(name);
    }

    @OnClick({R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                // 保存数据,并提交数据 editor.commit();被替换成apply()
                String text = editText1.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", text);
                editor.putInt("age", 10);
                editor.putBoolean("sex", true);
                editor.apply();
                Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                // 读取数据
                String name = sharedPreferences.getString("name", null);
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
