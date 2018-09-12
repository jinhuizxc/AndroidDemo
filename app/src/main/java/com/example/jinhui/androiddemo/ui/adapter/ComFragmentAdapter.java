package com.example.jinhui.androiddemo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by jh on 2018/9/10.
 * Email: 1004260403@qq.com
 */
public class ComFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public ComFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public ComFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments != null ? fragments.size() : 0;
    }
}
