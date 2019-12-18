package domain;

import annotation.Check;

/**
 * 一个有错误的类，通过检查注解得到对应的bug问题
 * @author lizhang.huang@hand-china.com
 * @date 2019-12-18 11:21
 */
@SuppressWarnings("all")
public class Calculator {
    //加法
    @Check
    public void add() {
        System.out.println("1 + 0 =" + (1 + 0));
    }
    //减法
    @Check
    public void sub() {
        System.out.println("1 - 0 =" + (1 - 0));
    }
    //乘法
    @Check
    public void mul(){
        System.out.println("1 * 0 =" + (1 * 0));
    }
    //除法
    @Check
    public void div(){
        System.out.println("1 / 0 =" + (1 / 0));
    }

    public void show() {
        System.out.println("没加注解的方法");
    }
}