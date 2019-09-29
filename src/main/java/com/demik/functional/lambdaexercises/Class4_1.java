package com.demik.functional.lambdaexercises;


import com.demik.functional.dto.logger.Logger;
import com.demik.functional.dto.logger.LoggerHelper;


/**
 * @author liubing
 * @dare: 2019/9/24 11:32 AM
 * @since JDK 1.8
 */
public class Class4_1 {
    //    private static Logger logger = LoggerFactory.getLogger(Class4_1.class.getName());
    private static Logger logger = LoggerHelper.getLogger();

    public static void main(String args[]) {
        logger.setLevel("debug");
        logger.setMessage("Token is wrong!");
        logger.setName("TokenLog");
        logger.setTimestamp(System.currentTimeMillis());
        logger.debug(() -> "[ "+logger.getTimestamp()+ " - " +logger.getName() + " ] : [" + logger.getLevel() + "] " + logger.getMessage());
    }

}
