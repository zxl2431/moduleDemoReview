package cn.agree.Thread;

public class TicketDemo01 {
    public static void main(String[] args) {
        // 创建线程任务对象
        Ticket ticket = new Ticket();

        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");

        t1.start();
        t2.start();
        t3.start();


    }
}
