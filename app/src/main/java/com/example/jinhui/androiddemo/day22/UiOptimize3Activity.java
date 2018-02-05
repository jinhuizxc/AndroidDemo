package com.example.jinhui.androiddemo.day22;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day22.cache.CacheActivity;
import com.example.jinhui.androiddemo.day22.gridview.GridviewActivity;
import com.example.jinhui.androiddemo.day22.gridview.example.GiftActivity;
import com.example.jinhui.androiddemo.day22.listviewheader.ListViewHeaderActivity;
import com.example.jinhui.androiddemo.day22.reference.ReferenceActivity;
import com.example.jinhui.androiddemo.day22.spinner.SpinnerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class UiOptimize3Activity extends AppCompatActivity {

    @BindView(R.id.bt_gridview)
    Button btGridview;
    @BindView(R.id.bt_spinner)
    Button btSpinner;
    @BindView(R.id.bt_listviewheader)
    Button btListviewheader;
    @BindView(R.id.bt_example)
    Button btExample;
    @BindView(R.id.bt_oom)
    Button btOom;
    @BindView(R.id.bt_cache)
    Button btCache;
    @BindView(R.id.bt_java_reference)
    Button btJavaReference;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uioptimize3);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_listviewheader, R.id.bt_gridview, R.id.bt_example,
            R.id.bt_spinner, R.id.bt_oom, R.id.bt_cache, R.id.bt_java_reference})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_listviewheader:
                startActivity(new Intent(this, ListViewHeaderActivity.class));
                break;
            case R.id.bt_gridview:
                startActivity(new Intent(this, GridviewActivity.class));
                break;
            case R.id.bt_example:
                startActivity(new Intent(this, GiftActivity.class));
                break;
            case R.id.bt_spinner:
                startActivity(new Intent(this, SpinnerActivity.class));
                break;
            case R.id.bt_oom:
                doOom();
                break;
            case R.id.bt_cache:
                startActivity(new Intent(this, CacheActivity.class));
                break;
            case R.id.bt_java_reference:
                Toast.makeText(this, "见代码注解", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(this, ReferenceActivity.class));
                break;
        }
    }

    /**
     * 什么是OOM
     * 手机系统内存份存储内存（ROM）和运行内存（RAM），我们谈论OOM讨论的是运行内存。
     * 简而言之，OOM就是我们申请的内存太大了，超出了系统分配给我们（app或者说进程）的可用内存。
     * android系统的app的每个进程或者每个虚拟机有个最大内存限制，如果申请的内存资源超过这个限制，系统就会抛出OOM错误。跟整个设备的剩余内存没太大关系。比如比较早的android系统的一个虚拟机最多16M内存，当一个app启动后，虚拟机不停的申请内存资源来装载图片，当超过内存上限时就出现OOM。
     */
    private void doOom() {
        Toast.makeText(this, "见代码注解", Toast.LENGTH_SHORT).show();
    }
}
