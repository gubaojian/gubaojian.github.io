package com.company;

import java.util.*;

public class SortedSetTest {


    public static void main(String[] args) {
        SortedSet<String> sets = new TreeSet<String>();
        for (int i = 0; i < 26; i++) {
            sets.add(String.valueOf((char) (i + 'a')));
        }
        System.out.println(sets);
        SortedSet subSet = sets.subSet("d", "q");
        System.out.println(subSet);


        SortedSet<String> headSet = sets.headSet("k");

        SortedSet<String> tailSet = sets.tailSet("k");

        System.out.println(headSet
                + "  " + tailSet);

        System.out.println(sets.first() + " " + sets.last());

        SortedMap<String, Employee> sortedMap = new TreeMap<String, Employee>();

        sortedMap.put("a", new Employee(10, "gubaojian"));
        sortedMap.put("b", new Employee(11, "gubaojian"));
        sortedMap.put("c", new Employee(12, "gubaojian"));
        sortedMap.put("d", new Employee(13, "gubaojian"));


        System.out.println(sortedMap.tailMap("b"));

        System.out.println(sortedMap.headMap("b"));



    }
}
