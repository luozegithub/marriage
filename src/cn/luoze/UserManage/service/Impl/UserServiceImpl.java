package cn.luoze.UserManage.service.Impl;

import cn.luoze.UserManage.dao.UserDao;
import cn.luoze.UserManage.entity.User;
import cn.luoze.UserManage.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by luoze on 2017/8/19.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(Serializable id) {
        userDao.delete(id);
    }

    @Override
    public User findObjectById(Serializable id) {
        return userDao.findObjectById(id);
    }

    @Override
    public List<User> findObjects() {
        return userDao.findObjects();
    }

    @Override
    public List<User> findUserByAccountAndPass(String account, String password) {
        return userDao.findUserByAccountAndPass(account,password);
    }
}
