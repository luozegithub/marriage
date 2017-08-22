package cn.luoze.UserManage.service;

import cn.luoze.UserManage.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by luoze on 2017/8/19.
 */
public interface UserService {
    public void save(User user);
    public void update(User user);
    public void delete(Serializable id);
    public User findObjectById(Serializable id);
    public List<User> findObjects();

    public List<User> findUserByAccountAndPass(String account,String password);




}
