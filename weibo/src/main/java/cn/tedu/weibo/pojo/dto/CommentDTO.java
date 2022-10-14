package cn.tedu.weibo.pojo.dto;

/**
 * 该类封装了评论者输入的信息
 */
public class CommentDTO {
    private String content;
    private Integer weiboId;

    @Override
    public String toString() {
        return "CommentDTO{" +
                "content='" + content + '\'' +
                ", weiboId=" + weiboId +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(Integer weiboId) {
        this.weiboId = weiboId;
    }
}
