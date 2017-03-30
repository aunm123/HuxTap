package javac.actions;

import org.apache.commons.io.FileUtils;
import com.opensymphony.xwork2.ActionSupport;
import javac.entity.User;
import javac.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {

    @Resource
    private UserService userService;
    private List<User> userList;
    private User user;
    private String[] selectedRow;
    private File headImg;
    private String headImgContentType;
    private String headImgFileName;

    //列表页面
    public String listUI(){
        userList=userService.findObjects();
        return "list";
    }

    //跳转到新增页面
    public String addUI(){
        return "addUI";
    }
    //保存新增
    public String add() throws IOException {
        if (user!=null){
            if (headImg!=null){
                String filePath = ServletActionContext.getServletContext().getRealPath("upload/user");
                String fileName = UUID.randomUUID().toString()+headImgFileName.substring(headImgFileName.lastIndexOf('.'));
                FileUtils.copyFile(headImg,new File(filePath,fileName));
                user.setHeadImg("user/"+fileName);
            }
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
        if (selectedRow!=null){
            for (String id : this.selectedRow){
                userService.delete(Integer.parseInt(id));
            }
        }
        return listUI();
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

    public String[] getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(String[] selectedRow) {
        this.selectedRow = selectedRow;
    }
}
