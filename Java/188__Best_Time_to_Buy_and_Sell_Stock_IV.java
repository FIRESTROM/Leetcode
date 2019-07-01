class Solution {
    public int maxProfit(int K, int[] prices) {
        if (K == 0 || prices.length == 0) return 0;
        if (K > prices.length / 2) return getMax(prices);
        int N = prices.length;
        int[][] owned = new int[N][K + 1];
        int[][] clear = new int[N][K + 1];

        for (int k = 1; k <= K; k++)
            owned[0][k] = -prices[0];
        for (int i = 1; i < N; i++) {
            for (int k = 1; k <= K; k++) {
                owned[i][k] = Math.max(owned[i - 1][k], clear[i - 1][k - 1] - prices[i]);
                clear[i][k] = Math.max(clear[i - 1][k], owned[i - 1][k] + prices[i]);
            }
        }
        return clear[N - 1][K];
    }

    private int getMax(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            result += Math.max(0, diff);
        }
        return result;
    }
}
