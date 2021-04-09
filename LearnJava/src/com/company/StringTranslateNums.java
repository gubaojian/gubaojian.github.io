package com.company;

public class StringTranslateNums {


    public static void main(String[] args){
        System.out.println(translateNum(12258));
    }


    public static int translateNum(int num) {
        String sb = String.valueOf(num);
        int result = doTranslateNum(sb);
        return result;
    }

    public  static int doTranslateNum(String sb){
        int result = 1;
        for(int i=1; i<sb.length(); i++){
            char ch = sb.charAt(i-1);
            char next = sb.charAt(i);
            if(ch >= '0' && ch <= '9' && next >= '0' && next <= '9'){
                String numStr = sb.substring(i-1, i+1);
                int num = Integer.valueOf(numStr);
                if(num >= 10 && num <= 25){
                    result += doTranslateNum(sb.substring(i+1));
                }
            }
        }
        return result;
    }
}
