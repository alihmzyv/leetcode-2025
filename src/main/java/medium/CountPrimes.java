package medium;

import java.util.Arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        boolean[] isPrimeArr = new boolean[n + 1];
        Arrays.fill(isPrimeArr, true);

        for (int i = 2; i * i < n; i++) {
            if (isPrimeArr[i]) {
                for (int j = i; i * j < n; j++) {
                    isPrimeArr[i * j] = false;
                }
            }
        }

        int numOfPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimeArr[i]) {
                numOfPrimes++;
            }
        }
        return numOfPrimes;
    }
}
