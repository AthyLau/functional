package com.demik.functional.test;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * 上界通配符跟下界通配符的意义
 *
 *                           food
 *                fruit                        meat
 *        Apple          Banana          Pork        Beef
 *  RedApple GreenApple
 *
 *
 * @author liubing
 * @dare: 2019/9/29 3:46 PM
 * @since JDK 1.8
 */
public class BoundsWildcards {

    public static void main(String args[]){
        //<? extends C> 适合大量做获取操作的情景，<? super C> 适合大量做添加操作的情景。
//        upBoundWildcards();
        downBoundWildcards();
    }
    //上界测试
    public static void upBoundWildcards(){

        //香蕉盘
        List<? extends Fruit> bananas = new ArrayList<Banana>(){{
            add(new Banana());
        }};
        //苹果盘
        List<? extends Fruit> Apples = new ArrayList<Apple>(){{
            add(new Apple());
        }};
        //水果盘装香蕉跟跟苹果
        //水果盘
        List<? extends Fruit> fruits = new ArrayList<Fruit>(){{
            addAll(Apples);
            addAll(bananas);
        }};

        //上界不能往里存，但是可以初始化的时候就设置好
//        fruits.addAll(bananas);
//        fruits.add(new Fruit());


        //上界为什么不能往里面继续存东西的原因案例
        //放了一个东西的盘子，但是我不知道这个东西是什么
        List<?> list = new ArrayList<Fruit>(){{
            add(new Fruit());
        }};
//        list.add(new Fruit());


        //上界可以往外取，原来里面放的什么类型取出来就是什么类型
        System.out.println(fruits.get(0).getClass());
        Apple apple = (Apple) fruits.get(0);
        System.out.println(fruits.get(0));
        System.out.println(apple);
        System.out.println();
        System.out.println();
        System.out.println(fruits.get(1).getClass());
        Banana banana = (Banana) fruits.get(1);
        System.out.println(fruits.get(1));
        System.out.println(banana);
    }
    //下界测试
    public static void downBoundWildcards(){
        //只能装水果的水果盘
        List<? super Fruit> fruits = new ArrayList<Fruit>(){{
            add(new Banana());
            add(new Fruit());
//            addAll(foods);
            addAll(new ArrayList<Fruit>(){{
                add(new Fruit());
                add(new Banana());
            }});
            addAll(new ArrayList<Banana>(){{
                add(new Banana());
            }});
            //下界只能添加Fruit及其子类的实例。
//            add(new Food());
        }};
        //只能装水果的食物盘
        List<? super Fruit> foods = new ArrayList<Food>(){{
            add(new Apple());
            //只能添加food的实例或者food子类的实例
            addAll(new ArrayList<Food>(){{
                add(new Food());
                add(new Fruit());
            }});
            addAll(new ArrayList<Fruit>(){{
                add(new Fruit());
            }});
            addAll(new ArrayList<Banana>(){{
                add(new Banana());
            }});
//            addAll(fruits);
        }};

        //下界可以初始化之后继续存东西
        fruits.add(new Banana());

//        fruits.addAll(foods);
//        foods.addAll(fruits);

        //下界可以往外取不过取出来的元素都是Object需要强转
        foods.stream().forEach(x -> {
            System.out.println(x.getClass());
            System.out.println(x);
            Food food = (Food) x;
            System.out.println(food);
        });


    }
}
//Lev 1
class Food{
    public Food() {
    }
}

//Lev 2
class Fruit extends Food{
    public Fruit() {
    }
}
class Meat extends Food{
    public Meat() {
    }
}

//Lev 3
class Apple extends Fruit{
    public Apple() {
    }
}
class Banana extends Fruit{
    public Banana() {
    }
}
class Pork extends Meat{
    public Pork() {
    }
}
class Beef extends Meat{
    public Beef() {
    }
}

//Lev 4
class RedApple extends Apple{
    public RedApple() {
    }
}
class GreenApple extends Apple{
    public GreenApple() {
    }
}