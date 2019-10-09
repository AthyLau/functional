package com.demik.functional.test;

import com.demik.functional.lambdaexpression.impl.LambdaXYDemo;
import com.demik.functional.lambdaexpression.impl.NullCheckDemo;
import com.demik.functional.lambdaexpression.inf.LambdaXY;
import com.demik.functional.lambdaexpression.inf.NullCheck;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BinaryOperator;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/8/9 4:46 PM
 * @since JDK 1.8
 */
public class LambadTest {

    public static void main(String args[]) throws InterruptedException {

//        interfaceDemo();
//        binaryOperatorDemo();
        lambdaXYTest();
    }

    /**
     * 拉姆达表达式
     * @throws InterruptedException
     */
    private static void interfaceDemo() throws InterruptedException {

        //没有参数的拉姆达表达式
        Runnable noArguments = () -> System.out.println("Hello World");
        noArguments.run();
        Thread t = new Thread(noArguments);
        t.start();
        Thread.sleep(10);
        System.out.println();

        //有一个参数的拉姆达表达式
        ActionListener oneArgument = event -> System.out.println("button clicked");

        //代码块作为拉姆达表达式
        Runnable multiStatement = () -> {
            System.out.print("Hello");
            System.out.println(" World");
        };
        multiStatement.run();
        System.out.println();
    }

    /**
     * BinaryOperator<T> 是一个接口，这个接口声明了一个没有方法名的方法，<T>是这个方法的返回值类型，
     * 纠正一下哈，这边不是说可以通过这个对象的apply方法来获取结果，而是，这个接口只有这一个apply未实现的方法，所以创建这个对象定义一个方法的时候实际上就是把这个未实现的方法apply实现了
     */
    private static void binaryOperatorDemo() {
        //不显示声明参数类型的拉姆达表达式定义的一个方法
        //拉姆达表达式的类型依赖于上下文环境，编译器根据上下文环境推断出来拉姆达表达式参数的类型。（比如说string str = null null付给str后才知道null的类型）
        BinaryOperator<Long> add = (x, y) -> x + y;
        System.out.println(add.apply(1l, 3l));
        System.out.println();
        //显示声明类型的拉姆达表达式定义的一个方法
        BinaryOperator<Boolean> addExplicit = (Boolean x, Boolean y) -> x && y;
        System.out.println(addExplicit.apply(true, true));
        System.out.println();
    }

    /**
     * 拉姆达表达式与final
     */
    private void finalAndLambda(){
        //既成事实的final变量
        int intTest = 1;
//        intTest++;//把这个打注释的话 就是把intTest这个变量隐式的定义为final的
        final List<Integer> listTest = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};
        listTest.add(33);
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("1").append("2").append("333");
        stringBuffer.append("111111");
        final String stringTest = "111";
        listTest.forEach(x->{
            if(intTest == Integer.parseInt(stringTest)){
                System.out.println(x);
                System.out.println(stringBuffer.toString());
            }
        });
    }

    private static void lambdaXYTest(){
        LambdaXY<Long> lambdaXY = (x, y) -> {
            if(Objects.equals(x, y)){
                return x*2;
            }else {
                return x > y ? x : y;
            }
        };
        System.out.println(lambdaXY.apply(2l, 9l));
    }

}

















