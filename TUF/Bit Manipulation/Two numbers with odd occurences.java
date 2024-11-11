// Given an unsorted array, Arr[] of size N and that contains even number of occurrences for all numbers except two numbers. Find the two numbers in decreasing order which has odd occurrences.

// Example 1:

// Input:
// N = 8
// Arr = {4, 2, 4, 5, 2, 3, 3, 1}
// Output: {5, 1} 
// Explanation: 5 and 1 have odd occurrences.

// Example 2:

// Input:
// N = 8
// Arr = {1 7 5 7 5 4 7 4}
// Output: {7, 1}
// Explanation: 7 and 1 have odd occurrences.

// Your Task:
// You don't need to read input or print anything. Your task is to complete the function twoOddNum() which takes the array Arr[] and its size N as input parameters and returns the two numbers in decreasing order which have odd occurrences.

// Expected Time Complexity: O(N)
// Expected Auxiliary Space: O(1)

class Solution
{
    public int[] twoOddNum(int arr[], int n)
    {
     int xor=0;
     for(int i=0;i<n;i++)
     {
         xor=xor^arr[i];
     }
     int rightmost=(xor&xor-1)^xor;
     int b1=0,b2=0;
     for(int i=0;i<n;i++)
     {
         if((arr[i]&rightmost)!=0)
         b1^=arr[i];
         else
         b2^=arr[i];
     }
     if(b1>b2)
     return new int[]{b1,b2};
     else
     return new int[]{b2,b1};
    }
}
