package com.demik.functional.test;

import java.util.function.Predicate;

/**
 * @author AthyLau
 * @dare: 2019/10/8 11:42 AM
 * @since JDK 1.8
 */
public class LambdaAndOverLoad {

    /**
     * 􏰀如果只有一个可能的目标类型，由相应函数接口里的参数类型推导得出;
     * 􏰀 如果有多个可能的目标类型，由最具体的类型推导得出;
     * 􏰀 如果有多个可能的目标类型且最具体的类型不明确，则需人为指定类型。
     *
     * @param args
     */
    public static void main(String args[]) {
        //usually overload
        usualOverLoad("111");
        //Lambda overload
//        lambdaOverLoad(x -> true);
    }

    //usually overload   都是精确到最小的类型然后作为入参调用重载的方法
    private static void usualOverLoad(Object obj) {
        System.out.println(obj.getClass().getName());
    }

    private static void usualOverLoad(String obj) {
        System.out.println("String");
    }

    //Lambda overload   如果精确到最小的单位后发现是一样的参数的话就不能区分重载  编译器无法确定Predicate与IntPredicate更具体
    //这就是 代码异味 说明此刻不该继续重载，应该重新命名一个方法。
    private static void lambdaOverLoad(Predicate<Integer> predicate) {
        System.out.println("predicate");
    }

    private static void lambdaOverLoad(IntPredicate intPredicate) {
        System.out.println("intpredicate");
    }

}

@FunctionalInterface
//这个注解是为了让编译器自动检验该接口是否符合函数编程的函数接口规范
interface IntPredicate {
    Boolean test(int value);
//    Boolean test1(int value);
}