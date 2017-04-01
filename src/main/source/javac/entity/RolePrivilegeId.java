package javac.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by timhuo on 2017/3/31.
 */
@Entity
@Table
public class RolePrivilegeId implements Serializable {
    @ManyToOne
    private Role role;
    private String code;

    public RolePrivilegeId() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolePrivilegeId)) return false;

        RolePrivilegeId that = (RolePrivilegeId) o;

        if (!getRole().equals(that.getRole())) return false;
        return getCode().equals(that.getCode());
    }

    @Override
    public int hashCode() {
        int result = getRole().hashCode();
        result = 31 * result + getCode().hashCode();
        return result;
    }
}
