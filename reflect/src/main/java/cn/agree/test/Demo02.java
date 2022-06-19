package cn.agree.test;

public class Demo02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // 获得字符串的Class对象
        Class c1 = Class.forName("java.lang.String");
        // 获得简单类名
        String name = c1.getSimpleName();
        System.out.println("简单类名name:"+name);
        // 获取完整类名
        String name1 = c1.getName();
        System.out.println("完整类名name1:"+name1);

        // 创建对象
        String str = (String) c1.newInstance();
        str="abc";




    }
}
