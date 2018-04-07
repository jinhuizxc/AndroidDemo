package com.example.jinhui.androiddemo.day21_adapter_footer_header.addfooter.refresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ListView;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.addFooterView(LayoutInflater.from(context).inflate(
                R.layout.refresh_footer, null));
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
