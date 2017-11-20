package cn.tommyyang.erweimastore.model;


public class Admin {

    private Integer id;
    private String name;
    private String nickname;
    private String passwd;
    private Integer type;  //0-超级管理员 1-普通管理员
    private Integer status;  // 0-删除 1-正常

    public Admin(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
 