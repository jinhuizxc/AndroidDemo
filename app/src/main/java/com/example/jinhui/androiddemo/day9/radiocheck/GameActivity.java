package com.example.jinhui.androiddemo.day9.radiocheck;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/31.
 * Email:1004260403@qq.com
 */

public class GameActivity extends AppCompatActivity {

    private static final String TAG = "GameActivity";
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.radio0)
    RadioButton radio0;
    @BindView(R.id.radio1)
    RadioButton radio1;
    @BindView(R.id.radio2)
    RadioButton radio2;
    @BindView(R.id.radioGroup1)
    RadioGroup radioGroup1;
    @BindView(R.id.bt_start)
    Button btStart;

    // RadioButton数组
    RadioButton rbs[] = new RadioButton[3];
    // 随机出的最大数字
    int MAX;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);

        rbs[0] = radio0;
        rbs[1] = radio1;
        rbs[2] = radio2;
    }

    @SuppressLint("StaticFieldLeak")
    @OnClick(R.id.bt_start)
    public void onViewClicked() {
        // 引入异步任务
//        new AsyncTask<Void, Integer, String>() {
//
//            @Override
//            protected String doInBackground(Void... params) {
//                //随机出时间
//                int max = (int) (Math.random() * 10) + 10;
//                //显示log信息
//                //	Log.d("Tag", String.valueOf(max));
//
//                int count = 0;
//                while (count < max) {
//                    count++;
//                    publishProgress(count % rbs.length);
//                    //count%rbs.length取余结果为0,1,2.length=3。
//                    //	Log.d("Tag", String.valueOf(count%rbs.length));
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                return rbs[count % rbs.length].getText().toString();
//            }
//
//            @Override
//            protected void onProgressUpdate(Integer... values) {
//                super.onProgressUpdate(values);
//
//                int count = values[0];
//                rbs[count].setChecked(true);
//            }
//
//            @Override
//            protected void onPostExecute(String result) {
//                super.onPostExecute(result);
//                Toast.makeText(GameActivity.this, result, Toast.LENGTH_SHORT).show();
//            }
//        }.execute();

        // 2.用Thread线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //随机出时间
                MAX = (int) (Math.random() * 10 + 10);
                Log.e(TAG, "MAX =" + MAX);
                count(MAX);
            }
        }).start();
    }

    int remainder;
    private void count(int max) {
        int count = 0;
        while(count < max){
            count++;
            // 求余操作
            remainder = count % rbs.length;
            //  android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.
//            rbs[remainder].setChecked(true);
            // 这里需要用handler
            Message message = handler.obtainMessage();
            message.arg1 = remainder;
            message.arg2 = count;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.sendMessage(message);
        }
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int remainder = msg.arg1;
            int count = msg.arg2;
            rbs[remainder].setChecked(true);
            if (count == MAX)
            Toast.makeText(GameActivity.this, rbs[remainder].getText().toString(), Toast.LENGTH_SHORT).show();
        }
    };
}
