package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here

        List<Person> personList = new ArrayList();
        personList.add(new Person("hello", 10));
        personList.add(new Person("hello", 2));
        personList.add(new Person("hello", 3));
        personList.add(new Person("hello", 4));


        personList.sort(Comparator.comparingInt(Person::getAge));

        for(Person person :  personList){
            System.out.println(person.toString());
        }


        personList.sort(Comparator.comparingInt(Person::getAge).reversed());

        for(Person person : personList){
            System.out.println(person);
        }


        Collections.sort(personList, Comparator.comparingInt(Person::getAge));

        for(Person person : personList){
            System.out.println(person);
        }

        System.out.println("work hello world；hello world。");

        System.out.println(personList.stream().map(Person::toString).collect(Collectors.joining(",")));


        long start = System.currentTimeMillis();
        double  a=Math.random();
        for(int  i=0; i<1000000; i++){
            a+=Math.random();
        }
        System.out.println("used " + (System.currentTimeMillis() - start)/1000.0);
    }
}
