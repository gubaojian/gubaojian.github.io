package org.efurture.learn;

import java.util.HashSet;

public class MaxCount {




    public static void main(String[] args){
        int[] input =  {2,2,3,4,3};
        int k = 4;
        System.out.println(maxLength(input));

        int[] attrs = {1988,10036,13287,24377,29106,8933,9124,14803,28081,28614,19887,4078,23539,2956,7669,11918,25334,6672,8961,15335,23223,29613,29389,22745,8933,30755,29417,20951,31671,19662,17752,20600,26700,28391,17342,21105,26912,23916,5492,13511,11767,29850,8973,1490,29595,1704,7224,912,22747,27828,5352,21567,1236,9214,32179,11562,623,19284,31608,23491,29995,5325,25157,25842,2845,32698,22392,11949,20533,28378,24356,26569,18114,28365,22710,8719,26936,16587,11992,21139,31025,32150,16021,11329,16307,25773,14782,2233,8881,11203,2189,21341,13268,25199,28297};

        System.out.println(maxLength(attrs));

        System.out.println(attrs.length);
    }

    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxLength (int[] arr) {
        // write code here
        int maxCount = 0;
        int count = 0;
        int pos  = 0;
        HashSet<Integer> sets = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            sets.add(arr[i]);
            int ele = arr[i];
            for(int m= pos; m < count && m < arr.length; m++){
                if(arr[m] == ele){
                    count = count - (m - pos + 1);
                    pos = m + 1;
                    break;
                }
            }
            count++;
            if(maxCount < count){
                maxCount = count;
            }
        }
        System.out.println(sets.size());
        return maxCount;
    }
}
