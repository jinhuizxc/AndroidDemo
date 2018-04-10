package com.example.jinhui.androiddemo.day3_interface.interface1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/27.
 * Email:1004260403@qq.com
 * <p>
 * 对界面动态增加与删除View
 *
 * 当需要对界面操作时，首先需要取出布局控件的对象，在调用
 * addView（View view）或者removeView（View view）方法实现动态往不居中增加或者删除view对象，
 */

public class Add_removeActivity extends AppCompatActivity {


    List<Button> list = new ArrayList<>();
    @BindView(R.id.bt_add)
    Button btAdd;
    @BindView(R.id.bt_remove)
    Button btRemove;
    @BindView(R.id.layout)
    LinearLayout layout;

    // 添加的按钮
    Button bt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_remove);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.bt_add, R.id.bt_remove})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_add:
                bt = new Button(this);

                bt.setText("添加的按钮");

                // 在布局中添加按钮
                layout.addView(bt);
                // 将新建按钮添加到链表中
                list.add(bt);
                break;
            case R.id.bt_remove:
                if (list.size() > 0) {
                    // 取出链表中的按钮对象
                    bt = list.get(list.size() - 1);
                    // 删除布局中的按钮
                    layout.removeView(bt);
                    // 删除链表中的按钮
                    list.remove(bt);
                }else {
                    Toast.makeText(this, "链表为空 ", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

}
