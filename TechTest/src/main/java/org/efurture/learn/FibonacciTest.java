package org.efurture.learn;

public class FibonacciTest {



    public static void main(String[] args){
        System.out.println(Fibonacci(39));
    }


    public static int Fibonacci(int n) {
        if(n <= 1){
            return n;
        }
        if(n == 2){
            return 1;
        }
        if(n < 64 && n > 0){
            int result = caches[n];
            if(result > 0){
                return result;
            }
            result = Fibonacci(n-1) + Fibonacci(n-2);
            caches[n] = result;
            return result;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }


    private static int[] caches = new int[64];

}
