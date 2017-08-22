package cn.luoze.UserManage.dao.Impl;

import cn.luoze.UserManage.dao.CareDao;
import cn.luoze.UserManage.entity.Care;
import cn.luoze.core.dao.Impl.BaseDaoImpl;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by luoze on 2017/8/21.
 */
public class CareDaoImpl extends BaseDaoImpl<Care> implements CareDao{
    @Override
    public List<Care> findObjectByIds(String careid, String caredid) {
        Query query;
        if (StringUtils.isNotBlank(careid)&& StringUtils.isNotBlank(caredid)){
            query=getSession().createQuery("FROM Care WHERE careid=? AND caredid=?");
            query.setParameter(0,careid);
            query.setParameter(1,caredid);
        }

        else if(StringUtils.isNotBlank(careid)){
            query=getSession().createQuery("FROM Care WHERE careid=?");
            query.setParameter(0,careid);
        }
        else{
            query=getSession().createQuery("FROM Care WHERE caredid=?");
            query.setParameter(0,caredid);
        }
        return query.list();
    }
}
