package com.example.jinhui.androiddemo.day1_layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 *
 * EditText常用属性
 *
 * android:hint 提示输入信息，编辑框输入内容时，这个提示信息会消失；
 *
 * android:password指定输入的文本是密码类型，以“.”显示信息，在高版本中用inputType代替；
 *
 * android:inputType属性可以创建不同类型的EditText，
 * 可以用来指定输入类型（密码、数字、时间、格式等）。比如密码类型就会以“.”显示，不会显示出文字内容；
 *
 * android:cursorVisible表示光标是否可见，设置为true时表示可见，若为false则表示不可见
 *
 * android:maxLines 解决当输入的内容过多时，界面就会变得非常难看的这个问题例android:maxLines="2"，表示显示输入的两行
 */

public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
    }
}
