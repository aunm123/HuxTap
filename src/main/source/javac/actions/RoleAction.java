package javac.actions;

import com.opensymphony.xwork2.ActionContext;
import javac.content.Constant;
import javac.entity.Role;
import javac.entity.RolePrivilege;
import javac.entity.RolePrivilegeId;
import javac.service.RoleService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.xml.ws.Action;
import java.util.HashSet;
import java.util.List;

/**
 * Created by timhuo on 2017/3/31.
 */
@Controller("roleAction")
public class RoleAction extends BaseAction {
    @Resource
    private RoleService roleService;
    private List<Role> roleList;
    private Role role;
    private String[] privilegeIds;

    public String listUI() {
        ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
        roleList = roleService.findObjects();
        return "listUI";
    }
    public String addUI(){
        ActionContext.getContext().getContextMap().put("privilegeMap" , Constant.PRIVILEGE_MAP);
        return "addUI";
    }
    public String add(){
        if (role!=null){
            if (privilegeIds!=null){
                HashSet<RolePrivilege> set = new HashSet<RolePrivilege>();
                for (int i = 0;i<privilegeIds.length;i++){
                    set.add(new RolePrivilege(new RolePrivilegeId(role,privilegeIds[i]));
                }
                role.setRolePrivileges(set);
            }
            roleService.save(role);
        }
        return "list";
    }
    public String editUI(){
        ActionContext.getContext().getContextMap().put("privilegeMap" , Constant.PRIVILEGE_MAP);
        if (role!=null&&role.getRoleId()!=null){
            role=roleService.findObjectById(role.getRoleId());
            if (role.getRolePrivileges()!=null){
                privilegeIds=new String[role.getRolePrivileges().size()];
                int i=0;
                for (RolePrivilege r:role.getRolePrivileges()){
                    privilegeIds[i++]=r.getId().getCode();
                }
            }
        }
        return "editUI";
    }
    public String edit(){
        if (privilegeIds!=null){
            HashSet<RolePrivilege> set = new HashSet<RolePrivilege>();
            for (int i=0;i<privilegeIds.length;i++){
                set.add(new RolePrivilege(new RolePrivilegeId(role,privilegeIds[i])));
            }
            role.setRolePrivileges(set);
        }
        roleService.update(role);
        return "list";
    }
    public String delete(){
        if (role!=null&&role.getRoleId()!=null){
            roleService.delete(role.getRoleId());
        }
        return "list";
    }
    public String deleteSelected(){
        if (selectedRow!=null){
            for (String id:selectedRow){
                roleService.delete(id);
            }
        }
        return "list";
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String[] getPrivilegeIds() {
        return privilegeIds;
    }

    public void setPrivilegeIds(String[] privilegeIds) {
        this.privilegeIds = privilegeIds;
    }
}
