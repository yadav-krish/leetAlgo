// Write a program to solve a Sudoku puzzle by filling the empty cells.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.

class Solution {
    public boolean solve(char[][]board)
    {
     for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    for(char num='1';num<='9';num++)
                    {
                        if(isValid(board, i,j,num))
                        {
                            board[i][j]=num;
                            if(solve(board))
                            return true;
                            board[i][j]='.';
                        }
                    }return false;
                    }
                    }
                    }
                    return true;
                    }

    public boolean isValid(char[][] board, int i, int j, int num) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == num)
                return false;
            if (board[k][j] == num)
                return false;
            if (board[3 * (i / 3) + (k / 3)][3 * (j / 3) + (k % 3)] == num)
                return false;
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
