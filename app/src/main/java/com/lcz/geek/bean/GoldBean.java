package com.lcz.geek.bean;

import java.io.Serializable;

/**
 * Created by 李承泽 on 2019/4/18.
 */
public class GoldBean implements Serializable{
    public String title;
    public boolean checked;

    public GoldBean(String title, boolean checked) {
        this.title = title;
        this.checked = checked;
    }
}
