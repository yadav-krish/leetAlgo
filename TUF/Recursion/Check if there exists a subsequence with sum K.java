// Problem statement
// You are given an array 'A' of 'N' integers. You have to return true if there exists a subset of elements of 'A' that sums up to 'K'. Otherwise, return false.
// For Example
// 'N' = 3, 'K' = 5, 'A' = [1, 2, 3].
// Subset [2, 3] has sum equal to 'K'.
// So our answer is True.
  
import java.util.*;
public class Solution {
    public static boolean findCombination(List<Integer> ds, int n, int target, int[] arr, int ind) {
        if (target == 0) {
            return true;
        }
        if (ind >= n || target < 0) {
            return false;
        }
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            if (findCombination(ds, n, target - arr[ind], arr, ind + 1)) {
                return true;
            }
            ds.remove(ds.size() - 1);
        }
        return findCombination(ds, n, target, arr, ind + 1);
    }

    public static boolean isSubsetPresent(int n, int target, int[] arr) {
        return findCombination(new ArrayList<>(), n, target, arr, 0);
    }
}
