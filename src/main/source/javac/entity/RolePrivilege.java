package javac.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by timhuo on 2017/3/31.
 */
@Entity
@Table
public class RolePrivilege implements Serializable{
    @EmbeddedId
    private RolePrivilegeId id;

    public RolePrivilege() {
    }

    public RolePrivilege(RolePrivilegeId id) {
        this.id = id;
    }

    public RolePrivilegeId getId() {
        return id;
    }

    public void setId(RolePrivilegeId id) {
        this.id = id;
    }
}
