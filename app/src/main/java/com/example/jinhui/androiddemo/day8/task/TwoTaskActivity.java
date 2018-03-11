package com.example.jinhui.androiddemo.day8.task;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 */

public class TwoTaskActivity extends AppCompatActivity {

    @BindView(R.id.progressBar1)
    ProgressBar progressBar1;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.button2)
    Button button2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twotask);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                doDownLoadTask();
                break;
            case R.id.button2:
                doCountTask();
                break;
        }
    }

    @SuppressLint("StaticFieldLeak")
    private void doCountTask() {
        new AsyncTask<Integer, Integer, Void>(){

            @Override
            protected Void doInBackground(Integer... integers) {
                int count = 0;
                while (count < integers[0]){
                    count++;
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
                textView1.setText(String.valueOf(values[0]));
            }
        }.execute(10);
    }

    // 执行下载异步任务
    @SuppressLint("StaticFieldLeak")
    private void doDownLoadTask() {
        new AsyncTask<Void, Integer, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                int count = 0;
                while (count < 100){
                    count += 10;
                    publishProgress(count);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar1.setProgress(values[0]);
            }
        }.execute();
    }
}
