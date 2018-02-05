package com.example.jinhui.androiddemo.day22.listviewheader;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class MyListView extends ListView {

    private MyReFreshListener refreshListenner;
    Header header;

    int downY;


    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        header = new Header(context);
        this.addHeaderView(header);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * View触摸事件的监听
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            if (header.getCurrentStatus() != Header.UPDATE) {
                downY = (int) ev.getY();
                Log.e("Test", "down");
                header.setStatus(Header.DOWN);
                // 更新header的高度?

            }

        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            int moveY = (int) ev.getY();
            if (moveY - downY > 0) {
                // 更新header的高度
                header.setHeaderHeight((moveY - downY) / 2);
                if (header.getHeaderHeight() > 60
                        && header.getCurrentStatus() == Header.DOWN) {
                    //设置为松开刷新状态
                    header.setStatus(Header.UP);
                }
            }
//			Log.d("Test", "move");
        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
            Log.e("Test", "up");
            // 更新header的高度?

            if (header.getCurrentStatus() != Header.UPDATE) {
                if (header.getCurrentStatus() == Header.UP) {
                    header.setStatus(Header.UPDATE);
                    //调用刷新逻辑
                    if (refreshListenner != null) {
                        refreshListenner.onReFresh();
                    }
                } else {
                    header.setStatus(Header.NORMAL);
                }
            }
        }
        return super.onTouchEvent(ev);
    }

    /**
     * 结束刷新的方法
     * 结束刷新，将header隐藏起来（header的高设为0）
     */
    public void finishRefresh() {
        header.setStatus(Header.NORMAL);
    }

    // 接口回调方法，监听ListView中header的正在刷新事件
    public interface MyReFreshListener {
        void onReFresh();
    }

    public void setRefreshListenner(MyReFreshListener refreshListenner) {
        this.refreshListenner = refreshListenner;
    }
}
