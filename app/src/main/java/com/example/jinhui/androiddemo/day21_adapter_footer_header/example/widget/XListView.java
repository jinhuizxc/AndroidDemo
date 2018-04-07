package com.example.jinhui.androiddemo.day21_adapter_footer_header.example.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class XListView extends ListView implements AbsListView.OnScrollListener {


    //    private static final String TAG = "XListView";

    private final static int SCROLL_BACK_HEADER = 0;
    private final static int SCROLL_BACK_FOOTER = 1;

    private final static int SCROLL_DURATION = 400;

    // when pull up >= 50px
    private final static int PULL_LOAD_MORE_DELTA = 50;

    // support iOS like pull
    private final static float OFFSET_RADIO = 1.8f;

    private float mLastY = -1;

    // used for scroll back
    private Scroller mScroller;
    // user's scroll listener
    private OnScrollListener mScrollListener;
    // for mScroller, scroll back from header or footer.
    private int mScrollBack;

    // the interface to trigger refresh and load more.
    private IXListViewListener mListener;

    private XHeaderView mHeader;
    // header view content, use it to calculate the Header's height. And hide it when disable pull refresh.
    private RelativeLayout mHeaderContent;
    private TextView mHeaderTime;
    private int mHeaderHeight;

    private LinearLayout mFooterLayout;
    private XFooterView mFooterView;
    private boolean mIsFooterReady = false;

    private boolean mEnablePullRefresh = true;
    private boolean mPullRefreshing = false;

    private boolean mEnablePullLoad = true;
    private boolean mEnableAutoLoad = false;
    private boolean mPullLoading = false;

    // total list items, used to detect is at the bottom of ListView
    private int mTotalItemCount;


    public XListView(Context context) {
        super(context);
    }

    public XListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWithContext(context);
    }


    public XListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // 初始化基本配置
    private void initWithContext(Context context) {
        mScroller = new Scroller(context, new DecelerateInterpolator());
        // 实现OnScrollListener的监听
        super.setOnScrollListener(this);
        // init header view
        mHeader = new XHeaderView(context);
        mHeaderContent = (RelativeLayout) mHeader.findViewById(R.id.header_content);
        mHeaderTime = (TextView) mHeader.findViewById(R.id.header_hint_time);
        addHeaderView(mHeader);

        // init footer view
        mFooterView = new XFooterView(context);
        mFooterLayout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout
                .LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER;
        mFooterLayout.addView(mFooterView, params);

        // init header height
        ViewTreeObserver observer = mHeader.getViewTreeObserver();
        if (null != observer) {
            observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @SuppressWarnings("deprecation")
                @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                @Override
                public void onGlobalLayout() {
                    mHeaderHeight = mHeaderContent.getHeight();
                    ViewTreeObserver observer = getViewTreeObserver();

                    if (null != observer) {
                        observer.removeOnGlobalLayoutListener(this);
                    }
                }
            });
        }
    }


    /**
     * 设置footer的布局适配
     * @param adapter
     */
    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
        if (!mIsFooterReady) {
            mIsFooterReady = true;
            addFooterView(mFooterLayout);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mLastY == -1) {
            mLastY = ev.getRawY();
        }

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = ev.getRawY();
                break;

            case MotionEvent.ACTION_MOVE:
                final float deltaY = ev.getRawY() - mLastY;
                mLastY = ev.getRawY();

                if (getFirstVisiblePosition() == 0 && (mHeader.getVisibleHeight() > 0 ||
                        deltaY > 0)) {
                    // the first item is showing, header has shown or pull down.
                    updateHeaderHeight(deltaY / OFFSET_RADIO);
                    invokeOnScrolling();

                } else if (getLastVisiblePosition() == mTotalItemCount - 1 && (mFooterView
                        .getBottomMargin() > 0 || deltaY < 0)) {
                    // last item, already pulled up or want to pull up.
                    updateFooterHeight(-deltaY / OFFSET_RADIO);
                }
                break;

            default:
                // reset
                mLastY = -1;
                if (getFirstVisiblePosition() == 0) {
                    // invoke refresh
                    if (mEnablePullRefresh && mHeader.getVisibleHeight() > mHeaderHeight) {
                        mPullRefreshing = true;
                        mHeader.setState(XHeaderView.STATE_REFRESHING);
                        refresh();
                    }

                    resetHeaderHeight();

                } else if (getLastVisiblePosition() == mTotalItemCount - 1) {
                    // invoke load more.
                    if (mEnablePullLoad && mFooterView.getBottomMargin() > PULL_LOAD_MORE_DELTA) {
                        startLoadMore();
                    }
                    resetFooterHeight();
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    /**
     * 重置footer高度
     */
    private void resetFooterHeight() {
        int bottomMargin = mFooterView.getBottomMargin();

        if (bottomMargin > 0) {
            mScrollBack = SCROLL_BACK_FOOTER;
            mScroller.startScroll(0, bottomMargin, 0, -bottomMargin, SCROLL_DURATION);
            invalidate();
        }
    }

    /**
     * 更新footer高度
     * @param delta
     */
    private void updateFooterHeight(float delta) {
        int height = mFooterView.getBottomMargin() + (int) delta;

        if (mEnablePullLoad && !mPullLoading) {
            if (height > PULL_LOAD_MORE_DELTA) {
                // height enough to invoke load more.
                mFooterView.setState(XFooterView.STATE_READY);
            } else {
                mFooterView.setState(XFooterView.STATE_NORMAL);
            }
        }

        mFooterView.setBottomMargin(height);

        // scroll to bottom
        // setSelection(mTotalItemCount - 1);
    }

    private void invokeOnScrolling() {
        if (mScrollListener instanceof OnXScrollListener) {
            OnXScrollListener listener = (OnXScrollListener) mScrollListener;
            listener.onXScrolling(this);
        }
    }

    /**
     * 更新头部高度
     * @param delta
     */
    private void updateHeaderHeight(float delta) {
        mHeader.setVisibleHeight((int) delta + mHeader.getVisibleHeight());

        if (mEnablePullRefresh && !mPullRefreshing) {
            // update the arrow image unrefreshing
            if (mHeader.getVisibleHeight() > mHeaderHeight) {
                mHeader.setState(XHeaderView.STATE_READY);
            } else {
                mHeader.setState(XHeaderView.STATE_NORMAL);
            }
        }

        // scroll to top each time
        setSelection(0);
    }

    public void autoRefresh() {
        mHeader.setVisibleHeight(mHeaderHeight);
        if (mEnablePullRefresh && !mPullRefreshing) {
            // update the arrow image not refreshing
            if (mHeader.getVisibleHeight() > mHeaderHeight) {
                mHeader.setState(XHeaderView.STATE_READY);
            } else {
                mHeader.setState(XHeaderView.STATE_NORMAL);
            }
        }

        mPullRefreshing = true;
        mHeader.setState(XHeaderView.STATE_REFRESHING);
        refresh();
    }



    private void refresh() {
        if (mEnablePullRefresh && null != mListener) {
            mListener.onRefresh();
        }
    }

    /**
     * Stop refresh, reset header view.
     */
    public void stopRefresh() {
        if (mPullRefreshing) {
            mPullRefreshing = false;
            resetHeaderHeight();
        }
    }

    private void resetHeaderHeight() {
        int height = mHeader.getVisibleHeight();
        if (height == 0) return;

        // refreshing and header isn't shown fully. do nothing.
        if (mPullRefreshing && height <= mHeaderHeight) return;

        // default: scroll back to dismiss header.
        int finalHeight = 0;
        // is refreshing, just scroll back to show all the header.
        if (mPullRefreshing && height > mHeaderHeight) {
            finalHeight = mHeaderHeight;
        }

        mScrollBack = SCROLL_BACK_HEADER;
        mScroller.startScroll(0, height, 0, finalHeight - height, SCROLL_DURATION);

        // trigger computeScroll
        invalidate();
    }

    /**
     * 重写下computeScroll()方法
     */
    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()) {
            if (mScrollBack == SCROLL_BACK_HEADER) {
                mHeader.setVisibleHeight(mScroller.getCurrY());
            } else {
                mFooterView.setBottomMargin(mScroller.getCurrY());
            }

            postInvalidate();
            invokeOnScrolling();
        }
        super.computeScroll();
    }

    /**
     * Stop load more, reset footer view.
     */
    public void stopLoadMore() {
        if (mPullLoading) {
            mPullLoading = false;
            mFooterView.setState(XFooterView.STATE_NORMAL);
        }
    }

    /**
     * Set last refresh time
     *
     * @param time
     */
    public void setRefreshTime(String time) {
        mHeaderTime.setText(time);
    }

    /**
     * Enable or disable pull down refresh feature.
     *
     * @param enable
     */
    public void setPullRefreshEnable(boolean enable) {
        mEnablePullRefresh = enable;
        // disable, hide the content
        mHeaderContent.setVisibility(enable ? View.VISIBLE : View.INVISIBLE);
    }

    /**
     * Enable or disable pull up load more feature.
     *
     * @param enable
     */
    public void setPullLoadEnable(boolean enable) {
        mEnablePullLoad = enable;

        if (!mEnablePullLoad) {
            mFooterView.setBottomMargin(0);
            mFooterView.hide();
            mFooterView.setPadding(0, 0, 0, 0);
            mFooterView.setOnClickListener(null);

        } else {
            mPullLoading = false;
            mFooterView.setPadding(0, 0, 0, 0);
            mFooterView.show();
            mFooterView.setState(XFooterView.STATE_NORMAL);
            // both "pull up" and "click" will invoke load more.
            mFooterView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    startLoadMore();
                }
            });
        }
    }

    /**
     * 开始加载更多
     */
    private void startLoadMore() {
        mPullLoading = true;
        mFooterView.setState(XFooterView.STATE_LOADING);
        loadMore();
    }

    private void loadMore() {
        if (mEnablePullLoad && null != mListener) {
            mListener.onLoadMore();
        }
    }

    /**
     * Enable or disable auto load more feature when scroll to bottom.
     *
     * @param enable
     */
    public void setAutoLoadEnable(boolean enable) {
        mEnableAutoLoad = enable;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (mScrollListener != null) {
            mScrollListener.onScrollStateChanged(view, scrollState);
        }

        if (scrollState == OnScrollListener.SCROLL_STATE_IDLE) {
            if (mEnableAutoLoad && getLastVisiblePosition() == getCount() - 1) {
                startLoadMore();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        // send to user's listener
        mTotalItemCount = totalItemCount;
        if (mScrollListener != null) {
            mScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
        }
    }


    // 定义接口回调
    public interface IXListViewListener{
        public void onRefresh();

        public void onLoadMore();
    }

    /**
     * Set listener.
     *
     * @param mListener
     */
    public void setXListViewListener(IXListViewListener mListener) {
        this.mListener = mListener;
    }

    /**
     * You can listen ListView.OnScrollListener or this one. it will invoke
     * onXScrolling when header/footer scroll back.
     */
    public interface OnXScrollListener extends OnScrollListener {
        public void onXScrolling(View view);
    }

    public void setOnScrollListener(OnScrollListener mScrollListener) {
        this.mScrollListener = mScrollListener;
    }
}
