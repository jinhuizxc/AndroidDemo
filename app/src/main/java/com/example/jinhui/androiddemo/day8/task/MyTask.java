package com.example.jinhui.androiddemo.day8.task;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 */

public class MyTask extends AsyncTask<Integer, Integer, String> {

    private static final String TAG = "MyTask";
    InterUpdate interUpdate;

    public MyTask(InterUpdate inter) {
        this.interUpdate = inter;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        interUpdate.update();
    }

    // 在子线程中执行，其他方法都是主线程中执行
    @Override
    protected String doInBackground(Integer... integers) {
        Log.e(TAG, "total =" + integers[0] + " " + integers[1]);
        int count = integers[0];
        while (count > 0 && !isCancelled()){
            count--;
            publishProgress(count);
            Log.d(TAG, "count = " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "时间到";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int count = values[0];
        interUpdate.updateCount(count);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        interUpdate.updateOver(s);
    }

    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
        Log.d(TAG, "onCancelled = " + s);
        interUpdate.cancle( "取消当前异步任务");
    }
}
