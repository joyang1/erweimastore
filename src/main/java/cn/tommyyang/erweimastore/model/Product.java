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
    private String storeName;

    public Product() {
    }

    public Product(String name, String picturePath, float price, float percent, String storeName) {
        this.name = name;
        this.picturePath = picturePath;
        this.price = price;
        this.percent = percent;
        this.storeName = storeName;
    }

    public Product(Integer id, String name, String picturePath, float price, float percent, Integer status, String storeName) {
        this.id = id;
        this.name = name;
        this.picturePath = picturePath;
        this.price = price;
        this.percent = percent;
        this.status = status;
        this.storeName = storeName;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
