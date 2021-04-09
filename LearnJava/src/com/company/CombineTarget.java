package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombineTarget {



    public static void main(String[] args){
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));

        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = doCombinationSum(candidates, target, 0);
        return results;
    }


    public static List<List<Integer>> doCombinationSum(int[] candidates, int target, int startOffset) {
        List<List<Integer>> results  = new ArrayList<>();
        if(target < candidates[0]){
            return results;
        }

        for(int i=startOffset; i<candidates.length; i++){
            if(target < candidates[i]){
                break;
            }
            if(target == candidates[i]){
                List<Integer> list = new ArrayList();
                list.add(target);
                if(!results.contains(list)) {
                    results.add(list);
                }
                continue;
            }
            int nextTarget = target - candidates[i];
            List<List<Integer>> subResults = doCombinationSum(candidates, nextTarget, i);
            if(!subResults.isEmpty()){
                for(List<Integer> subResult : subResults){
                    List<Integer> list = new ArrayList();
                    list.add(candidates[i]);
                    list.addAll(subResult);
                    results.add(list);
                }
            }
        }
        return results;
    }
}
