package com.demik.functional.lambdaexpression;

import com.demik.functional.lambdaexpression.pojo.Album;
import com.demik.functional.lambdaexpression.pojo.Artist;
import com.demik.functional.lambdaexpression.pojo.Track;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/9/23 10:41 AM
 * @since JDK 1.8
 */
public class ATADemo {


    public static Album album1 = new Album("值得一提的事", new ArrayList<Track>() {{
        add(new Track("童话幻灭", 900, 190));
        add(new Track("小星星", 1000, 120));
        add(new Track("阳光沙滩和你", 300, 100));
    }}, new ArrayList<Artist>() {{
        add(new Artist("个人1", null, "AAA"));
        add(new Artist("甲壳虫", Arrays.asList(new Artist("jiasiting1", null, "BBB"), new Artist("bibor", null, "ddd")), "FFF"));
        add(new Artist("个人2", null, "FFF"));
        add(new Artist("小星星", Arrays.asList(new Artist("xusong", null, "CCC"), new Artist("xuliang", null, "CCC")), "CCC"));
        add(new Artist("个人3", null, "CCC"));
        add(new Artist("个人4", null, "CCC"));
    }});

    public static Album album2 = new Album("dilidili", new ArrayList<Track>() {{
        add(new Track("坏女孩", 900, 130));
        add(new Track("素颜", 1000, 130));
        add(new Track("雪", 2000, 90));
        add(new Track("雨一直下", 300, 80));
    }}, new ArrayList<Artist>() {{
        add(new Artist("乐队1", Arrays.asList(new Artist("xusong", null, "CCC"), new Artist("xuliang", null, "CCC")), "AAA"));
        add(new Artist("许嵩", null, "FFF"));
        add(new Artist("乐队2", Arrays.asList(new Artist("jiasiting1", null, "BBB"), new Artist("bibor", null, "ddd")), "FFF"));
        add(new Artist("徐良", null, "CCC"));
        add(new Artist("周杰伦", null, "CCC"));
    }});

    public static ArrayList<Album> albums = new ArrayList<Album>() {{
        add(album1);
        add(album2);
    }};

    /**
     * 找出某张专辑下所有 乐 队 的国籍    艺术家可能是乐队可能是个人
     * 1、获取到所有的艺术家
     * 2、过滤掉所有的个人
     * 3、获取所有的国籍
     * 4、转为list
     */
    public static void findDistintOriginFromAlbum() {
        album1.getMusicians().stream().filter(x -> x.getMembers() != null).map(Artist::getOrigin).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }

    /**
     * 找出某张专辑下所有时长超过两分钟的曲目的名字
     * 普通方式双层遍历
     */
    public static void findLenTrackFromAlbum1() {
        List<String> list = new ArrayList<>();
        albums.forEach(x -> {
            x.getTracks().forEach(y -> {
                if (y.getSeconds() > 120) {
                    list.add(y.getName());
                }
            });
        });
        System.out.println(list);
    }
    /**
     * 找出某张专辑下所有时长超过两分钟的曲目的名字
     * 1、获取到所有的专辑
     * 2、获取到所有的曲目
     * 3、过滤曲目
     * 4、获取名字
     * 5、转为list
     */
    public static void findLenTrackFromAlbum2() {
        System.out.println(albums.stream().flatMap(x -> x.getTracks().stream().filter(y -> y.getSeconds() > 120).map(Track::getName)).collect(Collectors.toList()));
    }

    public static void main(String args[]) {
        findLenTrackFromAlbum1();
        findLenTrackFromAlbum2();
    }

}
