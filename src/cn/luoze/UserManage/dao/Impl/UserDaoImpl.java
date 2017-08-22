package cn.luoze.UserManage.dao.Impl;

import cn.luoze.UserManage.dao.UserDao;
import cn.luoze.UserManage.entity.User;
import cn.luoze.core.dao.Impl.BaseDaoImpl;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by luoze on 2017/8/19.
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public List<User> findUserByAccountAndPass(String account, String password) {
        Query query = getSession().createQuery("FROM User WHERE account=? AND password=?");
        query.setParameter(0,account);
        query.setParameter(1,password);
        return query.list();
    }

    @Override
    public List<User> findObjects() {
        Query query=getSession().createQuery("FROM User");
     return query.list();

    }
}
