package com.lcz.geek.bean;

/**
 * Created by 李承泽 on 2019/4/21.
 */
public class V2exBean {
    String img;
    String autor;
    String title;
    String old;
    String url;
    String num;
    String fenlei;

    public V2exBean(String img, String autor, String title, String old, String url, String num, String fenlei) {
        this.img = img;
        this.autor = autor;
        this.title = title;
        this.old = old;
        this.url = url;
        this.num = num;
        this.fenlei = fenlei;
    }

    public V2exBean() {
        super();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getFenlei() {
        return fenlei;
    }

    public void setFenlei(String fenlei) {
        this.fenlei = fenlei;
    }

    @Override
    public String toString() {
        return "V2exBean{" +
                "img='" + img + '\'' +
                ", autor='" + autor + '\'' +
                ", title='" + title + '\'' +
                ", old='" + old + '\'' +
                ", url='" + url + '\'' +
                ", num='" + num + '\'' +
                ", fenlei='" + fenlei + '\'' +
                '}';
    }
}
