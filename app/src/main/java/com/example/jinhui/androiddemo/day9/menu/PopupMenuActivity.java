package com.example.jinhui.androiddemo.day9.menu;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/31.
 * Email:1004260403@qq.com
 * <p>
 * PopupMenu
 * <p>
 * 1.创建PopupMenu
 * PopupMenu pop = new PopupMenu(this, v);
 * this.getMenuInflater().inflate(R.menu.main, pop.getMenu());
 * pop.show();
 * <p>
 * 2.监听PopupMenu菜单项
 * pop.setOnMenuItemClickListener(new OnMenuItemClickListener() {
 *
 * @Override public boolean onMenuItemClick(MenuItem item) {
 * return false;
 * }
 * });
 */

public class PopupMenuActivity extends AppCompatActivity {

    @BindView(R.id.bt_popupmenu)
    Button btPopupmenu;
    @BindView(R.id.bt_PopupWindow)
    Button btPopupWindow;

    private View mPopWindowView;
    private PopupWindow mPopWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_popupmenu);
        /**setContentView可以解析布局，也可以不解析直接应用布局文件*/
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.activity_popupmenu, null);
        setContentView(view);
        ButterKnife.bind(this);
    }

    /**
     * ButterKnife一个点击事件本身这个方法没有参数，
     * 由于PopupMenu的需要加上View view的形参；
     * <p>
     * ButterKnife多个点击事件本身有参数。
     *
     * @param view
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    @OnClick({R.id.bt_popupmenu, R.id.bt_PopupWindow})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_popupmenu:
                doPopupmenu(view);
                break;
            case R.id.bt_PopupWindow:
                doPopupWindow(view);
                break;
        }

    }

    /**
     * 补充下PopupWindow
     * PopupWindow
     * PopupWindow相比menu功能要强的多，可以实现布局更加复杂的效果
     * <p>
     * 其实用法和Menu差不多，只是背景色必须要在代码里进行设置，否则点击外面窗体不会消失，不知道这是BUG，还是Google就是这么设计的，有点想不通。
     *
     * @param view
     */
    private void doPopupWindow(View view) {
        mPopWindowView = getLayoutInflater().inflate(R.layout.pop_window_layout, null);
        // Focusable 为True，PopupWindow的点击事件才会相应
        mPopWindow = new PopupWindow(mPopWindowView, 400, 400, true);
        // 必须在代码中设置一下背景色，点击外面不会隐藏此弹窗
        mPopWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // Focusable 为False时，不执行则点击外面不会隐藏此弹窗
        //mPopWindow.setOutsideTouchable(true);

       // 显示 默认显示View的正下方，可以使用重载方法设置偏移量来调整位置
        mPopWindow.showAsDropDown(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void doPopupmenu(View view) {
        // 创建menu菜单
        PopupMenu menu = new PopupMenu(this, view);
        getMenuInflater().inflate(R.menu.pop_menu, menu.getMenu());
        menu.setGravity(Gravity.RIGHT); // 设置LETFT、CENTER效果一样，均在左侧
        menu.show();
        // 对menu菜单项进行监听
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.item01:
                        Toast.makeText(PopupMenuActivity.this, "item01", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item02:
                        Toast.makeText(PopupMenuActivity.this, "item02", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item03:
                        finish();
                        break;
                }
                return false;
            }
        });

        menu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {

            }
        });
    }


    /**
     * OptionsMenu菜单
     * 不置为return true;也可以创建OptionsMenu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_popup_window, menu);
        return super.onCreateOptionsMenu(menu);
//        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item01) {
            Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item02) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }
//        return true;

        return super.onOptionsItemSelected(item);
    }
}
