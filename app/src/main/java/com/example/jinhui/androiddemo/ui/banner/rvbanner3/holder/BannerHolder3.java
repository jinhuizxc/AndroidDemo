package com.example.jinhui.androiddemo.ui.banner.rvbanner3.holder;

import android.view.View;


import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.ui.banner.rvbanner3.TitleImageBannerEntry;
import com.example.jinhui.androiddemo.feature.banner.rvbanner3.transformer.ScrollPaintingPageTransformer;
import com.example.jinhui.androiddemo.widget.rvbanner3.view.BannerView;
import com.kelin.recycleradapter.holder.ItemLayout;
import com.kelin.recycleradapter.holder.ItemViewHolder;

import java.util.List;

/**
 * 创建人 kelin
 * 创建时间 2017/7/26  下午6:00
 * 版本 v 1.0.0
 */
@ItemLayout(R.layout.item_banner3)
public class BannerHolder3 extends ItemViewHolder<List<TitleImageBannerEntry>> {


    private final BannerView mBannerView;

    protected BannerHolder3(final View itemView) {
        super(itemView);
        //找到BannerView控件。
        mBannerView = getView(R.id.vp_view_pager);
        //设置翻页动画改变器
        mBannerView.setPageTransformer(true, new ScrollPaintingPageTransformer());
    }

    @Override
    public void onBindData(int i, List<TitleImageBannerEntry> bannerEntries) {
        //设置数据源并开始轮播。如果不希望启动轮播则调用两个参数的方法。
        mBannerView.setEntries(bannerEntries);
    }

    @Override
    public int[] onGetNeedListenerChildViewIds() {
        return new int[]{R.id.vp_view_pager};
    }
}
