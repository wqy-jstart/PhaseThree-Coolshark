package cn.tedu.coolshark.pojo.dto;

/**
 * 该实体类用于接收用户登录上传的信息
 */
public class UserDTO {
    private String username;
    private String password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
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
}
