class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[][] save = new int[primes.length][n + 1];
        int[] result = new int[n];
        for (int i = 0; i < primes.length; i++)
            save[i][0] = 1;
        int[] pointer = new int[primes.length];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                min = Math.min(save[j][pointer[j]], min);
            for (int j = 0; j < primes.length; j++) {
                if (save[j][pointer[j]] == min)
                    pointer[j]++;
                save[j][i] = min * primes[j];
            }
            result[i - 1] = min;
        }
        return result[n - 1];
    }
}
