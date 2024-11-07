// Consider a rat placed at (0, 0) in a square matrix mat of order n* n. It has to reach the destination at (n - 1, n - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
// Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list. The driver will output "-1" automatically.

// Examples:

// Input: mat[][] = [[1, 0, 0, 0],
//                 [1, 1, 0, 1], 
//                 [1, 1, 0, 0],
//                 [0, 1, 1, 1]]
// Output: DDRDRR DRDDRR
// Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.

class Solution {
    public void findPath(int row, int col, ArrayList<String> ans, int[][] mat, int[][] visited, String path, int n) {
        if (row == n - 1 && col == n - 1) { // Reached destination
            ans.add(path);
            return;
        }

        // Move Right
        if (col + 1 < n && visited[row][col + 1] == 0 && mat[row][col + 1] == 1) {
            visited[row][col + 1] = 1;
            findPath(row, col + 1, ans, mat, visited, path + "R", n);
            visited[row][col + 1] = 0; // Backtrack
        }

        // Move Left
        if (col - 1 >= 0 && visited[row][col - 1] == 0 && mat[row][col - 1] == 1) {
            visited[row][col - 1] = 1;
            findPath(row, col - 1, ans, mat, visited, path + "L", n);
            visited[row][col - 1] = 0; // Backtrack
        }

        // Move Down
        if (row + 1 < n && visited[row + 1][col] == 0 && mat[row + 1][col] == 1) {
            visited[row + 1][col] = 1;
            findPath(row + 1, col, ans, mat, visited, path + "D", n);
            visited[row + 1][col] = 0; // Backtrack
        }

        // Move Up
        if (row - 1 >= 0 && visited[row - 1][col] == 0 && mat[row - 1][col] == 1) {
            visited[row - 1][col] = 1;
            findPath(row - 1, col, ans, mat, visited, path + "U", n);
            visited[row - 1][col] = 0; // Backtrack
        }
    }

    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        ArrayList<String> ans = new ArrayList<>();
        
        // Check if starting or ending point is blocked
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) return ans;
        
        int[][] visited = new int[n][n]; // Use int array for visited
        visited[0][0] = 1; // Start point as visited

        findPath(0, 0, ans, mat, visited, "", n);
        return ans;
    }
}
