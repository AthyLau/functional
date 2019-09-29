package com.demik.functional.dto.logger;

/**
 * @author liubing
 * @dare: 2019/9/24 11:39 AM
 * @since JDK 1.8
 */
public class LoggerHelper {

    private static Logger logger;

    public static Logger getLogger(){
        if(logger == null){
            logger = new Logger();
        }
        return logger;
    }

}
