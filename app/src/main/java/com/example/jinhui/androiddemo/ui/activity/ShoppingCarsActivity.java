package com.example.jinhui.androiddemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.base.BaseActivity;
import com.example.jinhui.androiddemo.feature.shopcar.leftandright.ShoppingCartActivity;
import com.example.jinhui.androiddemo.feature.shopcar.rvshopcar.RvShopCarActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jh on 2018/9/17.
 * Email: 1004260403@qq.com
 * <p>
 * 购物车效果合集
 */
public class ShoppingCarsActivity extends BaseActivity {

    @BindView(R.id.bt_01)
    Button bt01;
    @BindView(R.id.bt_02)
    Button bt02;

    @Override
    protected void initData() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_shopping_cars;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_01, R.id.bt_02})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_01:
                startActivity(new Intent(this, ShoppingCartActivity.class));
                break;
            case R.id.bt_02:
                startActivity(new Intent(this, RvShopCarActivity.class));
                break;
        }
    }
}
