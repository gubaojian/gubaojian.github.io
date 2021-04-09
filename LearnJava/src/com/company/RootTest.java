package com.company;

import java.util.HashSet;
import java.util.Set;

public class RootTest {


    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        Set<Integer> sums = new HashSet<>();
        doPathSum(root, sums);
        System.out.println(sums);
    }


    public static void doPathSum(TreeNode root, Set<Integer> sums){
        if(root == null){
            return;
        }
        doPathSumVal(root, 0, sums);
    }

    public static void doPathSumVal(TreeNode root, int curVal, Set<Integer> sums){
        if(root == null){
            return;
        }
        int val = root.val + curVal;
        if(root.left == null && root.right == null){
            sums.add(val);
        }
        System.out.println(val + " " + root.left  + " " + root.right);
        doPathSumVal(root.left, val, sums);
        doPathSumVal(root.right, val, sums);
    }
}
