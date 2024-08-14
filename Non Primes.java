import java.util.Scanner;

class Codechef {

    static boolean[] isPrime = new boolean[201]; // To store if sum is prime

    public static void main(String[] args) {
        precomputePrimes(); // Precompute primes up to 200

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] count = new int[101]; // Count occurrences of each number from 1 to 100

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                count[arr[i]]++;
            }

            boolean found = false;
            for (int i = 1; i <= 100 && !found; i++) {
                if (count[i] == 0) continue; // Skip if no such element
                for (int j = i; j <= 100; j++) {
                    if (i == j && count[i] < 2) continue; // Need at least two for a pair
                    if (count[j] == 0) continue;
                    
                    if (!isPrime[i + j]) {
                        found = true;
                        // Find the first indices of i and j in the original array
                        int index1 = -1, index2 = -1;
                        for (int k = 0; k < n && (index1 == -1 || index2 == -1); k++) {
                            if (arr[k] == i && index1 == -1) index1 = k + 1;
                            else if (arr[k] == j && index2 == -1) index2 = k + 1;
                        }
                        System.out.println(index1 + " " + index2);
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("-1");
            }
        }

        sc.close();
    }

    static void precomputePrimes() {
        for (int i = 2; i <= 200; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= 200; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 200; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
