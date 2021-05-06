package org.efurture.learn;

import java.util.ArrayList;
import java.util.Comparator;

public class TechTest {

    public static void main(String[] args){
       int[] input =  {4,5,1,6,2,7,3,8};
       int k = 4;
        GetLeastNumbers_Solution(input, k);
    }


    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(k > input.length){
            return result;
        }
        for(int i=0; i<k; i++){
            result.add(input[i]);
        }
        result.sort(Comparator.naturalOrder());
        System.out.println(result);
        for(int i=k; i<input.length; i++){

            if(input[i] < result.get(result.size()-1)){
                int index = -1;
                for(int m=result.size()-1; m >= 0; m--){
                    if(result.get(m) <= input[i]){
                        index = m + 1;
                        break;
                    }
                }
                System.out.println("index " + index);
                if(index >= 0){

                    result.remove(result.size()-1);
                    result.add(index, input[i]);
                    System.out.println(result);

                }
            }
        }
        return result;
    }
}
