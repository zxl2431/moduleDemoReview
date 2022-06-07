package cn.agree.lesson;

public class InnerDemo {
    public static void main(String[] args) {

        Person person = new Person();

        // 创建内部类对象
        Person.Heart heart = person.new Heart();


        heart.jump();

        person.setLive(false);

        heart.jump();
    }
}
