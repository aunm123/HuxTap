package javac.actions;

import javac.entity.User;
import javac.exception.ActionException;
import javac.exception.SysException;
import javac.service.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.service.spi.ServiceException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction {

    @Resource
    private UserService userService;
    private List<User> userList;
    private User user;
    private File headImg;
    private String headImgContentType;
    private String headImgFileName;

    //列表页面
    public String listUI() throws SysException{
        try {
            userList=userService.findObjects();
        }catch (ServiceException e){
            throw new ActionException("action 出现异常"+e.getMessage());
        }
        return "list";
    }

    //跳转到新增页面
    public String addUI(){
        return "addUI";
    }
    //保存新增
    public String add() throws IOException,SysException {
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
    public String edit() throws IOException,SysException {
        if (user!=null){
            if (headImg!=null){
                String filePath=ServletActionContext.getServletContext().getRealPath("upload/user");
                String fileName = UUID.randomUUID().toString()+headImgFileName.substring((headImgFileName.lastIndexOf(".")));
                FileUtils.copyFile(headImg,new File(filePath,fileName));
                if (user.getHeadImg()!=null){
                    String oldfilename = filePath+"\\"+user.getHeadImg().substring(5);
                    File file = new File(oldfilename);
                    file.delete();
                }
                user.setHeadImg("user/"+fileName);
            }
            userService.update(user);
        }
        return listUI();
    }
    //删除
    public String delete() throws SysException{
        if (user!=null&&user.getId()!=null){
            userService.delete(user.getId());
        }
        return listUI();
    }
    //批量删除
    public String deleteSelect() throws SysException{
        if (selectedRow!=null){
            for (String id : this.selectedRow){
                userService.delete(Integer.parseInt(id));
            }
        }
        return listUI();
    }
    //验证用户名唯一
    public void verifyAccount() throws IOException {
        String result = "true";
        if (user!=null && StringUtils.isNotBlank(user.getAccount())){
            User tempuser = userService.findObjectByAccound(user.getAccount());
            if (tempuser!=null){
                result = "flase";
            }
            HttpServletResponse response = ServletActionContext.getResponse();
            response.setContentType("text/html");
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(result.getBytes());
            outputStream.close();
        }
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

    public File getHeadImg() {
        return headImg;
    }

    public void setHeadImg(File headImg) {
        this.headImg = headImg;
    }

    public String getHeadImgContentType() {
        return headImgContentType;
    }

    public void setHeadImgContentType(String headImgContentType) {
        this.headImgContentType = headImgContentType;
    }

    public String getHeadImgFileName() {
        return headImgFileName;
    }

    public void setHeadImgFileName(String headImgFileName) {
        this.headImgFileName = headImgFileName;
    }
}
