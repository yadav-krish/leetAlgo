// You are given a 2D array consisting of only 1's and 0's, where each row is sorted in non-decreasing order. You need to find and return the index of the first row that has the most number of 1s. If no such row exists, return -1.
// Note: 0-based indexing is followed.

class Solution {
    public int func(int[][] arr,int i,int m)
    {
        int ind=m;
        int low=0,high=m-1;
        while(low<=high)
        {
           int mid=low+(high-low)/2;
           if(arr[i][mid]==1)
           {
               ind=mid;
               high=mid-1;
           }
           else
           low=mid+1;
        }
        return m-ind;
    }
    public int rowWithMax1s(int arr[][]) {
        int ind=0;
        int n=arr.length;
        int m=arr[0].length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int cnt=func(arr,i,m);
            if(cnt>maxi)
            {
                maxi=Math.max(maxi,cnt);
                ind=i;
            }
        }
        return maxi!=0?ind:-1;
    }
}
