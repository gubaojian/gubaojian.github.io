package com.company;

import java.util.Stack;

public class StringTest {

    public static void main(String[] args){
        String s = "(()(((()";
        longestValidParentheses(s);
    }



    public static int longestValidParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                sb.append('(');
            }else{
                int index = sb.length()-1;
                while (index >= 0){
                    if(sb.charAt(index) == '2'){
                        index--;
                    }else{
                        break;
                    }
                }
                if(index >= 0 && sb.charAt(index) == '(') {
                    sb.deleteCharAt(index);
                    sb.append('2');
                }else{
                    sb.append(')');
                }
            }
        }
        int longestLen = 0;
        for(int i=0; i<sb.length();){
            char ch = sb.charAt(i);
            if(ch != '2'){
                i++;
            }else{
                int m=0;
                int len = 0;
                while ((i + m) < sb.length() && sb.charAt(i + m) == '2'){
                    len +=2;
                    m++;
                }
                i+=m;
                if(len > longestLen){
                    longestLen = len;
                }
            }
        }
        return longestLen;
    }
}
