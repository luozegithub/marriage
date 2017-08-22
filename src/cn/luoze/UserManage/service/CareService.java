package cn.luoze.UserManage.service;

import cn.luoze.UserManage.entity.Care;

import java.io.Serializable;
import java.util.List;

/**
 * Created by luoze on 2017/8/21.
 */
public interface CareService {
    public void save(Care care);
    public void update(Care care);
    public void delete(Serializable id);
    public Care findObjectById(Serializable id);
    public List<Care> findObjects();
    public List<Care> findObjectByIds(String careid,String caredid);
}
