package com.demik.functional.lambdaexercises;

import com.demik.functional.lambdaexpression.ATADemo;
import com.demik.functional.lambdaexpression.pojo.Album;
import com.demik.functional.lambdaexpression.pojo.Artist;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/9/23 11:58 AM
 * @since JDK 1.8
 */
public class Class3_9 {

    public static void main(String args[]) {
        System.out.println(add(1, 2, 3, 4));
        System.out.println(getNewArtistsList(ATADemo.album1.getMusicians()));
        System.out.println(getThreeTrackAlbum(ATADemo.albums));
        System.out.println(getTotalMembersFromList(ATADemo.album1.getMusicians()));
    }

    /**
     * n个数字相加
     */
    private static Integer add(Integer... ints) {
        return Arrays.asList(ints).stream().filter(Objects::nonNull).reduce(0, (acc, element) -> acc + element);
    }

    /**
     * 获取艺术家列表中的艺术家的名字跟国籍放入一个新的list中
     */
    private static List<String> getNewArtistsList(List<Artist> artists) {
        return artists.stream().map(artist -> artist.getName() + " " + artist.getOrigin()).collect(Collectors.toList());
    }

    /**
     * 找出专辑列表中只有三首歌曲的专辑
     */
    private static List<Album> getThreeTrackAlbum(List<Album> albums) {
        return albums.stream().filter(album -> album.getTracks() != null && album.getTracks().size() == 3).collect(Collectors.toList());
    }

    /**
     * 计算艺术家列表的所有成员
     */
    private static Integer getTotalMembersFromList(List<Artist> artists) {
        //内部迭代，外部迭代foreach
        return artists.stream().mapToInt(artist -> artist.getMembers() == null ? 1 : artist.getMembers().size()).sum();
    }
}
