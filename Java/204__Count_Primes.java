class Solution {
    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int result = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int p = 2; p < Math.sqrt(n); p++) {
            if (isPrime[p]) {
                for (int j = p * p; j < n; j += p) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2;i < isPrime.length; i++)
            if (isPrime[i]) {
                result++;
            }
        return result;
    }
}
