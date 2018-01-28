package com.example.jinhui.androiddemo.day3.interface1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jinhui.androiddemo.MainActivity;
import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day3.intent.Jump2Activity;
import com.example.jinhui.androiddemo.day3.intent.Jump3Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/27.
 * Email:1004260403@qq.com
 * <p>
 * 界面、界面跳转
 * <p>
 * (1)setContentView()方法的使用
 * 使用布局文件id作为实参 View对象为实参
 * <p>
 * setContentView这个方法是用来显示界面的，使用该方法的时候都是把一个布局文件的ID号传入，例如：setContentView（R.layout.xxx）。
 * <p>
 * 除了这种方式传参，我们还可以讲一个view对象作为参数传入，
 * 例如，setContentView（view），下面所讲的内容都将会以这种方式传参。
 * <p>
 * (2)Java代码中创建View对象
 * 使用UI控件类对象创建View对象
 * 使用LayoutInflater类对象创建View对象
 * (3)
 * 对界面动态的增加与删除View
 * <p>
 * Android四大组件之Activity跳转
 * 一个Android应用程序通常都会包含多个Activity，但只有一个Activity会作为程序的入口，当该 Android应用 程序运行时将会自动启并执该Activity。其他的Activity会由入口Activity或者入口 Activity启动的Activity去启动。
 * <p>
 * Activity生命周期是由系统框架层的Activity Manager来管理。
 * <p>
 * 介绍一个概念Intent。
 * Intent中文意思是“意图”，是Android 程序中各组件之间进行交互的一种重要方式，它不仅可以指明当前组件想要执行的动作，还可以在不同组件之间传递数据。我们可以把
 * Intent想象成一个邮差，他可以传递消息，还可传递包裹。
 * <p>
 * Intent分为显示意图和隐式意图。
 * <p>
 * 显示意图
 * 通过指定Intent组件名称来实现的，它一般用在知道目标组件名称的前提下，
 * 一般是在相同的应用程序内部实现的。
 * <p>
 * 首先，我们要自己新建一个Activity类来作为我们跳转的界面，之前已讲解
 * 过如何创建。
 * 隐式意图
 */

public class InterfaceActivity extends AppCompatActivity {

    @BindView(R.id.bt_ui)
    Button btUi;
    @BindView(R.id.bt_LayoutInflater)
    Button btLayoutInflater;
    @BindView(R.id.bt_add_remove)
    Button btAddRemove;
    @BindView(R.id.bt_jump1)
    Button btJump1;
    @BindView(R.id.bt_jump2)
    Button btJump2;
    @BindView(R.id.bt_intent1)
    Button btIntent1;
    @BindView(R.id.bt_intent2)
    Button btIntent2;
    @BindView(R.id.bt_example)
    Button btExample;
    @BindView(R.id.bt_alpha)
    Button btAlpha;
    @BindView(R.id.bt_translate)
    Button btTranslate;
    @BindView(R.id.bt_scale)
    Button btScale;
    @BindView(R.id.bt_rotate)
    Button btRotate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_ui, R.id.bt_LayoutInflater, R.id.bt_add_remove,
            R.id.bt_example, R.id.bt_intent1, R.id.bt_intent2,
            R.id.bt_jump1, R.id.bt_jump2, R.id.bt_alpha,
            R.id.bt_translate, R.id.bt_scale, R.id.bt_rotate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_ui:
                startActivity(new Intent(this, UiActivity.class));
                break;
            case R.id.bt_LayoutInflater:
                startActivity(new Intent(this, LayoutInflaterActivity.class));
                break;
            case R.id.bt_add_remove:
                startActivity(new Intent(this, Add_removeActivity.class));
                break;
            case R.id.bt_example:
                startActivity(new Intent(this, ExampleActivity.class));
                break;
            case R.id.bt_intent1:
                // 创建Intent()意图对象
                Intent intent = new Intent();
                intent.setClass(this, ExampleActivity.class);
                // 执行意图(邮差出发)
                startActivity(intent);
                break;
            case R.id.bt_intent2:
                doIntent2();
                break;
            case R.id.bt_jump1:
                Toast.makeText(this, "简单跳转，不处理", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_jump2:
                String msg = "aaaa";
                startActivity(new Intent(this, Jump2Activity.class)
                        .putExtra("msg", msg));
                break;
            case R.id.bt_alpha:
                startActivity(new Intent(this, Jump3Activity.class));
                // alpha动画
                overridePendingTransition(R.anim.alpha_enter, R.anim.alpha_exit);
                break;
            case R.id.bt_translate:
                startActivity(new Intent(this, Jump3Activity.class));
                // translate动画
                overridePendingTransition(R.anim.translate_enter, R.anim.translate_exit);
                break;
            case R.id.bt_scale:
                startActivity(new Intent(this, Jump3Activity.class));
                // scale动画
                overridePendingTransition(R.anim.scale_enter, R.anim.scale_exit);
                break;
            case R.id.bt_rotate:
                startActivity(new Intent(this, Jump3Activity.class));
                // rotate动画
                overridePendingTransition(R.anim.rotate_enter, R.anim.rotate_exit);
                break;
        }
    }

    /**
     * Android中原生的界面跳转看起来会很生硬，可以自定义切换动画来更改界面跳转的效果，让用户有一种耳目一新的感觉。使用这种切换动画可以设置Activity的移动、旋转、缩放以及透明度的变化效果。
     * 这里会用到overridePendingTransition(int enterAnim, int exitAnim)这个方法，该方法用于设置Activity界面切换时的动画。enterAnim表示另一个Activity进入时的动画，exitAnim表示当前Activity退出时的动画，需要创建两个xml文件来设定进入和退出的动画效果。
     * 在res目录下创建一个anim的文件夹，该文件夹下存放用于进行切换动画的
     * xml文件，scale_enter.xml和exit.xml。
     */


    /**
     * 通过Intent Filter来实现的，它一般用在没有明确指出目标组件名称的
     * 前提下，一般是用于在不同应用程序之间。
     * <p>
     * 下面是一个隐式意图跳转的实例，需要AndroidManifest.xml中增加
     * Activity的声明，并设置对应的Intent Filter和Action，才能被Android的
     * 应用程序框架所匹配。
     */
    private void doIntent2() {
        startActivity(new Intent().setAction("selector"));
    }


}
