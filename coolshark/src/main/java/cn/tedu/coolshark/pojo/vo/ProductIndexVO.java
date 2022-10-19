package cn.tedu.coolshark.pojo.vo;

/**
 * 该VO封装了主页查询的商品所有信息
 */
public class ProductIndexVO{
    private Integer id;
    private String title;
    private Double price;
    private String url;
    private Integer viewCount;
    private Integer saleCount;

    @Override
    public String toString() {
        return "ProductIndexVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", viewCount=" + viewCount +
                ", saleCount=" + saleCount +
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }
}
