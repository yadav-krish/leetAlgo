/* Given a string s of lowercase alphabets and a number k, the task is to print the minimum value of the string after removal of k characters. The value of a string is defined as the sum of squares of the count of each distinct character present in the string. */

class Solution{
public:
    int minValue(string s, int k){
        unordered_map<char,int>charMap;
        for(char i:s)
        {
            charMap[i]++;
        }
       priority_queue<int>maxHeap;
        for(auto it:charMap)
        {
            maxHeap.push(it.second);
        }
       while(k--)
       {
           int num=maxHeap.top();
           maxHeap.pop();
           maxHeap.push(num-1);
       }
       int sum=0;
       while(maxHeap.size()>0)
       {
           int num=maxHeap.top();
           sum+=(num*num);
           maxHeap.pop();
       }
       return sum;
    }
};
