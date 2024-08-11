// Given a set of n jobs where each jobi has a deadline and profit associated with it.

// Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with a job if and only if the job is completed by its deadline.

// Find the number of jobs done and the maximum profit.

// Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time on or before which job needs to be completed to earn the profit.

// Examples :

// Input: Jobs = [[1,4,20],[2,1,1],[3,1,40],[4,1,30]]
// Output: 2 60
// Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
// Input: Jobs = [[1,2,100],[2,1,19],[3,2,27],[4,1,25],[5,1,15]]
// Output: 2 127
// Explanation: 2 jobs can be done with maximum profit of 127 (100+27).
// Expected Time Complexity: O(nlogn)
// Expected Auxilliary Space: O(n)

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        int profit=0,cnt=0;
        Arrays.sort(arr,(a,b)->b.profit-a.profit);
        int maxDead=0;
        for(int i=0;i<n;i++)
        maxDead=Math.max(maxDead,arr[i].deadline);
        
        int[] hash=new int[maxDead+1];
        for(Job job:arr)
        {
            int jProfit=job.profit;
            int jDeadline=job.deadline;
                for(int i=jDeadline;i>0;i--)
                {
                    if(hash[i]==0)
                    {
                        profit+=jProfit;
                        hash[i]=job.id;
                        cnt++;
                        break;
                    }
                }
            }
            return new int[]{cnt,profit};
        }
    }

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
