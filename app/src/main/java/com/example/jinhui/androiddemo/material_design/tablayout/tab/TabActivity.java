package com.example.jinhui.androiddemo.material_design.tablayout.tab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by jh on 2018/9/3.
 * Email: 1004260403@qq.com
 */
public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //创建TabLayout
        TabLayout tabLayout = new TabLayout(this);
        tabLayout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));
        //tab可滚动
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //tab居中显示
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        //tab的字体选择器,默认黑色,选择时红色
        tabLayout.setTabTextColors(Color.BLACK, Color.RED);
        //tab的下划线颜色,默认是粉红色
        tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
        for (int i = 0; i < 20; i++) {
            //添加tab
            tabLayout.addTab(tabLayout.newTab().setText("TAB" + i));
        }
        final Toast toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        //设置tab的点击监听器
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                toast.setText(tab.getPosition() + ":" + tab.getText());
                toast.show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setContentView(tabLayout);
    }
}
