package com.example.jinhui.androiddemo.day23_fragment.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day23_fragment.example.fragment.ChatFragment;
import com.example.jinhui.androiddemo.day23_fragment.example.fragment.ContactFragment;
import com.example.jinhui.androiddemo.day23_fragment.example.fragment.DiscoverFragment;
import com.example.jinhui.androiddemo.day23_fragment.example.fragment.MeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 *
 * 微信底部导航效果
 */

public class WeixinActivity extends AppCompatActivity {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;

    // fragment的链表
    ArrayList<Fragment> data = new ArrayList<Fragment>();
    int[] ids = new int[] { R.id.button1, R.id.button2, R.id.button3, R.id.button4 };
    int[] whiteBacs = new int[] { R.drawable.chat1, R.drawable.contact1, R.drawable.discover1, R.drawable.me1 };
    int[] greenBacs = new int[] { R.drawable.chat2, R.drawable.contact2, R.drawable.discover2, R.drawable.me2 };

    Button[] bts = new Button[] { button1, button2, button3, button4 };
    Fragment[] fragments = new Fragment[] { new ChatFragment(),
            new ContactFragment(), new DiscoverFragment(), new MeFragment() };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weixin);
        ButterKnife.bind(this);
        // FragmentPagerAdapter仅仅支持v4包
        // import android.support.v4.app.FragmentPagerAdapter;

        /**
         * java.lang.NullPointerException:
         * Attempt to invoke virtual method 'void android.widget.Button.setBackgroundResource(int)'
         */
        for (int i = 0; i < bts.length; i++) {
            // 这里还必须写findViewById，不然会报空指针异常
            bts[i] = (Button) findViewById(ids[i]);
            data.add(fragments[i]);
        }

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(this.getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return data.get(position);
            }

            @Override
            public int getCount() {
                return data.size();
            }
        };
        // 绑定适配器
        viewpager.setAdapter(adapter);
        // setOnPageChangeListener被弃用
//        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }/
//        });

        // setOnPageChangeListener被弃用, 改换为addOnPageChangeListener
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bts[position].setBackgroundResource(greenBacs[position]);
                for (int i = 0; i < bts.length; i++) {
                    if (i != position){
                        bts[i].setBackgroundResource(whiteBacs[i]);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                doChange(view);
                break;
            case R.id.button2:
                doChange(view);
                break;
            case R.id.button3:
                doChange(view);
                break;
            case R.id.button4:
                doChange(view);
                break;
        }
    }

    private void doChange(View view) {
        for (int i = 0; i < fragments.length; i++) {
            if (view.getId() == ids[i]){
                viewpager.setCurrentItem(i);
                bts[i].setBackgroundResource(greenBacs[i]);
            }else {
                bts[i].setBackgroundResource(whiteBacs[i]);
            }
        }
    }

}
