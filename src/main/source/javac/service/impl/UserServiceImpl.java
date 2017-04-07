package javac.service.impl;

import javac.dao.RoleDao;
import javac.dao.UserDao;
import javac.entity.Role;
import javac.entity.User;
import javac.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

/**
 * Created by timhuo on 2017/3/29.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private RoleDao roleDao;

    public void save(User user) {
        userDao.save(user);
    }

    public void saveUserAndRole(User user, String[] userRoleIds) {
        HashSet<Role> roleHashSet = new HashSet<Role>();
        for (int i=0;i<userRoleIds.length;i++){
            Role tempRole = roleDao.findObjectById(userRoleIds[i]);
            if (tempRole!=null){
                roleHashSet.add(tempRole);
            }
        }
        user.setRoles(roleHashSet);
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void updateUserAndRole(User user, String[] userRoleIds) {
        HashSet<Role> roleHashSet = new HashSet<Role>();
        for (int i=0;i<userRoleIds.length;i++){
            Role tempRole = roleDao.findObjectById(userRoleIds[i]);
            if (tempRole!=null){
                roleHashSet.add(tempRole);
            }
        }
        user.setRoles(roleHashSet);
        userDao.update(user);
    }

    public void delete(Serializable id) {
        userDao.delete(id);
    }

    public User findObjectById(Serializable id) {
        return userDao.findObjectById(id);
    }

    public List<User> findObjects() {
        List<User> lUser = userDao.findObjects();
//        try {
//            int i = 1/0;
//        }catch (Exception e) {
//            throw new ServiceException("service 出错！"+e.getMessage());
//        }
        return lUser;
    }

    public User findObjectByAccound(String account) {
        return userDao.findUserByAccount(account);
    }
}
