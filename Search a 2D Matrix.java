// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

class Solution {
    public int findRow(int[][]mat,int n,int target)
    {
        int low=0,high=n-1;
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(mat[mid][0]<=target)
            {
                ans=mid;
                low=mid+1;
            }
            else
            high=mid-1;
        }
        return ans;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int row=findRow(matrix,n,target);
        int low=0,high=m-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(matrix[row][mid]==target)
            return true;
            else if(matrix[row][mid]>target)
            high=mid-1;
            else
            low=mid+1;
        }
        return false;
    }
}
