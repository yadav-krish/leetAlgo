class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int row = 0, col = m - 1;  // Start from the top-right corner

        // Traverse the matrix
        while (row < n && col >= 0) {
            if (matrix[row][col] == target) {
                return true;  // Target found
            } else if (matrix[row][col] > target) {
                col--;  // Move left
            } else {
                row++;  // Move down
            }
        }

        return false;  // Target not found
    }
}
