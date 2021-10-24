package com.studyAOP;

import java.lang.reflect.Proxy;

/**
 * @author 叶意
 * @ClassName Test
 * @Description TODO
 * @createTime 2021年10月21日  21:09:00
 */
public class Test {
    public static void main(String[] args) {
        CalculatorInterface calculator = new Calculator();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        CalculatorInterface proxy = (CalculatorInterface) myInvocationHandler.bind(calculator);
        proxy.add(1, 2);
    }
}
