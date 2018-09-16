package com.recycleview.smartrefresh.layout.api;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * 默认Header创建器
 * Created by hxl 2018/7/30
 */
public interface DefaultRefreshHeaderCreator {
    @NonNull
    RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout);
}
