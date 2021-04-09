package com.company;

import java.util.ArrayList;
import java.util.List;

public class StringTest8 {



    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2-1-1"));
        System.out.println(diffWaysToCompute("2*3-4*5"));


        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        System.out.println(lengthOfLongestSubstringTwoDistinct("abaccc"));





    }


    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 2){
            return 0;
        }
        char a = s.charAt(0);
        char b = s.charAt(1);
        int maxLen = 2;
        int len = 2;
        for(int i=2; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == a || ch == b){
                len++;
            }else if(a == b){
                a = b;
                b = ch;
                len++;
            }else{
                if(len > maxLen){
                    maxLen = len;
                }
                len = 0;
                a = s.charAt(i-1);
                b = ch;
                int m = i;
                System.out.println("ch " + ch  + " " + i);
                while(m >=0 && (s.charAt(m) == a || s.charAt(m) == b)){
                    len++;
                    m--;
                }
                System.out.println( i + "len " + len + " " + a  + "  " + b  );
            }
        }
        if(len > maxLen){
            maxLen = len;
        }
        return maxLen;
    }


    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> results = new ArrayList();
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int numI = 0;
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '*' || ch == '-' ||  ch == '+'){
               String  num = input.substring(numI, i);
               nums.add(Integer.parseInt(num));
               ops.add(ch);
               numI = i+1;
            }
        }
        String  num = input.substring(numI, input.length());
        nums.add(Integer.parseInt(num));

        doDiffWaysToCompute(results, nums, ops, ops.size()-1);
        return results;
    }

    private static void doDiffWaysToCompute(List<Integer> results, List<Integer> nums, List<Character> ops, int max){
        if(ops.size() <= 0){
            if(nums.size() == 1) {
                results.add(nums.get(0));
            }
            return;
        }
        max = Math.min(max, ops.size()-1);
        for(int m=max; m>=0; m--){
            char ch = ops.get(m);
            if(m + 1 >= nums.size()){
                break;
            }
            int left = nums.get(m);
            int right = nums.get(m+1);
            int num = 0;
            if(ch == '*'){
                num = left*right;
            }else if(ch == '+'){
                num = left + right;
            }else if(ch == '-'){
                num = left - right;
            }
            if(ops.size() <= 1){
                results.add(num);
                continue;
            }
            nums.remove(m+1);
            nums.set(m, num);
            ops.remove(m);
            doDiffWaysToCompute(results, nums, ops, m);
            ops.add(m, ch);
            nums.set(m, left);
            nums.add(m+1, right);
        }
    }

    private static void doDiffWaysToCompute(List<Integer> results, String input){
        int opLen = 0;
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '*' || ch == '-' ||  ch == '+'){
                opLen++;
            }
        }
        if(opLen <= 0){
            int num = Integer.parseInt(input);
            results.add(num);
            return;
        }
        char[] chs = new char[opLen];
        int[] ops = new int[opLen];
        int pi = 0;
        for(int i=0; i<input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '*' || ch == '-' ||  ch == '+'){
                chs[pi] = ch;
                ops[pi] = i;
                pi++;
            }
        }
        for(int m=0; m<ops.length; m++){
            int opi = ops[m];
            String left = null;
            String right = null;
            if(m <= 0 ){
                left = input.substring(0, opi);
            }else{
                left = input.substring(ops[m-1]+1, opi);
            }
            if(m+1 < ops.length){
                right = input.substring(opi + 1, ops[m+1]);
            }else{
                right = input.substring(opi+1, input.length());
            }
            char ch = chs[m];

            int num = 0;
            if(ch == '*'){
                num = Integer.parseInt(left)*Integer.parseInt(right);
            }else if(ch == '+'){
                num = Integer.parseInt(left) + Integer.parseInt(right);
            }else if(ch == '-'){
                num = Integer.parseInt(left) - Integer.parseInt(right);
            }

            System.out.println(left  + " " + ch + " " + right  + " = " + num);

            if(ops.length <= 1){
                results.add(num);
                continue;
            }

            StringBuilder sb = new StringBuilder();
            if(m > 0){
                sb.append(input.substring(0, ops[m-1]));
            }
            sb.append(num);
            if(m + 1 < ops.length){
                sb.append(input.substring(ops[m+1], input.length()));
            }
            System.out.println("  next " + sb);
            String next = sb.toString();
            doDiffWaysToCompute(results, next);
        }
    }
}
