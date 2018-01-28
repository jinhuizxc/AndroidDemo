package com.example.jinhui.androiddemo.day1.layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 * <p>
 * 线性布局
 * 线性布局是将该容器中的组件一个挨着一个的排列起来
 * <p>
 * 1) gravity-控制元素在该控件里的显示位置
 * 这个是针对控件里的元素来说的，用来控制元素在该控件里的显示位置。
 * 例如，在一个Button按钮控件中设置如下两个属性，android:gravity="left"和android:text="hi"，这时Button上的文字“hi”将会位于Button的左部。
 * <p>
 * 2) padding属性，设定内边距
 * 设定内边距，及控件内部的文本或图片内容距离该控件边框的距离，还有对应设定
 * 四个方向距离的属性：
 * android:padding：距离控件四周边框的距离
 * android:paddingLeft：距离控件左边框的距离
 * android:paddingTop：距离控件上边框的距离
 * android:paddingRight：距离控件右边框的距离
 * android:paddingBottom：距离控件底边框的距离
 * <p>
 * 3) layout_gravity相对重心-控制该控件在包含该控件的父控件中的位置
 * 这个是针对控件本身而言，用来控制该控件在包含该控件的父控件中的位置。同样，当我们在
 * Button按钮控件中设置android:layout_gravity="left"属性时，表示该Button按钮将位于界面的左部。
 * <p>
 * (1)当 android:orientation="vertical" 时， android:layout_gravity只有水平方向的设置才起作用，
 * 垂直方向的设置不起作用。即：left，right，center_horizontal 是生效的。
 * (2)当android:orientation="horizontal" 时，android:layout_gravity只有垂直方向的设置才起作
 * 用，水平方向的设置不起作用。即：top，bottom，center_vertical 是生效的
 * <p>
 * 4) android:layout_margin指定这个view距离“自己”上下左右最近控件的额外距离
 * <p>
 * 5) 有指定方向的margin
 * android: layout_marginBottom 指定这个view距离下方的额外距离
 * android: layout_marginLeft 指定这个view距离左方的额外距离
 * android: layout_marginRight 指定这个view距离右方的额外距离
 * android: layout_marginTop 指定这个view距离上方的额外距离
 * <p>
 * 这四个属性与 android: layout_margin相似，只不过是指定了特定的方向而已。
 * <p>
 * <p>
 * android:layout_gravity和android:gravity的属性值
 * 1.android:gravity:
 * 2.android:layout_gravity:
 * 属性值：
 * 这两个属性值可选的值有：top、bottom、left、right、center_vertical、
 * fill_vertical、center_horizontal、fill_horizontal、center、fill、clip_vertical.
 * 一个属性可以包含多个值，需要用|分开
 * 如：android:layout_gravity = "bottem|left" ，
 * 简单介绍下属性值
 * top: 将对象放在其容器的顶部，不改变大小；
 * bottem: 将对象放在其容器的底部，不改变大小；
 * left: 将对象放在其容器的左部，不改变大小；
 * right：将对象放在其容器的右部，不改变大小；
 * center_horizontal: 将对象纵向居中，不改变大小，垂直对齐方式：垂直方向上居中对齐；
 * center: 将对象横纵居中，不改变大小；
 * <p>
 * 特殊情况：
 * 当用线性布局时：
 * 1）方向是vertical时，left、right、center_horizontal是生效的；
 * 2）方向是horizontal时，top、bottom、center_vertical是生效的；
 * <p>
 * <p>
 * android:layout_weight（权重）
 * 对于权重这个属性可以这样来理解和使用，权重属性其实就是给控
 * 件分配剩余的空间，就像上面例子中当我们最开始放入三个控件后，在垂直或水平方向上还剩余
 * 有空间，然后通过每个控件的权重值，将剩余的空间按权重比例分配到对应的控件上。所以，我
 * 们使用控件的时候就把控件在对应方向上的尺寸大小设置为0dp，然后通过权重来控制控件在该
 * 方向上的尺寸大小。
 */

public class LinearlayoutActivity extends AppCompatActivity {

    @BindView(R.id.bt_layout_weight)
    Button btLayoutWeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_layout_weight)
    public void onViewClicked() {
        startActivity(new Intent(this, WeightActivity.class));
    }
}
