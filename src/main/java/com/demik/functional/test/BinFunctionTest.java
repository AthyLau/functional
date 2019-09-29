package com.demik.functional.test;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author liubing
 * @dare: 2019/9/29 5:10 PM
 * @since JDK 1.8
 */
public class BinFunctionTest {

    private final static BiFunction<Integer,Integer,Integer> BF1 = (x,y) -> x + y;
    private final static Function<Integer,Integer> BF2 = (x) -> x * 3;

    public static void main(String args[]) {
        //applyTest
        System.out.println(BF1.apply(10, 30));
        //andThen
        System.out.println(BF1.andThen(BF2).apply(10, 30));
    }


}
