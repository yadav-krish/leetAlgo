// Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

// Note that operands in the returned expressions should not contain leading zeros.

 

// Example 1:

// Input: num = "123", target = 6
// Output: ["1*2*3","1+2+3"]
// Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
// Example 2:

// Input: num = "232", target = 8
// Output: ["2*3+2","2+3*2"]
// Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
// Example 3:

// Input: num = "3456237490", target = 9191
// Output: []
// Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 

// Constraints:

// 1 <= num.length <= 10
// num consists of only digits.
// -231 <= target <= 231 - 1

class Solution {
    public void helper(List<String>ans,String num,int pos,int target,String path,long sum,long prev)
    {
        if(pos==num.length())
        {
            if(sum==target)
            ans.add(path);
            return;
        }
        for(int j=pos;j<num.length();j++)
        {
            if(j!=pos&&num.charAt(pos)=='0')
            break;
            long curr=Long.parseLong(num.substring(pos,j+1));
            if(pos==0)
            helper(ans,num,j+1,target,path+curr,curr,curr);
            else
            {
                helper(ans,num,j+1,target,path+"+"+curr,sum+curr,curr);
                helper(ans,num,j+1,target,path+"-"+curr,sum-curr,-curr);
                helper(ans,num,j+1,target,path+"*"+curr,sum-prev+prev*curr,curr*prev);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String>ans=new ArrayList<>();
        helper(ans,num,0,target,"",0,0);
        return ans;
    }
}
