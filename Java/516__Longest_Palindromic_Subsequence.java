class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        char[] s_char = s.toCharArray();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s_char[i] == s_char[j])
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
            }
        }
        return dp[len - 1][0];
    }
}
