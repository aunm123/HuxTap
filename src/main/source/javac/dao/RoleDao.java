package javac.dao;

import javac.entity.Role;

/**
 * Created by timhuo on 2017/3/31.
 */
public interface RoleDao extends BaseDao<Role> {
    public void deletePrivilegeByRoleId(Integer roleId);
}
