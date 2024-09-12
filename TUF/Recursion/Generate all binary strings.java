// Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.
// A binary string is that string which contains only 0 and 1.

class Solution {
  public static void generateFunction(List<String>ans,StringBuilder temp,int n,int ind)
  {
      if(ind==n)
      {
          ans.add(temp.toString());
          return;
      }
      temp.append('0');
      generateFunction(ans,temp,n,ind+1);
      temp.deleteCharAt(temp.length()-1);
      if(ind==0||temp.charAt(ind-1)=='0')
      {
      temp.append('1');
      generateFunction(ans,temp,n,ind+1);
      temp.deleteCharAt(temp.length()-1);
      }
  }
  public static List<String> generateBinaryStrings(int n) {
    StringBuilder str=new StringBuilder();
    List<String>ans=new ArrayList<>();
    generateFunction(ans,str,n,0);
    return ans;
  }
}
     
     
