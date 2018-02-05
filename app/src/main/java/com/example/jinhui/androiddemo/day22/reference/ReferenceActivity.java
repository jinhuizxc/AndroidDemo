package com.example.jinhui.androiddemo.day22.reference;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.jinhui.androiddemo.R;

/**
 * Created by jinhui on 2018/2/5.
 * Email:1004260403@qq.com
 *
 * Java引用分类（强，软，弱，虚）
 *
 * 从JDK 1.2版本开始，把对象的引用分为4种级别，使程序能更加灵活地控制对象的生命周期。这4种级别由高到低依次为：强引用、软引用、弱引用和虚引用。

 对象的引用分为4种级别：
 强引用：
 语法
 直接通过类型名来声明引用：Object obj = new Object()
 特性
 如果对象被强引用引用，那么一定不会被GC回收（即使内存不足）

 软引用：
 语法
 使用SoftReference声明引用，数据类型通过泛型表示，SoftReference softStr = new SoftReference(str)
 特性
 在内存不足的情况下，GC会回收软引用所指向的对象（内存足够时不会回收）。

 弱引用：
 语法
 使用WeakReference声明引用，数据类型通过泛型表示，WeakReference weakStr= new WeakReference(str)
 特性
 当GC扫描内存时，只要发现有弱引用指向的对象，都会回收（不论内存是否充足）。但是时效性不强。

 虚引用：
 语法
 new Student();
 特性
 只被虚引用引用的对象，声明之后就可能被立刻回收，被回收的可能性最高。

 软引用使用场景：
 使用软引用可以实现内存的缓存机制。
 如果软引用的引用对象因为系统内存不足而被释放掉，调用该引用的get()方法，会返回null，否则表示还未释放掉。

 •分析如下代码
 //tmp为成员变量时，d引用所指向的对象是否会被释放？
 //tmp为局部变量时，d引用所指向的对象是否会被释放？
 byte[] tmp = new byte[20 * 1024 * 1024];
 SoftReference<byte[]> d = new SoftReference<byte[]>(tmp);

 */

public class ReferenceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);
    }
}
