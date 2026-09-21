import java.util.*;

class Solution {
    public void solveSudoku(char[][] board) {
        sudoku(board, 0, 0);
    }

    private boolean sudoku(char[][] board, int row, int col){
        if(row == 9){
            return true;
        }
        int nextRow = row;
        int nextCol = col +1;
        if(nextCol == 9){
            nextRow = row +1;
            nextCol = 0;
        }
        if(board[row][col] != '.'){
           return sudoku(board, nextRow, nextCol);
        }
        for(char dig = '1'; dig <= '9'; dig++){
            if(isSafe(board, row, col, dig)){
                board[row][col] = dig;
            if(sudoku(board, nextRow, nextCol)){
                return true;
            }
            board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char dig){
        for(int j = 0; j < 9; j++){
            if(board[row][j] == dig){ // horizontal
                return false;
            }
        }
        for(int i = 0; i < 9; i++){
            if(board[i][col] == dig){ // vertical
                return false;
            }
        }
        int sRow = (row/3) * 3;
        int sCol = (col/3) * 3;
        for(int i = sRow; i <= sRow+2; i++){
            for(int j = sCol; j <= sCol+2; j++){
                if(board[i][j] == dig){ // grid
                    return false;
                }
            }
        }
        return true;
    }
}