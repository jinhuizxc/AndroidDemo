package com.example.jinhui.androiddemo.material_design.swiperefreshlayout.way1;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.ListView;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/4/10.
 * Email:1004260403@qq.com
 */
public class RefreshLayout extends SwipeRefreshLayout implements AbsListView.OnScrollListener {

    /**
     * 滑动到最下面时的上拉操作
     */

    private int mTouchSlop;
    /**
     * listview实例
     */
    private ListView mListView;

    /**
     * 上拉监听器, 到了最底部的上拉加载操作
     */
    private OnLoadMoreListener onLoadMoreListener;

    /**
     * ListView的加载中footer
     */
    private View mListViewFooter;

    /**
     * 按下时的y坐标
     */
    private int mYDown;
    /**
     * 抬起时的y坐标, 与mYDown一起用于滑动到底部时判断是上拉还是下拉
     */
    private int mLastY;
    /**
     * 是否在加载中 ( 上拉加载更多 )
     */
    private boolean isLoading = false;


    public RefreshLayout(Context context) {
        super(context);
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 这个方法不熟悉
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        mListViewFooter = LayoutInflater.from(context)
                .inflate(R.layout.item_refreshfooter, null, false);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        // 初始化ListView对象
        if (mListView == null) {
            getListView();
        }
    }

    /**
     * 获取ListView对象
     */
    private void getListView() {
        int child = getChildCount();
        if (child > 0){
            View childView = getChildAt(0);
            if (childView instanceof ListView){
                mListView = (ListView) childView;
                // 设置滚动监听器给ListView, 使得滚动的情况下也可以自动加载
                mListView.setOnScrollListener(this);
            }
        }
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        // 滚动时到了最底部也可以加载更多
        if (canload()){
            loadData();
        }
    }

    private void loadData() {
        if (onLoadMoreListener != null){
            // 设置状态
            setLoading(true);
            onLoadMoreListener.onLoadMore();
        }
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
        if (isLoading){
            mListView.addFooterView(mListViewFooter);
        }else {
            mListView.removeFooterView(mListViewFooter);
            mYDown = 0;
            mLastY = 0;
        }
    }

    /**
     * 是否可以加载更多, 条件是:
     * 到了最底部, listview不在加载中, 且为上拉操作.
     * @return
     */
    private boolean canload() {
        return isBottom() && !isLoading && isPullUp();
    }

    /**
     * 是否是上拉操作
     * @return
     */
    private boolean isPullUp() {
        return (mYDown - mLastY) >= mTouchSlop;
    }

    /**
     * 判断是否到了最底部
     */
    private boolean isBottom() {
        return mListView != null && mListView.getAdapter() != null && mListView.getLastVisiblePosition() == (mListView.getAdapter().getCount() - 1);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                // 按下
                mYDown = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                // 移动
                mLastY = (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                // 抬起
                if (canload()){
                    loadData();
                }
                break;
                default:
                    break;
        }
        return super.dispatchTouchEvent(ev);
    }


    /**
     * 加载更多的监听器
     *
     * @author mrsimple
     */
    public interface OnLoadMoreListener {
        public void onLoadMore();
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }
}
