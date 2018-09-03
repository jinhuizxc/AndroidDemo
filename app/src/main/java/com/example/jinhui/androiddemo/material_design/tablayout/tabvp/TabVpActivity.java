package com.example.jinhui.androiddemo.material_design.tablayout.tabvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.material_design.tablayout.tabvp.TabFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jh on 2018/9/3.
 * Email: 1004260403@qq.com
 *
 * tablayout +  viewpager
 */
public class TabVpActivity extends AppCompatActivity {

    List<String> mTitle = new ArrayList<>();
    List<String> mData = new ArrayList<>();
//    String[] mTitle = new String[20];
//    String[] mData = new String[20];
    TabLayout mTabLayout;
    ViewPager mViewPager;

    private int tabCount = 4;
    //当标签数目小于等于4个时，标签栏不可滑动
    public static final int MOVABLE_COUNT = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabvp);

        mTabLayout = (TabLayout) findViewById(R.id.tl_tab);
        mViewPager = (ViewPager) findViewById(R.id.vp_pager);

        initData();
        initTabLayout();
    }

    private void initData() {
        for (int i = 0; i < tabCount; i++) {
            mTitle.add("TAB" + (i + 1));
            mData.add("当前选中的是第" + (i + 1) + "Fragment");
        }
    }

    private void initTabLayout() {

        //MODE_FIXED标签栏不可滑动，各个标签会平分屏幕的宽度
        mTabLayout.setTabMode(tabCount <= MOVABLE_COUNT ? TabLayout.MODE_FIXED : TabLayout.MODE_SCROLLABLE);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //此方法用来显示tab上的名字
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position % mTitle.size());
            }

            @Override
            public Fragment getItem(int position) {
                //创建Fragment并返回
                TabFragment fragment = new TabFragment();
                fragment.setTitle(mData.get(position % mTitle.size()));
                return fragment;
            }

            @Override
            public int getCount() {
                return mTitle.size();
            }
        });
        //将ViewPager关联到TabLayout上
        mTabLayout.setupWithViewPager(mViewPager);

//  设置监听,注意:如果设置了setOnTabSelectedListener,则setupWithViewPager不会生效
//  因为setupWithViewPager内部也是通过设置该监听来触发ViewPager的切换的.
//  mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//   @Override
//   public void onTabSelected(TabLayout.Tab tab) {
//   }
//
//   @Override
//   public void onTabUnselected(TabLayout.Tab tab) {
//
//   }
//
//   @Override
//   public void onTabReselected(TabLayout.Tab tab) {
//
//   }
//  });
//  那我们如果真的需要监听tab的点击或者ViewPager的切换,则需要手动配置ViewPager的切换,例如:
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //切换ViewPager
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
