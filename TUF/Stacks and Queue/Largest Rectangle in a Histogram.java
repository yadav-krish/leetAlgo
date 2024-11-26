https://leetcode.com/problems/largest-rectangle-in-histogram

class Solution {
    public void NSE(int[] nse, int[] arr, int n) {
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

    public void PSE(int[] pse, int[] arr, int n) {
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

    public int largestRectangleArea(int[] heights) {
        int maxi = -1;
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        NSE(nse, heights, n);
        PSE(pse, heights, n);
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, (nse[i] - pse[i] - 1) * heights[i]);
        }
        return maxi;
    }
}
