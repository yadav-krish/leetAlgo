class Solution {
    public int calcSubarr(int arr[], int k) {
        int cnt = 0, l = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int r = 0; r < arr.length; r++) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            if (map.size() > k) {
                while (map.size() > k) {
                    map.put(arr[l], map.get(arr[l]) - 1);
                    if (map.get(arr[l]) == 0)
                        map.remove(arr[l]);
                    l++;
                }
            }
            if (map.size() <= k)
                cnt += r - l + 1;
        }
        return cnt;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return calcSubarr(nums, k) - calcSubarr(nums, k - 1);
    }
}
