package cn.tedu.coolshark.pojo.vo;

/**
 * 该VO封装了商品排行中查询商品的所有信息
 */
public class ProductTopVO {
    private Integer id;
    private Integer saleCount;
    private String title;

    @Override
    public String toString() {
        return "ProductVO{" +
                "id=" + id +
                ", saleCount=" + saleCount +
                ", title='" + title + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
