package cn.tommyyang.erweimastore.model;

/**
 * Created by TommyYang on 2017/11/21.
 */
public class Product {

    private Integer id;
    private String name;
    private String picturePath;
    private float price;
    private float percent;
    private Integer status;
    private Integer storeid;

    public Product() {
    }

    public Product(String name, String picturePath, float price, float percent, Integer storeid) {
        this.name = name;
        this.picturePath = picturePath;
        this.price = price;
        this.percent = percent;
        this.storeid = storeid;
    }

    public Product(Integer id, String name, String picturePath, float price, float percent, Integer status, Integer storeid) {
        this.id = id;
        this.name = name;
        this.picturePath = picturePath;
        this.price = price;
        this.percent = percent;
        this.status = status;
        this.storeid = storeid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }
}
