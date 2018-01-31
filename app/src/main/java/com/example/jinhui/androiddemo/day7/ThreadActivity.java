package com.example.jinhui.androiddemo.day7;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day7.asynctask.MyTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/30.
 * Email:1004260403@qq.com
 * <p>
 * <p>
 * Android多线程:
 * 1)一个Android的应用程序运行在一个独立的进程中，运行在一个独立的虚拟机(dvk)上。 (进程名为包名)---安全性考虑，若非如此，dvk资源耗尽，导致系统崩溃。
 * <p>
 * 2)Android应用程序开启后，默认开启一个主线程(UI线程)
 * Activity，Service，BroadcastReceiver组件运行在主线程中
 * Android应用程序退出后，保留空UI线程，可以加快应用程序启动速度。
 * <p>
 * 3)用户不能在UI主线程中做耗时的操作，一旦该操作超过5s，应用程序抛一个ANR异常（Application not respond）。
 * 如何避免ANR错误？
 * <p>
 * 将耗时的操作放入子线程中。
 * (耗时的操作包括：长时间的休眠，计数，，下载，联网，复杂的运算。)
 * <p>
 * 4)只有主线程才能操作Widget控件。
 * 如果在子线程中操作Widget控件，系统抛出CalledFromWrongThreadException异常。
 * <p>
 * 5)系统为什么要这么做？
 * --->避免出现同步问题。
 * <p>
 * 计数线程:
 * 1)启动线程new Thread（new Runnable).start（）
 * 2)	//创建消息对象
 * Message msg = new Message();
 * 3)  // 数据传递给msg
 * msg.arg1 = count;
 * <p>
 * 注：msg.what = 1;(2)message code（不同的信息码不同的线程区分）
 * 4)发送消息 (子线程发送消息给底层的消息队列)
 * handler.sendMessage(msg);
 * 5）处理消息
 * handleMessage(Message msg)
 */

public class ThreadActivity extends AppCompatActivity {

    private static final String TAG = "ThreadActivity";
    @BindView(R.id.bt_thread)
    Button btThread;
    @BindView(R.id.bt_count)
    Button btCount;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.editText1)
    EditText editText1;
    @BindView(R.id.editText2)
    EditText editText2;
    @BindView(R.id.bt_countdown)
    Button btCountdown;
    @BindView(R.id.prograssbar)
    ProgressBar prograssbar;
    @BindView(R.id.bt_download)
    Button btDownload;
    @BindView(R.id.tv_thread)
    TextView tvThread;
    @BindView(R.id.bt_start)
    Button btStart;
    @BindView(R.id.bt_cancle)
    Button btCancle;

    MyTask task;
    @BindView(R.id.text)
    TextView text;
    @BindView(R.id.bt_ui_count)
    Button btUiCount;
    @BindView(R.id.bt_asyctask)
    Button btAsyctask;
    @BindView(R.id.tv_result)
    TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        ButterKnife.bind(this);

        /**
         * 补充：
         * Integer.valueof(String s)与Integer.parseInt(String s)区别
         *
         * Integer.valueof(String s)是将一个包装类是将一个实际值为数字的变量先转成string型再将它转成Integer型的包装类对象(相当于转成了int的对象)这样转完的对象就具有方法和属性了。

         Integer.parseInt(String s)只是将是数字的字符串转成数字，注意他返回的是int型变量不具备方法和属性。

         例如：
         parseInt(String s )方法是类Integer的静态方法，它的作用就是将形参 s 转化为整数，比如：
         Interger.parseInt("1")=1;
         Integer.parseInt("20")=20;
         Integer.parseInt("324")=324;
         当然，s 表示的整数必须合法，不然是会抛异常的。
         valueOf(String s )也是Integer类的静态方法，它的作用是将形参 s 转化为Integer对搜索象，
         什么是Integer对象，Integer就是基本数据类型int型包装类，就是将int包装成一个类，这样在很多场合下是必须的。如果理解不了，你就认为int是Integer的mini版，好用了很多，但也丢失了一些功能，好了，看代码：
         Interger.valueOf("123")=Integer(123)
         这时候Integer（123）就是整数123的对象表示形式，它再调用intValue()方法，就是将123的对象表示形式转化为基本数据123
         */
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "s = " + s);
                if (s.length() > 0) {
                    // 将字符串转转化成int类型
                    int number = Integer.parseInt(s.toString());
                    if (number > 59) {
                        editText1.setText(String.valueOf(59));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    int number = Integer.parseInt(s.toString());
                    if (number > 59) {
                        editText2.setText(String.valueOf(59));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick({R.id.bt_ui_count, R.id.bt_thread, R.id.bt_count, R.id.bt_countdown,
            R.id.bt_download, R.id.bt_start, R.id.bt_cancle, R.id.bt_asyctask})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_ui_count:
                doUi_count();
                break;
            case R.id.bt_thread:
                doThread();
                break;
            case R.id.bt_count:
                doCount();
                break;
            case R.id.bt_countdown:
                doCountDown();
                break;
            case R.id.bt_download:
                // 下载，更新进度条
                updateProgress();
                break;
            case R.id.bt_start:
                //执行异步任务
                task = new MyTask(text);
                task.execute();
                break;
            case R.id.bt_cancle:
                //取消异步任务
                task.cancel(true);
                break;
            case R.id.bt_asyctask:
                doAsycTask();
                break;
        }
    }

    @SuppressLint("StaticFieldLeak")
    private void doAsycTask() {
        // 执行异步任务: 计数
        new AsyncTask<Integer, Integer, Void>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Log.d("Tag", "onPreExecute");
            }

            //该方法运行在非UI线程中,该方法中可以做耗时操作
            @Override
            protected Void doInBackground(Integer... params) {
                Log.d(TAG, "doInBackground");
                int count = 0;
                int Number = params[0];
                while (count < Number) {
                    count++;
                    //发布进度
                    //触发系统自动调用onProgressUpdate
                    //相当于handler.sendMessage()
                    publishProgress(count);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                Log.d(TAG, "onProgressUpdate");
                //操作UI控件
                int count = values[0];
                tvResult.setText(String.valueOf(count));
            }

            //接收数据
            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);
                Log.d(TAG, "onPostExecute = " + result);
            }

            //该方法在取消异步任务之后运行
            @Override
            protected void onCancelled() {
                super.onCancelled();
                Log.d(TAG, "onCancelled");
            }

        }.execute(10);

    }


    /**
     * 验证会不会出现ANR异常,
     * 尝试了好几次才出现ANR in com.example.jinhui.androiddemo (com.example.jinhui.androiddemo/.day7.ThreadActivity)
     * 系统会提示对话框 XXX（程序名）无响应，要将其关闭么？
     * 注：执行耗时操作，10秒后按钮会自动点击ok，说明按下按钮执行计数，直到计数完成按钮的点击操作才算完成！这点需要注意！
     */
    private void doUi_count() {
//        count();
    }

    private void doThread() {
        //比较优雅的
        new Thread(new Runnable() {
            @Override
            public void run() {
                count();
                //Thread 为Thread-3。非主线程main。
                Log.e(TAG, "Thread =" + Thread.currentThread().getName());
            }
        }).start();
    }

    /**
     * 下载操作
     */
    private void updateProgress() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (count < 100) {
                    count++;
                    // 从消息池中取出消息对象
                    Message msg = handler.obtainMessage();
                    msg.arg1 = count;
                    msg.what = 1;
                    handler.sendMessage(msg);
                    // 不延时500毫秒，进行测试，
                    // 由于while的循环速度很快，所以直接到100了，必须要有sleep体现过程
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * 倒计时操作
     */
    private void doCountDown() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 分秒时间和
                int maxTime = Integer.parseInt(editText1.getText().toString()) * 60
                        + Integer.parseInt(editText2.getText().toString());
                int countdown = maxTime;
                while (countdown > 0) {
                    countdown--;
                    // 从消息池中取出消息对象
                    Message msg = handler.obtainMessage();
                    msg.arg1 = countdown;
                    msg.what = 2;
                    handler.sendMessage(msg);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    int count = 0;

    private void doCount() {
        //启动线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //修改Widget控件的值
                //tv.setText(String.valueOf(count));
                while (count < 20) {
                    count++;
                    // Thread = Thread-3
                    Log.e(TAG, "Thread = " + Thread.currentThread().getName());
                    Log.e(TAG, "count = " + count);
                    //创建消息对象
                    Message msg = new Message();
                    msg.arg1 = count;
                    msg.what = 3;
                    //发送消息 (发给底层的消息队列)
                    handler.sendMessage(msg);
                    // 向消息队列发送消息，1000毫秒后执行Runnable对象中的代码。
                    // 注意：延迟5秒后开始打印log，但是count = 20 后计数已经完成，log会继续输出执行，共执行20次。
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.e(TAG, "thread name = " + Thread.currentThread().getName()); // thread name = main
                        }
                    }, 5000);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * 没有handler，仅仅用thread的话不能通知ui界面进行值的设置，不管是toast还是设置文本内容tvThread.setText("计数结果：" + i);
     * 而且会出现bug，造成闪退！
     */
    @SuppressLint("SetTextI18n")
    private void count() {
        // 耗时操作
        int i = 0;
        while (i < 10) {
            i++;
            Log.e(TAG, "i = " + i);
//            Toast.makeText(this, "i =" + i, Toast.LENGTH_SHORT).show();
            // android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.
//            tvThread.setText("计数结果：" + i + " " + "thread =" + Thread.currentThread().getName());
//            tvThread.setText("计数结果：" + i);
            Log.e(TAG, "count Thread = " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);  // 延时1秒，如时间一般，不加直接显示1到10
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    // 创建Handler内部类
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        //如果消息队列中有消息，系统自动调用该方法处理消息
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 3) {
                int count = msg.arg1;
                if (count == 20) {
                    Toast.makeText(ThreadActivity.this, "计数完成", Toast.LENGTH_SHORT).show();
                }
                tvCount.setText(String.valueOf(count));
            } else if (msg.what == 2) {
                // 倒计时与下载
                int count1 = msg.arg1;
                editText1.setText(String.valueOf(count1 / 60));//设置分钟的变化显示
                editText2.setText(String.valueOf(count1 % 60));//设置秒的变化显示
            } else if (msg.what == 1) {
                // 下载
                int count2 = msg.arg1;
                Log.e(TAG, "下载进度 =" + count2);
                if (count2 == 100) {
                    Toast.makeText(ThreadActivity.this, "下载完成", Toast.LENGTH_SHORT).show();
                }
                prograssbar.setProgress(count2);
            }


        }
    };


}
