package cn.agree.annotation;

public @interface Stud {
    String name();
    int age() default 18;
    String gender() default "男";
}
