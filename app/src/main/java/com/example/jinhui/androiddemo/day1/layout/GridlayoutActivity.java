package com.example.jinhui.androiddemo.day1.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 *
 * 网格布局
 * android4.0版本后新增的GridLayout网格布局 在android4.0版本之前，如果想要达到网格布局的效果，首先可以考虑使用最常见的LinearLayout布局，但是这样的排布会产生如下几点问题：

 不能同时在X，Y轴方向上进行控件的对齐；
 当多层布局嵌套时会有性能问题；
 不能稳定地支持一些支持自由编辑布局的工具。

 GridLayout的布局策略简单分为以下三个部分：

 首先它与LinearLayout布局一样，也分为水平和垂直两种方式，默认是水平布局，一个控件挨着一个
 控件从左到右依次排列，但是通过指定Android:columnCount设置列数的属性后，控件会自动换行进
 行排列。另一方面，对于GridLayout布局中的子控件，默认按照wrap_content的方式设置其显示，
 这只需要在GridLayout布局中显式声明即可。
 其次，若要指定某控件显示在固定的行或列，只需设置该子控件的android:layout_row和
 android:layout_column属性即可，但是需要注意：android:layout_row=”0”表示从第一行开
 始，android:layout_column=”0”表示从第一列开始，这与编程语言中一维数组的赋值情况类似。
 最后，如果需要设置某控件跨越多行或多列，只需将该子控件的android:layout_rowSpan或者
 layout_columnSpan属性设置为数值，再设置其layout_gravity属性为fill即可，前一个设置表明该控
 件跨越的行数或列数，后一个设置表明该控件填满所跨越的整行或整列。
 */

public class GridlayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridlayout);
    }
}
