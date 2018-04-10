package com.example.jinhui.androiddemo.day3_interface.interface1;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/27.
 * Email:1004260403@qq.com
 *
 * LayoutInflater类创建View对象
 *
 * 1.使用在 Context 中出现的实例方法 getSystemService(Stringname)，
 * getSystemService是Android很重要的一个API，它是Activity的一
 个方法，根据传入的NAME来取得对应的Object，然后转换成相应的服务对象。

 在这里我们传入Context.LAYOUT_INFLATER_SERVICE，就会返回一个
 LayoutInflater对象。

 2.Activity中出现的实例方法getLayoutInflater()

 当获得LayoutInflater对象后，在调用该对象的inflate(int resource,
 ViewGroup root)方法来创建布局对象，第一个参数是布局文件的ID号，第二
 个参数是生成层次结构的根视图，这里我们暂且不去研究，使用的时候填null
 即可。
 */

public class LayoutInflaterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * 通过LayoutInflater 对象配置布局文件创建View，
         *
         * 创建LayoutInflater的方式有两种:
         * 1、使用在 Context 中出现的实例方法 getSystemService
         * LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         * 2、使用 Activity 中出现的实例方法 getLayoutInflater()
         */

        //1、使用在 Context 中出现的实例方法 getSystemService
        LayoutInflater layoutInflater  = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // 2.使用在 Context 中出现的实例方法 getSystemService(Stringname)
//        LayoutInflater layoutInflater = getLayoutInflater();
        // 创建布局对象
        assert layoutInflater != null;
        LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.layout.layoutinflater, null);
        // 显示view
        setContentView(linearLayout);
    }
}
