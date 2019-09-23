package com.demik.functional.lambdaexercises;

import com.demik.functional.lambdaexpression.ATADemo;
import com.demik.functional.lambdaexpression.pojo.Album;
import com.demik.functional.lambdaexpression.pojo.Artist;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        System.out.println(getLowerCharNumFromStr("abc"));
        System.out.println(getMoreLowerStr(new ArrayList<String>() {{
            add("abcQEEWss");
            add("defdDSAd");
            add("qqqfeAAAf");
            add("3ertaassss");
        }}).get());
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

    /**
     * 计算一个字符串中小写字母的个数
     */
    private static Integer getLowerCharNumFromStr(String str){
//        return Integer.parseInt(String.valueOf(IntStream.rangeClosed(0, str.length()-1).filter(i -> Character.isLowerCase(str.charAt(i))).count()));
        return IntStream.rangeClosed(0, str.length()-1).filter(i -> Character.isLowerCase(str.charAt(i))).boxed().collect(Collectors.toList()).size();
    }

    /**
     * 在一个字符串列表中，找出包含最多小写字母的字符串。对于空列表，返回 Optional<String> 对象。
     */
    private static Optional<String> getMoreLowerStr(List<String> list) {
        return list.stream().max(Comparator.comparing(Class3_9::getLowerCharNumFromStr));
    }
}
