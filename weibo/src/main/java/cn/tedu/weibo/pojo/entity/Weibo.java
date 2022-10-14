package cn.tedu.weibo.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 该Weibo实体类封装了有关weibo的所有信息
 */
public class Weibo {
    private Integer id;
    private String content;
    private String url;
    //通过JsonFormat设置显示的时间格式
    // 2022年10月12号 15时23分22秒   2022-10-12 15:23:22
    // yyyy年MM月dd号 HH时mm分ss秒   yyyy-MM-dd HH:mm:ss (h为1-12时,H为1-24时)
    @JsonFormat(pattern = "yyy年MM月dd号 HH时mm分ss秒",timezone = "GMT+8")//指定时间呈现格式和时区GMT+8东八区
    private Date created;
    private Integer userId;//作者id

    @Override
    public String toString() {
        return "Weibo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", created=" + created +
                ", userId=" + userId +
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
