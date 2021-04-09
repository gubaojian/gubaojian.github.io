package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class WordMapTest {

    public static void main(String[] args){

        String[] words = LeeCodeUtils.toStrs("WordCase.txt", 0);
        String[] wordOnes = {"eat","tea","tan","ate","nat","bat"};
        long start = System.currentTimeMillis();
        groupAnagrams(words);
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " ms");

        int a = -2147483648;
        int b = a + 1;

        System.out.println(a + "   " + Math.abs(b));

    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> hashWordsMap = new HashMap();
        for(String word : strs){
            HashMap<Character, Integer> hash = doWordCollection(word);
            List<String> collects = hashWordsMap.get(hash);
            if(collects == null){
                collects = new ArrayList<>();
                hashWordsMap.put(hash, collects);
            }
            collects.add(word);
        }
        List<List<String>> result = new ArrayList<>();
        Iterator<Map.Entry<HashMap<Character, Integer>, List<String>>> it =  hashWordsMap.entrySet().iterator();
        while (it.hasNext()){
            result.add(it.next().getValue());
        }
        return result;
    }



    private static HashMap<Character, Integer> doWordCollection(String word){
        HashMap<Character, Integer> one = new HashMap<>(8);
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            int count = one.getOrDefault(ch, 0);
            one.put(ch, count + 1);

        }
        return one;
    }


}
