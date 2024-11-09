// Given a 32 bit unsigned integer num and an integer i. Perform following operations on the number - 

// 1. Get ith bit

// 2. Set ith bit

// 3. Clear ith bit

class Solution {
    static void bitManipulation(int num, int i) {
        int temp=num>>i-1;
       int get=temp&1;
       int set=num|(1<<i-1);
       int clr=num&~(1<<i-1);
       System.out.print(get+" "+set+" "+clr);
    }
}
// Shift Operators (<<, >>, >>>): Higher precedence
// Bitwise OR (|): Lower precedence
