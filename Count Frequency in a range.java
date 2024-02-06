// You are given an array 'arr' of length 'n' containing integers within the range '1' to 'x'.
// Your task is to count the frequency of all elements from 1 to n.
// Note:
// You do not need to print anything. Return a frequency array as an array in the function such that index 0 represents the frequency of 1, index 1 represents the frequency of 2, and so on.

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] countFrequency(int n, int x, int []nums){
        int []ans=new int[n];
     Map<Integer,Integer>numMap=new HashMap<>();
     for(int i=0;i<n;i++)
     {
         if(!numMap.containsKey(nums[i]))
         numMap.put(nums[i],0);
          numMap.put(nums[i], numMap.get(nums[i]) + 1);
     }
     for(int i=0;i<n;i++)
     {
         if(numMap.containsKey((i+1)))
         ans[i]=numMap.get(i+1);
         else
         ans[i]=0;
     }
     return ans;
    }
}
