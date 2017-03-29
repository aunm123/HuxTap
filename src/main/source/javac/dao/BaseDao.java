package javac.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by timhuo on 2017/3/29.
 */
public interface BaseDao<T> {
    //增
    public void save(T entity);
    //删
    public void delete(Serializable id);
    //改
    public void update(T entity);
    //查
    public T findObjectById(Serializable id);
    //查列表
    public List<T> findObjects();
}
