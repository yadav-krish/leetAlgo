// Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).

class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        // Special case for Integer.MIN_VALUE to prevent overflow
        if (n == Integer.MIN_VALUE) {
            return 1 / (x * myPow(x, Integer.MAX_VALUE));
        }

        if (n < 0)
            return 1 / myPow(x, -n);

        if (n % 2 == 0)
            return myPow(x * x, n / 2);
        else
            return x * myPow(x, n - 1);
    }
}
