package com.example.jinhui.androiddemo.day1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day1.layout.AbsolutelayoutActivity;
import com.example.jinhui.androiddemo.day1.layout.FramelayoutActivity;
import com.example.jinhui.androiddemo.day1.layout.GridlayoutActivity;
import com.example.jinhui.androiddemo.day1.layout.LinearlayoutActivity;
import com.example.jinhui.androiddemo.day1.layout.RelativelayoutActivity;
import com.example.jinhui.androiddemo.day1.layout.TablelayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 * 常用Widget与布局文件
 */

public class WidgetAndLayoutActivity extends AppCompatActivity {

    @BindView(R.id.bt_view)
    Button btView;
    @BindView(R.id.bt_textview)
    Button btTextview;
    @BindView(R.id.bt_button)
    Button btButton;
    @BindView(R.id.bt_edittext)
    Button btEdittext;
    @BindView(R.id.bt_prograssbar)
    Button btPrograssbar;
    @BindView(R.id.bt_imageview)
    Button btImageview;
    @BindView(R.id.bt_linearlayout)
    Button btLinearlayout;
    @BindView(R.id.bt_relativelayout)
    Button btRelativelayout;
    @BindView(R.id.bt_framelayout)
    Button btFramelayout;
    @BindView(R.id.bt_tablelayout)
    Button btTablelayout;
    @BindView(R.id.bt_gridlayout)
    Button btGridlayout;
    @BindView(R.id.bt_radiogroup)
    Button btRadiogroup;
    @BindView(R.id.bt_checkbox)
    Button btCheckbox;
    @BindView(R.id.bt_absolutelayout)
    Button btAbsolutelayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgetandlayout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_view, R.id.bt_textview, R.id.bt_button, R.id.bt_edittext,
            R.id.bt_prograssbar, R.id.bt_imageview, R.id.bt_linearlayout,
            R.id.bt_relativelayout, R.id.bt_framelayout, R.id.bt_tablelayout,
            R.id.bt_gridlayout, R.id.bt_radiogroup, R.id.bt_checkbox, R.id.bt_absolutelayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_view:
                doToast();
                break;
            case R.id.bt_textview:
                startActivity(new Intent(this, TextViewActivity.class));
                break;
            case R.id.bt_button:
                startActivity(new Intent(this, ButtonActivity.class));
                break;
            case R.id.bt_edittext:
                startActivity(new Intent(this, EditTextActivity.class));
                break;
            case R.id.bt_prograssbar:
                startActivity(new Intent(this, PrograssbarActivity.class));
                break;
            case R.id.bt_imageview:
                startActivity(new Intent(this, ImageViewActivity.class));
                break;
            case R.id.bt_radiogroup:
                /**
                 * RadioButton常用属性
                 * android:checked 指定该RadioButton初始化时是否被选中。
                 * android:text是RadioButton上的文本内容
                 *
                 * RadioGroup常用属性
                 * android:orientation 指定RadioGroup中dRadioButton的排列方式
                 * android：checkedButton 指定默认被选中按钮。
                 */
                doToast();
                break;
            case R.id.bt_checkbox:
                // CheckBox常用属性:android:checked
                doToast();
                break;
            case R.id.bt_linearlayout:
                startActivity(new Intent(this, LinearlayoutActivity.class));
                break;
            case R.id.bt_relativelayout:
                startActivity(new Intent(this, RelativelayoutActivity.class));
                break;
            case R.id.bt_framelayout:
                startActivity(new Intent(this, FramelayoutActivity.class));
                break;
            case R.id.bt_tablelayout:
                // 表格布局
                startActivity(new Intent(this, TablelayoutActivity.class));
                break;
            case R.id.bt_gridlayout:
                startActivity(new Intent(this, GridlayoutActivity.class));
                break;
            case R.id.bt_absolutelayout:
                Toast.makeText(this, "目前已弃用", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(this, AbsolutelayoutActivity.class));
                break;
        }
    }


    /**
     * View 类是所有可视化控件的基，主要提供了绘制和事务处理方法。 类是所有可视化控件的基，主要提供了绘制和事务处理方法。
     * 类是所有可视化控件的基，主要提供了绘制和事务处理方法。View 的父类是 Object 。下图是 View 类的 常用方法及对应类的java方法
     * <p>
     * View类常用属性及对应方法：
     * 属性名称               对应方法                    描述
     * android:background   setBackgroundResource(int)    设置背景
     * android:clickable    setClickable(boolean)         设置View是否响应单击事件
     * android:visbility    setVisibility                 控制View的可见性
     * android:focusable    setFocusable(boolean)         控制View是否可以获得焦点
     * android:id           setId(int)                    为View设置标识符，可通过findViewById()方法获取
     * android:longClickable setLongClickable(boolean)    设置View是否响应长点击事件
     * <p>
     * android:soundEffectsEnabled setSoundEffectsEnabled(boolean) 设置当View触发点击等事件时是否播放音效
     * android:saveEnabled   setSaveEnabled(boolean)       如果未作设置，当View被冻结时将不会保存其状态
     * android:nextFocusDown  setNextFocusDownId(boolean)  定义当向下搜索时应该获取焦点的View, 如果该View不存在或不可见，则会抛出RuntimeException异常
     * android:nextFocusLeft  setNextFocusLeftId(boolean)   定义当向左搜索时应该获取焦点的View
     * android:nextFocusRight  setNextFocusRightId(boolean)  定义当向右搜索时应该获取焦点的View
     * android:nextFocusUp  setNextFocusUpId(boolean)    定义当向上搜索时应该获取焦点的View
     */
    private void doToast() {
        Toast.makeText(this, "见代码注释", Toast.LENGTH_SHORT).show();
    }



}
