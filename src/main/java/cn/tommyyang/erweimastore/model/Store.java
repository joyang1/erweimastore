package cn.tommyyang.erweimastore.model;

/**
 * Created by TommyYang on 2017/11/21.
 */
public class Store {

    private Integer id;

    private String name;

    private String url;

    private String qrCodePath;

    public Store() {
    }

    public Store(Integer id, String name, String url, String qrCodePath) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.qrCodePath = qrCodePath;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQrCodePath() {
        return qrCodePath;
    }

    public void setQrCodePath(String qrCodePath) {
        this.qrCodePath = qrCodePath;
    }
}
