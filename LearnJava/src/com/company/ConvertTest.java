package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ConvertTest {


    public static void main(String[] args){
       String s = "PAYPALISHIRING";
       int numRows = 3;

       System.out.println(convert(s, numRows));

       System.out.println( ((1<<31) - 1) + "   " + 0x7fffffff);

       int res = -2147483648;

       System.out.println(res + "  " + res/10

       + "  reulst " + ( -2147483648 == (1<<31))) ;


       System.out.println((-4) >> 1);
        int div = 1;

        System.out.println(div <<= 1);
        System.out.println(div);

        System.out.println(div >>=1);
        System.out.println(div >>=1);

        System.out.println( ((-10)<<31));

    }

    public static String convert(String s, int numRows) {
        int numCols = s.length();
        if(numRows == 1){
            return s;
        }
        char[][] z = new char[numRows][numCols];
        int index = 0;
        for(int i=0; i<numCols; i++){
            int mod = i%(numRows - 1);
            for(int j=0; j<numRows; j++){
                if(index >= s.length()){
                    break;
                }
                if(mod == 0){
                    z[j][i] = s.charAt(index);
                    index++;
                }else{
                    if(j == numRows - mod - 1){
                        z[j][i] = s.charAt(index);
                        index++;
                    }
                }
            }
            if(index >= s.length()){
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++){
            for(int j=0; j<numCols; j++){
                char ch = z[i][j];
                if(ch != 0){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }


    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        if(divisor == 1){
            return dividend;
        }
        if(divisor == -1){
            if(dividend == (1<<31)){
                return ((1<<31) - 1);
            }
            return -dividend;
        }
        if(dividend > 0){
            if(divisor < 0){
                return -divide(-dividend, divisor);
            }else{
                return divide(-dividend, -divisor);
            }
        }else{
            if(divisor > 0){
                return -divide(dividend, -divisor);
            }
        }
        int[] dims = new int[32];
        int[] divs = new int[32];
        dims[0] = divisor;
        divs[0] = 1;
        int len = dims.length;
        for(int i=1; i<len; i++){
            dims[i] = dims[i-1] + dims[i-1];
            divs[i] = divs[i-1] + divs[i-1];
            if(dims[i] > dividend){
                dims[i] = 0;
                divs[i] = 0;
                len = i;
                break;
            }
            if(dims[i] < 0){
                dims[i] = 0;
                divs[i] = 0;
                len = i;
                break;
            }
        }
        int result = 0;
        for(int i=len; i>=0;){
            if(dims[i] == 0){
                i--;
                continue;
            }
            int remain = dividend - dims[i];
            if(remain < 0){
                result += divs[i];
                dividend = remain;
            }else if(remain == 0){
                result += divs[i];
                break;
            }else{
                i--;
            }
        }
        return result;
    }
}
