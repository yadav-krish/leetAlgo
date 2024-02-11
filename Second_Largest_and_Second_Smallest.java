public class Solution {
    public static int[] getSecondOrderElements(int n, int[] arr) {
        int max = Integer.MIN_VALUE, smax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                smax = max;
                max = arr[i];
            } else if (arr[i] > smax && arr[i] != max) {
                smax = arr[i];
            }

            if (arr[i] < min) {
                smin = min;
                min = arr[i];
            } else if (arr[i] < smin && arr[i] != min) {
                smin = arr[i];
            }
        }

        return new int[]{smax, smin};
    }
}
