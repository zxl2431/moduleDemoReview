package cn.agree.pojo;

import java.util.Objects;

public class Stu extends Object {

    private String name;
    private int age;

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /*
    *
    *
    * */
    @Override
    public boolean equals(Object o) {
        // 地址相等肯定是 相等
        if (this == o) return true;
        // 判断传入对象是否为空或者 类型是否相等
        if (o == null || getClass() != o.getClass()) return false;
        // 传入参数进行类型转换
        Stu stu = (Stu) o;
        // 基本类型比一下, 引用类型交给Objects对象的静态方法equals去比较
        return age == stu.age &&
                Objects.equals(name, stu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
