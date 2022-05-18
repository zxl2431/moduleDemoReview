package cn.agree;

public class Demo01 {
    public static void main(String[] args) {
        int i = 1;
        byte b = 2;

        // byte x = b+i;
        int j = b+i;

        /*-----------------------------------------------------------------------*/
        double d = 2.5;
        // int z = d+i;

        // 当一个short类型与1相加, 会类型提升, 但如果想把结果赋值给short类型, 就需要强制类型转换
        short s = 1;
        s = (short)(s+1);

        s+=1; // 等效于s = (short)(s+1);

        /*-----------------------------------------------------------------------*/
        // 强制类型转换 到边界会有溢出
        short s1 = 32767;
        s1 = (short) (s1+10);
        System.out.println(s1);


    }
}
