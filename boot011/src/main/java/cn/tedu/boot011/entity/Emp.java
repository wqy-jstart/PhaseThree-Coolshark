package cn.tedu.boot011.entity;

/**
 * 将表单上的多个信息封装到对象中,使得处理业务时直接传入对象即可获取多个参数
 * 提供getter,setter和toString方法(行业标准)
 */
public class Emp {
    private String name;
    private double salary;
    private String job;

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", job='" + job + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
