package com.demik.functional.lambdaexpression.pojo;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/9/19 5:21 PM
 * @since JDK 1.8
 */
public class Track {
    private String name;
    private Integer reader;
    private Integer seconds;
    public Track() {
    }

    public Track(String name, Integer reader) {
        this.name = name;
        this.reader = reader;
    }

    public Track(String name, Integer reader, Integer seconds) {
        this.name = name;
        this.reader = reader;
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", reader=" + reader +
                ", seconds=" + seconds +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReader() {
        return reader;
    }

    public void setReader(Integer reader) {
        this.reader = reader;
    }

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }
}
