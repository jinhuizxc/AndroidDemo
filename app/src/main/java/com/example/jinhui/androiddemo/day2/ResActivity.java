package com.example.jinhui.androiddemo.day2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jinhui.androiddemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/1/27.
 * Email:1004260403@qq.com
 * <p>
 * Resources类的使用
 * <p>
 * Resources类是一个抽象类，里面定义了一些方法用来获取资源文件中定义
 * 的资源，可以通过Activity类中的getResources()方法获得该对象，
 * Resources resources = getResources();
 * 再利用该对象调用相对应的方法。
 * 常用方法：
 * getString(int resId)：获得字符串资源
 * getStringArray(int id)：获得字符串数组资源
 * getDimension(int id)：获得尺寸资源
 * getColor(int id)：获得颜色资源
 * getDrawable(int id)：获得图片资源
 * <p>
 * 二：字符串资源
 * 字符串资源文件对应的路径是res/values/string.xml，
 * 在该文件中保存的是一些字符串常量，如下所示，每个string标签里保存一条字符串，
 * 并且可以自行新增字符串资源，这些字符串资源可以在java代码中和xml文件中使用。
 */

public class ResActivity extends AppCompatActivity {

    @BindView(R.id.bt_res)
    Button btRes;
    @BindView(R.id.bt_res_group)
    Button btResGroup;
    @BindView(R.id.bt_dimension)
    Button btDimension;
    @BindView(R.id.bt_color)
    Button btColor;
    @BindView(R.id.bt_img)
    Button btImg;
    @BindView(R.id.bt_color1)
    Button btColor1;
    @BindView(R.id.bt_setImg)
    ImageView btSetImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_res, R.id.bt_res_group, R.id.bt_dimension,
            R.id.bt_color, R.id.bt_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_res:
                doRes();
                break;
            case R.id.bt_res_group:
                doRes_group();
                break;
            case R.id.bt_dimension:
                doDimension();
                break;
            case R.id.bt_color:
                doColor();
                break;
            case R.id.bt_img:
                doImg();
                break;
        }
    }

    /**
     * getDrawable(int id)：获得图片资源
     * <p>
     * 图片资源存放在res/drawable
     * 目录下，每个图片资源文件都会在R文件中生成对应的ID号。
     * <p>
     * <p>
     * 在java代码中使用图片
     * 在java代码中获得定义的尺寸值，通过Resources类中的getDrawable(int id)方法获得，该方法返回值为Drawable类型，所以保存该图片资源的变量类型也需为Drawable，如下所示：
     * Drawable bitmap = getResources().getDrawable(R.drawable.a);
     * <p>
     * 在xml文件中使用
     * 在xml文件中使用时，只需在设置图片属性中引用即可，我先往drawable中添加一张图片my_picture，如下所示：
     * <ImageView
     * android:id="@+id/imageView1"
     * android:layout_width="wrap_content"
     * android:layout_height="wrap_content"
     * android:src="@drawable/my_picture" />
     */
    private void doImg() {
        Drawable drawable = getResources().getDrawable(R.drawable.img1);
        Toast.makeText(this, "获取的drawable = " + drawable, Toast.LENGTH_SHORT).show();
        btSetImg.setImageDrawable(drawable);
    }

    /**
     * getColor(int id)：获得颜色资源
     * 首先，我们需要在res/values目录下新建一个color目录，里面会有resource
     * 标签，可以在这个标签中使用< color.../>子标签来定义颜色资源，如下所示：
     * <p>
     * <?xml version="1.0" encoding="utf-8"?>
     * <resources>
     * <color name="red">#ffff0000</color>
     * <color name="green">#ff00ff00</color>
     * </resources>
     * <p>
     * 在java代码中使用
     * 当在java代码中需要动态修改某个颜色值时，
     * 通过Resources类中的getColor(int id)方法获得
     * 颜色资源文件中的颜色值，然后再对应的代码中使用该
     * 值，如下所示：
     * int red = getResources().getColor(R.color.red);
     * <p>
     * 在xml文件中使用
     * 在xml文件中使用时，只需在设置颜色属性中引用即可，如下所示：
     * <TextView
     * android:id="@+id/textView1"
     * android:layout_width="wrap_content"
     * android:layout_height="wrap_content"
     * android:text="@string/hello_world"
     * android:textSize="@dimen/text_size"
     * android:textColor="@color/red"/>
     * <p>
     * <TextView
     * android:id="@+id/textView2"
     * android:layout_width="wrap_content"
     * android:layout_height="wrap_content"
     * android:text="@string/hello_world"
     * android:textSize="@dimen/text_size"
     * android:background="@color/green"/>
     */
    private void doColor() {
        int red = getResources().getColor(R.color.red);
        Toast.makeText(this, "获取到的颜色 =" + red, Toast.LENGTH_SHORT).show();
    }

    /**
     * getDimension(int id)：获得尺寸资源
     * <p>
     * 尺寸资源文件存放在res/values目录下，此文件可针对字符串个别设定字号，
     * 像是px、in、mm、pt、dp、dip、sp等等尺寸。
     * <resources>
     * <dimen name="activity_horizontal_margin">16dp</dimen>
     * <dimen name="activity_vertical_margin">16dp</dimen>
     * <dimen name="text_size">20sp</dimen>
     * </resources>
     * <p>
     * 在java代码中使用
     * 在java代码中获得定义的尺寸值，通过Resources类中的getDimension(int id)方法获得：
     * float size = getResources().getDimension(R.dimen.text_size);
     * <p>
     * 在xml文件中使用
     * 2、在xml文件中使用，只需在textSize属性中引用即可：
     * <TextView
     * android:id="@+id/textView1"
     * android:layout_width="wrap_content"
     * android:layout_height="wrap_content"
     * android:text="@string/hello_world"
     * android:textSize="@dimen/text_size"/>
     */
    private void doDimension() {
        float size = getResources().getDimension(R.dimen.text_size);
        Toast.makeText(this, "尺寸大小 =" + size, Toast.LENGTH_SHORT).show();
    }

    /**
     * 首先，我们需要自己在values目录下新建一个array.xml文件（文件名定义）来存放字符串数组资源，在这个文件中有resource标签，可以在这个标签中使
     * 用<string-array.../>子标签来定义字符串数组。string-array标签的name就是这个字符串数组的名称。然后，在string-array标签中利用item标签来定义
     * 字符串内容，如下所示：
     * <p>
     * <?xml version="1.0" encoding="utf-8"?>
     * <resources>
     * <string-array name="books">
     * <item>三国</item>
     * <item>水浒</item>
     * <item>西游</item>
     * <item>红楼</item>
     * </string-array>
     * </resources>
     * <p>
     * 在java代码中使用 在java代码中获得字符串数组资源
     * 首先要调用getResources()方法获得Resources的对象，然后在调用该对象的
     * getStringArray(int id)方法，即可获得
     * 我们想要的数据，如下所示：
     * public class MainActivity extends ActionBarActivity {
     *
     * @Override protected void onCreate(Bundle savedInstanceState) {
     * super.onCreate(savedInstanceState);
     * setContentView(R.layout.activity_main);
     * <p>
     * //获取字符串数据
     * String str[] = getResources().getStringArray(R.array.books);
     * Log.d("Test", str[0]+str[1]+str[2]+str[3]);
     * }
     * }
     * <p>
     * 在xml文件中使用（了解）
     * <p>
     * 在xml文件中使用时，TextView不再适用，它只能显示数组的第一个元素，
     * 这里可以适用一个新的控件ListView（后续章节详细介绍），它的效果就是像
     * 手机通讯录联系人列表，有多个选项可以滚动。在android:entries属性引用
     * 数组资源。
     * <ListView
     * android:id="@+id/listView1"
     * android:layout_width="match_parent"
     * android:layout_height="wrap_content"
     * android:entries="@array/books">
     * </ListView>
     */
    private void doRes_group() {
        // 获取字符串数据
        String str[] = getResources().getStringArray(R.array.books);
        Toast.makeText(this, "数据依次是 =" + str[0] + str[1] + str[2] + str[3] + str[4], Toast.LENGTH_SHORT).show();
    }

    /**
     * getString(int resId)：获得字符串资源
     * <p>
     * 在java代码中使用
     * 在java代码中要获得string.Xml文件中的字符串时，需要调用Context类中
     * getString(int resId)方法，传入对应字符串的ID号，即“R.string.字符串名”，就会返回对应的字符串，如下所示：
     * public class MainActivity extends ActionBarActivity {
     *
     * @Override protected void onCreate(Bundle savedInstanceState) {
     * super.onCreate(savedInstanceState);
     * setContentView(R.layout.activity_main);
     * <p>
     * //获取字符串数据
     * String str = getString(R.string.hello_world);
     * Log.d("Test", str);
     * }
     * }
     * <p>
     * 在xml文件中使用
     * 在xml文件中使用时较为简单，在需要设置字符串数据的地方，按照
     * “@string/字符串名”的格式引用即可，如下所示：
     * <TextView
     * android:id="@+id/textView1"
     * android:layout_width="wrap_content"
     * android:layout_height="wrap_content"
     * android:text="@string/hello_world"
     * android:textAppearance="?android:attr/textAppearanceLarge" />
     */
    private void doRes() {
        // 获取字符串资源
        String str = getString(R.string.app_name);
        Toast.makeText(this, "获取到的字符串string =" + str, Toast.LENGTH_SHORT).show();
    }



}
