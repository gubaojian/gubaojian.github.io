package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PersonReductionTest {

    public static void main(String[] args) {
        List<Person> roster = new ArrayList<>();

        roster.add(new Person("gubaojian", 10));
        roster.add(new Person("谷宝剑", 20));
        roster.add(new Person("测试", 30));
        roster.add(new Person("你好", 35));

        double average = roster.stream().mapToInt(Person::getAge).average().getAsDouble();

        System.out.println(average);

        int sum = roster.stream().mapToInt(Person::getAge).sum();

        System.out.println(sum);

        int sum2 = roster.stream().map(Person::getAge).reduce(10, (a, b)->a + b);

        System.out.println(sum2);


        Averager averager = roster.stream().map(Person::getAge).collect(Averager::new, Averager::accept, Averager::combine);

        System.out.println(averager.average());

        Map<String, Integer> maps = roster.stream().collect(Collectors.groupingBy(Person::getName,
                Collectors.reducing(0, Person::getAge, Integer::sum)));

        System.out.println(maps);

    }
}
