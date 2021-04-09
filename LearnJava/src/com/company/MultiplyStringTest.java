package com.company;

public class MultiplyStringTest {

    public static void main(String[] args){

        System.out.println(multiply("140", "721"));

    }

    public static String multiply(String num1, String num2) {
        StringBuilder[] mutiplys = new StringBuilder[num2.length()];
        for(int i=0; i<num2.length(); i++){
            char ch = num2.charAt((num2.length() -1) - i);
            StringBuilder sb = new StringBuilder();
            int tenN = i;
            while(tenN > 0){
                sb.append('0');
                tenN--;
            }
            int left = 0;
            int chNum = ch - '0';
            for(int m=0; m<num1.length(); m++){
                char mch = num1.charAt((num1.length() - 1) - m);
                int val = (mch - '0')*chNum + left;
                left = val/10;
                char valCh = (char)(val%10 + '0');
                sb.append(valCh);
            }
            if(left > 0){
                sb.append(left);
            }
            mutiplys[i] = sb;
            System.out.println(sb);
        }
        int length = 0;
        for(int i=0; i<mutiplys.length; i++){
            if(length < mutiplys[i].length()){
                length = mutiplys[i].length();
            }
        }
        StringBuilder result = new StringBuilder();
        int left = 0;
        for(int i=0; i<length; i++){
            int val = 0 + left;
            for(int m=0; m<mutiplys.length; m++){
                if(i < mutiplys[m].length()){
                    char ch = mutiplys[m].charAt(i);
                    val += (ch - '0');
                }
            }
            char valCh = (char)(val%10 + '0');
            left = val/10;
            result.append(valCh);
        }
        if(left > 0){
            char valCh = (char)(left + '0');
            result.append(valCh);
        }
        System.out.println(result);

        while(result.length() > 1 && result.charAt(result.length() - 1) == '0'){
            result.deleteCharAt(result.length() -1);
        }

        return result.reverse().toString();
    }
}
