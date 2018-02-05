package com.example.jinhui.androiddemo.day22.gridview.example;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class GiftActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.gridView)
    GridView gridView;

    ArrayList<ItemData> data = new ArrayList<ItemData>();
    int chooseNames[] = {0, 1, 2, 5, 8, 7, 6, 3};
    GiftAdapter adapter;
    boolean isRun = false;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift);
        ButterKnife.bind(this);

        //准备数据
        String names[] = {"iphone7", "小米note", "大米",
                "谢谢参与", "开始", "谢谢参与",
                "充电宝", "机械键盘", "psp"};

        for (int i = 0; i < names.length; i++) {
            ItemData itemData = new ItemData(names[i], false);
            data.add(itemData);
        }

        adapter = new GiftAdapter(this, data);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(this);
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 4 && !isRun) {
            isRun = true;
            // 开始抽奖！
            new AsyncTask<Integer, Integer, String>() {

                @Override
                protected String doInBackground(Integer... params) {
                    while (count < params[0]) {
                        //更新文字颜色
                        publishProgress(chooseNames[count % chooseNames.length]);
                        count++;

                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    return data.get(chooseNames[(count - 1) % chooseNames.length]).getName();
                }

                protected void onProgressUpdate(Integer... values) {
                    int index = values[0];
                    Log.e("Test", "index = " + index);
                    for (int i = 0; i < data.size(); i++) {
                        if (i == 4) {
                            continue;
                        }
                        if (i == index) {
                            data.get(i).setWhite(true);
                        } else {
                            data.get(i).setWhite(false);
                        }
                    }
                    adapter.notifyDataSetChanged();
                }

                protected void onPostExecute(String result) {
                    Toast.makeText(GiftActivity.this, result, Toast.LENGTH_SHORT).show();
                    isRun = false;
                    count = 0;
                }
            }.execute(15 + (int) (Math.random() * 10));
        }
    }
}
