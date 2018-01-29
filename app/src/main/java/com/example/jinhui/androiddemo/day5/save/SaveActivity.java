package com.example.jinhui.androiddemo.day5.save;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 * <p>
 * 横屏：
 * setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
 * 竖屏：
 * setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
 * <p>
 * 需要注意的是，如果界面中的控件有设置id号，系统会为我们自动保
 * 存其状态，不需要我们手动再保存一次。
 *
 *
 * 运行效果如下,切换到横屏时，文本框中数据被保存，没有id的多选按钮状
 态没被保存。
 需要注意的是，onSaveInstanceState()方法并不是一定会被调用的, 因
 为有些场景是不需要保存状态数据的. 比如用户按下BACK键退出activity时,
 用户显然想要关闭这个activity, 此时是没有必要保存数据以供下次恢复的,
 也就是onSaveInstanceState()方法不会被调用。

 还需要了解的是，在保存数据时onSaveInstanceState（）方法是在onStop（）方法之前调用，
 重新创建activity恢复数据时onRestoreInstanceState（）方法在onStart（）方法之后调用。

 补充：
 Activity的 onSaveInstanceState() 和 onRestoreInstanceState()并不是生命周期方法，它们不同于 onCreate()、onPause()等生命周期方法，它们并不一定会被触发。
 当应用遇到意外情况（如：内存不足）由系统销毁一个Activity时，onSaveInstanceState() 会被调用。但是当用户主动去销毁一个Activity时，
 例如在应用中按返回键，onSaveInstanceState()就不会被调用。因为在这种情况下，用户的行为决定了不需要保存Activity的状态。
 通常onSaveInstanceState()只适合用于保存一些临时性的状态，而onPause()适合用于数据的持久化保存。
 另外，当屏幕的方向发生了改变， Activity会被摧毁并且被重新创建，如果你想在Activity被摧毁前缓存一些数据，
 并且在Activity被重新创建后恢复缓存的数据。可以重写Activity的 onSaveInstanceState() 和 onRestoreInstanceState()方法.
 注意：在Activity的onCreate(Bundle savedInstanceState)方法里面，该方法的参数与onRestoreInstanceState()方法中的参数一致，因此在onCreate()方法中也能恢复缓存的数据。
 */

public class SaveActivity extends AppCompatActivity {

    private static final String TAG = SaveActivity.class.getSimpleName();

    @BindView(R.id.bt_h)
    Button btH;
    @BindView(R.id.bt_s)
    Button btS;
    @BindView(R.id.et)
    EditText et;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        setContentView(R.layout.activity_save);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState");
        //保存数据
        outState.putString("msg", et.getText().toString());
        // 保存数据
//        outState.putString("data", et.getText().toString());
    }

    /**
     * 这个方法做什么用？
     * API 21为Activity增加了一个新的属性，只要将其设置成persistAcrossReboots，activity就有了持久化的能力，另外需要配合一个新的bundle才行，那就是PersistableBundle。
     onCreate(Bundle savedInstanceState, PersistableBundle persistentState)
     Same as onCreate(android.os.Bundle) but called for those activities created with the attribute persistableMode set to persistAcrossReboots.

     这里的持久化与传统意义的不同，它的具体实现在Activity重载的onSaveInstanceState、onRestoreInstanceState和onCreate方法。

     public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState)
     public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState)
     public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState)
     onSaveInstanceState和onRestoreInstanceState方法是一对拯救灾难的方法，它们不在“正常“的Activity生命周期中，
     只有一些突发异常情况才会触发它们，比如横竖屏切换、按Home键等。当API 21后增加了PersistableBundle参数，令这些方法有了系统关机重启后数据恢复的能力。
     只需在Manifest中的activity设置属性：
     android:persistableMode="persistAcrossReboots"
     然后在activity中直接用上述的三个方法即可。
     另外注意API版本是21及以上。

     * @param outState
     * @param outPersistentState
     */
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState");
        //获取保存的数据
        String str = savedInstanceState.getString("msg");
        et.setText(str);
//        // 取出保存的数据
//        et.setText(savedInstanceState.getString("data"));
    }

    @OnClick({R.id.checkBox, R.id.bt_h, R.id.bt_s})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.checkBox:
                break;
            case R.id.bt_h:
                // 横屏
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;
            case R.id.bt_s:
                // 竖屏
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
        }
    }
}
