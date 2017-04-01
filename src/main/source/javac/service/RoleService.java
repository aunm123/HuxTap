package javac.service;

import javac.entity.Role;

import java.io.Serializable;
import java.util.List;

/**
 * Created by timhuo on 2017/3/31.
 */
public interface RoleService {
    public void save(Role role);
    public void update(Role role);
    public void delete(Serializable id);
    public Role findObjectById(Serializable id);
    public List<Role> findObjects();
}
