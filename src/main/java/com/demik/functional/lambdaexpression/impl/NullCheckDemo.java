package com.demik.functional.lambdaexpression.impl;

import com.demik.functional.lambdaexpression.inf.NullCheck;

import java.util.HashMap;
import java.util.Map;

/**
 * Function:可以使用一个接口的一个方法来 定义方法内的多个规则而不用写啥子实现类
 *
 * @author liubing
 * Date: 2019/8/14 10:30 AM
 * @since JDK 1.8
 */
public class NullCheckDemo {

    public static void main(String args[]) {

        NullCheck<String> nullCheck = x -> x != null && !x.isEmpty();

        System.out.println(nullCheck.nullCheck("aaa"));

        Map<String,Object> tokenMap = new HashMap<String,Object>(){{
           put("a","beaer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsaXViaW5nIiwiZXhwIjoxNTY3NTkyNjY0LCJhdXRob3JpdHkiO");
        }};
        String token = (String) tokenMap.getOrDefault("a","");
        tokenMap.put("a",token.substring(token.lastIndexOf(" ")+1,token.length()));
        System.out.println(tokenMap.get("a").equals("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsaXViaW5nIiwiZXhwIjoxNTY3NTkyNjY0LCJhdXRob3JpdHkiO"));
    }


}
