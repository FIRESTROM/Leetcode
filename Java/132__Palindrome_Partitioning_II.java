class Solution {
    public int minCut(String s) {
        char[] s_arr = s.toCharArray();
        int len = s.length();
        boolean isPalindrome[][] = new boolean[len][len];
        int dp[] = new int[len];

        for (int end = 0; end < len; end++) {
            int min = Integer.MAX_VALUE;
            for (int start = 0; start <= end; start++) {
                if (s_arr[end] == s_arr[start] && (start + 1 >= end || isPalindrome[start + 1][end - 1]) ){
                    isPalindrome[start][end] = true;
                    min = start == 0 ? 0 : Math.min(min, dp[start - 1] + 1);
                }
            }
            dp[end] = min;
        }
        return dp[len - 1];
    }
}
