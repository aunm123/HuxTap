package javac.service;

import javac.entity.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by timhuo on 2017/3/29.
 */
public interface UserService {
    public void save(User user);
    public void update(User user);
    public void delete(Serializable id);
    public User findObjectById(Serializable id);
    public List<User> findObjects();
}
