package com.demik.functional.test;

/**
 * 4.7多重继承
 * @author AthyLau
 * @dare: 2019/10/8 2:10 PM
 * @since JDK 1.8
 */
public class DefaultTest {

    //如果对默认方法的工作原理，特别是在多重继承下的行为还没有把握，如下三条简单的定 律可以帮助大家。
    //1. 类胜于接口。如果在继承链中有方法体或抽象的方法声明，那么就可以忽略接口中定义 的方法。
    //2. 子类胜于父类。如果一个接口继承了另一个接口，且两个接口都定义了一个默认方法， 那么子类中定义的方法胜出。
    //3. 没有规则三。如果上面两条规则不适用，子类要么需要实现该方法，要么将该方法声明 为抽象方法。
    //其中第一条规则是为了让代码向后兼容。
    public static void main(String agrs[]) {
        new MyEarth().HelloWord();
        new JustCountry().HelloWord();
    }


}


interface Earth {
    default void HelloWord() {
        System.out.println("Hello Earth!");
    }
}

class MyEarth implements Earth {

}

interface China {
    default void HelloWord() {
        System.out.println("Hello China!");
    }
}
class MyChina implements China {

}
interface America {
    default void HelloWord() {
        System.out.println("Hello America!");
    }
}

//class AmericaAndChina implements China,America{
//    //编译器被干懵逼了，因为不知道调用的话是调用哪个接口里的方法,如果必须要用这个累实现China跟America的话就必须覆盖
//}

class JustCountry extends MyChina implements America {

    //如果补重写的话这里就报错了，因为有两个同样的方法都属于这个类
    @Override
    public void HelloWord() {
        System.out.println("Hello JustCountry!");
        //还可以这么指定
        America.super.HelloWord();
        //指定MyChina类的HelloWord方法
        super.HelloWord();
    }
}
