package com.example.jinhui.androiddemo.day5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day5.finishall.Tool;
import com.example.jinhui.androiddemo.day5.finishall.finishall1.SecondActivity;
import com.example.jinhui.androiddemo.day5.finishall.finishall2.Second1Activity;
import com.example.jinhui.androiddemo.day5.launchmode.SingleInstanceActivity;
import com.example.jinhui.androiddemo.day5.launchmode.SingleTaskActivity;
import com.example.jinhui.androiddemo.day5.launchmode.SingleTopActivity;
import com.example.jinhui.androiddemo.day5.launchmode.StandardActivity;
import com.example.jinhui.androiddemo.day5.save.SaveActivity;
import com.example.jinhui.androiddemo.day5.xuliehua.Me;
import com.example.jinhui.androiddemo.day5.xuliehua.SerialActivity;
import com.example.jinhui.androiddemo.day5.xuliehua.Surprise;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 * <p>
 * Android 四大组件之Activity
 * Activity是Android组件中最基本也是最为常见用的四大组件：
 * （Activity，Service服务, Content Provider内容提供者，BroadcastReceiver广播接收器）之一 。
 * <p>
 * Activity是一个应用程序组件，提供一个屏幕，用户可以用来交互为了完成某项任务。Activity中所有操作都与用户密切相关，是一个负责与用户交互的组件，可以通过setContentView(View)来显示指定控件。
 * <p>
 * 在一个android应用中，一个Activity通常就是一个单独的屏幕，它上面可以显示一些控件也可以监听并处理用户的事件做出响应。Activity之间通过Intent进行通信。
 * <p>
 * 1)Activity生命周期概念
 * Activity的生命周期指的是，Activity对象从被创建到销毁的全过程。
 * <p>
 * 2)Activity的状态
 * 运行状态（Running）
 * 该状态表示Activity可见并且拥有用户焦点。
 * <p>
 * 暂停状态（Paused）
 * 如果Activity A被Activity B覆盖了一部分，但是Activity A又是可见的，那么Activity A就处于暂停状态，(类似对话框形式)。
 * <p>
 * 停止状态（Stop）
 * 如果Activity A被Activity B完全覆盖，或者由于用户点击Home按钮导致Activity A处于后台。那么Activity A就处于停止状态；
 * <p>
 * Killed状态
 * 被系统杀死回收或者没有被启动时处于 Killed状态。
 * <p>
 * 3)Activity生命周期的7个回调函数
 * 1.public void onCreate(Bundle savedInstanceState)
 * 一个 Activity 的实例被启动时调用的第一个方法。一般情况下，我们都
 * 覆盖该方法作为应用程序的一个入口点，在这里做一些初始化数据、设置用户界面等工作。大多数情况下，我们都要在这里从 xml 中加载设计好的用户界面。
 * 2.protected void onStart()
 * 该方法在 onCreate() 方法之后被调用，或者在
 * Activity 从 Stop 状态转换为 Active 状态时被调用
 * 3.protected void onRestart ()
 * 在 Activity 从 Pause 状态转换到 running 状态时被调用。
 * 4.protected void onResume()
 * 在 执行完onStart（）方法后被调用，获得焦点，用户可以点击屏幕进行交互。
 * 5.protected void onPause()
 * 当需要切断Activity与用户进行交互时被系统回调，失去焦点，用户点击无法交互。从running状态转换到Pause状态。
 * 6.protected void onStop()
 * 在 Activity 从 Pause 状态转换到 Stop 状态时被调用。
 * 7.protected void onDestroy()
 * 在 Active 被结束时调用，它是被结束时调用的最后一个方法，在这里一
 * 般做些释放资源，清理内存等工作。
 * <p>
 * 各个方法的调用时机
 * 例子：我们主要验证四个方面：
 * 1. Activity启动
 * 2. Activity启动后转入后台运行（即按home键）
 * 3. Activity从stop状态转为Running状态
 * 4. Activity退出
 * <p>
 * 1.启动项目时会按顺序执行onCreate、onStart、onResume
 * 2.启动后按下home键，APP界面消失转入后台运行，
 * 可以看到，按下home键后会执行 onPause、onStop，失去焦点，界面消失
 * 进入Stop状态。
 * 3.项目启动后转为后台运行，并再次转为前台运行，当我们再次启动时（在手机任务管理里点击该APP启动），
 * 系统会依次调用onRestart、onStart、onResume
 * <p>
 * 4)Activity生命周期回调函数对于实际开发存在什么样的意义？
 * 在Activity的不同时期，系统会自动回调它的一系列回调函数。
 * 那么，我们就可以重写Activity的这些回调方法。添加我们想要的行为。比如我们启动Activity时加载一些本地数据，或者退出activity时要保存我们需要的一些数据等等。
 * <p>
 * 5)Activity状态存储
 * 在Activity中保存用户的当前操作状态非常重要，如在写短信的时候接到一个电话，那么当你接电话的时候短信界面就会别隐藏，那么我们希望接完电话后可以继续编辑短信，就需要保存状态。
 * <p>
 * 当系统由于内存不足或其他原因，自动销毁某一个Activity时，系统会回调该
 * Activity的onSaveInstanceState方法。如果再次启动该Activity时，系统又会回调该Activity的onRestoreInstanceState方法。因此，用户可以重写Activity
 * 的onSaveInstanceState方法，并通过outState参数保存键值对数据。当系统
 * 回调onRestoreInstanceState方法时，用户再从savedInstanceState参数中，获取之前保存的键值对。
 * <p>
 * 在这里可以利用横竖屏切换来模拟，因为屏幕切换时
 * activity会被先销毁，再从新创建。下面是设置横屏和竖屏的方法：
 */

public class ActivityActivity extends AppCompatActivity {


    private static final String TAG = ActivityActivity.class.getSimpleName();
    @BindView(R.id.bt_save)
    Button btSave;
    @BindView(R.id.bt_standard)
    Button btStandard;
    @BindView(R.id.bt_singleTop)
    Button btSingleTop;
    @BindView(R.id.bt_singleTask)
    Button btSingleTask;
    @BindView(R.id.bt_singleInstance)
    Button btSingleInstance;
    @BindView(R.id.bt_finishall_1)
    Button btFinishall1;
    @BindView(R.id.bt_finishall_2)
    Button btFinishall2;
    @BindView(R.id.bt_serial)
    Button btSerial;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        ButterKnife.bind(this);
        //添加当前activity类对象到链表
        Tool.list.add(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @OnClick({R.id.bt_save, R.id.bt_standard, R.id.bt_singleTop,
            R.id.bt_singleTask, R.id.bt_singleInstance, R.id.bt_finishall_1,
            R.id.bt_finishall_2, R.id.bt_serial})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_save:
                startActivity(new Intent(this, SaveActivity.class));
                break;
            case R.id.bt_standard:
                startActivity(new Intent(this, StandardActivity.class));
                break;
            case R.id.bt_singleTop:
                startActivity(new Intent(this, SingleTopActivity.class));
                break;
            case R.id.bt_singleTask:
                startActivity(new Intent(this, SingleTaskActivity.class));
                break;
            case R.id.bt_singleInstance:
                startActivity(new Intent(this, SingleInstanceActivity.class));
                break;
            case R.id.bt_finishall_1:
                /**
                 * 1.定义Tool类,管理Activity
                 public class Tool{
                 //静态链表
                 public static List<Activity> list = new ArrayList<Activity>();
                 }
                 2.分别让MainActivity、SecondActivity、ThirdActivity，在每一个Activity里
                 //添加当前类对象到链表，注意理解类的继承
                 Tool.list.add(this);
                 跳转设置MainActivity->SecondActivity->ThirdActivity,在ThirdActivity里面
                 添加语句
                 for (int i = 0; i < Tool.list.size(); i++) {
                 Tool.list.get(i).finish();
                 }
                 */
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.bt_finishall_2:
                /**
                 * 1.定义Tool类
                 public class Tool{
                 //静态链表
                 public static List<Activity> list = new ArrayList<Activity>();
                 }
                 2.创建BaseActivity继承Activity
                 //添加当前类对象到链表，注意理解类的继承
                 Tool.list.add(this);
                 2.分别让MainActivity、SecondActivity、ThirdActivity继承BaseActivity，
                 跳转设置MainActivity->SecondActivity->ThirdActivity,在ThirdActivity里面
                 添加语句
                 for (int i = 0; i < Tool.list.size(); i++) {
                 Tool.list.get(i).finish();
                 }

                 */
                startActivity(new Intent(this, Second1Activity.class));
                break;
            case R.id.bt_serial:
                /**
                 *
                 * Parcelable效率比Serializable要高，因为Serializable在序列化的时候会产生很多临时变量，影响他的效率
                 * 当要把数据写到磁盘上的时候，会采用Serializable方式
                 *
                 */
                Intent intent = new Intent();

                intent.setClass(this, SerialActivity.class);

                //bundle就相当于容器，里面可以存放很多数据
                Bundle bundle = new Bundle();

                Surprise surprise = new Surprise("原子弹", 20);
                //把要传递的类的对象绑定到bundle上
                bundle.putSerializable("data", surprise);
                //把bundle这个容器绑定到intent对象上
                intent.putExtras(bundle);

                startActivity(intent);

                Me me = new Me("Hello world", "lalalala");
                bundle.putParcelable("me", me);

                //把bundle这个容器绑定到intent对象上
                intent.putExtras(bundle);
                startActivity(intent);
                break;
        }
    }
}
