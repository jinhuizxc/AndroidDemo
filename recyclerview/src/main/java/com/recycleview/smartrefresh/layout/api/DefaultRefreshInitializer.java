package com.recycleview.smartrefresh.layout.api;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * 默认全局初始化器
 * Created by hxl 2018/7/30
 */

public interface DefaultRefreshInitializer {
    void initialize(@NonNull Context context, @NonNull RefreshLayout layout);
}
