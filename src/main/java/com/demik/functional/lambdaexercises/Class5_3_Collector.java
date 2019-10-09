package com.demik.functional.lambdaexercises;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

/**
 * 收集器
 *
 * @author AthyLau
 * @dare: 2019/10/9 5:00 PM
 * @since JDK 1.8
 */
public class Class5_3_Collector {


    //class 5_3_1
    public static void class_5_3_1() {
        //使用定制的集合收集元素
        new ArrayList<>().stream().filter(Objects::nonNull).collect(Collectors.toCollection(TreeSet::new));
    }
}
