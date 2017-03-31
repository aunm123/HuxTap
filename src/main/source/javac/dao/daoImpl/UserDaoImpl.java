package javac.dao.daoImpl;

import javac.dao.UserDao;
import javac.entity.User;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by timhuo on 2017/3/29.
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
    public User findUserByAccount(String account){
        String hql = "from User Where account= ?";
        Query query = (Query) getSessionFactory().getCurrentSession().createQuery(hql);
        query.setParameter(0,account);
        List<User> list = query.list();
        if (list.size()>0){
            return (User) query.list().get(0);
        }else {
            return null;
        }
    }
}
