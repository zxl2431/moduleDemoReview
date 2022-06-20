package cn.agree.annotest;

import cn.agree.annotation.Book;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnoDemo01 {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println("-----------------获取类上注解的数据--------------------");
        test01();
        System.out.println("-----------------获取成员方法注解的数据----------------");
        test02();

    }

    public static void test01() {
        Class c = BookShelf.class;
        Book book = (Book) c.getAnnotation(Book.class);
        System.out.println(book.value()+"---"+book.price()+"---"+ Arrays.toString(book.authors()) );
    }

    public static void test02() throws NoSuchMethodException {
        Class c = BookShelf.class;
        Method m = c.getMethod("showBook");
        Book book = m.getAnnotation(Book.class);

        System.out.println(book.value()+"---"+book.price()+"---"+ Arrays.toString(book.authors()) );




    }





}
