package com.example.jinhui.androiddemo.day1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 *
 * Text常用属性
 *
 * android:textColor-文本颜色
 *
 * android:textSize-文本大小
 *
 * android:autoLink-设置是否当文本为URL链接/email/电话号码/map，文本显示可点击链接
 *
 * android:lines 设置文本行数，设置2行就显示2行，即使第二行没有数据显示
 *
 * android：ellipsize设置当文本文字过长时，该控件该如何显示，
 *有5中设置（none：不做任何处理；start：在文本开始时截断，并显示省略号；end：在文本结尾处截断，并显示省略号；middle：在文本中间处截断，并显示省略号；marquee：以跑马灯方式滚动文本）
 *
 * android：singleLine设置单行显示设置单行显示。如果和 layout_width 一起使用，当文本不能全部显示时，后面用“...”显示
 *
 * android：shadowRadius 设置阴影半径。设置为0.1就变成字体的颜色了，一般设置为3.0效果比较好。
 * android：shadowDx设置阴影横向坐标开始位置
 * android：shadowDy设置阴影纵向坐标开始位置
 * android：shadowColor指定文本颜色需要与shadowRadius一起使用
 *
 * TextView的跑马灯效果，除了上面的所提到的相关属性，还需要在增加几条，大家可自行测试这个效果。
 * android:marqueeRepeatLimit：在ellipsize指定marquee的情况下，设置重复滚动的次数，当设marquee_forever时表示无限次。
 *
 * 布局中需要添加下面2行代码
 * android:focusable="true"
 * android:focusableInTouchMode="true"
 *
 * 注意：上述的省略、跑马灯效果需在android:singleLine="true"条下才会生效，因为TextView会在一行无法完全显示时自动换行。
 *
 */

public class TextViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
    }
}
