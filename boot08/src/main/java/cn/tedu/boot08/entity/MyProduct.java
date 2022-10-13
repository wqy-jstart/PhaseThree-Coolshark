package cn.tedu.boot08.entity;

/**
 * 该类封装了MyProduct对象的所有信息
 */
public class MyProduct {
    private Integer id;
    private String title;
    private Integer saleCount;
    private Integer viewCount;

    @Override
    public String toString() {
        return "MyProduct{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", saleCount=" + saleCount +
                ", viewCount=" + viewCount +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
}
