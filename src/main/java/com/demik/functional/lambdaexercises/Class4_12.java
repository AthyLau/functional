package com.demik.functional.lambdaexercises;

import com.demik.functional.lambdaexpression.pojo.Artist;

import java.util.List;
import java.util.Optional;
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

class Artists {
    private List<Artist> artists;
    public Artists(List<Artist> artists) {
        this.artists = artists;
    }
    public Optional<Artist> getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
//            indexException(index);
        }
        return Optional.of(artists.get(index));
    }
    private void indexException(int index) {
        throw new IllegalArgumentException(index +
            "doesn't correspond to an Artist");
    }
    public String getArtistName(int index) {
        return getArtist(index).map(Artist::getName).orElse("unknown");
    }
}














