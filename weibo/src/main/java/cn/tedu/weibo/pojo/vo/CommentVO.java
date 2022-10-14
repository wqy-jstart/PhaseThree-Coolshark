package cn.tedu.weibo.pojo.vo;

/**
 * 该类封装了查询到评论者的信息
 */
public class CommentVO {
    private String content;
    private Integer userId;

    @Override
    public String toString() {
        return "CommentVO{" +
                "content='" + content + '\'' +
                ", userId=" + userId +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
