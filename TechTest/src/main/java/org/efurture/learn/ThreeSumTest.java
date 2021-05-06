package org.efurture.learn;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumTest {


    public static void main(String[] args){
        int[] num = {1,2,-2,-1};
        System.out.println(threeSum(num));

        System.out.println(threeSum2(num));
    }


    public static ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(num == null || num.length <= 2){
            return results;
        }
        Arrays.sort(num);
        int sum, left, right;
        for(int i=0; i<num.length-2; i++){
            if(i > 0 && num[i] == num[i-1]){
                continue;
            }
            left = i + 1;
            right = num.length - 1;
            /**
             * 固定一个数，从后面的数中选出两个数，因为数组是有序的，
             * 用两个数组下表left和right，left指向当前元素的后一个位置。
             * right指向最后一个位置，三个数相加的和等于0时，加入解集。
             * 小于0时，left向右边移动
             * 大于0是，right向左边移动
             * */
            while(left < right){
                sum = num[left] + num[right];
                if(sum + num[i] == 0){
                    ArrayList<Integer> solution = new ArrayList<>();
                    solution.add(num[i]);
                    solution.add(num[left]);
                    solution.add(num[right]);
                    results.add(solution);
                    left++;
                    right--;
                    while(left < right && num[left] == num[left - 1]){
                        left++;
                    }
                    while (left < right && num[right] == num[right+1]){
                        right--;
                    }
                }else if(sum + num[i] < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return  results;
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);

        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        doThreeSum(num,  results);
        return results;
    }

    public static void doThreeSum(int[] nums, ArrayList<ArrayList<Integer>> results){
        for(int i=0; i<nums.length-2; i++){
            int a = nums[i];
            for(int j=i+1; j<nums.length-1; j++){
                int b = nums[j];
                if( a + b > 0){
                    break;
                }
                int c = 0 - (a + b);
                int index = Arrays.binarySearch(nums, c);
                if(index < 0 ){
                    continue;
                }
                if(index < j){
                    continue;
                }
                System.out.println(j + " " + i  + " ");
                if(nums[index] == nums[j]){
                    if(nums[j + 1] == nums[j]){
                        index = j + 1;
                    }else{
                        continue;
                    }
                }
                c = nums[index];
                ArrayList<Integer> result = new  ArrayList<Integer>();
                result.add(a);
                result.add(b);
                result.add(c);
                if(results.size() > 0){
                    ArrayList<Integer> top = results.get(results.size()-1);
                    if(top.equals(result)){
                        continue;
                    }
                }
                results.add(result);
            }
        }
    }
}
