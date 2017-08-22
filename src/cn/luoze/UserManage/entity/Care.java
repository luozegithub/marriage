package cn.luoze.UserManage.entity;

import java.io.Serializable;

/**
 * Created by luoze on 2017/8/21.
 */
public class Care implements Serializable{
    private Integer id;
    private String care_id;
    private String cared_id;

    public Care() {

    }


    public Care(String care_id, String cared_id) {
        this.care_id = care_id;
        this.cared_id = cared_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCare_id() {
        return care_id;
    }

    public void setCare_id(String care_id) {
        this.care_id = care_id;
    }

    public String getCared_id() {
        return cared_id;
    }

    public void setCared_id(String cared_id) {
        this.cared_id = cared_id;
    }

    @Override
    public String toString() {
        return "Care{" +
                "id=" + id +
                ", care_id='" + care_id + '\'' +
                ", cared_id='" + cared_id + '\'' +
                '}';
    }
}
