package com.demik.functional.test;

import java.util.function.Function;

/**
 * @author AthyLau
 * @dare: 2019/9/29 4:50 PM
 * @since JDK 1.8
 */
public class FunctionTest {

    private final static Function<Integer, Integer> F1 = (x) -> x * 10;
    private final static Function<Integer, Integer> F2 = (x) -> x + 10;

    public static void main(String args[]) {

        //applyTest
        System.out.println(F1.apply(3));
        System.out.println(F2.apply(3) + "\r\n");

        //composeTest
        System.out.println(F1.compose(F2).apply(3));//f2 -> f1
        System.out.println(F2.compose(F1).apply(3) + "\r\n");//f1 -> f2

        //andThenTest
        System.out.println(F1.andThen(F2).apply(3));//f1 -> f2
        System.out.println(F2.andThen(F1).apply(3) + "\r\n");//f2 -> f1

        //identityTest
        System.out.println(Function.identity().apply(1));//return x

    }

}
