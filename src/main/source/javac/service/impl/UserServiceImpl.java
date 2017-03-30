package javac.service.impl;

import javac.dao.UserDao;
import javac.entity.User;
import javac.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by timhuo on 2017/3/29.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    public void save(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(Serializable id) {
        userDao.delete(id);
    }

    public User findObjectById(Serializable id) {
        return userDao.findObjectById(id);
    }

    public List<User> findObjects() {
        return userDao.findObjects();
    }
}
