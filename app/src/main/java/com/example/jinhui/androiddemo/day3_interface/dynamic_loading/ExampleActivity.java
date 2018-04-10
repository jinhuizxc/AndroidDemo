package com.example.jinhui.androiddemo.day3_interface.dynamic_loading;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/27.
 * Email:1004260403@qq.com
 */

public class ExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 创建View对象
        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        LinearLayout linear1 = new LinearLayout(this);
        linear1.setOrientation(LinearLayout.HORIZONTAL);
        Button bt = new Button(this);
        ImageView imageView = new ImageView(this);
        EditText editText = new EditText(this);
        // 添加到布局对象中
        linear.addView(linear1);
        linear.addView(bt);
        linear1.addView(imageView);
        linear1.addView(editText);

        /**
         * LayoutParams是LinearLayout类中的一个static类
         * (这里是LinearLayout,所以导入import android.widget.LinearLayout包)
         * LayoutParams相当于一个属性包
         */

        // 最外层linearlayout属性
        LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(0,0);
        p1.width = ViewGroup.LayoutParams.MATCH_PARENT;
        p1.height = ViewGroup.LayoutParams.MATCH_PARENT;
        linear.setLayoutParams(p1);

        // 嵌套的linearlayout属性
        LinearLayout.LayoutParams p2 = new LinearLayout.LayoutParams(0,0);
        p2.width = ViewGroup.LayoutParams.MATCH_PARENT;
        p2.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        p2.weight = 1;
        linear1.setLayoutParams(p2);

        // 按钮属性
        LinearLayout.LayoutParams p3 = new LinearLayout.LayoutParams(0,0);
        p3.width = ViewGroup.LayoutParams.MATCH_PARENT;
        p3.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        p3.weight = 1;
        bt.setText("按钮");
        bt.setLayoutParams(p3);

        // 图片属性
        LinearLayout.LayoutParams image = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        image.weight = 1;
        imageView.setImageResource(R.mipmap.ic_launcher);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(image);

        // EditText属性
        LinearLayout.LayoutParams edit = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
        edit.weight = 1;
        editText.setHint("请输入...");
        editText.setLayoutParams(edit);

        setContentView(linear);
    }
}
