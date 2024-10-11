class Solution {
    public void findSubsetSum(ArrayList<Integer>ans,ArrayList<Integer>arr,int sum,int ind,int n)
    {
        if(ind==n)
        {
            ans.add(sum);
            return;
        }
        findSubsetSum(ans,arr,sum+arr.get(ind),ind+1,n);
        findSubsetSum(ans,arr,sum,ind+1,n);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
    ArrayList<Integer>ans=new ArrayList<>();
    findSubsetSum(ans,arr,0,0,n);
    return ans;
    }
}
