package com.example.jinhui.androiddemo.day4;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/28.
 * Email:1004260403@qq.com
 * <p>
 * Activity带返回值跳转、
 * 如果想在Activity中得到新打开Activity关闭后返回的数据，
 * <p>
 * 1.需要使用系统提供的startActivityForResult(Intent intent, int requestCode)方法打开新的Activity，
 * 2.新的Activity写好数据通过setResult(resultCode, data)将值返回给Activity；
 * 当前Activity关闭后会向前面的Activity传回数据，
 * 3.为了得到传回的数据，必须在前面的Activity中重写onActivityResult(int requestCode, int resultCode, Intent data)方法。
 * <p>
 * 请求码的作用：
 * 使用startActivityForResult(Intent intent, int requestCode)方法打开新的Activity，
 * 我们需要为startActivityForResult()方法传入一个请求码(第二个参数)。
 * 请求码的值是根据业务需要由自已设定，用于标识请求来源。
 * 例如：一个Activity有两个按钮，点击这两个按钮都会打开同一个Activity，
 * 不管是那个按钮打开新Activity，当这个新Activity关闭后，
 * 系统都会调用前面Activity的onActivityResult(int requestCode, int resultCode, Intent data)方法。
 * 在onActivityResult()方法如果需要知道新Activity是由那个按钮打开的，并且要做出相应的业务处理
 * <p>
 * <p>
 * 界面全屏和对话框形式、
 * 就目前我们自己所写的APP运行后会发现在屏幕的上方会有状态栏和标题栏：
 * 在实际应用程序开发中，我们有时需要把 Activity 设置成全屏显示，如游戏或者播放视频。
 * 一般情况下，可以通过两种方式来设置全屏显示效果。
 * 其一，通过AndroidManifest配置文件来设置全屏，
 * 其二，通过在代码中可以设置。
 * <p>
 * activity的销毁
 * 1.返回键：
 * 使用这种方式时，系统会调用onDestory（）方法，其
 * 占用的资源也会被释放。
 * 2.finish()方法
 * 调用该方法后会结束当前activity的生命周期，
 * 在 Activity对象被销毁之前，系统会调用onDestory（）方法，其
 * 占用的资源也会被释放。
 * <p>
 * onKeyDown方法，
 * 该方法是接口KeyEvent.Callback中的抽象方法，所有的View全部实现了该接口并重写了该方法，该方法用来捕捉手机键盘被按下的事件,比如返回键、home键等。通过onKeyDown方法，可以对物理外键的事件进行相对应的处理，比如当用户按下返回键时，可以弹出一个对话框进行友好提示，避免用户因为不小心按下而导致退出了程序或者返回了其他界面。
 * <p>
 * Java代码如下：
 * public boolean onKeyDown(int keyCode, KeyEvent event)
 * 参数keyCode，该参数为被按下的键值即键盘码，手机键盘中每个按钮都会有其单独的键盘码，在应用程序都是通过键盘码才知道用户按下的是哪个键。
 * 参数event，该参数为按键事件的对象，其中包含了触发事件的详细信息，例如事件的状态、事件的类型、事件发生的时间等。当用户按下按键时，系统会自动将事件封装成KeyEvent对象供应用程序使用。
 * <p>
 * 返回值，该方法的返回值为一个boolean类型的变量，当返回true时，表示已经完整地处理了这个事件，并不希望其他的回调方法再次进行处理，而当返 回false时，表示并没有完全处理完该事件，更希望其他回调方法继续对其进行处理，例如Activity中的回调方法。
 * 下面通过一个实例来看看该方法的具体用法，点击两次返回键退出：
 * 见笔记代码！
 */

public class Interface2Activity extends AppCompatActivity {

    @BindView(R.id.bt_intentback)
    Button btIntentback;
    @BindView(R.id.bt_fullscreen)
    Button btFullscreen;
    @BindView(R.id.bt_activity_dialog)
    Button btActivityDialog;
    @BindView(R.id.tv_back)
    TextView tvBack;
    @BindView(R.id.tv_back1)
    TextView tvBack1;
    @BindView(R.id.bt_intentback1)
    Button btIntentback1;
    @BindView(R.id.bt_fullscreen_java)
    Button btFullscreenJava;
    @BindView(R.id.bt_onkeyown)
    Button btOnkeyown;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface2);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_intentback, R.id.bt_intentback1, R.id.bt_fullscreen,
            R.id.bt_fullscreen_java, R.id.bt_activity_dialog, R.id.bt_onkeyown})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_intentback:
                // 打开新的activity, 设置请求码
                startActivityForResult(new Intent(this, IntentBackActivity.class), 1);
                break;
            case R.id.bt_intentback1:
                // 打开新的activity, 设置请求码
                startActivityForResult(new Intent(this, IntentBackActivity.class), 2);
                break;
            case R.id.bt_fullscreen:
                startActivity(new Intent(this, FullscreenActivity.class));
                break;
            case R.id.bt_fullscreen_java:
                startActivity(new Intent(this, FullscreenJavaActivity.class));
                break;
            case R.id.bt_activity_dialog:
                startActivity(new Intent(this, DialogActivity.class));
                break;
            case R.id.bt_onkeyown:
                startActivity(new Intent(this, OnkeyDownActivity.class));
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        return super.onKeyDown(keyCode, event);
        if(keyCode == KeyEvent.KEYCODE_BACK){

            Toast.makeText(this, "退出键", Toast.LENGTH_SHORT).show();
			/*
			 * 1、创建builder对象
			 * 2、设置标题
			 * 3、设置内容
			 * 4、设置确定按钮，并且对其监听
			 * 5、设置取消按钮
			 * 6、创建对话框
			 * 7、显示对话框
			 */
            //创建builder对象
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            //设置标题
            builder.setTitle("是否退出？");
            //设置内容
            builder.setMessage("请选择确定or取消？");
            //设置确定按钮，并且监听
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            //设置取消按钮
            builder.setNegativeButton("取消", null);
            //创建对话框
            builder.create();
            //显示对话框
            builder.show();
        }

        //返回true相当于屏蔽返回键
        return true;
    }

    /**
     * 返回的数据就保存在意图对象data中，我们调用与数据类型对应的get方法可以得到数据
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    // 当用户加载的新activity退出时，该方法被系统自动调用
    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    // 获得返回的数据
                    String string = data.getStringExtra("msg");
                    tvBack.setText("接收到的返回数据1是:" + string);
                    break;
                case 2:
                    // 获得返回的数据
                    String string1 = data.getStringExtra("msg");
                    tvBack1.setText("接收到的返回数据2是:" + string1);
                    break;
            }
        }

    }

}
