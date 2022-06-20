package cn.agree.javabean;

import cn.agree.pojo.Stu;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsDemo02 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // 创建学生对象
        Stu stu = new Stu();
        // 调用BeanUtils工具类的方法给对象属性赋值
        BeanUtils.setProperty(stu,"name","风清扬");
        BeanUtils.setProperty(stu,"gender","男");
        BeanUtils.setProperty(stu,"age",40);
        BeanUtils.setProperty(stu,"hobbies",new String[]{"敲代码","打篮球"});

        // 再创建一个学生对象
        Stu stu1 = new Stu();

        BeanUtils.copyProperties(stu1, stu);
        System.out.println(stu1);
    }
}
