package cn.tedu.weibo.pojo.vo;
//VO接收数据库中查询的信息
/**
 * 将接收查询到的信息封装到UserVO对象中
 */
public class UserVO {
    private Integer id;
    private String password;
    private String nickname;

    @Override
    public String toString() {
        return "UserVO{" +
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
