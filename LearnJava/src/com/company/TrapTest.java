package com.company;

public class TrapTest {


    public static void main(String[] args){
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }


    public static int trap(int[] height) {
        int sum = 0;
        for(int i=0; i<height.length; i++){
            int h = height[i];
            int n = findMin(height, i);
            if(n > h){
                sum += (n - h);
            }
        }
        return sum;
    }

    public static int findMin(int[] height, int index){
        if(index <= 0){
            return 0;
        }
        if((index + 1) >= height.length){
            return 0;
        }
        int left = height[index-1];
        for(int i=index-1; i>=0; i--){
            if(left < height[i]){
                left = height[i];
            }
        }
        int right = height[index+1];
        for(int i=index+1; i<height.length; i++){
            if(right < height[i]){
                right = height[i];
            }
        }
        return Math.min(left, right);
    }
}
