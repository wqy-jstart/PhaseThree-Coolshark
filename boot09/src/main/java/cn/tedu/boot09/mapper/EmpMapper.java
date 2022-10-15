package cn.tedu.boot09.mapper;

import cn.tedu.boot09.entity.Emp;

import java.util.List;

public interface EmpMapper {

    /**
     * 插入一位员工信息
     * @param emp Emp员工对象(包含该员工的所有信息)
     */
    void insert(Emp emp);

    /**
     * 批量插入员工信息
     * @param e 员工对象集合
     * @return 返回插入的数量
     */
    int insert1(List<Emp> e);

    /**
     * 修改员工信息
     * @param emp 将要修改的信息传到对象中
     * @return 返回修改的条数
     */
    int update(Emp emp);

    /**
     * 根据id删除一位员工信息
     * @param id 员工id
     */
    void deleteById1(int id);

    /**
     * 根据员工id批量删除员工信息
     * @param list 包含要删除的员工id的集合
     * @return 返回删除的数量
     */
    int deleteById2(List<Integer> list);

    /**
     * 动态修改员工信息
     * @param e 修改后的员工对象
     */
    void dynamicUpdate(Emp e);

    /**
     * 查询一位员工信息
     * @param id 需要查询的员工id
     * @return 返回员工对象
     */
    Emp selectById1(int id);

    /**
     * 查询所有员工信息
     * @return 以List集合形式返回所有员工信息
     */
    List<Emp> selectById2();

    /**
     * 查询员工数量
     * @return 返回员工数量
     */
    int count();
}
