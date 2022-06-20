package cn.agree.dynamic;

import cn.agree.inter.JinLian;
import cn.agree.inter.KindWomen;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MenQing {
    public static void main(String[] args) {


        KindWomen proxyInstance = (KindWomen) Proxy.newProxyInstance(MenQing.class.getClassLoader(), JinLian.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("happyWithMan".equals(method.getName())) {
                    System.out.println("准备开房");
                    return null;
                } else if ("collect".equals(method.getName())) {
                    System.out.println("收了多少钱:"+args[0]);
                    double m = (double)args[0]*0.8;
                    return m;
                }
                return null;
            }
        });

        proxyInstance.happyWithMan();
        double collect = proxyInstance.collect(500.00);
        System.out.println(collect);
    }
}
