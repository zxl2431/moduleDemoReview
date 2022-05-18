package cn.agree;

public class Demo03 {
    public static void main(String[] args) {
        // case穿透, case后面不写break, 不会在判断下一个case值, 直接向后运行
        // 直到遇到break,或者整体switch结束
        int i = 5;
        switch (i) {
            case 0:
                System.out.println("执行case0");
                break;
            case 5:
                System.out.println("执行case5");
            case 10:
                System.out.println("执行case10");
                // break;
            default:
                System.out.println("执行default");
        }
    }
}
