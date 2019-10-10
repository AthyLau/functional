package com.demik.functional.lambdaexercises;

import com.demik.functional.lambdaexpression.ATADemo;
import com.demik.functional.lambdaexpression.pojo.Artist;

import java.util.*;
import java.util.stream.Collectors;

import static com.demik.functional.lambdaexpression.ATADemo.album1;


/**
 * 收集器
 *
 * @author AthyLau
 * @dare: 2019/10/9 5:00 PM
 * @since JDK 1.8
 */
public class Class5_3_Collector {

    public static void main(String args[]) {
//        class_5_3_3();
//        class_5_3_4();
//        class_5_3_5();
        class_5_3_6();
    }


    //class 5_3_1   转换成其他集合
    public static void class_5_3_1() {
        //使用定制的集合收集元素
        new ArrayList<>().stream().filter(Objects::nonNull).collect(Collectors.toCollection(TreeSet::new));
    }

    //class 5_3_2   转化成值
    public static void class_5_3_2() {

        //找出一堆专辑中曲目的平均数量
        Double aDouble = ATADemo.albums.stream().collect(Collectors.averagingInt(album -> album.getTracks().size()));
        System.out.println(aDouble);

        //找出一堆乐队中人数最多的乐队
//        Optional<Artist> artist1 = ATADemo.albums.stream().max(Comparator.comparing(x -> x.getMusicians().stream().max(Comparator.comparing(y -> y.getMembers().size()))));
        Optional<Artist> artist2 = album1.getMusicians().stream().filter(x -> Objects.nonNull(x.getMembers())).max(Comparator.comparing(y -> y.getMembers().size()));
        System.out.println(artist2.get());
    }

    //class 5_3_3   数据分块
    public static void class_5_3_3() {
        //将艺术家组成的流分成乐队和独唱歌手两部分
        Map<Boolean, List<Artist>> map = album1.getMusicians().stream().collect(Collectors.partitioningBy(x -> Objects.nonNull(x.getMembers())));
        System.out.println(map.get(true));
        System.out.println(map.get(false));
    }

    //class 5_3_4   数据分组
    public static void class_5_3_4() {
        //将艺术家组成的流分成乐队和独唱歌手两部分
        Map<Boolean, List<Artist>> map = album1.getMusicians().stream().collect(Collectors.groupingBy(x -> Objects.nonNull(x.getMembers())));
        System.out.println(map.get(true));
        System.out.println(map.get(false));
    }

    //class 5_3_5 字符串
    public static void class_5_3_5() {
        //将乐队中所有人的姓名拼接起来
        System.out.println(album1.getMusicians().stream().map(artist -> artist.getOrigin() + " : " + artist.getName()).collect(Collectors.joining(" , ", " [ ", " ] ")));
    }

    //class 5_3_6 组合收集器
    public static void class_5_3_6() {
        //得到将艺术家组成的流分成乐队和独唱歌手两部分的数量
        System.out.println(album1.getMusicians().stream().collect(Collectors.groupingBy(x -> Objects.nonNull(x.getMembers()), Collectors.counting())));
    }

}
