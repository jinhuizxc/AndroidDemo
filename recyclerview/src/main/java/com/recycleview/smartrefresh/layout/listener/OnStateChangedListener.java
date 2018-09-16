package com.recycleview.smartrefresh.layout.listener;


import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;

import com.recycleview.smartrefresh.layout.api.RefreshLayout;
import com.recycleview.smartrefresh.layout.constant.RefreshState;

import static android.support.annotation.RestrictTo.Scope.LIBRARY;
import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;
import static android.support.annotation.RestrictTo.Scope.SUBCLASSES;

/**
 * 刷新状态改变监听器
 * Created by hxl 2018/7/30
 */

public interface OnStateChangedListener {
    /**
     * 状态改变事件 {@link RefreshState}
     * @param refreshLayout RefreshLayout
     * @param oldState 改变之前的状态
     * @param newState 改变之后的状态
     */
    @RestrictTo({LIBRARY,LIBRARY_GROUP,SUBCLASSES})
    void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState);
}
