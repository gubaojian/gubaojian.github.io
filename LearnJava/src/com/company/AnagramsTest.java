package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AnagramsTest {


    public static void main(String[] args){

        Map<String, List<String>> wordsMap = new HashMap<>();
        try{
            Scanner scanner = new Scanner(AnagramsTest.class.getResourceAsStream("scanner.txt"));
            scanner.useDelimiter(":| |\\[|\\]|,");
            while (scanner.hasNext()){
                String word = scanner.next();
                if(word.isEmpty()){
                    continue;
                }
                System.out.println(word);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
