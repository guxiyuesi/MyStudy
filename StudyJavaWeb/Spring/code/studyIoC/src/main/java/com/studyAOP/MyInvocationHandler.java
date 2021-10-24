package com.studyAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 叶意
 * @ClassName MyInvocationHandler
 * @Description TODO
 * @createTime 2021年10月21日  21:12:00
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object object = null;

    public Object bind(Object object){
        this.object = object;
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("输入的参数为: " + args[0] + " " + args[1]);
        Object object = method.invoke(this.object, args);
        System.out.println("计算的结果为: " + object);
        return null;
    }
}
