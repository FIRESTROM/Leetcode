class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++)
            dp[i][0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                dp[i + 1][j + 1] = dp[i][j + 1];
                if (s.charAt(i) == t.charAt(j))
                    dp[i + 1][j + 1] += dp[i][j];
            }
        }
        return dp[s.length()][t.length()];
    }
}
