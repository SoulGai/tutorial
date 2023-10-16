package top.testeru.dataobject;

/**
 * @program: mapstruct_tutorial
 * @author: 盖盖
 * @description: 用户do实体类
 *          与数据库表结构一一对应，通过DAO层向上传输数据源对象
 *          主要是mapper引用，操作数据库实体类
 * @Date: 2023/10/16
 */
public class UserDO {

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
        final StringBuilder sb = new StringBuilder();

        sb.append(getClass().getName());
        sb.append("[");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
