package org.efurture.learn;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {



    public static void main(String[] args){
        int[][] matrix = {{1,3,5,9},{8,10,3,4},{5,0,6,1},{8,8,4,0}};

        for(int x=0; x<matrix.length; x++){
            for(int y=0; y<matrix.length; y++){
                System.out.print(matrix[x][y] + "  ");
            }
            System.out.println();
        }
        System.out.println(minPathSum(matrix));
        System.out.println(dynamicMinPathSum(matrix));

        System.out.println(dynamicMinPathSum2(matrix));
    }




    public static int dynamicMinPathSum2(int[][] matrix){
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] dp = new int[height][width];
        for(int row=0; row < height; row++){
            for(int col=0; col<width; col++){
                int lastRow, leftCol;
                if(row == 0 || col == 0){
                    lastRow = (row - 1 < 0) ? 0 : row - 1;
                    leftCol = (col-1 < 0) ? 0 : col-1;
                    dp[row][col] = dp[lastRow][leftCol] + matrix[row][col];
                }else{
                    dp[row][col] = Math.min(matrix[row][col] + dp[row-1][col], matrix[row][col] +
                            dp[row][col-1]);
                }
            }
        }
        return dp[height-1][width-1];
    }

    public static int dynamicMinPathSum (int[][] matrix) {
        int height = matrix.length;
        int width  = matrix[0].length;
        int[][] dp = new int[height][width];

        for(int row=0; row < height; row++){
            for(int col = 0; col < width; col++){
                int lastRow, leftCol;
                if(row == 0 || col == 0){
                    lastRow = (row-1 < 0) ? 0 : row - 1;
                    leftCol = (col-1 < 0) ? 0 : col-1;
                    dp[row][col] = dp[lastRow][leftCol] +  matrix[row][col];
                }else{
                    dp[row][col] = Math.min(dp[row-1][col] + matrix[row][col],
                            dp[row][col-1] + matrix[row][col]);
                }
            }
        }

        return dp[height-1][width-1];
    }
    /**
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public static int minPathSum (int[][] matrix) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int sum = matrix[0][0];
        minPathSum(matrix, 0, 0, sum, treeSet);
        return treeSet.first();
    }

    public  static void minPathSum(int[][] matrix, int x, int y, int sum, TreeSet<Integer> result){
        if(result.size() > 0 && sum > result.first()){
            return;
        }
        if(x == matrix.length-1 && y == matrix.length - 1) {
            result.add(sum);
            return;
        }

        if(y < matrix.length-1){
            y++;
            sum += matrix[x][y];
            minPathSum(matrix, x, y, sum, result);
            sum -= matrix[x][y];
            y--;

        }

        if(x < matrix.length -1){
            x++;
            sum += matrix[x][y];
            minPathSum(matrix, x, y, sum, result);
            sum -= matrix[x][y];
            x--;
        }
    }


}
