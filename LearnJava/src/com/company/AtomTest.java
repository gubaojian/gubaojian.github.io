package com.company;

public class AtomTest {


    public static void main(String[] args){
        System.out.println(myAtoi("21474836460"));

    }




    public static int myAtoi(String s) {
        int start = -1;
        int end = -1;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(start < 0){
                if(ch == ' '){
                    continue;
                }
                if(ch >= '0' && ch <= '9'){
                    start = i;
                }else if(ch == '-' || ch == '+'){
                    if(i + 1 < s.length() && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9'){
                        continue;
                    }
                    return 0;
                }else{
                    return 0;
                }
            }else{
                if(ch >= '0' && ch <= '9'){
                    end = i;
                }else{
                    if(end < 0){
                        end = start;
                    }
                    break;
                }
            }
        }
        if(start < 0){
            return 0;
        }
        if(end < 0){
            end = start;
        }
        int flag = 1;
        if(start - 1 >= 0 && s.charAt(start - 1) == '-'){
            flag = -1;
        }
        int num = 0;
        for(int i=start; i<=end; i++){
            int res = s.charAt(i) - '0';
            if(flag < 0){
                res = -res;
            }
            int overflowCheck = num;
            num = num*10 + res;
            System.out.println("num =  " + num);
            if(num/10 != overflowCheck){
                System.out.println("overlow num =  " + num  + "  " +  ((1<<31) - 1)
                + " " + Integer.MAX_VALUE);
                if(flag < 0){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
            System.out.println("num     =  " + num);
        }
        System.out.println("num =  " + num);
        return num;
    }
}
