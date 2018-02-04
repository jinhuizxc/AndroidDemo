package com.example.jinhui.androiddemo.day21.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/4.
 * Email:1004260403@qq.com
 */

public class ChatActivity extends AppCompatActivity {

    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.bt_send_left)
    Button btSendLeft;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.bt_send_right)
    Button btSendRight;

    ArrayList<Msg> data = new ArrayList<Msg>();
    ChatAdapter chatAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        chatAdapter = new ChatAdapter(this, data);
        listView.setAdapter(chatAdapter);
    }

    @OnClick({R.id.bt_send_left, R.id.bt_send_right})
    public void onViewClicked(View view) {
        // 输入为空的话return
        String text = editText.getText().toString();
        if(text.length() == 0){
            Toast.makeText(this, "输入不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Msg msg = null;
        //刷新到ListView中
        switch (view.getId()) {
            case R.id.bt_send_left:
                msg = new Msg(text, true);
                break;
            case R.id.bt_send_right:
                msg = new Msg(text, false);
                break;
        }

        chatAdapter.add(msg);
        //将listView显示焦点移动到最后一行
        listView.setSelection(data.size());
        editText.setText("");
    }
}
