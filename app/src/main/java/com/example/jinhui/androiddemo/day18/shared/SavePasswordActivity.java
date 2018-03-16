package com.example.jinhui.androiddemo.day18.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/12.
 * Email:1004260403@qq.com
 * <p>
 * 示例：保存密码
 */

public class SavePasswordActivity extends AppCompatActivity {

    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.checkBox1)
    CheckBox checkBox1;
    @BindView(R.id.button1)
    Button button1;

    SharedPreferences share;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savepassword);
        ButterKnife.bind(this);

        share = this.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        boolean isSave = share.getBoolean("isSave", false);
        // 读取数据
        if (isSave){
            String name = share.getString("name", "");
            String pass = share.getString("pass", "");
            editText1.setText(name);
            editText2.setText(pass);
            checkBox1.setChecked(true);
        }
    }

    @OnClick(R.id.button1)
    public void onViewClicked() {
        boolean isSave = checkBox1.isChecked();
        // 保存数据
        String name = editText1.getText().toString();
        String pass = editText2.getText().toString();
        SharedPreferences.Editor editor = share.edit();
        editor.putString("name", name);
        editor.putString("pass", pass);
        editor.putBoolean("isSave", isSave);
        editor.apply();
        finish();
    }
}
