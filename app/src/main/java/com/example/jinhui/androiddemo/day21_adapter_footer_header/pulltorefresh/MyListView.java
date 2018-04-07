package com.example.jinhui.androiddemo.day21_adapter_footer_header.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class MyListView extends ListView {

    //阻尼系数
    final float RADIO = 2.6f;
    Header header;
    Footer footer;
    OnRefreshHeader refreshHeader;
    OnRefreshFooter refreshFooter;

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //添加header首部
        header = new Header(context);
        this.addHeaderView(header);

        footer = new Footer(context);
        this.addFooterView(footer);

        footer.getBtn().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                footer.setBtnVisible(false);
                if (refreshFooter != null) {
                    refreshFooter.onRefreshFoot();
                }
            }
        });
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    int down_y;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        this.getCheckedItemIds();
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            down_y = (int) ev.getY();
            if (header.getCurrent() != Header.UPDATE)
                header.setStatus(Header.DOWN);
        } else if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            if (header.getCurrent() != Header.UPDATE) {
                int move_y = (int) ev.getY();
                header.setHeaderHeight((int) ((move_y - down_y) / RADIO));
                if (header.getHeaderHeight() > 80) {
                    header.setStatus(Header.UP);
                } else {
                    header.setStatus(Header.DOWN);
                }
            }
        } else if (ev.getAction() == MotionEvent.ACTION_UP) {
            if (header.getCurrent() == Header.DOWN) {
                header.setHeaderHeight(0);
            } else if (header.getCurrent() == Header.UP) {
                header.setHeaderHeight(60);
                header.setStatus(Header.UPDATE);
                if (refreshHeader != null) {
                    refreshHeader.onRefreshHead();
                }
            }
        }

        return super.onTouchEvent(ev);
    }

    /**
     * 注册刷新接口
     */
    public void setOnReFreshHeader(OnRefreshHeader onReFresh) {
        refreshHeader = onReFresh;

    }

    public void setOnReFreshFooter(OnRefreshFooter onReFresh) {
        refreshFooter = onReFresh;
    }

    /**
     * 刷新结束
     */
    public void setOnReFreshFinish() {
        header.setHeaderHeight(0);
        header.setStatus(Header.DOWN);
    }

    public void setOnReFreshFooterFinish() {
        footer.setBtnVisible(true);
    }

}


