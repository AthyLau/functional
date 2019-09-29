package com.demik.functional.dto.logger;

import java.util.function.Supplier;

/**
 * @author liubing
 * @dare: 2019/9/24 11:37 AM
 * @since JDK 1.8
 */
public class Logger {

    private String level;
    private String name;
    private String message;
    private Long timestamp;

    Logger() {
    }

    private Logger(String level, String name, String message, Long timestamp) {
        this.level = level;
        this.name = name;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Boolean isDebugEnabled() {
        if (this.getLevel() == null) {
            return false;
        }
        return this.level.equals("debug");
    }

    public void debug(Supplier<String> supplier) {
        if(isDebugEnabled()){
            System.out.println(supplier.get());
        }
    }


    @Override
    public String toString() {
        return "Logger{" +
                "level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
