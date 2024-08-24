// You're given two sorted arrays 'arr1' and 'arr2' of size 'n' and 'm' respectively and an element 'k'.

// Find the element that would be at the 'kth' position of the combined sorted array.

// Position 'k' is given according to 1 - based indexing, but arrays 'arr1' and 'arr2' are using 0 - based indexing.

// For example :
// Input: 'arr1' = [2, 3, 45], 'arr2' = [4, 6, 7, 8] and 'k' = 4
// Output: 6
// Explanation: The merged array will be [2, 3, 4, 6, 7, 8, 45]. The element at position '4' of this array is 6. Hence we return 6.

import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int n, int m, int k) {
       int cnt=0;
    int ele=0;
    int ind1=0,ind2=0;
    while(ind1<n&&ind2<m)
    {
        if(a.get(ind1)<=b.get(ind2))
            ele=a.get(ind1++);
        else
            ele=b.get(ind2++);
            cnt++;
            if(cnt==k)
            return ele;
    }
    if(ind1<n)
    return (a.get(k-cnt-1));
    if(ind2<m)
    return b.get(k-cnt-1);
        return 0;
    }
}
