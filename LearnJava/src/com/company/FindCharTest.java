package com.company;

import java.util.*;

public class FindCharTest {



    public static void main(String[] args){
       // System.out.println(alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));


        //System.out.println(alienOrder(new String[]{"abe","abd"}));

       // System.out.println(alienOrder(new String[]{"x","z"}));

        //System.out.println(alienOrder(new String[]{"x","z", "x"}));

        System.out.println(alienOrder(new String[]{"aa", "ad","cd","cc", "b"}));

        System.out.println(alienOrder(new String[]{"aa", "ad","cd","ce", "b"}));



        System.out.println("table " + alienOrder2(new String[]{"aa", "ad","cd","cc", "b"}));

        System.out.println("table " + alienOrder3(new String[]{"aa", "ad","cd","cc", "b"}));


        System.out.println("table " + alienOrder3(new String[]{"z", "x","z"}));


    }


    public static String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        List<Character> sorts = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            String word = words[i];
            for(int m=0; m<word.length(); m++){
                char ch = word.charAt(m);
                if(sb.indexOf(String.valueOf(ch)) < 0){
                    sb.append(ch);
                }
            }
            if(word.length() > 0){
                char ch = word.charAt(0);
                if(sorts.indexOf(ch) < 0){
                    sorts.add(word.charAt(0));
                }
            }
        }

        List<Character[]> sortInfos = new ArrayList<>();
        for(int i=1; i<words.length; i++){
            String one = words[i-1];
            String two = words[i];
            int len = Math.min(one.length(), two.length());
            for(int m=0; m<len; m++){
                char onc = one.charAt(m);
                char twc = two.charAt(m);
                if(onc == twc){
                    continue;
                }
                Character[] info = new Character[2];
                info[0] = onc;
                info[1] = twc;
                sortInfos.add(info);
                break;
            }
        }
        if(sorts.size() == 1){
            sorts.clear();
        }
        String table = sb.toString();
        boolean valid = doAlienOrder(sorts,  table.length(), sortInfos);
        if(!valid){
            return "";
        }
        System.out.println("size " + sortInfos.size());
        if(sorts.size() <=  table.length()){
            List<Character> normal = new ArrayList<>();
            for(int i=0; i<table.length(); i++){
                Character ch = table.charAt(i);
                if(sorts.indexOf(ch) < 0){
                    normal.add(ch);
                }
            }
            Collections.sort(normal);
            StringBuilder ssb = new StringBuilder();
            for(Character ch : normal){
                ssb.append(ch);
            }
            for(Character ch : sorts){
                ssb.append(ch);
            }
            return ssb.toString();
        }


        return "";
    }


    public static boolean doAlienOrder(List<Character> sorts, int maxLen, List<Character[]> sortInfos) {
        if(sortInfos.size() == 0){
            return true;
        }
        Character[] step = null;
        for(int i=0; i<sortInfos.size(); i++){
            Character[] info = sortInfos.get(i);
            Character first =  info[0];
            Character second =  info[1];
            int fi = sorts.indexOf(first);
            int si = sorts.indexOf(second);
            if(fi < 0 &&  si< 0){
                sorts.add(first);
                sorts.add(second);
                step = info;
                sortInfos.remove(i);
                break;
            }
            if(fi >= 0 && si >= 0){
                if(fi < si){
                    sortInfos.remove(i);
                    step = info;
                    break;
                }else{
                    //非法参数
                    return false;
                }
            }
            if(fi >= 0){
                //find second min
            }
        }
        if(step == null){
            return true;
        }

        return doAlienOrder(sorts, maxLen, sortInfos);
    }


    public static String alienOrder2(String[] words) {
        // 提取边(整个题目的核心就在这里了，提取出来边以后剩下的就是拓扑排序的模板题了)
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            int len = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < len; j++) {
                if (words[i].charAt(j) == words[i + 1].charAt(j)) {
                    continue;
                }
                Set<Character> set = map.getOrDefault(words[i].charAt(j), new HashSet<>());
                set.add(words[i + 1].charAt(j));
                map.putIfAbsent(words[i].charAt(j), set);
                break;
            }
        }
        // 计算并保存节点的入度
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree[c - 'a'] = 0;
            }
        }
        for (Character key : map.keySet()) {
            for (Character v : map.get(key)) {
                inDegree[v - 'a']++;
            }
        }
        // bfs
        StringBuilder builder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] == 0) {
                queue.add((char) (i + 'a'));
            }
            if (inDegree[i] != -1) {
                count++;
            }
        }
        while (!queue.isEmpty()) {
            Character node = queue.poll();
            builder.append(node);
            if (map.containsKey(node)) {
                for (Character nei : map.get(node)) {
                    inDegree[nei - 'a']--;
                    if (inDegree[nei - 'a'] == 0) {
                        queue.add(nei);
                    }
                }
            }
        }
        if (builder.length() != count) {
            return "";
        }
        return builder.toString();
    }


    public static String alienOrder3(String[] words) {
        Map<Character,Set<Character>> graph = new HashMap<>();
        for(int i=1; i<words.length; i++){
            String one = words[i-1];
            String two = words[i];
            int len = Math.min(one.length(), two.length());
            for(int m=0; m<len; m++){
                char onc = one.charAt(m);
                char twc = two.charAt(m);
                if(onc == twc){
                    continue;
                }
                Set<Character> sets = graph.getOrDefault(onc, new HashSet());
                sets.add(twc);
                graph.putIfAbsent(onc, sets);
            }
        }
        int[] tables = new int[26];
        Arrays.fill(tables, -1);
        for(String word : words){
            for(int i=0; i<word.length(); i++){
                char ch = word.charAt(i);
                tables[ch - 'a'] = 0;
            }
        }
        for(Character key : graph.keySet()){
            for(Character v : graph.get(key)){
                tables[v - 'a']++;
            }
        }
        Queue<Character> queue = new LinkedList<>();
        int count = 0;
        for(int i=0; i<26; i++){
            if(tables[i] == 0){
                char ch  = (char)(i + 'a');
                queue.add(ch);
            }

            if(tables[i] != -1){
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            Character node = queue.poll();
            sb.append(node);
            if(graph.containsKey(node)){
                for(Character next : graph.get(node)){
                    tables[next - 'a']--;
                    if(tables[next - 'a'] == 0){
                        queue.add(next);
                    }
                }
            }
        }
        System.out.println("sb  " + sb);
        if(sb.length() != count){
            //return "";
        }
        return sb.toString();
    }

}
