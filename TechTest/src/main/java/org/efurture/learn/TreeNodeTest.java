package org.efurture.learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeNodeTest {



    public static void main(String[] args){
        TreeNode root = new TreeNode();
        root.val = 1;

        makeLeftRight(root, 2, 3);

        makeLeftRight(root.left, 4, 5);

       // makeLeftRight(root.right, -1, 5);

        ArrayList<ArrayList<Integer>>  result = zigzagLevelOrder(root);

        System.out.println(result);



    }

    public static void makeLeftRight(TreeNode node, int left, int right){
        if(left > 0) {
            node.left = new TreeNode();
            node.left.val = left;
        }
        if(right > 0) {
            node.right = new TreeNode();
            node.right.val = right;
        }
    }



    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> layerVals = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return layerVals;
        }

        ArrayList<TreeNode> layerNodes = new ArrayList<>();
        layerNodes.add(root);
        boolean leftToRight = false;
        while(layerNodes.size() > 0){
            ArrayList<Integer> layerVal = new ArrayList<Integer>();
            ArrayList<TreeNode> nextNodes = new ArrayList<>();
            for(TreeNode node : layerNodes){
                layerVal.add(node.val);
            }


            if(leftToRight){
                for(int i=layerNodes.size()-1; i>= 0; i--){
                    TreeNode node = layerNodes.get(i);
                    if(node.left != null){
                        nextNodes.add(node.left);
                    }
                    if(node.right != null){
                        nextNodes.add(node.right);
                    }
                }
            }else{
                for(int i=layerNodes.size()-1; i>= 0; i--){
                    TreeNode node = layerNodes.get(i);
                    if(node.right != null){
                        nextNodes.add(node.right);
                    }
                    if(node.left != null){
                        nextNodes.add(node.left);
                    }
                }
            }

            layerVals.add(layerVal);
            layerNodes = nextNodes;
            leftToRight = !leftToRight;
        }

        return layerVals;
    }
}


