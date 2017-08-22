package cn.luoze.UserManage.service.Impl;

import cn.luoze.UserManage.dao.CareDao;
import cn.luoze.UserManage.entity.Care;
import cn.luoze.UserManage.service.CareService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by luoze on 2017/8/21.
 */
@Service("careService")
public class CareServiceImpl implements CareService {

    @Resource
    CareDao careDao;
    @Override
    public void save(Care care) {
        careDao.save(care);
    }

    @Override
    public void update(Care care) {
        careDao.update(care);
    }

    @Override
    public void delete(Serializable id) {
        careDao.delete(id);
    }

    @Override
    public Care findObjectById(Serializable id) {
        return careDao.findObjectById(id);
    }

    @Override
    public List<Care> findObjectByIds(String careid,String caredid) {
        return careDao.findObjectByIds(careid,caredid);
    }

    @Override
    public List<Care> findObjects() {
        return careDao.findObjects();
    }
}
