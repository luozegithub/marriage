package cn.luoze.UserManage.dao;

import cn.luoze.UserManage.entity.User;
import cn.luoze.core.dao.BaseDao;

import java.util.List;

/**
 * Created by luoze on 2017/8/19.
 */
public interface UserDao extends BaseDao<User>{
    public List<User> findUserByAccountAndPass(String account,String password);
}
