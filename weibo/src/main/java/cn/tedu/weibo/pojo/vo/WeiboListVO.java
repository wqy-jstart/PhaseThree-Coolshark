package cn.tedu.weibo.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 该类封装了向数据库查询出的所有weibo信息
 */
public class WeiboListVO {
    private Integer id;
    private String content;
    private String nickname;
    //通过JsonFormat设置显示的时间格式
    // 2022年10月12号 15时23分22秒   2022-10-12 15:23:22
    // yyyy年MM月dd号 HH时mm分ss秒   yyyy-MM-dd HH:mm:ss (h为1-12时,H为1-24时)
    @JsonFormat(pattern = "yyy-MM-dd- HH-mm-ss",timezone = "GMT+8")//指定时间呈现格式和时区GMT+8东八区
    private Date created;

    @Override
    public String toString() {
        return "WeiboDetailVO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", nickname='" + nickname + '\'' +
                ", created=" + created +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
