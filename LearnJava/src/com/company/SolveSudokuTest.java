package com.company;

import java.util.Arrays;

public class SolveSudokuTest {

    public static void main(String[] args){
        String[][] boardStrs = {
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"},
        };

        char[][] boards = new char[9][9];
        for(int i=0; i<boardStrs.length; i++){
            for(int m=0; m<boardStrs.length; m++){
                boards[i][m] = boardStrs[i][m].charAt(0);
            }
        }


       solveSudoku(boards);
       printArrays(boards);





    }

    private static void printArrays(char[][] boards){
        for(int i=0; i<boards.length; i++){
            System.out.println(Arrays.toString(boards[i]));
        }
    }


    public static void solveSudoku(char[][] board) {
        stepNextSolvenSudoku(board);
    }

    public static boolean stepNextSolvenSudoku(char[][] board) {
        if(!isValidSudoku(board)){
            return false;
        }
        int stepi = -1;
        int stepm = -1;
        for(int i=0; i<board.length; i++){
            for(int m=0; m<board.length; m++){
                if(board[i][m] == '.'){
                    stepi = i;
                    stepm = m;
                    break;
                }
            }
            if(stepi >= 0 || stepm >= 0){
                break;
            }
        }
        if(stepi < 0 || stepm < 0){
            return true;
        }

        boolean[] flags = new boolean[board.length];
        for(int i=0; i<9; i++){
            if(board[i][stepm] != '.'){
                int num = board[i][stepm] - '1';
                flags[num] = true;
            }
            if(board[stepi][i] != '.'){
                int num = board[stepi][i] - '1';
                flags[num] = true;
            }
        }

        int oi  = (stepi/3)*3;
        int om = (stepm/3)*3;
        for(int i=0; i<3; i++){
            for(int m=0; m<3; m++){
                char ch = board[oi + i][ om + m];
                if(ch != '.'){
                    int num = ch - '1';
                    flags[num] = true;
                }
            }
        }
        boolean findFlags = false;
        for(int i=0; i<flags.length; i++){
            if(flags[i]){
                continue;
            }
            int num = i;
            char ch = (char)(num + '1');
            board[stepi][stepm] = ch;
            if(!stepNextSolvenSudoku(board)){
                flags[i] = true;
            }else{
                findFlags = true;
                break;
            }
        }

        if(!findFlags){
            board[stepi][stepm] = '.';
            return false;
        }

        if(!stepNextSolvenSudoku(board)){
            return false;
        }
        return true;
    }


    public static boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++){
            boolean[] rowFlags = new boolean[board.length + 1];
            boolean[] colFlags = new boolean[board.length + 1];
            for(int m=0; m<board.length; m++){
                if(board[i][m] != '.'){
                    int num = board[i][m] - '1';
                    if(rowFlags[num]){
                        return false;
                    }
                    rowFlags[num] = true;
                }
                if(board[m][i] != '.'){
                    int colNum = board[m][i] - '1';
                    if(colFlags[colNum]){
                        return false;
                    }
                    colFlags[colNum] = true;
                }
            }
        }
        for(int j=0; j<3; j++){
            for(int k=0; k<3; k++){
                int oi = j*3;
                int om = k*3;
                boolean[] flags = new boolean[board.length];
                for(int i=0; i<3; i++){
                    for(int m=0; m<3; m++){
                        char ch = board[oi + i][ om + m];
                        if(ch != '.'){
                            int num = ch - '1';
                            if(flags[num]){
                                return false;
                            }
                            flags[num] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
