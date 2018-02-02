package com.example.jinhui.androiddemo.day14;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day14.all.AllActivity;
import com.example.jinhui.androiddemo.day14.bindservice.BindService;
import com.example.jinhui.androiddemo.day14.calculator.CalculatorActivity;
import com.example.jinhui.androiddemo.day14.countservice.CountService;
import com.example.jinhui.androiddemo.day14.service.MyService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/2.
 * Email:1004260403@qq.com
 */

public class Service1Activity extends AppCompatActivity {

    private static final String TAG = "Service1Activity";
    @BindView(R.id.bt_intentservice)
    Button btIntentservice;
    @BindView(R.id.bt_downloadseervice)
    Button btDownloadseervice;
    @BindView(R.id.bt_countservice)
    Button btCountservice;
    @BindView(R.id.bt_bindservice)
    Button btBindservice;
    @BindView(R.id.bt_stopservice)
    Button btStopservice;
    @BindView(R.id.bt_stopDownloadService)
    Button btStopDownloadService;
    @BindView(R.id.bt_stopcount)
    Button btStopcount;
    @BindView(R.id.et_max)
    EditText etMax;
    @BindView(R.id.bt_unbindservice)
    Button btUnbindservice;
    @BindView(R.id.tv_bind)
    TextView tvBind;
    @BindView(R.id.bt_count)
    Button btCount;
    @BindView(R.id.bt_calculator)
    Button btCalculator;
    @BindView(R.id.bt_all)
    Button btAll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service1);
        ButterKnife.bind(this);
    }

    @SuppressLint("SetTextI18n")
    @OnClick({R.id.bt_intentservice, R.id.bt_stopservice, R.id.bt_downloadseervice,
            R.id.bt_stopDownloadService, R.id.bt_countservice, R.id.bt_stopcount,
            R.id.bt_bindservice, R.id.bt_unbindservice, R.id.bt_count,
            R.id.bt_calculator, R.id.bt_all})
    public void onViewClicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.bt_intentservice:
                // 启动服务
                intent = new Intent();
                intent.setClass(this, MyService.class);
                startService(intent);
                break;
            case R.id.bt_stopservice:
                // 关闭服务
                stopService(new Intent(this, MyService.class));
                break;
            case R.id.bt_downloadseervice:
                //启动下载服务
//                startService(new Intent("com.example.jinhui.androiddemo.day14.service.DownLoadService"));

                // java.lang.IllegalArgumentException: Service Intent must be explicit: Intent { act=com.example.jinhui.androiddemo.day14.service.DownLoadService }
                // Android之后不允许隐式意图启动服务，这点需要知道
                // 这里提供两种方法解决这个问题：（方法1、2亲测可行）

                // 1.设置Action和Package名
                //为 Intent设置Action属性 ,Android 5.0之后就要求只能使用显示的Intent启动Service
//                intent = new Intent();
//                intent.setAction("DownLoadService");//设置Action
//                intent.setPackage("com.example.jinhui.androiddemo");//设置包名
//                startService(intent);

                // 2.将隐式启动转为显示启动
                intent = new Intent();
                intent.setAction("DownLoadService");
                Intent mintent = new Intent(getExplicitIntent(this, intent));//转换成显示Intent
                startService(mintent);
                break;
            case R.id.bt_stopDownloadService:
                //关闭下载服务
                // 方法1
//                intent = new Intent();
//                intent.setAction("DownLoadService");//设置Action
//                intent.setPackage("com.example.jinhui.androiddemo");//设置包名
//                stopService(intent);

                // 方法2
                intent = new Intent();
                intent.setAction("DownLoadService");
                Intent mintent1 = new Intent(getExplicitIntent(this, intent));//转换成显示Intent
                stopService(mintent1);
                break;
            case R.id.bt_countservice:
                int number = Integer.parseInt(etMax.getText().toString());
                intent = new Intent(this, CountService.class);
                intent.putExtra("max", number);
                startService(intent);
                break;
            case R.id.bt_stopcount:
                // 取消计数,
                // 注意：目前这样的把服务停止了，但是开的thread还在进行，还在计数，需要把线程的计数也终止掉，
                // 采取的措施：加上boolean isRun; 加以控制！见代码
                stopService(new Intent(this, CountService.class));
                break;
            case R.id.bt_bindservice:
                //绑定服务
                intent = new Intent(this, BindService.class);
                bindService(intent, conn, Context.BIND_AUTO_CREATE);
                break;
            case R.id.bt_unbindservice:
                //解除绑定
                unbindService(conn);
                break;
            case R.id.bt_count:
                // 这样仅仅是手动获取想要的计数的值，不是要的效果！
                //显示计数的值
                int count = myBinder.getCount();
                tvBind.setText("显示的数据：" + String.valueOf(count));
                break;
            case R.id.bt_calculator:
                startActivity(new Intent(this, CalculatorActivity.class));
                break;
            case R.id.bt_all:
                startActivity(new Intent(this, AllActivity.class));
                break;
        }
    }

    BindService.MyBinder myBinder;
    // 服务的连接对象，用来接收服务中的信息(服务start,stop的信息)
    public ServiceConnection conn = new ServiceConnection() {

        // 当服务绑定到Activity上时，自动调用该方法，接收信息
        @SuppressLint("SetTextI18n")
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "onServiceDisconnected");
            myBinder = (BindService.MyBinder) service;
            // 显示最大数值
//            int max = myBinder.getMax();
//            tvBind.setText("显示最大数值：" + String.valueOf(max));


            //显示计数器的值
            // 只是保证了服务的正确连接，不会实时显示tvBind的text的值
//            int count = myBinder.getCount();
//            tvBind.setText(String.valueOf(count));
        }

        // 当服务异常停止时，自动调用该方法，接收信息
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(TAG, "onServiceDisconnected");
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
        // 解除服务绑定
        unbindService(conn);
    }

    //将隐式启动转换为显式启动,兼容编译sdk5.0以后版本
    public Intent getExplicitIntent(Context context, Intent implicitIntent) {
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(implicitIntent, 0);
        if (resolveInfos == null || resolveInfos.size() != 1) {
            return null;
        }
        Intent explicitIntent = null;
        ResolveInfo info = resolveInfos.get(0);
        String packageName = info.serviceInfo.packageName;
        String className = info.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);
        explicitIntent = new Intent(implicitIntent);
        explicitIntent.setComponent(component);
        return explicitIntent;
    }
}
