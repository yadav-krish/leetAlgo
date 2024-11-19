// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

// Example 1:

// Input: arr = [3,1,2,4]
// Output: 17
// Explanation: 
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.
// Example 2:

// Input: arr = [11,81,94,43,3]
// Output: 444

class Solution {
    public void NSE(int[] arr, int[] nse, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                stack.pop();
            if (stack.isEmpty())
                nse[i] = n;
            else
                nse[i] = stack.peek();
            stack.push(i);
        }
    }

    public void PSE(int[] arr, int[] pse, int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            if (stack.isEmpty())
                pse[i] = -1;
            else
                pse[i] = stack.peek();
            stack.push(i);
        }
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        PSE(arr, pse, n);
        NSE(arr, nse, n);
        int mod = (int)(1e9 + 7);
        long total = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pse[i];   
            long right = nse[i] - i; 
            total = (total + (right * left % mod) * arr[i] % mod) % mod; 
        }
        return (int) total; 
    }
}
