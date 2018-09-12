package com.example.jinhui.androiddemo.day25.mvvm;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.databinding.ActivityMvvmBinding;
import com.example.jinhui.androiddemo.day25.mvvm.adapter.NewsAdapter;
import com.example.jinhui.androiddemo.day25.mvvm.helper.DialogHelper;
import com.example.jinhui.androiddemo.utils.ToastUtil;
import com.example.jinhui.androiddemo.day25.mvvm.view.INewsView;
import com.example.jinhui.androiddemo.day25.mvvm.viewmodel.NewsVM;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import static com.example.jinhui.androiddemo.day25.mvvm.constant.MainConstant.LoadData.FIRST_LOAD;


/**
 * Created by jinhui on 2018/3/11.
 * Email:1004260403@qq.com
 *
 * 3/16—今天把mvvm的demo写完，以及常用的设计模式并提交一次github
 *
 * 妈的，mvvm点击进入闪退，bug, 待处理！
 */

public class MVVMActivity extends AppCompatActivity implements INewsView, XRecyclerView.LoadingListener {

    private Context mContext;
    private ActivityMvvmBinding binding;
    private NewsAdapter newsAdapter; //新闻列表的适配器
    private NewsVM newsVM;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mvvm);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        mContext = this;
        initRecyclerView();
        newsVM = new NewsVM(this, newsAdapter);
    }

    /**
     * 初始化RecyclerView
     */
    private void initRecyclerView() {
        binding.newsRv.setRefreshProgressStyle(ProgressStyle.BallClipRotate); //设置下拉刷新的样式
        binding.newsRv.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate); //设置上拉加载更多的样式
        binding.newsRv.setArrowImageView(R.mipmap.pull_down_arrow);
        binding.newsRv.setLoadingListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.newsRv.setLayoutManager(layoutManager);
        newsAdapter = new NewsAdapter(this);
        binding.newsRv.setAdapter(newsAdapter);
    }

    @Override
    public void onRefresh() {
        //下拉刷新
        newsVM.loadRefreshData();
    }

    @Override
    public void onLoadMore() {
        //上拉加载更多
        newsVM.loadMoreData();
    }

    @Override
    public void loadStart(int loadType) {
        if (loadType == FIRST_LOAD) {
            DialogHelper.getInstance().show(mContext, "加载中...");
        }
    }

    @Override
    public void loadComplete() {
        DialogHelper.getInstance().close();
        binding.newsRv.loadMoreComplete(); //结束加载
        binding.newsRv.refreshComplete(); //结束刷新
    }

    @Override
    public void loadFailure(String message) {
        DialogHelper.getInstance().close();
        binding.newsRv.loadMoreComplete(); //结束加载
        binding.newsRv.refreshComplete(); //结束刷新
        ToastUtil.show(mContext, message);
    }
}
