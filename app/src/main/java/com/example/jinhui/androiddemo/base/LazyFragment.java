package com.example.jinhui.androiddemo.base;

import android.os.Bundle;
import android.view.View;

/**
 * Created by jh on 2018/9/10.
 * Email: 1004260403@qq.com
 *
 * fragment懒加载？
 */
public abstract class LazyFragment extends BaseFragment {

    private static final String TAG = LazyFragment.class.getSimpleName();
    private boolean hasLoaded = false;
    private boolean isCreated = false;
    private boolean isVisibleToUser = false;
    private View view;

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        isCreated = true;
        this.view = view;
        lazyLoad(this.view, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;  //注：关键步骤
        lazyLoad(view, null);
    }

    private void lazyLoad(View view, Bundle savedInstanceState) {
        if (!isVisibleToUser || hasLoaded || !isCreated){
            return;
        }
        lazyInitView(view, savedInstanceState);
        hasLoaded = true;//注：关键步骤，确保数据只加载一次
    }

    public abstract void lazyInitView(View view, Bundle savedInstanceState);


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isCreated = false;
        hasLoaded = false;
    }
}
