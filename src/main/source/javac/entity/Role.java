package javac.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by timhuo on 2017/3/31.
 */
@Entity
@Table
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer roleId;
    private String name;
    private String state;
    @OneToMany(cascade=CascadeType.ALL)
    private Set<RolePrivilege> rolePrivileges;

    public Role(Integer roleId, String name, String state, Set<RolePrivilege> rolePrivileges) {
        this.roleId = roleId;
        this.name = name;
        this.state = state;
        this.rolePrivileges = rolePrivileges;
    }

    public Role() {
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<RolePrivilege> getRolePrivileges() {
        return rolePrivileges;
    }

    public void setRolePrivileges(Set<RolePrivilege> rolePrivileges) {
        this.rolePrivileges = rolePrivileges;
    }
}
