package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TryResourcesTest {

    public static void main(String[] args){
        List<Optional<String>> list =   Arrays.asList (
                Optional.empty(),
                Optional.of("A"),
                Optional.empty(),
                Optional.of("B"));
        System.out.println(list);

        List<String> filterList = list.stream().flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty()).collect(Collectors.toList());


        System.out.println(filterList);
    }
}
