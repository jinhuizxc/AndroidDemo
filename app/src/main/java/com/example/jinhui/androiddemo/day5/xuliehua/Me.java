package com.example.jinhui.androiddemo.day5.xuliehua;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 *
 * Parcelable
 * 实现Parcelable接口稍微复杂一些，
 * 通过实现Parcelable接口序列化对象
 *
 * 1）implements Parcelable

 2）重写describeContents方法，内容接口描述，默认返回0就可以

 3）实例化静态内部对象CREATOR实现接口Parcelable.Creator
 public static final Parcelable.Creator<T> CREATOR
 注：其中public static final一个都不能少，内部对象CREATOR的名称
 也不能改变，必须全部大写。需重写本接口中的两个方法：
 createFromParcel(Parcel in) 实现从Parcel容器中读取传递数据值，封装
 成Parcelable对象返回逻辑层，newArray(int size) 创建一个类型为T，长
 度为size的数组，仅一句话即可（return new T[size]），供外部类反序列化
 本类数组使用。

 简而言之：通过writeToParcel将你的对象映射成Parcel对象，再通过
 createFromParcel将Parcel对象映射成你的对象。也可以将Parcel看成是一
 个流，通过writeToParcel把对象写到流里面，在通过createFromParcel从流
 里读取对象，只不过这个过程需要你来实现，因此写的顺序和读的顺序必须一致。

 4）重写writeToParcel方法，将你的对象序列化为一个Parcel对象，即：将类的数据写入外部提供的Parcel中，打包需要传递的数据到Parcel容器保存，以便从 Parcel容器获取数据
 */

public class Me implements Parcelable{

    private String name;
    private String msg;

    public Me(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }
    public String getMsg() {
        return msg;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        //往流里写数据
        dest.writeString(name);
        dest.writeString(msg);
    }

    public static final Parcelable.Creator<Me> CREATOR = new Creator<Me>() {
        @Override
        public Me[] newArray(int size) {
            //改写返回值，注意格式
            return new Me[size];
        }

        @Override
        public Me createFromParcel(Parcel source) {
            //改写返回值，注意格式
            return new Me(source);
        }
    };

    public Me(Parcel source) {
        //读取数据，注意与写数据的顺序一致
        name = source.readString();
        msg = source.readString();
    }

}
