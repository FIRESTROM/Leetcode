/*
  dp[i][j] represents whether the sum of first i numbers can be j - 5000. dp[0][5000] = true.
  Then dp[i + 1][j] = dp[i][j - rods[i]] | dp[i][j + rods[i]] | dp[i][j].
  max[i][j] represents the largest sum of all positive numbers when the sum of first i numbers is j - 5000.
*/
class Solution {
    public int tallestBillboard(int[] rods) {
        int len = rods.length;
        boolean[][] dp = new boolean[len + 1][10001];
        int[][] max = new int[len + 1][10001];
        dp[0][5000] = true;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= 10000; j++) {
                if (j - rods[i] >= 0 && dp[i][j - rods[i]]) {
                    dp[i + 1][j] = true;
                    max[i + 1][j] = Math.max(max[i + 1][j], max[i][j - rods[i]] + rods[i]);
                }
                if (j + rods[i] <= 10000 && dp[i][j + rods[i]]) {
                    dp[i + 1][j] = true;
                    max[i + 1][j] = Math.max(max[i + 1][j], max[i][j + rods[i]]);
                }
                if (dp[i][j]) {
                    dp[i + 1][j] = true;
                    max[i + 1][j] = Math.max(max[i + 1][j], max[i][j]);
                }
            }
        }
        return max[len][5000];
    }
}
