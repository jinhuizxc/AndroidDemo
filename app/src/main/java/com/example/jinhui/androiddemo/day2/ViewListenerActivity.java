package com.example.jinhui.androiddemo.day2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/27.
 * Email:1004260403@qq.com
 * <p>
 * View的事件监听
 * 事件的监听有两种方式，基于事件监听处理和基于回调方法处理，
 * <p>
 * 这里先来介绍前者，回调方法处理在以后课程中介绍。
 * 要对view的事件监听就必须给该view对象设置监听器对象，这样事件产生后就会被监听器对象监听到，监听器对象会调用事件处理方法。同一个view对象会产生不同的事件，如点击事件，长按点击事件，触摸事件等等，这就需要给view对象设置不同的监听器对象。View的监听器类实计上就是相关接口的实现类，这些接口都是View类的内部静态接口。
 * 在1.6版本只有6个，发展到4.x后已经有10个了，如：
 * <p>
 * android.view.View.OnClickListener;
 * android.view.View.OnKeyListener;
 * android.view.View.OnLongClickListener;
 * android.view.View.OnTouchListener;
 * ……
 * <p>
 * View类中提供相应的方法来设置这些接口的实现类对象
 * (监听器对象)，这样当相应事件产生监听器对象就会调用回调方法，这里介绍两个：
 * <p>
 * 点击事件
 * view.setOnClickListener(OnClickListener 接口实现类对象），为点击事件；
 * 长按事件
 * view.setOnLongClickListener(OnLOngClickListener 接口实现类对象），为长按事件。
 * <p>
 * <p>
 * 理解事件源、事件、监听器概念
 * <p>
 * 获取UI控件对象
 * 使用控件时需要先获得控件的对象，调用Activity的方法findViewById(int id)
 * ，控件的对应ID传入即可。要注意的是该方法的返
 * 回值类型是View，注意类型的强转。如下所示：
 * <p>
 * protected void onCreate(Bundle savedInstanceState) {
 * super.onCreate(savedInstanceState);
 * setContentView(R.layout.activity_main);
 * <p>
 * //获得button对象，按钮对应的id是button1
 * Button bt = (Button) findViewById(R.id.button1);
 * }
 * <p>
 * 事件源
 * 事件源值得是事件发生的来源，也就是说某个事件是由什么产生的，事件源可以是UI控件、某个硬件、物理按键等。
 * <p>
 * 事件
 * 事件指的是在事件源上产生的特定事情，如Button(事件源)被点击会产生点击事件，屏(事件源)监听手势后产生的手势事件，封装了事件信息，该对象会被传到事件处理回调用方法的参数中。事件的触发方式一般存在三种情况：
 * <p>
 * (1) 用户的某种操作，如触屏、点击按钮、按"返回键"、按声音键等
 * (2) 硬件传感器作用事件，如GPS芯片接收到新的经纬度、磁场感应器接收到磁场的变化等 (3)
 * 系统设置改变事件，如屏幕方向设置改变、触摸屏触摸方式设置改变等
 * <p>
 * 监听器
 * 监听事件源发生的事件，并对被监听的事件做出相应的响应，如按钮的点击
 * 事件。
 * <p>
 * <p>
 * 事件处理
 * 事件处理是指在特定情况下某种事件发生后被处理，处理事件会通过一些方法，该方法可能在监听器类中，也可能在其它相关类中(回调用方法类似ARM
 * 的中断处理方法)，回调用方法的参数中一般都存在一个事件对象，从该对象中我们就可以取出相应的事件信息。
 */

public class ViewListenerActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.bt_1)
    Button bt1;
    @BindView(R.id.bt_2)
    Button bt2;
    @BindView(R.id.bt_3)
    Button bt3;
    @BindView(R.id.bt_4)
    Button bt4;
    @BindView(R.id.tv_5)
    TextView tv5;
    @BindView(R.id.bt_open)
    Button btOpen;
    @BindView(R.id.bt_close)
    Button btClose;
    @BindView(R.id.bt_7)
    Button bt7;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlistener);
        ButterKnife.bind(this);
    }

    /**
     * 由于ButterKnife的onViewClicked 点击事件直接执行不用监听的，
     * 所以出现点击2次触发按钮的点击就见怪不怪了
     * @param view
     */
    @OnClick({R.id.bt_1, R.id.bt_2, R.id.bt_3, R.id.bt_4,
            R.id.bt_open, R.id.bt_close, R.id.bt_7})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_1:
                dobt_1();
                break;
            case R.id.bt_2:
                dobt_2();
                break;
            case R.id.bt_3:
                dobt_3();
                break;
            case R.id.bt_4:
                dobt_4();
                break;
            case R.id.bt_open:
                doOpen();
                break;
            case R.id.bt_close:
                doClose();
                break;
            case R.id.bt_7:
                dobt_7();
                break;
        }
    }

    private void doClose() {
        Toast.makeText(this, "点击关闭", Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * 上面我们只是简单地介绍每种的监听方式，在对事件的监听过程中可以对一个控件对象设置多个不同的监听器对象，也可以让一个监听器对象监听多个控件对象，如下所示：
     public class MainActivity extends ActionBarActivity implements
     OnClickListener,
     OnLongClickListener {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);

     Button open = (Button) findViewById(R.id.button1);
     Button close = (Button) findViewById(R.id.button2);

     /*
      * 1、一个view对象可以设置多个监听器对象
      * 2、一个监听器对象可以绑定到多个view对象
     * open按钮设置点击事件监听器
     * open.setOnClickListener(this);

    //open按钮设置长按事件监听器
 open.setOnLongClickListener(this);

    //close按钮设置点击事件
 close.setOnClickListener(this);
}

    //点击事件监听方法
    @Override
    public void onClick(View v) {
 * 1、这里的参数v就是我们点击的控件对象
 * 2、当该监听器要监听多个控件对象时，可利用参数v来区分
 *获得控件对象的ID
        int id = v.getId();
        if (id == R.id.button1) {
            Log.d("Tag","点击打开");
        }else if(id == R.id.button2){
            Log.d("Tag","点击关闭");
        }
    }
    //长按事件监听方法
    // @Override
    public boolean onLongClick(View v) {
        Log.d("Tag","长按打开");
        return false;
    }

}
     *
     */
    private void doOpen() {
        btOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewListenerActivity.this, "点击打开", Toast.LENGTH_SHORT).show();
            }
        });
        btOpen.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(ViewListenerActivity.this, "长按打开", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    /**
     * 除了上面的设置监听方式，Android还有一种更加简洁的方式，直接在布局文件中利用控件标签的onClick属性来设置监听方法，然后在Activity类中去实现该方法，例如：
     onClick=“MyListener”，则在Activity中必须定义一
     个public void MyListener（View v）{......}方法。

     注意，不是Button或不是ImageButton配置onClick=“方法名”属性的同
     时，还得配置clickable="true"，否则onClick不生效。

     如下所示：
     <LinearLayout
     xmlns:android="http://schemas.android.com/apk/res/android"
     android:layout_width="fill_parent"
     android:layout_height="fill_parent"
     android:orientation="vertical" >
     <TextView
     android:id="@+id/textView1"
     android:layout_width="wrap_content"
     android:layout_height="wrap_content"
     android:layout_gravity="center"
     android:textSize="40sp"
     android:text="快点我"
     android:onClick="MyListener"
     android:clickable="true"/>
     </LinearLayout>

     Java代码：
     public class MainActivity extends ActionBarActivity {
     @Override
     protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     }
     //与xml文件中对应的监听方法
     public void MyListener(View v){
     Log.d("Tag", "我被点击了");
     }
     }

     方法体前缀：public
     */
    public void click(View view) {
        Toast.makeText(this, "onClick属性设置监听器", Toast.LENGTH_SHORT).show();
    }

    /**
     * Java代码修改/获取UI控件的属性
     */
    private void dobt_7() {
        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取编辑文本框的数据
                String msg = et.getText().toString();
                // 将内容显示
                tv.setText(msg);
            }
        });
    }

    /**
     * 当前类对象
     */
    private void dobt_4() {
        bt4.setOnClickListener(this);
    }

    /**
     * 匿名内部类对象
     */
    private void dobt_3() {
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewListenerActivity.this, "匿名内部类对象", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 内部类对象
     */
    private void dobt_2() {
        // 创建自定义外部类监听器对象
        MyListener1 myListener = new MyListener1();
        bt2.setOnClickListener(myListener);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, " 当前类对象", Toast.LENGTH_SHORT).show();
    }


    class MyListener1 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
//            Log.e(TAG, "外部类对象");
            Toast.makeText(ViewListenerActivity.this, "内部类对象", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * w外部类对象
     */
    private void dobt_1() {
        // 创建自定义外部类监听器对象
        MyListener myListener = new MyListener();
        bt1.setOnClickListener(myListener);
    }

}

// 外部类对象
class MyListener implements View.OnClickListener {

    private static final String TAG = MyListener.class.getSimpleName();

    @Override
    public void onClick(View v) {
        Log.e(TAG, "外部类对象");
//        Toast.makeText(ViewListenerActivity.this, "外部类对象", Toast.LENGTH_SHORT).show();
    }
}
