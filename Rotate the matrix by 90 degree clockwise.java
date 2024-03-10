// You are given a square matrix ‘Mat’ of size ‘N’. You need to rotate ‘Mat’ by 90 degrees in the clockwise direction.

// Note:

// You must rotate the matrix in place, i.e., you must modify the given matrix itself. You must not allocate another square matrix for rotation.

// For example

// When,
// ‘N’ = 2 and ‘Mat’ = {{1, 2}, {3, 4}}, we must modify ‘Mat’ to {{3, 1}, {4, 2}}.

class Solution {
    public void rotate(int[][] mat) {
        int n = mat.length;
      // taking transpose of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
      // reversing each row
        for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;
            while (start <= end) {
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}
