package com.example.jinhui.androiddemo.day5.xuliehua;

import java.io.Serializable;

/**
 * Created by jinhui on 2018/1/29.
 * Email:1004260403@qq.com
 *
 * Serializable ------------------
 * 首先来看下Serializable接口，
 * public interface Serializable {
 * }
 *
 * 这个接口没有任何抽象方法，所以使用Serializable实现对象序列化非常单，
 * 只需要将自定义类去实现该接口即可。
 * 自定义的Book类使用Serializable序列化，只需要该类实现Serializable接口，如下所示：
 * public class Book implements Serializable {
    按需求定义内容。。。
 }
 */

public class Surprise implements Serializable {

    String name;
    int number;

    public Surprise(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
