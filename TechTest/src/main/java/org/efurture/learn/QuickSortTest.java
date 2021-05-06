package org.efurture.learn;

import java.util.Arrays;

public class QuickSortTest {


    public static void main(String[] args){
        int[] a = new int[]{1,3,5,2,2, 8, 9, 10, 3, 9};
        int k = 2;
        k--;
        quickFindKth(a, 0, a.length-1, k);
        System.out.println(a[k]);
        System.out.println(Arrays.toString(a));
    }


    public static void quickFindKth(int[] a, int start, int end, int k){
        int pivot = a[start];
        int i = start;
        int j = end;
        while(i < j){
            while(i < j && pivot < a[j]){
                j--;
            }
            while(i < j && pivot > a[i]){
                i++;
            }
            if(a[i] == a[j] && i < j){
                i++;
            }else{
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        if(i - 1 > start){
            if(k <= i - 1) {
                quickFindKth(a, start, i - 1, k);
            }else{
            }
        }

        if(j + 1 < end){
            if(k > end){
            }else {
                quickFindKth(a, j + 1, end, k);
            }
        }
    }
}
