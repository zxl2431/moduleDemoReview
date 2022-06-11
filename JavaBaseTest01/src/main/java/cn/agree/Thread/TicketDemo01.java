package cn.agree.Thread;

public class TicketDemo01 {
    public static void main(String[] args) {
        // 有线程安全问题的
        // test01();

        // 同步代码块的方式解决线程安全问题
        // test02();

        // 同步方法的方式解决线程安全问题
        // test03();

        // 锁机制的方式解决线程安全问题
        test04();

    }

    public static void test01() {
        System.out.println("-------------有线程安全问题的example---------------");
        Ticket ticket = new Ticket();

        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

    public static void test02() {
        System.out.println("-------------同步代码块的方式解决线程安全问题------------------");
        TicketSyn01 ticketSyn01 = new TicketSyn01();

        Thread t1 = new Thread(ticketSyn01, "窗口1");
        Thread t2 = new Thread(ticketSyn01, "窗口2");
        Thread t3 = new Thread(ticketSyn01, "窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

    public static void test03() {
        System.out.println("-------------同步方法的方式解决线程安全问题------------------");
        TicketSyn02 ticketSyn02 = new TicketSyn02();

        Thread t1 = new Thread(ticketSyn02, "窗口1");
        Thread t2 = new Thread(ticketSyn02, "窗口2");
        Thread t3 = new Thread(ticketSyn02, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

    public static void test04() {
        System.out.println("--------------Lock锁的方式解决线程安全的问题---------------");
        TicketSyn03 ticketSyn03 = new TicketSyn03();

        Thread t1 = new Thread(ticketSyn03, "窗口1");
        Thread t2 = new Thread(ticketSyn03, "窗口2");
        Thread t3 = new Thread(ticketSyn03, "窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
