package javac.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by timhuo on 2017/3/30.
 */
@Controller("testAction")
@Scope("prototype")
public class TestAction extends ActionSupport{
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
