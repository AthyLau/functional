package com.demik.functional.lambdaexercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 元素顺序
 *
 * @author AthyLau
 * @dare: 2019/10/9 4:46 PM
 * @since JDK 1.8
 */
public class Class5_2_ElementOrder {

    public static void main(String args[]) {
        //如果是有序的集合的话流内部的元素的出现顺序跟集合的元素顺序是相同的
        //如果是无序集合的话则不一定相同

        //有序集合
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> sameOrder = list.stream()
                .collect(Collectors.toList());
        System.out.println(sameOrder.equals(list));

        //无序集合
        Set<Integer> set = new HashSet<>(Arrays.asList(4, 3, 2, 1));
        List<Integer> diffOrder = set.stream()
                .collect(Collectors.toList());
        System.out.println(set.equals(diffOrder));

        //有些操作在有序的流上速度会更快比如map、fliter
        list.stream().forEachOrdered(System.out::println);
        //有的操作适合无序的流
        list.stream().unordered().forEach(System.out::println);

    }


}
