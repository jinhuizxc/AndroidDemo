package com.example.jinhui.androiddemo.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.base.BaseActivity;
import com.example.jinhui.androiddemo.ui.adapter.ComFragmentAdapter;
import com.example.jinhui.androiddemo.ui.fragment.ArticleFragment;
import com.example.jinhui.androiddemo.ui.fragment.DynamicFragment;
import com.example.jinhui.androiddemo.ui.fragment.QuestionFragment;
import com.example.jinhui.androiddemo.utils.DeviceUtil;
import com.example.jinhui.androiddemo.utils.ScreenUtil;
import com.example.jinhui.androiddemo.utils.ToastUtil;
import com.example.jinhui.androiddemo.utils.StatusBarUtil;
import com.example.jinhui.androiddemo.utils.ToastUtil;
import com.example.jinhui.androiddemo.widget.ColorFlipPagerTitleView;
import com.example.jinhui.androiddemo.widget.JudgeNestedScrollView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by jh on 2018/9/9.
 * Email: 1004260403@qq.com
 * <p>
 * https://github.com/SiberiaDante/MultiScrollDemo
 * 使用NestedScrollView+ViewPager+RecyclerView+SmartRefreshLayout打造酷炫下拉视差效果并解决各种滑动冲突
 * <p>
 * 新特性布局属性解析：https://blog.csdn.net/tablle/article/details/52288515
 * layout_collapseMode：（子布局设置折叠模式）
 * 有两种“pin”：固定模式，在折叠的时候最后固定在顶端；“parallax”：视差模式，在折叠的时候会有个视差折叠的效果。
 */
public class MultiScrollDemoActivity extends BaseActivity {

    @BindView(R.id.iv_header)
    ImageView ivHeader;
    @BindView(R.id.iv_avatar)
    CircleImageView ivAvatar;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_major)
    TextView tvMajor;
    @BindView(R.id.tv_gender)
    TextView tvGender;
    @BindView(R.id.tv_level_num)
    TextView tvLevelNum;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.tv_position)
    TextView tvPosition;
    @BindView(R.id.tv_follow_num)
    TextView tvFollowNum;
    @BindView(R.id.tv_fans_num)
    TextView tvFansNum;
    @BindView(R.id.tv_introduce)
    TextView tvIntroduce;
    @BindView(R.id.tv_authentication)
    TextView tvAuthentication;
    @BindView(R.id.tv_edit_info)
    TextView tvEditInfo;
    @BindView(R.id.tv_integral_num)
    TextView tvIntegralNum;
    @BindView(R.id.tv_japanese_currency)
    TextView tvJapaneseCurrency;
    @BindView(R.id.tv_prestige)
    TextView tvPrestige;
    @BindView(R.id.tv_friendliness)
    TextView tvFriendliness;
    @BindView(R.id.tv_label_one)
    TextView tvLabelOne;
    @BindView(R.id.tv_label_two)
    TextView tvLabelTwo;
    @BindView(R.id.tv_label_three)
    TextView tvLabelThree;
    @BindView(R.id.tv_edit_label)
    TextView tvEditLabel;
    @BindView(R.id.collapse)
    CollapsingToolbarLayout collapse;
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.scrollView)
    JudgeNestedScrollView scrollView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.toolbar_avatar)
    CircleImageView toolbarAvatar;
    @BindView(R.id.toolbar_username)
    TextView toolbarUsername;
    @BindView(R.id.buttonBarLayout)
    ButtonBarLayout buttonBarLayout;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.magic_indicator_title)
    MagicIndicator magicIndicatorTitle;
    @BindView(R.id.fl_activity)
    FrameLayout flActivity;

    int toolBarPositionY = 0;
    private int mOffset = 0;
    private int mScrollY = 0;
    private String[] mTitles = new String[]{"动态", "文章", "问答"};
    private List<String> mDataList = Arrays.asList(mTitles);

    // 不懂？！
//    private ContentObserver mNavigationStatusObserver = new ContentObserver(new Handler()) {
//        @Override
//        public void onChange(boolean selfChange) {
//            dealWithHuaWei();
//            int navigationBarIsMin = Settings.System.getInt(getContentResolver(), "navigationbar_is_min", 0);
//            if (navigationBarIsMin == 1) {
//                Log.d(TAG, "onChange: ------------------导航键隐藏了");
//            } else {
//                Log.d(TAG, "onChange: ------------------导航键显示了");
//            }
//        }
//    };


    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initView();
    }

    private void initView() {
        StatusBarUtil.immersive(this);
        StatusBarUtil.setPaddingSmart(this, toolbar);
        refreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener(){

            @Override
            public void onHeaderPulling(RefreshHeader header, float percent, int offset, int headerHeight, int extendHeight) {
                super.onHeaderPulling(header, percent, offset, headerHeight, extendHeight);
                mOffset = offset / 2;
                ivHeader.setTranslationY(mOffset - mScrollY);
                toolbar.setAlpha(1- Math.min(percent, 1));
            }

            @Override
            public void onHeaderReleasing(RefreshHeader header, float percent, int offset, int footerHeight, int extendHeight) {
                super.onHeaderReleasing(header, percent, offset, footerHeight, extendHeight);
                mOffset = offset / 2;
                ivHeader.setTranslationY(mOffset - mScrollY);
                toolbar.setAlpha(1 - Math.min(percent, 1));
            }
        });
        //判断是否是华为手机并且是否有虚拟导航键
//        if (DeviceUtil.isHUAWEI() && DeviceUtil.checkDeviceHasNavigationBar(this.getApplicationContext())) {
//            getContentResolver().registerContentObserver(Settings.System.getUriFor
//                    ("navigationbar_is_min"), true, mNavigationStatusObserver);
//        }
        toolbar.post(new Runnable() {
            @Override
            public void run() {
                dealWithViewPager();
            }
        });

        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            int lastScrollY = 0;
            int h = DensityUtil.dp2px(170);
            int color = ContextCompat.getColor(getApplicationContext(), R.color.mainWhite) & 0x00ffffff;


            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int[] location = new int[2];
                magicIndicator.getLocationOnScreen(location);
                int yPosition = location[1];
                if (yPosition < toolBarPositionY) {
                    magicIndicatorTitle.setVisibility(View.VISIBLE);
                    scrollView.setNeedScroll(false);
                } else {
                    magicIndicatorTitle.setVisibility(View.GONE);
                    scrollView.setNeedScroll(true);

                }

                if (lastScrollY < h) {
                    scrollY = Math.min(h, scrollY);
                    mScrollY = scrollY > h ? h : scrollY;
                    buttonBarLayout.setAlpha(1f * mScrollY / h);
                    toolbar.setBackgroundColor(((255 * mScrollY / h) << 24) | color);
                    ivHeader.setTranslationY(mOffset - mScrollY);
                }
                if (scrollY == 0) {
                    ivBack.setImageResource(R.drawable.back_white);
                    ivMenu.setImageResource(R.drawable.icon_menu_white);
                } else {
                    ivBack.setImageResource(R.drawable.back_black);
                    ivMenu.setImageResource(R.drawable.icon_menu_black);
                }
                lastScrollY = scrollY;
            }
        });

        buttonBarLayout.setAlpha(0);
        toolbar.setBackgroundColor(0);

        // 适配器
        viewPager.setAdapter(new ComFragmentAdapter(getSupportFragmentManager(), getFragments()));
        viewPager.setOffscreenPageLimit(10);
        initMagicIndicator();
        initMagicIndicatorTitle();

    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(DynamicFragment.getInstance());
        fragments.add(ArticleFragment.getInstance());
        fragments.add(QuestionFragment.getInstance());
        return fragments;
    }

    private void initMagicIndicatorTitle() {
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setScrollPivotX(0.65f);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorFlipPagerTitleView(context);
                simplePagerTitleView.setText(mDataList.get(index));
                simplePagerTitleView.setNormalColor(ContextCompat.getColor(MultiScrollDemoActivity.this, R.color.mainBlack));
                simplePagerTitleView.setSelectedColor(ContextCompat.getColor(MultiScrollDemoActivity.this, R.color.mainBlack));
                simplePagerTitleView.setTextSize(16);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index, false);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineHeight(UIUtil.dip2px(context, 2));
                indicator.setLineWidth(UIUtil.dip2px(context, 20));
                indicator.setRoundRadius(UIUtil.dip2px(context, 3));
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
                indicator.setColors(ContextCompat.getColor(MultiScrollDemoActivity.this, R.color.mainRed));
                return indicator;
            }
        });
        magicIndicatorTitle.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicatorTitle, viewPager);
    }

    private void initMagicIndicator() {
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setScrollPivotX(0.65f);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mDataList == null ? 0 : mDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorFlipPagerTitleView(context);
                simplePagerTitleView.setText(mDataList.get(index));
                simplePagerTitleView.setNormalColor(ContextCompat.getColor(MultiScrollDemoActivity.this, R.color.mainBlack));
                simplePagerTitleView.setSelectedColor(ContextCompat.getColor(MultiScrollDemoActivity.this, R.color.mainBlack));
                simplePagerTitleView.setTextSize(16);
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewPager.setCurrentItem(index, false);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setLineHeight(UIUtil.dip2px(context, 2));
                indicator.setLineWidth(UIUtil.dip2px(context, 20));
                indicator.setRoundRadius(UIUtil.dip2px(context, 3));
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
                indicator.setColors(ContextCompat.getColor(MultiScrollDemoActivity.this, R.color.mainRed));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewPager);
    }

    private void dealWithViewPager() {
        toolBarPositionY = toolbar.getHeight();
        ViewGroup.LayoutParams params = viewPager.getLayoutParams();
        params.height = ScreenUtil.getScreenHeightPx(getApplicationContext()) - toolBarPositionY - magicIndicator.getHeight() + 1;
        viewPager.setLayoutParams(params);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_multiscroll;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_avatar, R.id.tv_username, R.id.tv_position, R.id.tv_edit_info})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_avatar:
                ToastUtil.show(this, "头像");
                break;
            case R.id.tv_username:
                ToastUtil.show(this, "SiberiaDante");
                break;
            case R.id.tv_position:
                ToastUtil.show(this, "中国·GitHub");
                break;
            case R.id.tv_edit_info:
                ToastUtil.show(this, "编辑资料");
                break;
        }
    }
}
