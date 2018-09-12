package com.example.jinhui.androiddemo.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.jinhui.androiddemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jh on 2018/9/11.
 * Email: 1004260403@qq.com
 *
 * 底部弹框
 */
public class SheetDialog {

    private final Context context;
    private final Display display;

    private TextView txt_title;
    private TextView txt_cancel;
    private LinearLayout lLayout_content;
    private ScrollView sLayout_content;
    private boolean showTitle = false;

    private Dialog dialog;
    // 数据
    private List<SheetItem> sheetItemList;

    public SheetDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
        builder();
    }

    private void builder() {
        // 获取Dialog布局
        View view = LayoutInflater.from(context)
                .inflate(R.layout.toast_view_actionsheet, null);
        // 设置Dialog最小宽度为屏幕宽度
        view.setMinimumWidth(display.getWidth());
        // 获取自定义Dialog布局中的控件
        sLayout_content = (ScrollView) view.findViewById(R.id.sLayout_content);
        lLayout_content = (LinearLayout) view.findViewById(R.id.lLayout_content);
        txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_cancel = (TextView) view.findViewById(R.id.txt_cancel);

        txt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        // 定义Dialog布局和参数
        dialog = new Dialog(context, R.style.SheetDialogStyle);
        dialog.setContentView(view);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.setCancelable(false);
        Window dialogWindow = dialog.getWindow();
        assert dialogWindow != null;
        dialogWindow.setGravity(Gravity.START | Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.x = 0;
        lp.y = 0;
        dialogWindow.setAttributes(lp);
    }

    public SheetDialog setTitle(String title) {
        showTitle = true;
        txt_title.setVisibility(View.VISIBLE);
        txt_title.setText(title);
        return this;
    }

    public SheetDialog setCancelableOnTouchOutSide(boolean cancel) {
        dialog.setCanceledOnTouchOutside(cancel);
        return this;
    }

    /**
     *
     * @param strItems
     *            条目名称数组
     * @param color
     *            条目字体颜色如"#ff0000"，设置null则默认蓝色
     * @param listener
     * @return
     */
    public SheetDialog addSheetItems(String[] strItems, SheetItemColor color, OnSheetItemClickListener listener) {
        if (sheetItemList == null){
            sheetItemList = new ArrayList<>();
        }
        for (String strItem: strItems){
            sheetItemList.add(new SheetItem(strItem, listener, color));
        }
        return this;
    }

    public void show() {
        setSheetItems();
        dialog.show();
    }

    /**
     * 设置条目布局
     */
    private void setSheetItems() {
        if (sheetItemList == null || sheetItemList.size() <= 0){
            return;
        }

        int size = sheetItemList.size();
        //  添加条目过多的时候控制高度
        if (size >= 7){
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) sLayout_content.getLayoutParams();
            params.height = display.getHeight() / 2;
            sLayout_content.setLayoutParams(params);
        }

        // 循环添加条目
        for (int i = 1; i <= size; i++) {
            final int index = i;
            SheetItem sheetItem = sheetItemList.get(i - 1);
            String strItem = sheetItem.name;
            SheetItemColor color = sheetItem.color;
            final OnSheetItemClickListener listener = sheetItem.onSheetItemClickListener;

            final TextView textView = new TextView(context);
            textView.setText(strItem);
            textView.setTextSize(18);
            textView.setGravity(Gravity.CENTER);

            // 背景图片
            if (size == 1){
                if (showTitle) {
                    textView.setBackgroundResource(R.drawable.actionsheet_bottom_selector);
                } else {
                    textView.setBackgroundResource(R.drawable.actionsheet_single_selector);
                }
            }else {
                if (showTitle) {
                    if (i >= 1 && i < size) {
                        textView.setBackgroundResource(R.drawable.actionsheet_middle_selector);
                    } else {
                        textView.setBackgroundResource(R.drawable.actionsheet_bottom_selector);
                    }
                } else {
                    if (i == 1) {
                        textView.setBackgroundResource(R.drawable.actionsheet_top_selector);
                    } else if (i < size) {
                        textView.setBackgroundResource(R.drawable.actionsheet_middle_selector);
                    } else {
                        textView.setBackgroundResource(R.drawable.actionsheet_bottom_selector);
                    }
                }
            }

            // 字体颜色
            if (color == null){
               textView.setTextColor(Color.parseColor(SheetItemColor.Blue.getName()));
            }else {
                textView.setTextColor(Color.parseColor(color.getName()));
            }

            // 高度
            float scale = context.getResources().getDisplayMetrics().density;
            int height = (int) (45 * scale + 0.5f);
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    height));

            // 点击事件
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(index, textView.getText().toString());
                    dialog.dismiss();
                }
            });

            lLayout_content.addView(textView);
        }
    }


    // 定义枚举
    public enum SheetItemColor{
        Blue("#037BFF"), Red("#FD4A2E");

        private String name;

        SheetItemColor(String name) {
           this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    // 定义点击接口
    public interface OnSheetItemClickListener {
        void onClick(int which, String content);
    }

    private class SheetItem {
        String name;
        OnSheetItemClickListener onSheetItemClickListener;
        SheetItemColor color;

        public SheetItem(String name, OnSheetItemClickListener onSheetItemClickListener, SheetItemColor color) {
            this.name = name;
            this.onSheetItemClickListener = onSheetItemClickListener;
            this.color = color;
        }
    }
}
