package com.demik.functional.lambdaexpression.pojo;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/9/19 5:21 PM
 * @since JDK 1.8
 */
public class Album {
    private String name;
    private List<Track> tracks;
    private List<Artist> musicians;

    public Album() {
    }

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        this.name = name;
        this.tracks = tracks;
        this.musicians = musicians;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", tracks=" + tracks +
                ", musicians=" + musicians +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }
}
