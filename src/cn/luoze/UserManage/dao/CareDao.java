package cn.luoze.UserManage.dao;

import cn.luoze.UserManage.entity.Care;
import cn.luoze.core.dao.BaseDao;

import java.util.List;

/**
 * Created by luoze on 2017/8/21.
 */
public interface CareDao extends BaseDao<Care> {
    public List<Care> findObjectByIds(String caredi, String caredid);
}
