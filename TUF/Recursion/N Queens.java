// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

class Solution {
    public boolean isSafe(int row, int col, char[][] board, int n) {
        int dupRow = row;
        int dupCol = col;
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }
        col = dupCol;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row++;
            col--;
        }
        return true;
    }

    public List<String> construct(char[][] board, int n) {
        List<String> sol = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String t = new String(board[i]);
            sol.add(t);
        }
        return sol;
    }

    public void findNQueens(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(construct(board,n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(i, col, board, n)) {
                board[i][col] = 'Q';
                findNQueens(col + 1, board, ans, n);
                board[i][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        findNQueens(0, board, ans, n);
        return ans;
    }
}
