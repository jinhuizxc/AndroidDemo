package com.example.jinhui.androiddemo.day13;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jinhui.androiddemo.MainActivity;
import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 * <p>
 * 高级界面05
 * <p>
 * Intent意图：
 * Intent的作用 ：
 * 是执行一个动作的抽象描述，封装了动作的意图。封装了启动组件到被启动组件之间传递的信息。
 * 提供了统一的编程模式。
 * 主要用于启动Activity、Service、和传递广播。
 * <p>
 * Intent的类型：
 * <p>
 * 显式 Intent：
 * 按名称（完全限定类名）指定要启动的组件。通常会在应用中使用显式 Intent 来启动组件。创建显式 Intent 启动 Activity 或服务时，系统将立即启动 Intent 对象中指定的应用组件。
 * <p>
 * 隐式 Intent ：
 * 不会指定特定的组件，而是声明要执行的常规操作，从而允许其他应用中的组件来处理它。
 * 创建隐式 Intent 时，系统将Intent的内容，与设备上所有应用清单文件中的Intent过滤器比较，找到需要启动的相应组件。
 * 如果 Intent 与某个组件的Intent 过滤器匹配，系统将启动该组件。若匹配多个，系统则会显示一个对话框，将选择权交于用户。
 * <p>
 * Component属性：
 * Component在使用时要指定包名和类名，这样就可以唯一的确定一个组件类。这样应用程序就可以根据指定的组件类启动特定的组件。
 * 方法一
 * <p>
 * //创建一个ComponentName对象
 * ComponentName cp = new ComponentName(MainActivity.this,SecondAc.class);
 * Intent intent = new Intent();
 * intent.setComponent(comp);   // 为Intent设置Component属性
 * startActivity(intent);
 * 方法二
 * <p>
 * Intent intent = new Intent(MainActivity.this,SecondAc.class);
 * startActivity(intent);
 * 方法三
 * <p>
 * ComponentName cp = new ComponentName(MainActivity.this, "com.fs.SecondActivity");
 * Intent intent = new Intent();
 * intent.setComponent(comp);
 * startActivity(intent);
 * 方法四
 * <p>
 * //启动本项目的任意的Activity或别的项目的首页的Activity
 * ComponentName cp = new ComponentName("com.fs"   ,"com.fs.SecondActivity");
 * Intent intent = new Intent();
 * intent.setComponent(comp);
 * startActivity(intent);
 * <p>
 * Action、Category属性与intent-filter
 * Intent的Action 和Category属性都是普通字符串信息，其中Action代表Intent要完成的抽象的动作。 Category 用于为Action增加额外的信息。Action与Category要配合使用，Action并不关心被启动的是Activity、Service、还是广播，并且也不关心具体是哪一个组件。
 * <p>
 * 至于启动的是哪个组件，取决于组件的<intent-filter>配置。Intent属性Action、Category只要与某个组件的<intent-filter>配置包含了相同的配置内容，那么这个组件就有可能被启动。
 * <p>
 * 一个intent-filter中可以配置多个action与多个category 配置了action的就必须配置category
 * <p>
 * 启动时，如果出现多个匹配的条件，则手机会弹出选择对话框，具体启动那个组件由用户决定。
 * Data、Type属性
 * 设置Data属性, 即设置Uri对象。
 * Intent中设置了Data或同时设置了Data和Type那么符合Intent条件配置的组件可以被启动。当Intent不指定Data的Type属性时，Type属性才会起作用。否则系统会根据Data属性值来分析数据类型，因此无需指定Type属性。
 * Intent intent = new Intent();
 * intent.setAction(Intent.ACTION_VIEW);
 * intent.setData(Uri.parse("http://www.farsight.cn"));
 * startActivity(intent);
 * Extra属性
 * 传递数据用的属性，类型为Bundle（容器）。
 * Flag属性
 * Flag可用于为该Intent添加一些额外的控制旗标。
 * <p>
 * ACTIVITYBROUGHTTOFRONT：如果通过该Flag启动的Activity已经存在，再次启动时，将只是将该Activity带到前台。
 * ACTIVITYCLEAR_TOP：该Flag相当于加载模式中的singleTask。
 * ACTIVITYNEW_TASK：默认的启动旗标，该旗标控制重新创建一个新的Activity。
 * ACTIVITYNO_ANIMATION：该旗标会控制启动Activity时不使用过渡动画。
 * ACTIVITYNO_HISTORY：该旗标控制被启动的Activity将不会保留在Activity栈中。
 * ACTIVITYREORDERTOFRONT：该Flag控制如果当前已有该Activity，直接将该Activity带到前台。
 * ACTIVITYSINGLE_TOP：相当于加载模式的singleTop模式。
 * //跳到MainAct,如果存在MainAct,则直接使用,并把MainAct
 * //上面的Activity会部销毁,相当于加载模式中的singleTask
 * <p>
 * Intent intent = new Intent();
 * intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
 * intent.setClass(ThreeAct.this, MainAct.class);
 * startActivity(intent);
 * <p>
 * <p>
 * 启动系统应用—打电话
 * <p>
 * Intent intent = new Intent();
 * intent.setAction(Intent.ACTION_CALL);
 * intent.setData(Uri.parse("tel:" + 10086));
 * startActivity(intent);
 * <p>
 * 添加权限：
 * <uses-permission android:name="android.permission.CALL_PHONE"/>
 * 调用系统发信息应用
 * <p>
 * Intent intent = new Intent();
 * intent.setAction(Intent.ACTION_SENDTO);
 * intent.setData(Uri.parse("smsto:" + 10086));
 * intent.putExtra("sms_body","你好");
 * startActivity(intent);
 * <p>
 * 添加权限：
 * <uses-permission android:name="android.permission.SEND_SMS"/>
 */

public class AdvanceInterface5Activity extends AppCompatActivity {

    @BindView(R.id.bt_intent)
    Button btIntent;
    @BindView(R.id.bt_component)
    Button btComponent;
    @BindView(R.id.bt_call)
    Button btCall;
    @BindView(R.id.bt_message)
    Button btMessage;
    @BindView(R.id.bt_internet)
    Button btInternet;
    @BindView(R.id.bt_flag)
    Button btFlag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanceinterface5);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.bt_intent, R.id.bt_component, R.id.bt_call,
            R.id.bt_message, R.id.bt_internet, R.id.bt_flag})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.bt_intent:
                Toast.makeText(this, "见代码注解", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_component:
                //跨进程启动组件
                //参数：包名 +将要启动的组件的类的全名
                //启动本项目的任意的Activity或别的项目的首页的Activity
                ComponentName comp = new ComponentName("com.example.jinhui.androiddemo", "com.example.jinhui.androiddemo.MainActivity");
                intent = new Intent();
                intent.setComponent(comp); // 为Intent设置Component属性
                startActivity(intent);
                break;
            case R.id.bt_call:
                // 需要添加权限
                intent = new Intent();
                //设置隐式意图，启动拨号界面
                intent.setAction(Intent.ACTION_CALL);
                //tel: img: video: ...
                Uri uri = Uri.parse("tel:10086");
                intent.setData(uri);
                startActivity(intent);
                break;
            case R.id.bt_message:
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_SENDTO);
                intent2.setData(Uri.parse("smsto:" + 10086));
                intent2.putExtra("sms_body", "你好");
                startActivity(intent2);
                break;
            case R.id.bt_internet:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                break;
            case R.id.bt_flag:
                //跳到MainActivity,如果存在MainActivity,则直接使用,
                // 并把MainActivity上面的Activity会部销毁,相当于加载模式中的singleTask
                intent = new Intent();
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setClass(this, MainActivity.class);
                startActivity(intent);
                break;

        }
    }

}
