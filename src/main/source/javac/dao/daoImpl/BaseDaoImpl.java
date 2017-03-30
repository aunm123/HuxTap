package javac.dao.daoImpl;

import javac.dao.BaseDao;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by timhuo on 2017/3/29.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    Class<T> classz;

    public BaseDaoImpl(){
        //baseDaoImpl<User> 获得泛型框中的第一个泛型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        classz = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public void save(Object entity) {
        getHibernateTemplate().save(entity);
    }

    public void delete(Serializable id) {
        getHibernateTemplate().delete(findObjectById(id));
    }

    public void update(Object entity) {
        getHibernateTemplate().update(entity);
    }

    public T findObjectById(Serializable id) {
       return getHibernateTemplate().get(classz,id);
    }

    public List findObjects() {
        Query query = (Query) getSessionFactory().
                getCurrentSession().
                createQuery("from "+classz.getSimpleName());

        return query.list();
    }
}
