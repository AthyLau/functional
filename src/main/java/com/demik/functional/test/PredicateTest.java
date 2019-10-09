package com.demik.functional.test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author AthyLau
 * @dare: 2019/9/29 7:10 PM
 * @since JDK 1.8
 */
public class PredicateTest {

    private static final Predicate<Integer> P1 = (x) -> x == 1;
    private static final Predicate<Integer> P2 = (x) -> x == 2;
    private static final Predicate<Integer> P3 = (x) -> x == 3;
    private static final Predicate<Map<String, Object>> P4 = (x) -> x.containsKey("a");

    public static void main(String args[]) {
        //testTest
        System.out.println(P1.test(10));
        System.out.println(P4.test(new HashMap<String, Object>(){{
            put("a", "`11");
        }}));

        //andtest
        System.out.println(P1.and(P2).and(P3).test(100));

        //orTest
        System.out.println(P1.or(P2).or(P3).test(1));

        //negatetest
        System.out.println(P1.negate().test(1));


    }



}
