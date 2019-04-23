package com.lcz.geek.bean;

/**
 * Created by 李承泽 on 2019/4/22.
 */
public class Car {
    String name;
    String title;

    public Car(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
