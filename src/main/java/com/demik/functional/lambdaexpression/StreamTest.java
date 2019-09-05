package com.demik.functional.lambdaexpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/9/5 1:32 PM
 * @since JDK 1.8
 */
public class StreamTest {
    private static Map<String, Object> map1 = new HashMap<String, Object>(){{
        put("1","1");
        put("2","2");
        put("3","3");
        put("4","4");
        put("5","5");
    }};
    private static Map<String, Object> map2 = new HashMap<String, Object>(){{
        put("a","a");
        put("b","b");
        put("c","c");
        put("d","d");
        put("e","e");
    }};
    private static Map<String, Object> map3 = new HashMap<String, Object>(){{
        put("A","A");
        put("B","B");
        put("C","C");
        put("D","D");
    }};
    private static List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(){{
        add(map1);
        add(map2);
        add(map3);
    }};
    /**
     * 使用内部迭代获取遍历过滤得到的数量
     */
    private static void streamFliterCount(){
        long count = list.stream().filter(x -> x.containsKey("A")).count();
        System.out.println(count);
    }
    public static void main(String args[]){
        streamFliterCount();
    }
}
