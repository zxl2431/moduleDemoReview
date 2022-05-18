package cn.agree.pojo;

public class Student {
    private String name;
    private int age;
    /*
    *  当set方法的形参变量和成员变量名一样的时候,重名了
    *  会导致成员变量名被隐藏, 方法中的变量名,无法访问到
    *  成员变量,从而赋值失败
    *  就近原则
    *  为了解决这个问题, 引入this.
    *  this代表当前对象的地址值.
    *
    * */
    public void setName(String name) {
        name = name;
    }

    public void setAge(int age) {
        age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}
