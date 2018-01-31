package com.example.jinhui.androiddemo.day7.asynctask;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by jinhui on 2018/1/30.
 * Email:1004260403@qq.com
 * <p>
 * <p>
 * 异步任务（AsyncTask）
 * Params 执行异步任务时，传入的参数
 * Progress 异步任务的进度
 * Result 结果
 * <p>
 * // 继承只会重写doInBackground(Void... voids)方法
 * <p>
 * 自己需要手动重写
 * onPreExecute()、
 * onProgressUpdate(Integer... values)
 * onCancelled(String s)方法
 * <p>
 * 方法执行顺序：
 * onPreExecute->doInBackground->onProgressUpdate
 * <p>
 * 异步任务的6个方法:
 * 1.execute(Params... params):
 * 执行一个异步任务，需要我们在代码中调用此方法，触发异步任务的执行。
 * <p>
 * 2.onPreExecute():
 * 在execute(Params... params)被调用后立即执行，一般用来在执行后台任务前对UI做一些标记。
 * <p>
 * 3.doInBackground(Params... params)，:
 * //该方法运行在非UI线程中，可以做耗时操作
 * 在onPreExecute()完成后立即执行，用于执行较为费时的操作，此方法将接收输入参数和返回计算结果。在执行过程中可以调用publishProgress(Progress... values)来更新进度信息。
 * <p>
 * 4.onProgressUpdate(Progress... values):
 * //发布进度，触发系统自动调用onProgressUpdate
 * //相当于handler.sendMessage()；
 * //该方法运行在UI线程中.
 * 在调用publishProgress(Progress... values)时，此方法被执行，直接将进度信息更新到UI组件上。
 * <p>
 * 5.onPostExecute(Result result):
 * 当后台操作结束时，此方法将会被调用，计算结果将做为参数传递到此方法中，直接将结果显示到UI组件上。
 * <p>
 * 6.onCancelled(String s)
 * //该方法在取消异步任务后运行
 *
 * @Override protected void onCancelled() {
 * // TODO Auto-generated method stub
 * super.onCancelled();
 * }
 * <p>
 * 取消异步任务:
 * /**
 * cancel(true) 取消当前的异步任务，传入的true,表示当中断异步任务时继续已经运行的线程的操作，
 * 但是为了线程的安全一般为让它继续设为true
 * mTask.cancel(true);
 * 但是重新运行后会发现还是不能起到效果，
 * 注意:这是因为cancel方法只是发出一个请求取消异步任务的信号,
 * 将对应当前的异步任务标记为CANCEL状态，而并不是真正取消线程的执行，
 * 而此时异步任务中的线程仍然在执行并没有结束
 * 所以效果依然是这样的，并且在java中我们是无法直接暴力将一个线程给停止掉
 * 既然我们知道无法去取消一个已经正在运行的线程，但是我们如何去解决这个BUG呢？
 *
 * isCanceled（）回调方法：
 * 在异步任务中还给我们提供一个isCanceled的回调方法，也就是当我已经给当前的异步任务
 * 调用了cancel(true)方法，发出一个请求取消异步任务的信号，那么此时的isCanceled的回调方法
 * 会直接返回一个true，那么我们就可以通过判断当前异步任务isCanceled是否为true，来终止
 * 线程中的操作而不是去终止线程，从而达到了界面显示好像线程中的操作被终止了，而实际上
 * 该线程依然在运行 .
 *
 * 注意:
 *  1.异步任务对象只能执行一次。
 *  2.异步任务对象必须在UI主线程中创建。execute(Params... params)方法必须在UI线程中调用。
 *  3.不要手动调用onPreExecute()，doInBackground(Params... params)，onProgressUpdate(Progress... values)，onPostExecute(Result result)这几个方法。
 *  4.不能在doInBackground(Params... params)中更改UI组件的信息。

 *
 *
 *
 *
 */

public class MyTask extends AsyncTask<Void, Integer, String> {

    private static final String TAG = "MyTask";
    @SuppressLint("StaticFieldLeak")
    private TextView tv;


    // 构造方法
    public MyTask(TextView textView) {
        this.tv = textView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.e(TAG, "onPreExecute");
    }

    /**
     * 该方法运行在非UI线程中，
     * 该方法中可以做耗时操作
     *
     * @param voids
     * @return
     */
    @Override
    protected String doInBackground(Void... voids) {
        Log.e(TAG, "doInBackground");
        Log.e(TAG, "doInBackground 线程 =" + Thread.currentThread().getName()); // doInBackground 线程 =AsyncTask #1
        int count = 0;
        while (!isCancelled() && count < 10) {
            count++;
            Log.d(TAG, "count =" + count);
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
        return "时间到";
    }

    /**
     * 相当于handlerMessage()
     * 该方法运行在UI线程中
     *
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.e(TAG, "onProgressUpdate");
        Log.e(TAG, "onProgressUpdate 线程 =" + Thread.currentThread().getName()); // onProgressUpdate 线程 =main
//        if (isCancelled()) {
//            return;
//        }
        //操作UI控件
        int count = values[0];
        tv.setText(String.valueOf(count));

    }

    /**
     * 该方法在取消异步任务之后运行,附加String result参数
     *
     * @param s
     */
    @Override
    protected void onCancelled(String s) {
        super.onCancelled(s);
        Log.d(TAG, "onCancelled" + s);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute =" + s);
    }
}
