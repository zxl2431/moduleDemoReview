package cn.agree.serialstream;

import cn.agree.pojo.Employee;

import java.io.*;

public class SerializeDemo01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee employee = new Employee();
        employee.name="xiaohong";
        employee.address="北京";
        employee.age=20;

        // 创建序列化流
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("E:\\testfile\\employee.txt"));
        out.writeObject(employee);

        out.close();
        System.out.println("employee已经被序列化");

        // 反序列化
        Employee e;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:\\testfile\\employee.txt"));
        e = (Employee) in.readObject();

        in.close();

        System.out.println(e);
    }
}
