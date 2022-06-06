package cn.agree.lesson;

public class StringTest01 {
    public static void main(String[] args) {
        String s1 = "fsjdkfjsk";
        // 常用方法
        System.out.println(s1.equals("abc"));
        System.out.println(s1.concat("fsddff"));
        System.out.println(s1.charAt(0));
        System.out.println(s1.indexOf("jdb"));
        System.out.println(s1.substring(3));
        System.out.println(s1.substring(3,6));

        // 转换方法
        char[] chars = s1.toCharArray();
        byte[] bytes = s1.getBytes();
        s1.replace("fs", "FS");

        // 分割方法
        String s2="aa|bb|cc";
        String[] strArray = s2.split("|");










    }
}
