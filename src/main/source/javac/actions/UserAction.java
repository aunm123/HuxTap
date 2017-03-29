package javac.actions;

import com.opensymphony.xwork2.ActionSupport;
import javac.entity.User;
import javac.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

    @Resource
    private UserService userService;
    private List<User> userList;
    private User user;

    //列表页面
    public String listUI(){
        userList=userService.findObjects();
        return "listUI";
    }

    //跳转到新增页面
    public String addUI(){
        return "addUI";
    }
    //保存新增
    public String add(){
        if (user!=null){
            userService.save(user);
        }
        return listUI();
    }
    //跳转到编辑界面
    public String editUI(){
        if (user!=null && user.getId()!=null){
            user=userService.findObjectById(user.getId());
        }
        return "editUI";
    }
    //保存编辑
    public String edit(){
        if (user!=null){
            userService.update(user);
        }
        return listUI();
    }
    //删除
    public String delete(){
        if (user!=null&&user.getId()!=null){
            userService.delete(user.getId());
        }
        return listUI();
    }
    //批量删除
    public String deleteSelect(){
        return listUI();
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}