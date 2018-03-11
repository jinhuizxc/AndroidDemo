package com.example.jinhui.androiddemo.day24;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jinhui.androiddemo.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 */

public class UiOptimize5Activity extends AppCompatActivity {

    private static final String TAG = "UiOptimize5Activity";
    @BindView(R.id.bt_bitmap)
    Button btBitmap;
    @BindView(R.id.bt_deformation)
    Button btDeformation;
    @BindView(R.id.bt_oom)
    Button btOom;
    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uioptimize5);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_bitmap, R.id.bt_deformation, R.id.bt_oom})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_bitmap:
                doBitmap();
                break;
            case R.id.bt_deformation:
                doDeformation();
                break;
            case R.id.bt_oom:
                break;
        }
    }

    /**
     * Bitmap图片变形
     * 图片变化需要使用到的类

     destBmp = Bitmap.createBitmap(srcBmp, 0, 0,
     srcBmp.getWidth(), srcBmp.getHeight(), matrix, true);
     参数1：需要变形的Bitmap对象
     参数2，3：从原图采样的起始坐标
     参数4，5：原图的宽，高像素个数
     参数6：描述变形规则的Matrix对象
     参数7：原图是否需要被过滤
     缩放

     Matrix matrix = new Matrix();
     //设置x，y上的缩放比例
     matrix.setScale(x, y);
     旋转

     Matrix matrix = new Matrix();
     //设置旋转角度
     matrix.setRotate(旋转角度);
     扭曲

     Matrix matrix2 = new Matrix();
     //设置x，y上扭曲系数
     matrix2.setSkew(x, y);
     裁剪图片

     Bitmap的静态方法createBitmap(Bitmap source, int x, int y, int width, int height)对Bitmap进行裁剪。裁剪的区域是相前对原位图左上角为原点的坐标来决定即(x, y)与(width,height)。
     注意

     议使用jpg格式的图片，png格式的图片在变形后背景会变成黑色，这和png格式有关。
     *
     */
    private void doDeformation() {
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_head);

        // Matrix类
        Matrix matrix = new Matrix();
        // 设置x，y上的缩放比例
//		matrix.setScale(2, 2);
        // 设置旋转角度
//		matrix.setRotate(90);
        //设置x，y上扭曲系数
//		matrix.setSkew(1, 3);

        Bitmap bitmapNew = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);

        // 裁剪图片
        Bitmap bitmapNewCut = Bitmap.createBitmap(bitmap, 0, bitmap.getHeight()/2, bitmap.getWidth(), bitmap.getHeight()/2);

        imageView.setImageBitmap(bitmapNew);
//		iv.setImageBitmap(bitmapNewCut);
    }

    /**
     * Bitmap对象的获取
     *
     * Bitmap介绍:
     位图类。通常用它的实例代表一张图片。该对象中保存了像素矩阵，矩阵中的每个元素都代表一个像素的颜色。
     从Drawable资源文件中获取:
     参数1：Resources对象，可以通过getResources()方法获取
     参数2：要获取的资源id
     参数3：用来控制采样频率，以及是否将图片完全解码，还是只需要返回图片的大小
     Bitmap static BitmapFactory.decodeResource(Resources res, int id)


     Bitmap static BitmapFactory.decodeResource(Resources res,
     int id, BitmapFactory.Options ops);

     从SD卡中的图片文件获取:
     BitmapFactory.decodeFile(String pathName)

     从输入流获取:
     BitmapFactory.decodeStream(InputStream is);

     从ImageView控件中获取:
     Bitmap bmp =((BitmapDrawable)iv.getDrawable()).getBitmap();

     从assets资源文件中获取:
     //获取AssetManager
     AssetManager manager = getAssets();
     //获取文件流
     InputStream is = manager.open(资源文件在assets目录中的相对路径);
     //解码成Bitmap对象
     Bitmap bmp4 = BitmapFactory.decodeStream(is);

     */
    @SuppressLint("StaticFieldLeak")
    private void doBitmap() {

        // 从Drawable资源文件中获取
//        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_head);
//        imageView.setImageBitmap(bitmap);

        // 从SD卡中的图片文件获取,获取到的时网络下载的那个小女孩图片
//        String path = Environment.getExternalStorageDirectory() + "/01.png";
//        Bitmap bitmap = BitmapFactory.decodeFile(path);
//        imageView.setImageBitmap(bitmap);

        // 从输入流获取，即网络下载
//        final String path = Environment.getExternalStorageDirectory() + "/01.png";
//        new AsyncTask<String, Void, Bitmap>() {
//            @Override
//            protected Bitmap doInBackground(String... params) {
//                try {
//                    URL url = new URL(params[0]);
//                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                    InputStream is = conn.getInputStream();
//                    // 从输入流获取，即网络下载
//                    Bitmap bitmap = BitmapFactory.decodeStream(is);
//                    is.close();
//                    conn.disconnect();
//                    return bitmap;
//
//                } catch (MalformedURLException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                return null;
//            }
//
//            protected void onPostExecute(Bitmap result) {
//                imageView.setImageBitmap(result);
//                // 保存到sdcard
//                File file = new File(path);
//                try {
//                    FileOutputStream fos = new FileOutputStream(file);
//                    // 将bitmap保存到sdcard上
//                    result.compress(Bitmap.CompressFormat.PNG, 100, fos);
//                    fos.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }.execute("http://www.nowamagic.net/librarys/images/random/rand_11.jpg");

        // 从ImageView控件中获取
        // E/UiOptimize5Activity: bitmap =android.graphics.Bitmap@29b3da7
        Bitmap bitmap =((BitmapDrawable)imageView.getDrawable()).getBitmap();
        Log.e(TAG, "bitmap =" + bitmap);

        // 从assets资源文件中获取
        // 获取AssetManager
//        AssetManager manager = getAssets();
//        // 获取文件流
//        InputStream is = manager.open(资源文件在assets目录中的相对路径);
//        // 解码成Bitmap对象
//        Bitmap bmp4 = BitmapFactory.decodeStream(is);
    }

}
