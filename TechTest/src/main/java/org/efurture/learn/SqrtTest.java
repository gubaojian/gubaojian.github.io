package org.efurture.learn;

public class SqrtTest {



    public static void main(String[] args){
        System.out.println(sqrt(2, 0.0001) + "  " + Math.sqrt(2));
    }



    public static double sqrt(int n, double pre){
        double left = 0;
        double right = n;
        while (left < right){
            double mid = (left + right)/2;
            double result = mid*mid;
            if(result > n + pre){
                right = mid;
            }else if(mid  < n + pre){
                left = mid;
            }else{
                break;
            }
            if(right - left < pre){
                break;
            }
        }
        return (left + right)/2;
    }
}
