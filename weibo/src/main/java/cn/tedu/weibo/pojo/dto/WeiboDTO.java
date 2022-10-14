package cn.tedu.weibo.pojo.dto;
//DTO为用户请求时传入的信息
/**
 * 该类封装了用户请求时传递的信息
 */
public class WeiboDTO {
    private String content;
    private String url;

    @Override
    public String toString() {
        return "WeiboDTO{" +
                "content='" + content + '\'' +
                ", url='" + url + '\'' +
                '}';
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
}
