package com.study.base.java8.stream;

import com.study.base.java8.vo.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *  一、Stream 的三个操作步骤
 *      1、创建Stream
 *          方式1.可以通过Collection 每列集合提供的 stream() 或 parallelStream()
 *          方式2.可以通过Arrays中的静态方法获取 stream()
 *          方式3.可以通过Stream 类中的静态方法 of()
 *          方式4.创建无限流 （迭代、生成）
 *
 *    注意：多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止操作，否则
 *          中间操作不会执行任何的处理！而在终止操作时一次性全部处理，称为“惰性求值”
 *
 */
public class Stream_1_Create {
    /**
     * 创建Stream
     */
    public void streamTest1(){
        // 方式1.可以通过Collection 每列集合提供的 stream() 或 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 方式2.可以通过Arrays中的静态方法获取 stream()
        Employee[] empArr = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(empArr);

        // 方式3.可以通过Stream 类中的静态方法 of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 方式4.创建无限流
        // 迭代
        //      iterate(x, y) 运算 从x开始，后面按y进行运算。
        //      下面这个是 从0开始，每次加2
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        // 生成
        Stream.generate(() -> Math.random()).forEach(System.out::println);
    }
}
