package com.studyAOP;

/**
 * @author 叶意
 * @ClassName Calculator
 * @Description TODO
 * @createTime 2021年10月21日  21:07:00
 */
public class Calculator implements CalculatorInterface{
    @Override
    public Double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public Double sub(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public Double mul(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public Double div(double num1, double num2) {
        return num1 / num2;
    }

}
