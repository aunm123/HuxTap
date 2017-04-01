package javac.exception;

/**
 * Created by timhuo on 2017/3/31.
 */
public class ActionException extends SysException {
    public ActionException() {
        super("请求发送错误");
    }

    public ActionException(String message) {
        super(message);
    }
}
