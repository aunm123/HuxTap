package javac.service.impl;

import javac.dao.RoleDao;
import javac.entity.Role;
import javac.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by timhuo on 2017/3/31.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;

    public void save(Role role) {
        roleDao.save(role);
    }

    public void update(Role role) {
        roleDao.deletePrivilegeByRoleId(role.getRoleId());
        roleDao.update(role);
    }

    public void delete(Serializable id) {
        roleDao.delete(id);
    }

    public Role findObjectById(Serializable id) {
        return roleDao.findObjectById(id);
    }

    public List<Role> findObjects() {
        return roleDao.findObjects();
    }
}
