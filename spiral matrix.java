// You are given a 2D matrix ‘MATRIX’ of ‘N’*’M’ dimension. You have to return the spiral traversal of the matrix.

// Example:

// Input:
// MATRIX = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60] ]
// Output:
// 1 3 5 7 20 60 34 30 23 10 11 16

// Explanation: Starting from the element in the first row and the first column, traverse from left to right (1 3 5 7), then top to bottom (20 60), then right to left (34 30 23), then bottom to up (10) and then left to right (11 16).

import java.util.*;
public class Solution {
    public static int[] spiralMatrix(int [][]matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int right = m - 1;
        int bottom = n - 1;
        int[] ans = new int[n * m];
        int ind = 0;
        int left = 0;
        int top = 0;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans[ind] = matrix[top][i];
                ind++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans[ind] = matrix[i][right];
                ind++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[ind] = matrix[bottom][i];
                    ind++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[ind] = matrix[i][left];
                    ind++;
                }
                left++;
            }
        }
        return ans;
    }
}
