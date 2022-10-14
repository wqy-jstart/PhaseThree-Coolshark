package cn.tedu.weibo.pojo.dto;

/**
 * 将用户注册请求时输入的信息封装到UserDTO对象中(保证客户端请求的信息都是非NULL的)
 */
public class UserDTO {
    private String username;
    private String password;
    private String nickname;

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
