package com.example.jinhui.androiddemo.day1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/1/26.
 * Email:1004260403@qq.com
 *
 * ImageView常用属性
 *
 * ImageView 继承自 View，是一个图像视用于在屏幕上显示任何的 ，是一个图像视用于在屏幕上显示任何的 Drawable 对象，通常用来显示图片。
 * 除此之外 ImageView 还派生了 ImageButton 、ZoomButton 等组件。 之前的组件使用 background属性来设置 控件或容器的背景，而 ImageView使用 src属性来设置要显示的图片。
 *
 * 1、android:src设置ImageView所显示的Drawable对象的ID 。如：android:src="@drawable/ 图片名称 "
 *
 * 2、android:tint用于为图片着色,其属性值可以是用于为图片着色，其属性值可以是用于为图片着色，其属性值可以是 #rgb”、“ #argb” 、 #rrggbb”或 #aarrggbb” 表示的颜色值。
 *
 * 3、android:adjustViewBounds设置ImageView是否调整自己的边界来保持所显示图片的长宽比
 *
 * 4、android:maxHeight设置ImageView的最大高度4、android:maxHeight：设置 ImageView的最大高度需要设置android:adjustViewBounds属性值为 true，否则不起作用；
 *
 * 5、android:maxWidth设置ImageView的最大宽度5、android:maxWidth设置ImageView的最大宽度，需要设置android:adjustViewBounds属性值为 true，否则不起作用；
 *
 * 6、android:scaleType用于设置所显示的图片如何缩放或移动以适应ImageView的大小。
 *其属性值是：
 * matrix：不改变原图的大小，从 ImageView的左上角开始绘制原图，超过ImageView的部分作裁剪处理 。
 * fitXY：拉伸图片（不按比例）以填充View的宽高。
 * fitStart ：把原图按比例扩大(缩小 )到ImageView的高度，显示在ImageView的左部分位置。
 * fitCenter：把原图按比例扩大或缩小到ImageView的高度，且显示在，且显示在View的中间。
 * fitEnd：把原图按比例扩大(缩小 )到ImageView的高度，显示在ImageView的右部分位置。
 * center：按原图大小显示图片，但图片宽高大于View的宽高时，图片中间的部分显示。
 * centerCrop ：以填满整个ImageView为目的，将原图中心对准ImageView的中心，等比例放大原图，直到填满ImageView为止（指的是ImageView的宽和高都要填满），原图超过ImageView的部分做裁剪效果。
 * centerInside：当原图宽高或等于ViewView的宽高时，按原图大小居中显示；反之将原图缩放至 View的宽高居中显示。
 *
 */

public class ImageViewActivity extends AppCompatActivity {

    /**
     * 图片显示分析：
     * 发现2张图片的大小一样，但是2个ImageView的大小不一样，只要是android:maxHeight、
     * android:maxWidth与android:adjustViewBounds配合使用的效果，就如上面
     * android:adjustViewBounds设置ImageView是否调整自己的边界来保持所显示图片的长宽比
     * maxHeight、maxWidth设置View的最大高度，单独使用无效，需要与setAdjustViewBounds一起使用。
     * 如果想设置图片固定大小，又想保持图片宽高比，需要如下设置：
     * 1）设置setAdjustViewBounds为true;
     * 2）设置maxWidth、maxHeight;
     * 3）设置layout_width和layout_height为wrap_content
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);

    }
}
