package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamLearn {

    public static void main(String[] args){
        List<String> datas = new ArrayList<String>();
        datas.add("Stream");
        datas.add("Learn");
        datas.add("Hello");
        datas.add("World");
        datas.add("W");
        datas.add("C");

        String result = datas.stream().filter(ele->
                ele.length() > 2
                ).collect(Collectors.joining(","));
        System.out.println(result);

        datas.stream().forEach(ele->System.out.println(ele));

        List<Integer> hashs = datas.stream().map(Objects::hashCode).collect(Collectors.toList());



        System.out.println(hashs);
    }
}
