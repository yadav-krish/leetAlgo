class Solution {
    int upperBound(int matrix[][],int r,int C,int target)
    {
        int ans=C;
        int low=0,high=C-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(matrix[r][mid]>target)
            {
                ans=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return ans;
    }
    int countSmallOrEqual(int matrix[][],int R,int C,int target)
    {
        int cnt=0;
        for(int i=0;i<R;i++)
        {
            cnt+=(upperBound(matrix,i,C,target));
        }
        return cnt;
    }
    
    int[] findLH(int matrix[][],int R,int C){
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<R;i++)
        {
            low=Math.min(matrix[i][0],low);
            high=Math.max(high,matrix[i][C-1]);
        }
        return new int[]{low,high};
    }
    int median(int matrix[][], int R, int C) {
        int ans=0;
        int req=(R*C)/2;
        int[]range=findLH(matrix,R,C);
        int low=range[0],high=range[1];
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int cnt=countSmallOrEqual(matrix,R,C,mid);
            if(cnt>req)
            {
                ans=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return ans;
    }
}
