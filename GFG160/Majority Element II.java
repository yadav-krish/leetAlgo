// You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 
// Note: The answer should be returned in an increasing format.
// Examples:
// Input: arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
// Output: [5, 6]
// Explanation: 5 and 6 occur more n/3 times.
// Input: arr[] = [1, 2, 3, 4, 5]
// Output: []
// Explanation: no candidate occur more than n/3 times.

class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        int n=nums.length;
       Map<Integer,Integer>map=new HashMap<>();
       for(int i=0;i<n;i++)
       {
           map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       }
       for(int key:map.keySet())
       {
           if(map.get(key)>n/3)
           ans.add(key);
       }
       return ans;
    }
}

// Method 2 Boyer Moore Voting Algorithm

class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        int n=nums.length;
        int cnt1=0,cnt2=0,cand1=0,cand2=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==cand1)
            cnt1++;
            else if(nums[i]==cand2)
            cnt2++;
            else if(cnt1==0)
            {
                cnt1=1;
                cand1=nums[i];
            }
            else if(cnt2==0)
            {
                cnt2=1;
                cand2=nums[i];
            }
            else
            {
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==cand1)
            cnt1++;
            else if(nums[i]==cand2)
            cnt2++;
        }
        if(cnt1>n/3)
        ans.add(cand1);
        if(cnt2>n/3)
        ans.add(cand2);
        Collections.sort(ans);
        return ans;
    }
}


