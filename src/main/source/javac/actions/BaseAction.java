package javac.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by timhuo on 2017/3/31.
 */
public abstract class BaseAction extends ActionSupport {
    protected  String[] selectedRow;

    public String[] getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(String[] selectedRow) {
        this.selectedRow = selectedRow;
    }
}
