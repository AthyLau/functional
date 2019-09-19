package com.demik.functional.lambdaexpression.pojo;

import java.util.List;

/**
 * Function:创作音乐的个人或团队
 *
 * @author liubing
 * Date: 2019/9/19 5:18 PM
 * @since JDK 1.8
 */
public class Artist {

    private String name;
    private List<Artist> members;
    private String origin;

    public Artist() {
    }

    public Artist(String name, String origin) {
        this.name = name;
        this.origin = origin;
    }

    public Artist(String name, List<Artist> members, String origin) {
        this.name = name;
        this.members = members;
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", members=" + members +
                ", origin='" + origin + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Artist> getMembers() {
        return members;
    }

    public void setMembers(List<Artist> members) {
        this.members = members;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
