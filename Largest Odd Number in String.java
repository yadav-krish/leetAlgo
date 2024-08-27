class Solution {
    public String largestOddNumber(String num) {
        String ans="";
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<num.length();i++)
        {
            char ch=num.charAt(i);
            int n=Character.getNumericValue(ch);
            temp.append(ch);
            if(n%2!=0)
            ans=temp.toString();
        }
        return ans;
    }
}
// Approach 2
class Solution {
    public String largestOddNumber(String num) {
        for(int i=num.length()-1;i>=0;i--)
        {
            int n=num.charAt(i)-'0';
            if(n%2!=0)
            return num.substring(0,i+1);
        }
        return "";
    }
}
