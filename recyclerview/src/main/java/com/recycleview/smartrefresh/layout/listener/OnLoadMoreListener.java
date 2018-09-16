package com.recycleview.smartrefresh.layout.listener;

import android.support.annotation.NonNull;

import com.recycleview.smartrefresh.layout.api.RefreshLayout;

/**
 * 加载更多监听器
 * Created by hxl 2018/7/30
 */

public interface OnLoadMoreListener {
    void onLoadMore(@NonNull RefreshLayout refreshLayout);
}
