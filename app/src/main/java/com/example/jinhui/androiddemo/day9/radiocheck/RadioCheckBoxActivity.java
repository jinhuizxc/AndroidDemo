package com.example.jinhui.androiddemo.day9.radiocheck;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/31.
 * Email:1004260403@qq.com
 * <p>
 * RadioButton与CheckBox
 * <p>
 * RadioGroup是按钮组；
 * 注意单选按钮一定要在RadioGroup中。
 * <p>
 * 勾选事件监听：状态改变的监听
 * OnCheckedChangeListener
 * (对于RadioButton当选择别的RadioButton时状态变为false、
 * 对于CheckBox本身可以选中或者不选中)
 */

public class RadioCheckBoxActivity extends AppCompatActivity {

    private static final String TAG = "RadioCheckBoxActivity";
    @BindView(R.id.radio0)
    RadioButton radio0;
    @BindView(R.id.radio1)
    RadioButton radio1;
    @BindView(R.id.radio2)
    RadioButton radio2;
    @BindView(R.id.radioGroup1)
    RadioGroup radioGroup1;
    @BindView(R.id.checkBox1)
    CheckBox checkBox1;
    @BindView(R.id.checkBox2)
    CheckBox checkBox2;
    @BindView(R.id.checkBox3)
    CheckBox checkBox3;
    @BindView(R.id.textView1)
    TextView textView1;

    ArrayList<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiocheckbox);
        ButterKnife.bind(this);

        radio0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(RadioCheckBoxActivity.this, "check =" + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

//        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Toast.makeText(RadioCheckBoxActivity.this, "check =" + isChecked, Toast.LENGTH_SHORT).show();
//            }
//        });

        radio1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

        radio2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });


    }

    String text;

    @OnClick({R.id.checkBox1, R.id.checkBox2, R.id.checkBox3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.checkBox1:
                text = checkBox1.getText().toString();
                doCheck(text);
                break;
            case R.id.checkBox2:
                text = checkBox2.getText().toString();
                doCheck(text);
                break;
            case R.id.checkBox3:
                text = checkBox3.getText().toString();
                doCheck(text);
                break;
        }
    }


    private void doCheck(String text) {
        //检查链表
        checkList(text);
        Log.d(TAG, data.toString());
        textView1.setText("身份：");
        for (int i = 0; i < data.size(); i++) {
            textView1.append(data.get(i));
        }
    }

    private void checkList(String text) {
        //检查链表中否存在该对象，如果有，移除，不加的话会造成点击当前checkbox会无止境的添加当前项，这是bug。
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(text)) {
                data.remove(i);
                return;
            }
        }
        data.add(text);
    }
}
