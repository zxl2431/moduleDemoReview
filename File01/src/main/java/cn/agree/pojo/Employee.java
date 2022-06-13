package cn.agree.pojo;

import java.io.Serializable;

public class Employee implements Serializable {

    public String name;
    public String address;

    public transient int age;

    public void addressCheck() {
        System.out.println("Address check : " + name + " ‐‐ " + address);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
