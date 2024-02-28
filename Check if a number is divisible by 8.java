// Given a string representation of a decimal number s, check whether it is divisible by 8.

// Example 1:

// Input:
// s = "16"
// Output:
// 1
// Explanation:
// The given number is divisible by 8,
// so the driver code prints 1 as the output.

// Example 2:

// Input:
// s = "54141111648421214584416464555"
// Output:
// -1
// Explanation:
// Given Number is not divisible by 8, 
// so the driver code prints -1 as the output.

class Solution{
    int DivisibleByEight(String s){
        int size=s.length();
     int n=0;
      String x="";
      if(size>3)
      {
      for(int i=size-1;i>=size-3;i--)
      {
       x=s.charAt(i)+x;
      }
      s=x;
      }
 n=Integer.parseInt(s);
      if(n%8==0)
      return 1;
      else
      return -1;
    }
}
