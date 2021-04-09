package com.company;

import java.util.stream.Collectors;

public class RotateTest {

    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        int[][] matrixs = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);

        printMatrix(matrixs);
        rotate(matrixs);
        printMatrix(matrixs);

    }

    public static void printMatrix(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void rotate(int[][] matrix) {
        doRotate(matrix, 0, matrix.length-1);
    }

    public static void doRotate(int[][] matrix, int li, int hi){
        int length = hi - li;
        if(length <= 0){
            return;
        }
        for(int i=0; i<length; i++){
            int a = matrix[li + i][hi];
            matrix[li + i][hi] = matrix[li][li + i];
            int b = matrix[hi][hi-i];
            matrix[hi][hi-i] = a;
            a = matrix[hi-i][li];
            matrix[hi-i][li] = b;
            matrix[li][li + i] = a;
        }
        doRotate(matrix, li +1, hi - 1);
    }
}
