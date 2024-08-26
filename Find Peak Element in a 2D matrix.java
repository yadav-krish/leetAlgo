// A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbors to the left, right, top, and bottom.

// Given a 0-indexed m x n matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the length 2 array [i,j].

// You may assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

// You must write an algorithm that runs in O(m log(n)) or O(n log(m)) time.

class Solution {
    public int findRowMax(int[][]mat,int col,int m)
    {
        int ind=0;
        int ele=Integer.MIN_VALUE;
        for(int i=0;i<m;i++)
        {
            if(mat[i][col]>ele)
            {
                ele=mat[i][col];
                ind=i;
            }
        }
        return ind;
    }
    public int[] findPeakGrid(int[][] mat) {
       int m=mat.length;
       int n=mat[0].length;
       int low=0,high=n-1;
       while(low<=high)
       {
        int mid=low+(high-low)/2;
        int row=findRowMax(mat,mid,m);
        int left=mid-1>=0?mat[row][mid-1]:-1;
        int right=mid+1<n?mat[row][mid+1]:-1;
        int ele=mat[row][mid];
        if(ele>left&&ele>right)
        return new int[]{row,mid};
        else if(ele>left)
        low=mid+1;
        else
        high=mid-1;
       } 
       return new int[]{-1,-1};
    }
}
