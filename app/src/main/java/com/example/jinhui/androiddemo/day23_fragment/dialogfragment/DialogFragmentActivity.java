package com.example.jinhui.androiddemo.day23_fragment.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/4/7.
 * Email:1004260403@qq.com
 */
public class DialogFragmentActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        Fragment_dialog fragment_dialog = new Fragment_dialog();
        fragment_dialog.show(getFragmentManager(), "dialog");
    }
}
