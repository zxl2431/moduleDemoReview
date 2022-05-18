package cn.agree;

public class Demo02 {
    public static void main(String[] args) {

        // char和int计算过程中, char先去查编码表97,提升为int类型, 和1求和
        char c = 'a';
        int i = 1;

        i = i+c;
        System.out.println(i);


    }
}
