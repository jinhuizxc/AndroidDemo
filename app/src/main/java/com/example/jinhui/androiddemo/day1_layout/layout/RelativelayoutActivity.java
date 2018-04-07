package com.example.jinhui.androiddemo.day1_layout.layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 *
 * 相对布局
 * RelativeLayout是一种相对布局，控件的位置是按照相对位置来计算的，后一个控件在什么位置依赖于前一个控件的基本位置，是布局最常用，也是最灵活的一种布局。
 （a,b,c属性）
 这几个属性使用时需指定参考的控件，如
 用android:layout_below、android:layout_alignParentBottom来告诉系统我是要距离哪个控件多远的距离，否则将以布局父控件的上边和左边为基准

 　a）、第一类:属性值为true或false
 　android:layout_centerHrizontal 水平居中
 　　android:layout_centerVertical 垂直居中
 　　android:layout_centerInparent 相对于父元素完全居中
 　　android:layout_alignParentBottom 贴紧父元素的下边缘
 　　android:layout_alignParentLeft 贴紧父元素的左边缘
 　　android:layout_alignParentRight 贴紧父元素的右边缘
 　　android:layout_alignParentTop 贴紧父元素的上边缘　　

 　b）、第二类：属性值必须为id的引用名“@id/id-name”
 android:layout_below 在某元素的下方
 　　android:layout_above 在某元素的的上方
 　　android:layout_toLeftOf 在某元素的左边
 　　android:layout_toRightOf 在某元素的右边
 　　android:layout_alignTop 本元素的上边缘和某元素的的上边缘对齐
 　　android:layout_alignLeft 本元素的左边缘和某元素的的左边缘对齐
 　　android:layout_alignBottom 本元素的下边缘和某元素的的下边缘对齐
 　　android:layout_alignRight 本元素的右边缘和某元素的的右边缘对齐


 　c）、第三类：属性值为具体的像素值，如30dip，40px
 android:layout_marginBottom 离某元素底边缘的距离
 　　android:layout_marginLeft 离某元素左边缘的距离
 　　android:layout_marginRight 离某元素右边缘的距离
 　　android:layout_marginTop 离某元素上边缘的距离

 */

public class RelativelayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);
    }
}
