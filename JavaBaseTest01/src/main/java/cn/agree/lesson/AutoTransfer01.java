package cn.agree.lesson;

public class AutoTransfer01 {
    public static void main(String[] args) {

        /*
        *
        *  byte     1个字节    -128到127
        *  short    2个字节    -32768到32768
        *  char     2个字节    0到2
        *  int      4个字节
        *  long     8个字节
        *  float    4个字节
        *  double   8个字节
        *
        *  类型的自动转换
        *  byte、short、char --> int --> long --> float --> double
        *
        *
        *
        * */

        int i=1;        // int类型是4个字节 65535
        byte b = 2;     // byte类型是1个字节 128

        double d = 1.2; // double类型是8个字节

        // byte j = i+b; //

        int j = b + i;

        // double内存是8个字节 int类型是4个字节
        int a = (int)1.5;

        System.out.println(j);

        System.out.println("-----------------------");
        short s = 1;
        short s1 = 32767;   // s1是short的极限了, 再加加超出范围了,溢出了
        // s = s+1;     // short类型的 不能接受int的 因为1是默认的int
        s1 = (short) (s1+1);
        System.out.println(s1);

    }
}
