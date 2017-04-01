package javac.dao.daoImpl;

import javac.dao.RoleDao;
import javac.entity.Role;
import org.hibernate.query.Query;

/**
 * Created by timhuo on 2017/3/31.
 */
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

    public void deletePrivilegeByRoleId(Integer roleId) {
        Query query = getSessionFactory().getCurrentSession().createQuery("delete from RolePrivilege where id.role.roleId=?");
        query.setParameter(0,roleId);
        query.executeUpdate();
    }
}
