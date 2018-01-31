package com.example.jinhui.androiddemo.day9.popup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/31.
 * Email:1004260403@qq.com
 * <p>
 * 1.PopupWindow这个类用来实现一个弹出框，
 * 可以使用任意布局View作为其内容，这个弹出框悬浮在当前activity之上。
 */

public class PopupwindowActivity extends AppCompatActivity {

    @BindView(R.id.bt_pop)
    Button btPop;

    PopupWindow pop;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindow);
        ButterKnife.bind(this);

        //创建popupwindow
        View view = LayoutInflater.from(this).inflate(R.layout.popup, null);
        pop = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //给popupWindow中的按钮添加监听
        Button bt_cancle = (Button) view.findViewById(R.id.bt_cancle);
        bt_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 隐藏popupWindow
                pop.dismiss();
            }
        });
    }


    @OnClick({R.id.bt_pop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_pop:
                // 显示popupwindow
                pop.showAtLocation(view, Gravity.CENTER, 0, view.getHeight());
                break;
        }
    }
}
