package com.demik.functional.lambdaexpression;

import com.demik.functional.lambdaexpression.pojo.Track;
import org.apache.logging.log4j.util.Strings;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/9/5 1:32 PM
 * @since JDK 1.8
 */
public class StreamTest {
    private static Map<String, Object> map1 = new HashMap<String, Object>() {{
        put("1", "1");
        put("2", "2");
        put("3", "3");
        put("4", "4");
        put("5", "5");
    }};
    private static Map<String, Object> map2 = new HashMap<String, Object>() {{
        put("a", "a");
        put("b", "b");
        put("c", "c");
        put("d", "d");
        put("e", "e");
    }};
    private static Map<String, Object> map3 = new HashMap<String, Object>() {{
        put("A", "A");
        put("B", "B");
        put("C", "C");
        put("D", "D");
    }};
    private static List<Map<String, Object>> list = new ArrayList<Map<String, Object>>() {{
        add(map1);
        add(map2);
        add(map3);
    }};

    /**
     * 使用内部迭代获取遍历过滤得到的数量
     */
    private static void streamFliterCount() {
        list.forEach(x -> {
            System.out.println(x.values());
        });
        long count = list.stream().filter(x -> x.containsKey("A")).count();

        //实际上这个fliter并不返回一个新的list集合，这就是惰性求值，而上边一行代码，对于没创建的集合进行求值，称为 及早求值法
        list.stream().filter(x -> x.containsKey("A"));
        list.forEach(x -> {
            System.out.println(x.values());
        });
        //如果返回值是Stream则是惰性求值，如果是其他或者空的话就是及早求值
        System.out.println("惰性求值时并没有输出");
        list.stream().filter(x -> {
            System.out.println(x.values());
            return x.containsKey("A");
        });
        System.out.println("及早求值时有输出");
        list.stream().filter(x -> {
            System.out.println(x.values());
            return x.containsKey("A");
        }).count();

        System.out.println();
    }

    //collect的使用
    public static void collectStream() {
        //惰性求值+及早求值
        List<String> list = Stream.of("1", "2", "3").collect(toList());
        list.forEach(System.out::print);
        System.out.println();
        List<String> xx = Stream.of("a", "b", "helloworld").map(String::toUpperCase).collect(toList());
        xx.forEach(System.out::print);
        System.out.println();
        List<Integer> yy = Stream.of("", "b", "helloworld").filter(x -> !Strings.isEmpty(x)).map(x -> x.length()).collect(toList());
        List<Integer> zz = Stream.of("", "b", "helloworld").filter(x -> !Strings.isEmpty(x)).map(String::length).collect(toList());
        xx.forEach(System.out::print);

        List<String> test = new ArrayList<String>() {{
            add("1aaa");
            add("cc");
            add("2qq");
        }};
        test.stream().filter(x -> '1' <= x.charAt(0) && x.charAt(0) <= '9').collect(toList());
    }

    public static void StreamTest() {
        IntStream.of(1,2,3,5).forEach(System.out::println);
        IntStream.range(1,10).forEach(System.out::println);
        IntStream.rangeClosed(1,10).forEach(System.out::println);

        Stream.of(1,2,3,4,5).forEach(System.out::println);
    }

    //map   maptoInt    maptoDouble     mapToLong
    public static void mapTest() {

        List<Character> list = Stream.of("10", "21", "32", "41").map(x -> x.charAt(0)).collect(toList());
        List<Double> doubleList = Stream.of("10", "21", "32", "41").map(Double::parseDouble).collect(toList());

        //转出来的double是基本数据类型，不能放入集合中去
//        List<Double> dlist = Stream.of("1", "2", "3", "4").mapToDouble(Double::parseDouble).collect(toList());
        //所以得装箱为基本数据类型的包装类型
        List<Double> dlist = Stream.of("1", "2", "3", "4").mapToDouble(Double::parseDouble).boxed().collect(toList());
        dlist.forEach(System.out::println);

        Double x = Stream.of("1", "2", "3", "4").mapToDouble(Double::parseDouble).max().getAsDouble();
        Long y = Stream.of("1", "2", "3", "4").mapToLong(Long::parseLong).max().getAsLong();
        Integer z = Stream.of("1", "2", "3", "4").mapToInt(Integer::parseInt).max().getAsInt();
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }

    //  max min
    // 对于maptodouble 这种max方法就不需要传参数了，因为实际上返回的实例为OptionalDouble的对象
    public static void maxAndMinTest() {
        Track max = Stream.of(new Track("Bakai", 524), new Track("Green", 111), new Track("kkk", 1823), new Track("12306", 223))
                .max(Comparator.comparing(Track::getReader)).orElse(null);
        System.out.println(max.toString());
        max = Stream.of(new Track("Bakai", 524), new Track("Green", 111), new Track("kkk", 1823), new Track("12306", 223))
                .max(Comparator.comparing(Track::getReader)).orElseThrow(null);
        System.out.println(max.toString());

    }
    // 普通的非lambda形式下的reduce操作。
    public static void reduceTest() {
        List<Track> list = asList(new Track("Bakai", 524), new Track("Green", 111), new Track("kkk", 1823), new Track("12306", 223));
        Track accumulator = list.get(0);
        for(Track element : list) {
            accumulator = combine(accumulator, element);
        }
        System.out.println(accumulator.toString());
    }

    private static Track combine(Track accumulator, Track element) {
        return accumulator.getReader() > element.getReader() ? accumulator : element;
    }

    //lambda stream的流式reduce操作
    public static void reduceStreamTest() {
        //从 -1开始加一直加到6
        int count = Stream.of(0, 1, 2, 3, 4, 5, 6).reduce(-1, (acc, element) -> acc + element);
        System.out.println(count);
        count = IntStream.rangeClosed(0, 6).reduce(-1 ,(acc, element) -> acc + element);
        System.out.println(count);
    }

    //optional
    public static void optionalTest() throws Throwable {
        //orElseThrow可以认为不是optional的值是null的话就抛出自己定义的异常或者是自己随便搞个异常类继承Supplier就可以了
        System.out.println("xx:" + Optional.empty().orElseThrow(() -> new Exception("1111")));
        System.out.println("xx:" + Optional.empty().orElseThrow((Supplier<Throwable>) () -> new Exception("1111")));
        System.out.println("xx:" + Optional.empty().orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new Exception("1111");
            }
        }));
    }

    //flatmap
    public static void flatMapTest() {
        //合并两个list并且去重      flatmap是把两个list先进行操作然后最后进行flat
        System.out.println(Stream.of(asList(1, 2, 3), asList(2, 3, 4)).flatMap(numbers -> numbers.stream().filter(x -> x <= 3)).distinct().collect(toList()));

        Arrays.asList(1, 3, 4, 5, 9).forEach(x -> {
            System.out.println(x);
        });

        for (Integer x : asList(1, 3, 4, 5, 9)) {
            System.out.println(x);
        }

    }







    public static void main(String args[]) throws Throwable {
//        System.out.println(Arrays.asList(Stream.of("1", "2", "3", "4").mapToDouble(Double::parseDouble).toArray()));
//        mapTest();
//        maxAndMinTest();
//        reduceTest();
        reduceStreamTest();
    }



}
