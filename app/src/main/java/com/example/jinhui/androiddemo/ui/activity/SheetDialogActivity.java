package com.example.jinhui.androiddemo.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.base.BaseActivity;
import com.example.jinhui.androiddemo.utils.ToastUtil;
import com.example.jinhui.androiddemo.widget.SheetDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jh on 2018/9/11.
 * Email: 1004260403@qq.com
 *
 * 底部弹框
 * https://github.com/bajian/sheetDialogueDemo
 */
public class SheetDialogActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private String[] strs = new String[]{"aaa", "bbbb", "123", "aaa", "bbbb", "123"};

    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        // 设置支持toolbar
        setSupportActionBar(toolbar);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_sheet_dialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fab)
    public void onViewClicked() {
        // 打开底部弹框
        new SheetDialog(this)
                .setTitle("请选择: ")
                .setCancelableOnTouchOutSide(false)
                .addSheetItems(strs, SheetDialog.SheetItemColor.Blue,
                        new SheetDialog.OnSheetItemClickListener(){

                            @Override
                            public void onClick(int which, String content) {
                                ToastUtil.show(getApplicationContext(), "which = " + which + ", " + "content = " + content);
                                System.out.println("which" + which);
                            }

                        }).show();
    }
}
