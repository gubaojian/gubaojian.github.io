package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DealTest {

    public static  void main(String[] args){
        String[] rank = new String[] {
                "ace", "2", "3", "4",
                "5", "6", "7", "8", "9", "10",
                "jack", "queen", "king"
        };
        List<String> list = Arrays.asList(rank);
        System.out.println(list);

        List<String> sublist = list.subList(2, list.size());
        System.out.println(sublist);
        System.out.println(list);



        System.out.println(sublist);
        System.out.println(list);


        List<String> ofs = new ArrayList<>();
        ofs.add("ace");
        ofs.add("jack");
        ofs.add("queen");
        ofs.add("king");

        List<String> ofsSubList  = ofs.subList(2, ofs.size());

        System.out.println(ofsSubList);

        ofsSubList.clear();


        System.out.println(ofsSubList);
        System.out.println(ofs);
    }
}
