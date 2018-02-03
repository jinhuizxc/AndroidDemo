package com.example.jinhui.androiddemo.day16.forcequit;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;

import com.example.jinhui.androiddemo.MainActivity;
import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class ForceQuitReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, Intent intent) {
        //弹出对话框

        Log.d("Test", "收到广播，弹出对话框");
        // android.content.ReceiverCallNotAllowedException: BroadcastReceiver components are not allowed to register to receive intents
        /**
         * 解决方法：
         *
         在Android开发中
         1、bindService不能在BroadcastReceiver 中调用，你可以在里面调用StartService并把要传递参数放到intent中
         2、registerReceiver不能在BroadcastReceiver调用，可以通过context.getApplicationContext().registerReceiver();解决，我测试成功
         其他的android.content.ReceiverCallNotAllowedException也可以通过context.getApplicationContext()，不过我没有测试。
         */

//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setTitle("下线");
//        builder.setMessage("系统强制下线");
//
//        //设置对话框不能取消
//        builder.setCancelable(false);
//        AlertDialog dialog = builder.create();
//        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
//        dialog.show();
//
//        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                //再次打开登录界面
//                Intent intent = new Intent(context, MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
//            }
//        });

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        // 设置对话框标题栏
        builder.setTitle("标题");
        // 对话框正文
        builder.setMessage("是否退出应用程序");
        builder.setIcon(R.drawable.ic_launcher);
        // 设置对话框按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.setNegativeButton("取消", null);
        builder.setNeutralButton("中间", null);
        // 创建对话框
        builder.create();
        AlertDialog dialog = builder.create();
        dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        // 显示对话框
        dialog.show();
    }

}
