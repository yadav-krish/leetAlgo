//You are given an integer ‘n’.
//Function ‘sumOfDivisors(n)’ is defined as the sum of all divisors of ‘n’.
//Find the sum of ‘sumOfDivisors(i)’ for all ‘i’ from 1 to ‘n’.

int sumOfAllDivisors(int n){
int sum=0;
 for (int i = 1; i <= n; i++) {
        for (int j = 1; j * j <= i; j++) {
            if (i % j == 0) {
                sum += j;
                if (i / j != j) {
                  sum += i / j;
                }
            }
        }
 }
 return sum;
}

// TC is O(N.sqrtN) which is better than O(N^2)


int sumOfAllDivisors(int n)
{
    int ans = 0;
    int l = 1;
    while (l <= n)
    {
        int val = n / l;

        int r = n / val;
        ans += ((r * (r + 1)) / 2 - (l * (l - 1)) / 2) * val;
        l = r + 1;

    }
    return ans;
}
// TC is O(sqrtN) which is best
