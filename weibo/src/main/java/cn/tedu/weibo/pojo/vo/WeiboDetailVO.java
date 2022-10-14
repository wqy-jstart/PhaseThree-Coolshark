package cn.tedu.weibo.pojo.vo;

import java.util.Date;

/**
 * 该类封装了向数据库查询出的一条weibo信息
 */
public class WeiboDetailVO {
   private Integer id;
   private String content;
   private String url;
   private Date created;
   private String nickname;

    @Override
    public String toString() {
        return "WeiboDetailVO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", created=" + created +
                ", nickname='" + nickname + '\'' +
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
