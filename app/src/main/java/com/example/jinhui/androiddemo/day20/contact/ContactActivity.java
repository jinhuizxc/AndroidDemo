package com.example.jinhui.androiddemo.day20.contact;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/3.
 * Email:1004260403@qq.com
 * <p>
 * 1. 联系人数据库
 * 2. 制作ListView
 * 3. 增删该查，结果刷新到ListView上
 * 4. 优化（数据库优化，ListView优化）
 */

public class ContactActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.bt_add)
    Button btAdd;
    SQLiteDatabase db;

    MyAdapter adapter;

    ArrayList<Person> data = new ArrayList<Person>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);


        MySqliteOpenHelper helper = new MySqliteOpenHelper(this, "contacts.db",
                null, 1);
        db = helper.getWritableDatabase();

        adapter = new MyAdapter(this, data);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(this);


        // 查询数据库 --> 保存data中
        // 刷新ListView
        queryAndRefresh();
    }


    @OnClick(R.id.bt_add)
    public void onViewClicked() {

        // 添加记录
        // 1.用户输入的
        // 2.添加到数据库中
        // 3.更新视图

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("添加");
        View view = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        final EditText etName = (EditText) view.findViewById(R.id.editText1);
        final EditText etPhone = (EditText) view.findViewById(R.id.editText2);
        builder.setView(view);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();

                //添加到数据库
                ContentValues values = new ContentValues();
                values.put(MySqliteOpenHelper.FIELD_NAME, name);
                values.put(MySqliteOpenHelper.FIELD_PHONE, phone);
                db.insert(MySqliteOpenHelper.TABLE_NAME, null, values);
                Log.e("Test", "添加一条记录");

                //查询新增记录的id
                Cursor cursor = db.query(MySqliteOpenHelper.TABLE_NAME, null, null,
                        null, null, null, null);
                cursor.moveToLast();
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                //更新视图
                data.add(new Person(name, phone, id));
                adapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("取消", null);
        builder.create();
        builder.show();
    }

    /**
     * 查询数据库 --> 保存data中 刷新ListView
     */
    private void queryAndRefresh() {

        Cursor cursor = db.query(MySqliteOpenHelper.TABLE_NAME, null, null,
                null, null, null, null);
        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor
                    .getColumnIndex(MySqliteOpenHelper.FIELD_NAME));
            String phone = cursor.getString(cursor
                    .getColumnIndex(MySqliteOpenHelper.FIELD_PHONE));

            data.add(new Person(name, phone, id));
        }

        // 刷新适配器。通知系统调用适配器中的方法，更新视图
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 关闭数据库
        db.close();
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view,
                                   final int position, long id) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("更新");
        View viewDialog = LayoutInflater.from(this).inflate(R.layout.dialog, null);
        final EditText etName = (EditText) viewDialog.findViewById(R.id.editText1);
        final EditText etPhone = (EditText) viewDialog.findViewById(R.id.editText2);

        etName.setText(data.get(position).getName());
        etPhone.setText(data.get(position).getPhone());
        builder.setView(viewDialog);
        //增加了删除与更新数据操作----------添加项有哪些好好体会下
        builder.setPositiveButton("删除", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                String args = String.valueOf(data.get(position).getId());

                //将记录从数据库中删除
                db.delete(MySqliteOpenHelper.TABLE_NAME, "id = ?", new String[]{args});
                Log.d("Test", "成功删除一条记录");

                //更新视图
                data.remove(position);
                adapter.notifyDataSetChanged();

            }
        });

        builder.setNeutralButton("更新", new DialogInterface.OnClickListener() {

            private Person person;
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //更新数据库
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();

                String args = String.valueOf(data.get(position).getId());
                ContentValues values = new ContentValues();
                values.put("name", String.valueOf(name));
                values.put("phone", String.valueOf(phone));
                db.update(MySqliteOpenHelper.TABLE_NAME, values, "id = ?", new String[]{args});
                //更新视图
                person = new Person();
                person.setName(name);
                person.setPhone(phone);
                data.set(position, person);
                adapter.notifyDataSetChanged();
            }
        });

        builder.setNegativeButton("取消", null);
        builder.create();
        builder.show();
        return false;
    }
}
