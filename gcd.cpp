// Optimized solution for finding gcd of two numbers
int calcGCD(int a, int b){
   while (a != 0) {
        int temp = a;
        a = b % a;
        b = temp;
    }
    return b;
}

//The worst-case time complexity is O(log⁡(min⁡(a,b)))O(log(min(a,b))) in terms of the number of iterations. This is because in each step, the size of the numbers involved decreases exponentially.
