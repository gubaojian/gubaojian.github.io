package com.company;

public class FindMiddle {


    public static void main(String[] args){
        int[] nums1  = {1,3};
        int[] num2 = {2,7};

    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] results = new int[nums2.length + nums1.length];
        int m=0; int n=0;
        for(int i=0; i<results.length; i++){
            if(m <nums1.length && n < nums2.length){
                if(nums1[m] <= nums2[n]){
                    results[i] = nums1[m];
                    m++;
                }else{
                    results[i] = nums2[n];
                    n++;
                }
            }else if(m <nums1.length){
                results[i] = nums1[m];
                m++;
            }else if(n <nums2.length){
                results[i] = nums2[n];
                n++;
            }
        }
        if(results.length % 2 == 0){
            if(results.length == 0){
                return 0;
            }
            int mid = results.length/2;
            return (results[mid] + results[mid - 1])/2.0;
        }else{
            return results[results.length/2];
        }
    }
}
