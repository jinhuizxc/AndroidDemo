package com.example.jinhui.androiddemo.ui.banner.rvbanner3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.ui.banner.rvbanner3.holder.BannerHolder;
import com.example.jinhui.androiddemo.ui.banner.rvbanner3.holder.BannerHolder2;
import com.example.jinhui.androiddemo.ui.banner.rvbanner3.holder.BannerHolder3;
import com.example.jinhui.androiddemo.widget.rvbanner3.BannerEntry;
import com.example.jinhui.androiddemo.widget.rvbanner3.view.BannerView;
import com.kelin.recycleradapter.ItemAdapter;
import com.kelin.recycleradapter.MultiTypeAdapter;
import com.kelin.recycleradapter.interfaces.EventBindInterceptor;
import com.kelin.recycleradapter.interfaces.LayoutItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jh on 2018/8/31.
 * Email: 1004260403@qq.com
 *
 * 代码2: https://github.com/loonggg/RecyclerViewBanner
 */
public class RVBanner3Activity extends AppCompatActivity {

    private EventBindInterceptor mEventInterceptor;
    private BannerView.OnPageClickListener mOnBannerEventListener;
    private BannerView bannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvbanner3);
        bannerView = (BannerView) findViewById(R.id.vp_view_pager);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        MultiTypeAdapter adapter = new MultiTypeAdapter(recyclerView);
        ItemAdapter<List<ImageBannerEntry>> banner1Adapter = new ItemAdapter<>(BannerHolder.class, getImageBannerEntries());
        ItemAdapter<List<TitleImageBannerEntry>> banner2Adapter = new ItemAdapter<>(BannerHolder2.class, getTitleImageBannerEntries());
        ItemAdapter<List<TitleImageBannerEntry>> banner3Adapter = new ItemAdapter<>(BannerHolder3.class, getTitleImageBannerEntry());
        banner1Adapter.setEventInterceptor(getItemEventInterceptor());
        banner2Adapter.setEventInterceptor(getItemEventInterceptor());
        banner3Adapter.setEventInterceptor(getItemEventInterceptor());
        adapter.addAdapter(banner1Adapter, banner2Adapter, banner3Adapter, new ItemAdapter<>(getStringList(), ItemHolder.class));
        recyclerView.setAdapter(adapter);
    }

    private EventBindInterceptor getItemEventInterceptor() {
        if (mEventInterceptor == null) {
            mEventInterceptor = new EventBindInterceptor() {
                @Override
                public boolean onInterceptor(View view, LayoutItem layoutItem) {
                    if (view.getId() == R.id.vp_view_pager) {
                        BannerView bannerView = (BannerView) view;
                        bannerView.setOnPageClickListener(new BannerView.OnPageClickListener() {
                            @Override
                            public void onPageClick(BannerEntry entry, int index) {
                                //某个页面被单击后执行，entry就是这个页面的数据模型。index是页面索引，从0开始。
                                Toast.makeText(RVBanner3Activity.this, "单击：" + entry.getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        bannerView.setOnPageLongClickListener(new BannerView.OnPageLongClickListener() {
                            @Override
                            public void onPageLongClick(BannerEntry entry, int index) {
                                //某个页面被长按后执行，entry就是这个页面的数据模型。index是页面索引，从0开始。
                                Toast.makeText(RVBanner3Activity.this, "长按：" + entry.getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        });
                        bannerView.setOnPageChangedListener(new BannerView.OnPageChangeListener() {
                            @Override
                            public void onPageSelected(BannerEntry entry, int index) {
                                //某个页面被选中后执行，entry就是这个页面的数据模型。index是页面索引，从0开始。
                            }

                            @Override
                            public void onPageScrolled(int index, float positionOffset, int positionOffsetPixels) {
                                //页面滑动中执行，这个与ViewPage的回调一致。
                            }

                            @Override
                            public void onPageScrollStateChanged(int state) {
                                //页面滑动的状态被改变时执行，也是与ViewPager的回调一致。
                            }
                        });
                        return true;
                    }
                    return false;
                }
            };
        }
        return mEventInterceptor;
    }

    @Override
    protected void onStart() {
        super.onStart();
        bannerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                bannerView.setEntries(getTitleImageBannerEntries());
            }
        }, 500);
    }

    @NonNull
    private BannerView.OnPageClickListener getBannerEventListener() {
        if (mOnBannerEventListener == null) {
            mOnBannerEventListener = new BannerView.OnPageClickListener() {
                @Override
                public void onPageClick(BannerEntry entry, int index) {
                    if (entry instanceof ImageBannerEntry) {
                        SubActivity.start(RVBanner3Activity.this, ((ImageBannerEntry) entry).getValue());
                    } else if (entry instanceof TitleImageBannerEntry) {
                        SubActivity.start(RVBanner3Activity.this, ((TitleImageBannerEntry) entry).getValue());
                    }
                }
            };
        }
        return mOnBannerEventListener;
    }

    @NonNull
    private List<ImageBannerEntry> getImageBannerEntries() {
        List<ImageBannerEntry> items = new ArrayList<>();
        items.add(new ImageBannerEntry("大话西游：“炸毛韬”引诱老妖", "更新至50集", "http://m.qiyipic.com/common/lego/20171026/dd116655c96d4a249253167727ed37c8.jpg"));
        items.add(new ImageBannerEntry("天使之路：藏风大片遇高反危机", "10-29期", "http://m.qiyipic.com/common/lego/20171029/c9c3800f35f84f1398b89740f80d8aa6.jpg"));
        items.add(new ImageBannerEntry("星空海2：陆漓设局害惨吴居蓝", "更新至30集", "http://m.qiyipic.com/common/lego/20171023/bd84e15d8dd44d7c9674218de30ac75c.jpg"));
        items.add(new ImageBannerEntry("中国职业脱口秀大赛：狂笑首播", "10-28期", "http://m.qiyipic.com/common/lego/20171028/f1b872de43e649ddbf624b1451ebf95e.jpg"));
        items.add(new ImageBannerEntry("奇秀好音乐，你身边的音乐真人秀", null, "http://pic2.qiyipic.com/common/20171027/cdc6210c26e24f08940d36a5eb918c34.jpg"));
        return items;
    }

    @NonNull
    private List<TitleImageBannerEntry> getTitleImageBannerEntries() {
        List<TitleImageBannerEntry> items = new ArrayList<>();
        items.add(new TitleImageBannerEntry("中国新歌声：E神赞藏语Rap", "更新至10集", R.drawable.img_banner01, "我是第一页"));
        items.add(new TitleImageBannerEntry("中国有嘻哈:热狗公演霸气嗨唱", "更新至11集", R.drawable.img_banner02, "我是第二页"));
        items.add(new TitleImageBannerEntry("爱笑会议室：三生三世虐恋情缘", "更新至12集", R.drawable.img_banner03, "我是第三页"));
        items.add(new TitleImageBannerEntry("开心剧乐部：吴京上演战狼故事", "更新至13集", R.drawable.img_banner04, "我是第四页"));
        return items;
    }

    @NonNull
    private List<TitleImageBannerEntry> getTitleImageBannerEntry() {
        List<TitleImageBannerEntry> items = new ArrayList<>();
        items.add(new TitleImageBannerEntry("中国新歌声：E神赞藏语Rap", "更新至10集", R.drawable.img_banner01, "我是第一页"));
        items.add(new TitleImageBannerEntry("中国有嘻哈:热狗公演霸气嗨唱", "更新至11集", R.drawable.img_banner02, "我是第二页"));
        items.add(new TitleImageBannerEntry("爱笑会议室：三生三世虐恋情缘", "更新至12集", R.drawable.img_banner03, "我是第三页"));
        items.add(new TitleImageBannerEntry("开心剧乐部：吴京上演战狼故事", "更新至13集", R.drawable.img_banner04, "我是第四页"));
        return items;
    }

    public List<String> getStringList() {
        List<String> list = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            list.add("我是条目" + i);
        }
        return list;
    }
}
