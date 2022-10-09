package cn.tedu.boot02.controller;

import cn.tedu.boot02.entity.Product;
import cn.tedu.boot02.util.DBUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class ProductController {
    @RequestMapping("/insert")
    @ResponseBody
    //处理根据Product对象中封装的用户输入的信息来插入到bbsdb数据库product表中的业务
    public String insert(Product product){
        System.out.println("product = "+product);
        try (
                Connection connection = DBUtil.getConnection()
        ){
            String sql = "INSERT INTO product VALUES(null,?,?,?)";//表中id设置为自增,这里设置为null
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, product.getTitle());
            ps.setDouble(2,product.getPrice());
            ps.setInt(3,product.getNum());
            int num = ps.executeUpdate();//该方法返回是否影响了一条记录
            if (num==0){
                return "添加失败!<a href ='/'>返回首页</a>";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "添加完成!<a href ='/'>返回首页</a>";
    }

    @RequestMapping("/select")
    @ResponseBody
    //处理查询商品集合中的所有商品,并呈现到HTML页面表格中的业务
    public String select(){
        //用来装查询回来的"商品对象"的集合
        ArrayList<Product> list = new ArrayList<>();
        try(
                Connection connection = DBUtil.getConnection()
        ){
            String sql = "SELECT id,title,price,num " +
                    "FROM product";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();//返回查询的结果集
            while (rs.next()){ //利用while可以查询并添加多条数据
                //getInt(int columnIndex)方法获取此ResultSet对象的当前行中指定列的值。(以上面字符串中的SQL语句为准)
                int id = rs.getInt(1);
                String title = rs.getString(2);
                double price = rs.getDouble(3);
                int num = rs.getInt(4);
                //将查询的商品对象添加到集合中
                list.add(new Product(id,title,price,num));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //书写HTML页面表格,将List集合中封装的所有对象信息呈现到该表格中,最终返回页面
        String html = "<table border='1' align='center'>";
        html+="<caption><b>商品列表<b></caption>";
        html+="<tr><th>id</th><th>商品标题</th><th>价格</th><th>库存</th><th>操作</th></tr>";
        for (Product p : list){
            html+="<tr>";
            html+="<td>"+p.getId()+"</td>";
            html+="<td>"+p.getTitle()+"</td>";
            html+="<td>"+p.getPrice()+"</td>";
            html+="<td>"+p.getNum()+"</td>";
            //添加删除字段,传入需要删除的商品ID,"?"左边是处理该业务的请求地址,提供ID进行处理
            html+="<td><a href='/delete?id="+p.getId()+"'>删除</a></td>";
            html+="</tr>";
        }
        html+="</table>";
//        return list.toString();//输出该集合[{},{},{}...]
        return html;
    }

    @RequestMapping("/delete")
    @ResponseBody
    //处理根据商品ID删除Product集合里面的对应商品对象,并从数据库中删除的业务
    public String delete(int id){
        System.out.println("id = "+id);
        try (
                Connection connection = DBUtil.getConnection()
        ){
           String sql = "DELETE FROM product WHERE id=?";
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setInt(1,id);
           int num = ps.executeUpdate();//返回影响表数据的条数
            if (num==0){//若没有影响一条记录,说明没有删除成功
                return "删除失败!<a href='/select'>返回列表页面</a>";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "删除完成!<a href='/select'>返回列表页面</a>";
    }

    @RequestMapping("/update")
    @ResponseBody
    //根据商品id处理修改商品对象的属性,先判断该Id下的商品是否存在,再进行修改
    public String update(Product product){
        System.out.println("product = "+product);
        try(
                Connection connection = DBUtil.getConnection()
        ) {
            String sql = "SELECT 1 FROM product WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,product.getId());
            ResultSet rs = ps.executeQuery();//返回查询的结果集
            if (!rs.next()){//如果查询不到一条结果
                return "不存在该商品ID!<a href='/select'>返回页面";
            }
            String sql1 = "UPDATE product SET title=?,price=?,num=? " +
                    "WHERE id=?";
            ps = connection.prepareStatement(sql1);
            ps.setString(1, product.getTitle());
            ps.setDouble(2,product.getPrice());
            ps.setInt(3,product.getNum());
            ps.setInt(4,product.getId());
            int num = ps.executeUpdate();//返回影响表数据的条数
            if (num==0){ //若影响表中的数据为0,则没有修改成功
                return "修改失败!<a href='/select'>返回列表页面";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "修改完成!<a href='/select'>返回列表页面</a>";
    }
}
