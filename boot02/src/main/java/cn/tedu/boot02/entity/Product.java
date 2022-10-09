package cn.tedu.boot02.entity;

/**
 * 封装了商品的信息
 */
public class Product {
    // null         int id; 默认值为0(无法判断是否被赋值)
    private Integer id;//包装类多了一个未赋值状态默认null
    private String title;
    private Double price;
    private Integer num;

    //无参构造器默认存在,但是当有了有参构造器,无参构造器就不存在了,由于SpringMVC内部会用到无参构造器,所以需再加入无参构造器
    public Product(){}

    public Product(Integer id, String title, Double price, Integer num) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", num=" + num +
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
