package javac.exception;

/**
 * Created by timhuo on 2017/3/31.
 */
public class SysException extends Exception {
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public SysException() {
        super();
    }

    public SysException(String message) {
        super(message);
    }

    public SysException(String message, Throwable cause) {
        super(message, cause);
    }

    public SysException(Throwable cause, String errorMsg) {
        super(cause);
        this.errorMsg = errorMsg;
    }
}
