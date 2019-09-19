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

    public Track() {
    }

    public Track(String name, Integer reader) {
        this.name = name;
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", reader=" + reader +
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
}
