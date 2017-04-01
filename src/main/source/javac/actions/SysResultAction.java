package javac.actions;

import com.opensymphony.xwork2.ActionInvocation;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.result.StrutsResultSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by timhuo on 2017/3/31.
 */
public class SysResultAction extends StrutsResultSupport {
    protected void doExecute(String s, ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();

        BaseAction action = (BaseAction) actionInvocation.getAction();

        System.out.println("进入了SysResultAction");
    }
}
