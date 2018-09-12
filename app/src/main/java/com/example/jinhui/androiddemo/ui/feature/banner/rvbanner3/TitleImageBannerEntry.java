package com.example.jinhui.androiddemo.feature.banner.rvbanner3;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.widget.rvbanner3.BannerEntry;


/**
 * 创建人 kelin
 * 创建时间 2017/7/25  下午5:12
 * 版本 v 1.0.0
 */

public class TitleImageBannerEntry implements BannerEntry<String> {
    private final String url;
    private String title;
    private String subTitle;
    @DrawableRes
    private int imgRes;

    TitleImageBannerEntry(String title, String subTitle, int imgRes, String url) {
        this.title = title;
        this.subTitle = subTitle;
        this.imgRes = imgRes;
        this.url = url;
    }

    @Override
    @NonNull
    public View onCreateView(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_title_banner_item, parent, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_image);
        imageView.setImageResource(imgRes);
        return view;
    }

    /**
     * 获取标题
     *
     * @return 返回当前条目的标题。
     */
    @Override
    public CharSequence getTitle() {
        return title;
    }

    /**
     * 获取子标题。
     *
     * @return 返回当前条目的子标题。
     */
    @Nullable
    @Override
    public CharSequence getSubTitle() {
        return subTitle;
    }

    /**
     * 获取当前页面的数据。
     *
     * @return 返回当前页面的数据。
     */
    @Override
    public String getValue() {
        return url;
    }

    @Override
    public boolean same(BannerEntry newEntry) {
        return newEntry instanceof TitleImageBannerEntry && TextUtils.equals(title, newEntry.getTitle()) && TextUtils.equals(subTitle, newEntry.getSubTitle()) && imgRes == ((TitleImageBannerEntry)newEntry).imgRes;
    }
}
