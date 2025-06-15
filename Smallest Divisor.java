// Given an integer array arr[] and an integer k (where k ≥ arr.length), find the smallest positive integer divisor such that the sum of the ceiling values of each element in arr[] divided by this divisor is less than or equal to k.

// Examples:

// Input: arr[] = [1, 2, 5, 9], k = 6
// Output: 5
// Explanation: 5 is the smallest divisor having sum of quotients (1 + 1 + 1 + 2 = 5) less than or equal to 6.
// Input: arr[] = [1, 1, 1, 1], k = 4
// Output: 1
// Explanation: 1 is the smallest divisor having sum of quotients (1 + 1 + 1 + 1 = 4) less than or equal to 4.
// Constraints:
// 1  ≤  arr.size()  ≤ 10^5
// 1  ≤  arr[i]  ≤ 10^6
// arr.size()  ≤ k  ≤ 10^6


class Solution {
    int smallestDivisor(int[] arr, int k) {
        int ans=0;
        int largest=-1;
        for(int i=0;i<arr.length;i++)
        {
            largest=Math.max(arr[i],largest);
        }
        int s=1,e=largest;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            int sum=0;
            for(int i=0;i<arr.length;i++)
            {
                sum=sum+((int)Math.ceil((double)arr[i]/mid)); // In this integer divison will be performed first if double is not used hence the ceil function will become useless
            }
            if(sum<=k)
            {
            ans=mid;
            e=mid-1;
            }
            else
            s=mid+1;
        }
        return ans;
    }
}
