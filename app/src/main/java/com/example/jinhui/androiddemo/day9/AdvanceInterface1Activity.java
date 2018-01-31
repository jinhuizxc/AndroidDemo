package com.example.jinhui.androiddemo.day9;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;
import com.example.jinhui.androiddemo.day9.datetime.Date_timeActivity;
import com.example.jinhui.androiddemo.day9.datetime.ModifyDate_timeActivity;
import com.example.jinhui.androiddemo.day9.dialog.AlertdialogActivity;
import com.example.jinhui.androiddemo.day9.menu.PopupMenuActivity;
import com.example.jinhui.androiddemo.day9.popup.PopupwindowActivity;
import com.example.jinhui.androiddemo.day9.radiocheck.GameActivity;
import com.example.jinhui.androiddemo.day9.radiocheck.RadioCheckBoxActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/31.
 * Email:1004260403@qq.com
 */

public class AdvanceInterface1Activity extends AppCompatActivity {

    @BindView(R.id.bt_radio_checkbox)
    Button btRadioCheckbox;
    @BindView(R.id.bt_popupmenu)
    Button btPopupmenu;
    @BindView(R.id.optionmenu)
    Button optionmenu;
    @BindView(R.id.contextmenu)
    Button contextmenu;
    @BindView(R.id.bt_alertdialog)
    Button btAlertdialog;
    @BindView(R.id.popupwindow)
    Button popupwindow;
    @BindView(R.id.bt_date_time)
    Button btDateTime;
    @BindView(R.id.bt_game)
    Button btGame;
    @BindView(R.id.tv_contextmenu)
    TextView tvContextmenu;

    // 为每个菜单定义一个标识
    final int MENU1 = 0x111;
    final int MENU2 = 0x112;
    @BindView(R.id.bt_modify_date_time)
    Button btModifyDateTime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanceinterface1);
        ButterKnife.bind(this);

        /**注册register的4个方法
         * registerForContextMenu(tv);
         * registerComponentCallbacks(callback)
         * registerReceiver(receiver, filter)
         * registerReceiver(receiver, filter, broadcastPermission, scheduler)*/
        // 注册tv，当用户长按tv时，触发上下文菜单
        registerForContextMenu(tvContextmenu);
    }

    @OnClick({R.id.bt_radio_checkbox, R.id.bt_game, R.id.bt_popupmenu,
            R.id.optionmenu, R.id.contextmenu, R.id.bt_alertdialog,
            R.id.popupwindow, R.id.bt_date_time, R.id.bt_modify_date_time})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_radio_checkbox:
                startActivity(new Intent(this, RadioCheckBoxActivity.class));
                break;
            case R.id.bt_game:
                startActivity(new Intent(this, GameActivity.class));
                break;
            case R.id.bt_popupmenu:
                startActivity(new Intent(this, PopupMenuActivity.class));
                break;
            case R.id.optionmenu:
                Toast.makeText(this, "见本界面效果", Toast.LENGTH_SHORT).show();
                break;
            case R.id.contextmenu:
                Toast.makeText(this, "点击文本见效果", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_alertdialog:
                startActivity(new Intent(this, AlertdialogActivity.class));
                break;
            case R.id.popupwindow:
                startActivity(new Intent(this, PopupwindowActivity.class));
                break;
            case R.id.bt_date_time:
                startActivity(new Intent(this, Date_timeActivity.class));
                break;
            case R.id.bt_modify_date_time:
                startActivity(new Intent(this, ModifyDate_timeActivity.class));
                break;
        }
    }

    /**
     * 创建选项菜单
     * OptionMenu
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.quit) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * //创建上下文菜单
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // 1.手动添加菜单项
        menu.addSubMenu(0, MENU1, 0, "收藏");
        menu.addSubMenu(0, MENU2, 0, "删除");
        // 将三个菜单项设为单选菜单项
        menu.setGroupCheckable(0, true, true);
        //设置上下文菜单的标题、图标
        menu.setHeaderIcon(R.drawable.ic_launcher);
        menu.setHeaderTitle("请选择item");

        // 2.通过xml文件来配置上下文菜单选项
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.context_menu, menu);
    }

    /**
     * 监听上下文菜单项
     *
     * @param item
     * @return
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == MENU1) {
            item.setChecked(true);
            Toast.makeText(this, "收藏", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == MENU2) {
            item.setChecked(true);
            Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.favor) {
            Toast.makeText(this, "收藏1", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.delete) {
            Toast.makeText(this, "删除1", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
