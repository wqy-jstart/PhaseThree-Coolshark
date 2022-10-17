package cn.tedu.coolshark.pojo.vo;

/**
 * 该实体类封装了查询到的用户有关信息
 */
public class UserVo {
    private Integer id;
    private String password;
    private String nickname;

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
