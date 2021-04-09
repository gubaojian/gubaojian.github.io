package com.company;

public class ReverseTest {


    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }


    public static int reverse(int x) {
        int res = 0;
        while(x != 0){
            int mod = x%10;
            int pre = res;
            res = mod + res*10;
            x = x/10;
            if(res/10 != pre){
                return 0;
            }
            System.out.println(mod + " " + res);

        }
        return res;
    }
}
