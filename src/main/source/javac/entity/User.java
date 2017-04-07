package javac.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by timhuo on 2017/3/29.
 */
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String account;
    private String password;
    //部门
    private String dept;
    //头像
    private String headImg;
    //性别
    private String gender;
    private String email;
    private String mobile;
    private String memo;
    private Date birthday;
    private String state;
    @ManyToMany(targetEntity = Role.class)
    private Set<Role> roles;

    //用户状态
    public final static String USER_STATE_VALID = "1";//有效
    public final static String USER_STATE_INVALID = "0";//无效

    public User() {
    }

    public User(Integer id, String name, String account, String password, String dept, String headImg, String gender, String email, String mobile, String memo, Date birthday, String state) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.dept = dept;
        this.headImg = headImg;
        this.gender = gender;
        this.email = email;
        this.mobile = mobile;
        this.memo = memo;
        this.birthday = birthday;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
