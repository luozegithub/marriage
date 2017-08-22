package cn.luoze.UserManage.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by luoze on 2017/8/19.
 */
public class User implements Serializable{
    private String id;
    private String name;
    private String dept;
    private String account;
    private String password;
    private String headImg;
    private boolean gender;
    private String email;
    private String mobile;
    private Date birthday;
    private String memo;

    public User() {

    }

    public User(String id, String account, String name, String password, String dept, String headImg, boolean gender, String email, String mobile, String memo, Date birthday) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.password = password;
        this.dept = dept;
        this.headImg = headImg;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.memo = memo;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", dept='" + dept + '\'' +
                ", headImg='" + headImg + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", memo='" + memo + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
