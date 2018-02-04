package com.example.jinhui.androiddemo.day20.baseadapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 */

public class BaseAdapterActivity extends AppCompatActivity {

    @BindView(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseadapter);
        ButterKnife.bind(this);

        // 图片数据
        int imageIds[] = { R.drawable.a01, R.drawable.a02, R.drawable.a03,
                R.drawable.a04, R.drawable.a05 };

        // 书名
        String names[] = { "Java", "Lua", "Php", "Unity", "MySql" };

        // 价格
        double prices[] = { 99.9, 78.9, 91.9, 111.0, 110.9 };

        // 数量
        int numbers[] = { 1, 1, 1, 1, 1 };

        //数据源
        ArrayList<Book> data = new ArrayList<Book>();
        for (int i = 0; i < numbers.length; i++) {
            Book book = new Book(names[i], imageIds[i], prices[i], numbers[i]);
            data.add(book);
        }

        BookAdapter adapter = new BookAdapter(this, data);

        listview.setAdapter(adapter);
    }

}
