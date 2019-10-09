package com.demik.functional.lambdaexercises;

import com.demik.functional.lambdaexpression.pojo.Artist;

import java.util.stream.Stream;

/**
 * @author AthyLau
 * @dare: 2019/10/8 4:29 PM
 * @since JDK 1.8
 */
public class Class4_12 {

    public static void main(String args[]) {
    }

}

interface Performance {
    String getName();

    Stream<Artist> getMusicians();

    default Stream<String> getAllMusicians(){
        return getMusicians().flatMap(artist -> Stream.concat(artist.getMembers().stream().map(Artist::getName), Stream.of(artist).map(Artist::getName)));
    }
}