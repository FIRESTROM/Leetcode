class Solution {
    public int knightDialer(int N) {
        if (N == 1)
            return 10;
        int[][] dp = new int[][] {{4,6}, {6,8}, {7,9},{4,8}, {0,3,9}, {}, {1,7,0},{2,6}, {1,3}, {4,2}};
        int mod = 1000_000_007;
        int[] cnt = new int[10], prev = new int[10];
        Arrays.fill(prev, 1);

        for (int i = 1; i <= N - 1; i++) {
            for (int j = 0; j < 10;j ++)
                for (int k : dp[j])
                    cnt[k] = (cnt[k] + prev[j]) % mod;

            prev = cnt;
            cnt = new int[10];
        }
        int sum = 0;
        for (int j = 0; j < 10; j++)
            sum = (sum + prev[j]) % mod;
        return sum;
    }
}
