package cn.agree.javabean;

import cn.agree.pojo.Stu;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsDemo01 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Stu stu = new Stu();

        // 调用BeanUtils工具类的方法给对象属性赋值
        BeanUtils.setProperty(stu,"name","风清扬");
        BeanUtils.setProperty(stu,"gender","男");
        BeanUtils.setProperty(stu,"age",40);
        BeanUtils.setProperty(stu,"hobbies", new String[]{"敲代码", "打篮球"});
        System.out.println(stu);

        // 调用BeanUtils工具类的方法获取对象属性值
        String name = BeanUtils.getProperty(stu,"name");
        String gender = BeanUtils.getProperty(stu,"gender");
        String age = BeanUtils.getProperty(stu,"age");
        // 当属性的类型是数组类型时,获取到的值是数组中的第一个值
        String hobbies = BeanUtils.getProperty(stu,"hobbies");
        System.out.println("姓名："+ name);
        System.out.println("性别："+ gender);
        System.out.println("年龄：" + age);
        System.out.println("爱好：" + hobbies);
    }
}
