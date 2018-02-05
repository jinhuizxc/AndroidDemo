package com.example.jinhui.androiddemo.day23.example1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class TopActivity extends FragmentActivity implements View.OnClickListener {


    ViewPager viewPager;
    Button button1, button2, button3, button4;
    Button[] bts = new Button[] { button1, button2, button3, button4 };
    int ids[] = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button4};
    int[] whiteBacs = new int[] { R.drawable.chat1, R.drawable.contact1, R.drawable.discover1, R.drawable.me1 };
    int[] greenBacs = new int[] { R.drawable.chat2, R.drawable.contact2, R.drawable.discover2, R.drawable.me2 };
    ArrayList<Fragment> fragment = new ArrayList<Fragment>();
    Fragment fragments[] = new Fragment[]{new FragmentOne(), new FragmentTwo(),
            new FragmentThird(), new FragmentFour()};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        for (int i = 0; i < bts.length; i++) {
            bts[i] = findViewById(ids[i]);
            bts[i].setOnClickListener(this);
            fragment.add(fragments[i]);
        }

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        // FragmentManager fm = this.getFragmentManager();
        // FragmentTransaction trans = fm.beginTransaction();
        // trans.hide(fragment);
        // trans.show(fragment);
        // trans.remove(fragment);
        // trans.commit();
        /**
         * this.getFragmentManager();这个方法只有在app.fragment里面才可以用，v4不可以！,
         * v4的是getSupportFragmentManager，方法属于FragmentActivity
         */

        FragmentManager fm = this.getSupportFragmentManager();
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(fm) {

            @Override
            public int getCount() {
                return fragment.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return fragment.get(arg0);
            }
        };
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            //当用户成功切换到一个新的页面时，系统调用该方法
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
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button1){
            doChange(v);
        }else if(v.getId() == R.id.button2){
            doChange(v);
        }else if(v.getId() == R.id.button3){
            doChange(v);
        }else if(v.getId() == R.id.button4){
            doChange(v);
        }
    }

    private void doChange(View view) {
        for (int i = 0; i < fragments.length; i++) {
            if (view.getId() == ids[i]){
                viewPager.setCurrentItem(i);
                bts[i].setBackgroundResource(greenBacs[i]);
            }else {
                bts[i].setBackgroundResource(whiteBacs[i]);
            }
        }
    }

}
