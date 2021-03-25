/*
 * Copyright By ZATI
 * Copyright By 3a3c88295d37870dfd3b25056092d1a9209824b256c341f2cdc296437f671617
 * All rights reserved.
 *
 * If you are not the intended user, you are hereby notified that any use, disclosure, copying, printing, forwarding or
 * dissemination of this property is strictly prohibited. If you have got this file in error, delete it from your system.
 */
package com.gl.springboot.jdk8.stream;

import com.gl.springboot.entity.UserInfo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一、Stream的三个操作步骤
 *
 * 1.创建Stram
 *
 * 2.中间操作
 *
 * 3.终止操作
 */
public class StreamTest {

    /**
     * 一、创建Stream
     */
    public static void test1(){
        //1.可以通过Collection系列集合提供的stream()或paralleStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //2.通过Arrays中的静态方法stream()获取
        String[] strings = null;
        Stream<String> stream1 = Arrays.stream(strings);

        //3.通过Stream中的静态方法获取
        Stream<String> stream2 = Stream.of("1", "2");

        //4.创建无限流
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);

    }

    /**
     * 二、筛选与切片
     * 1.filter：接收lambda，从流中排除某些元素
     * 2.limit：截断流，使其元素不超过给定数量
     * 3.skip(n)：跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补。
     * 4.distinct：筛选，通过流所生成元素的hashCode()和equals()去除重复元素
     */
    public static void test2(){
        List<UserInfo> userInfos = Arrays.asList(new UserInfo("1", "GL", 10),
                new UserInfo("2", "GL2", 20),
                new UserInfo("3", "GL3", 30),
                new UserInfo("4", "GL4", 40),
                new UserInfo("5", "GL5", 50),
                new UserInfo("6", "GL6", 60));
        Stream<UserInfo> userInfoStream = userInfos.stream()
                .filter((userInfo) -> userInfo.getUserAge().equals("30"));
        userInfoStream.forEach(System.out :: println);
    }

    /**
     * 三、映射
     * 1.map：接收Lambda，将元素转换成其它形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * 2.flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
     */
    public static void test3(){

        //1.map映射
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee");
        Stream<String> stringStream = list.stream().map((str) -> str.toUpperCase());
        stringStream.forEach(System.out :: println);

        //2.map提取
        userInfos.stream().map(UserInfo :: getUserName).forEach(System.out :: println);
    }

    /**
     * 四、排序
     * 1.sorted()：自然排序（Comparable）
     * 2.sorted(Comparator com)：定制排序（Comparator）
     */
    public static void test4(){
        //自然排序
        userInfos.stream().sorted().forEach(System.out::println);
        System.out.println("------------------------------------------------------------------");
        //定制排序
        userInfos.stream().sorted((e1,e2) -> {
            //年龄一样就按照名字排序
           if (e1.getUserAge().equals(e2.getUserAge())){
               return e1.getUserName().compareTo(e2.getUserName());
           }else {
               return e1.getUserAge().compareTo(e2.getUserAge());
           }
        }).forEach(System.out::println);
    }

    /**
     * 五、归约
     * reduce(T identity,BinaryOperator) / reduce(BinaryOperator)：
     * 可以将流中元素反复结合起来，得到一个值。
     */
    public static void test5(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //求和
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        System.out.println("-----------------------------------------------------------");

        //map-reduce模式经常被使用
        Optional<Integer> optional = userInfos.stream()
                .map(UserInfo::getUserAge)
                .reduce(Integer::sum);
        System.out.println(optional.get());
    }

    /**
     * 六、收集
     * collect：将流转换为其它形式。接收一个Collector接口的实现，用于给Stream中的元素做汇总的方法。
     */
    public static void test6(){
        //放到List中
        List<String> list = userInfos.stream().map(UserInfo::getUserName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("-----------------------------------------------------");

        //放到HashSet中
        HashSet<String> hashSet = userInfos.stream().map(UserInfo::getUserName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
    }

    public static void main(String[] args) {
        userInfos = Arrays.asList(new UserInfo("1", "GL", 10),
                new UserInfo("2", "GL2", 20),
                new UserInfo("3", "GL3", 30),
                new UserInfo("4", "GL4", 30),
                new UserInfo("5", "GL5", 50),
                new UserInfo("6", "GL6", 60));
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
        test6();
    }

    public static List<UserInfo> userInfos;
}
