package com.bwie.commoditypurchasecalculation.bean;

/**
 * Created by DELL on 2018/10/7.
 */

public class Shop {

    //商品封装类
    private int img;//商品图片
    private String name;//商品名称
    private String tjiage;//代表“价格”
    private int price;//代表实际价格
    private boolean check;//选框

    public Shop() {
    }

    public Shop(int img, String name, String tjiage, int price, boolean check) {
        this.img = img;
        this.name = name;
        this.tjiage = tjiage;
        this.price = price;
        this.check = check;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTjiage() {
        return tjiage;
    }

    public void setTjiage(String tjiage) {
        this.tjiage = tjiage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "img=" + img +
                ", name='" + name + '\'' +
                ", tjiage='" + tjiage + '\'' +
                ", price=" + price +
                ", check=" + check +
                '}';
    }
}
