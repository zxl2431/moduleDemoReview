package cn.agree.lesson;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;

public class DateTest01 {
    public static void main(String[] args) throws ParseException {

        System.out.println(new Date());
        System.out.println(new Date(0L));
        System.out.println(new Date().getTime());

        System.out.println("------------DateFormat日期和文本之间的转换----------------");
        /*
        *  格式化: 按照指定的格式yyyy-MM-dd, 从Date对象转换为String对象
        *  解析: 按照指定的格式, 从String对象转换成Date对象
        *
        * */
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = simpleDateFormat.format(date);

        System.out.println(str);
        String str1 = "1988-03-08 16:45:55";

        Date date1 = simpleDateFormat.parse(str1);
        System.out.println(date1);

        System.out.println("--------------------Calendar日历------------------");
        Calendar cal = getInstance();
        // 设置年
        cal.set(YEAR, 2000);
        // 使用add方法
        cal.add(YEAR, 2);
        // 获取年
        int year = cal.get(Calendar.YEAR);
        // 获取月
        int month = cal.get(Calendar.MONTH)+1;
        // 获取日
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        System.out.println(year+"年"+month+"月"+dayOfMonth+"日");

        // Calendar中getTime方法并不是获取毫秒时刻, 而是拿到对应的Date对象
        Date time = cal.getTime();
        System.out.println(time);

        System.out.println("--------------System类------------------");
        /*
        *  提供了大量的静态方法
        * currentTimeMills()
        * arraycopy()
        * */

        System.out.println("--------------StringBuilder类----------------");
        /*
        *  由于String类的对象内容是不可改变的, 所以每当进行字符串拼接的时候, 总是会创建一个新的对象
        *
        * */
        String s2 = "Hello";
        String s3 = new String("Hello");
        // s2= s2+"World";

        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        // Integer.toHexString(s2.hashCode());
        System.out.println(s2==s3);     // false 地址不一样
        System.out.println(s2.equals(s3));

        StringBuilder sb = new StringBuilder("agree");
        System.out.println(sb);




    }
}
