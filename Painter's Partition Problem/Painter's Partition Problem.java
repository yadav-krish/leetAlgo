// Given an array/list of length ‘n’, where the array/list represents the boards and each element of the given array/list represents the length of each board. Some ‘k’ numbers of painters are available to paint these boards. Consider that each unit of a board takes 1 unit of time to paint.
  
// You are supposed to return the area of the minimum time to get this job done of painting all the ‘n’ boards under a constraint that any painter will only paint the continuous sections of boards.

// Example :
// Input: arr = [2, 1, 5, 6, 2, 3], k = 2

// Output: 11

// Explanation:
// First painter can paint boards 1 to 3 in 8 units of time and the second painter can paint boards 4-6 in 11 units of time. Thus both painters will paint all the boards in max(8,11) = 11 units of time. It can be shown that all the boards can't be painted in less than 11 units of time.

import java.util.ArrayList;

public class Solution 
{
    public static boolean func(ArrayList<Integer>boards,int n,int maxi,int k)
    {
        int cnt=1;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            if(sum+boards.get(i)<=maxi)
            sum+=boards.get(i);
            else
            {
                cnt++;
                sum=boards.get(i);
            }
        }
        return cnt<=k;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int n=boards.size();
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=boards.get(i);
            maxi=Math.max(maxi,boards.get(i));
        }
        int low=maxi,high=sum;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
        boolean res=func(boards,n,mid,k);
        if(res==true)
        high=mid-1;
        else
        low=mid+1;
        }
        return low;
    }
}
