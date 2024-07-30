// Consider a rat placed at (0, 0) in a square matrix mat of order n* n. It has to reach the destination at (n - 1, n - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
// Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list. The driver will output "-1" automatically.

// Examples:

// Input: mat[][] = [[1, 0, 0, 0],
//                 [1, 1, 0, 1], 
//                 [1, 1, 0, 0],
//                 [0, 1, 1, 1]]
// Output: DDRDRR DRDDRR
// Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
// Input: mat[][] = [[1, 0],
//                 [1, 0]]
// Output: -1
// Explanation: No path exists and destination cell is blocked.
// Expected Time Complexity: O(3n^2)
// Expected Auxiliary Space: O(l * x)
// Here l = length of the path, x = number of paths.

// Constraints:
// 2 ≤ n ≤ 5
// 0 ≤ mat[i][j] ≤ 1

class Solution {
    public void func(ArrayList<String>ans,ArrayList<Character>ds,int[][]mat,int n,int i,int j)
    {
        if (i == n || j == n || i < 0 || j < 0 || mat[i][j] == 0) {
            return;
        }
        if (i == n - 1 && j == n - 1) {
            StringBuilder str = new StringBuilder();
            for (Character ch : ds) {
                str.append(ch);
            }
            ans.add(str.toString());
            return;
        }
        
        mat[i][j] = 0; 
        
        if (j + 1 < n && mat[i][j + 1] != 0) {
            ds.add('R');
            func(ans, ds, mat, n, i, j + 1);
            ds.remove(ds.size() - 1);
        }
        if (i + 1 < n && mat[i + 1][j] != 0) {
            ds.add('D');
            func(ans, ds, mat, n, i + 1, j);
            ds.remove(ds.size() - 1);
        }
        if (i - 1 >= 0 && mat[i - 1][j] != 0) {
            ds.add('U');
            func(ans, ds, mat, n, i - 1, j);
            ds.remove(ds.size() - 1);
        }
        if (j - 1 >= 0 && mat[i][j - 1] != 0) {
            ds.add('L');
            func(ans, ds, mat, n, i, j - 1);
            ds.remove(ds.size() - 1);
        }
        
        mat[i][j] = 1; 
         }
    public ArrayList<String> findPath(int[][] mat) {
        int n=mat.length;
         if(mat[0][0]==0||mat[n-1][n-1]==0)
         return new ArrayList<String>();
        ArrayList<String>ans=new ArrayList<>();
        ArrayList<Character>ds=new ArrayList<>();
        func(ans,ds,mat,n,0,0);
        return ans;
        
    }
}
