class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        int i = 0, j = 0;
        while (j < p.length() && p.charAt(j) == '*') {
            dp[0][j + 1] = true;
            j++;
        }
        for (i = 1; i <= s.length(); i++) {
            for (j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
