package com.wsh.proxy;

import com.wsh.proxy.impl.LenovoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        //1、获得真实对象（LenovoImpl）
        LenovoImpl lenovo = new LenovoImpl();

        //2、获得代理对象，并用代理对象对方法进行加强
        Computer proxyInstance =(Computer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*
            代理逻辑编写的方法:代理对家调用的所有方法都会触发该方法执行参数:
                    1.proxy:代理对象
                    2.method:代理对象调用的方法，被封装为的对象
                    3.args:代理对象调用的方法时，传递的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //（1）、对参数进行加强
                if(method.getName().equals("sale")){//判断
                   double money= (double) args[0];
                    money=  money * 0.85;
                    //使用真实对象调用该方法
                    String invoke =(String) method.invoke(lenovo, money);
                    //（2）、对方法体进行加强，顾客买电脑，帮它打包包装
                    System.out.println("包装起来");
                    //（3）、对方法结果进行加强
                    return invoke+"+鼠标";
                }else {
                    Object invoke = method.invoke(lenovo, args);
                    return invoke;
                }
            }
        });

        //3、代理对象调用方法
        String sale = proxyInstance.sale(8000);
        System.out.println(sale);


        /*//用真实对象调用方法
        lenovo.sale(80000);*/
    }
}
