package com.demik.functional.test;

import java.util.Arrays;
import java.util.function.*;
import java.util.stream.Collectors;

/**
 * @author liubing
 * @dare: 2019/10/8 11:12 AM
 * @since JDK 1.8
 */
public class ToBaseFunctionTest {

    private static ToLongFunction<Integer> toLongFunction = (x) -> Long.parseLong(String.valueOf(x));
    private static ToIntFunction<Integer> toIntFunction = (x) -> Integer.parseInt(String.valueOf(x));
    private static ToDoubleFunction<Integer> toDoubleFunction = (x) -> Double.parseDouble(String.valueOf(x));

    //LongUnaryOperator
    private static LongUnaryOperator longUnaryOperator = x -> x+1;
    //DoubleUnaryOperator
    private static DoubleUnaryOperator doubleUnaryOperator = x -> x+1;
    //IntUnaryOperator
    private static IntUnaryOperator intUnaryOperator = x -> x+1;
    //上边这三个东西可以放入intStream或者DoubleStream或者longStream的map操作里面。
    public static void main(String args[]) {
        Arrays.asList(1,2,3,4,5).stream().mapToLong(toLongFunction).map(longUnaryOperator).boxed().collect(Collectors.toList()).forEach(System.out::println);
        Arrays.asList(1,2,3,4,5).stream().mapToInt(toIntFunction).map(intUnaryOperator).boxed().collect(Collectors.toList()).forEach(System.out::println);
        Arrays.asList(1,2,3,4,5).stream().mapToDouble(toDoubleFunction).map(doubleUnaryOperator).boxed().collect(Collectors.toList()).forEach(System.out::println);
    }

}
