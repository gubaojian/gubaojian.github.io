package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineTarget2 {



    public static void main(String[] args){
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        //System.out.println(combinationSum2(new int[]{2,3,5}, 8));
    }



    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> results = doCombinationSum2(candidates, target, 0);
        return results;
    }

    public  static List<List<Integer>> doCombinationSum2(int[] candidates, int target, int startI) {
        if(startI >= candidates.length){
            return null;
        }
        if(target < candidates[startI]){
            return null;
        }
        List<List<Integer>> results = null;
        for(int i=startI; i<candidates.length; i++){
            if(target < candidates[i]){
                break;
            }
            if(target == candidates[i]){
                List<Integer> list = new ArrayList<>();
                list.add(target);
                if(results == null){
                    results = new ArrayList<>();
                }
                if(!results.contains(list)){
                    results.add(list);
                }
                continue;
            }
            List<List<Integer>> subResults = doCombinationSum2(candidates, target - candidates[i], i+1);
            if(subResults != null){
                for(List<Integer> subResult : subResults){
                    List<Integer> list = new ArrayList<>();
                    list.add(candidates[i]);
                    list.addAll(subResult);
                    if(results == null){
                        results = new ArrayList<>();
                    }
                    if(!results.contains(list)){
                        results.add(list);
                    }
                }
            }
        }
        return results;
    }

}
