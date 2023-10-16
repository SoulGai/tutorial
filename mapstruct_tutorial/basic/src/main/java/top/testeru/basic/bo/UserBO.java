package top.testeru.basic.bo;

/**
 * @program: mapstruct_tutorial
 * @author: 盖盖
 * @description:
 *      BO（Business Object）：业务对象。由Service层输出的封装业务逻辑的对象。
 * @Date: 2023/10/16
 */
public class UserBO {

    /** 用户编号 **/
    private Integer id;
    /** 用户名 **/
    private String username;
    /** 密码 **/
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //完全限定名称
        sb.append(getClass().getName());
        sb.append("[");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(']');
        return sb.toString();
    }
}

