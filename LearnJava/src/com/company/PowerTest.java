package com.company;

public class PowerTest {




    public static void main(String[] args){
        double x = 2.00000;
        int n =  -2147483648;
        double result = myPow(x, n);
        System.out.println(result + " " + Math.pow(x, n));
    }

    public static double myPow(double x, int n) {
        if(n >=0){
            if(n > 32){
                int sn = n/2;
                int mod = n%2;
                double val = myPow(x, sn);
                return val*val*myPow(x, mod);
            }else{
                double result = 1;
                for(int i=0; i<n; i++){
                    result *=x;
                }
                return result;
            }
        }else{
            int absN = -n;
            double result =  0;
            if(absN < 0){
                result =  1/x*myPow(x, -(absN +1));
            }else{
                result =  1/myPow(x, absN);
            }
            if(Double.isInfinite(result) || Double.isNaN(result)){
                return 0;
            }
            return result;
        }
    }
}
