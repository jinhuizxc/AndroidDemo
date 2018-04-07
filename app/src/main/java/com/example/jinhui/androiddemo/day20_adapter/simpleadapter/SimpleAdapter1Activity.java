package com.example.jinhui.androiddemo.day20_adapter.simpleadapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class SimpleAdapter1Activity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simpleadapter1);
        ButterKnife.bind(this);

        // 图片数据
        int imageIds[] = {R.drawable.a01, R.drawable.a02, R.drawable.a03,
                R.drawable.a04, R.drawable.a05};

        // 书名
        String names[] = {"Java", "Lua", "Php", "Unity", "MySql"};

        // 价格
        double prices[] = {99.9, 78.9, 91.9, 111.0, 110.9};

        // 数量
        int numbers[] = {1, 1, 1, 1, 1};

        //数据源
        ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < numbers.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("image", imageIds[i]);
            map.put("name", names[i]);
            map.put("price", prices[i]);
            map.put("number", numbers[i]);

            data.add(map);
        }


        //布局
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.simple_item1,
                new String[]{"image", "name", "price", "number"},
                new int[]{R.id.imageView1, R.id.textView1, R.id.textView2, R.id.textView3});

        listview.setAdapter(adapter);
    }
}
