package cn.tedu.coolshark.pojo.dto;

/**
 * 该实体类用于接收用户登录上传的信息,rem判断用户是否勾选了记住密码
 */
public class UserDTO {
    private String username;
    private String password;
    private Boolean rem;

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rem=" + rem +
                '}';
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

    public Boolean getRem() {
        return rem;
    }

    public void setRem(Boolean rem) {
        this.rem = rem;
    }
}
