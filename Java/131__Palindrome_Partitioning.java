class Solution {

    boolean[][] dp;
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return result;
        }
        dp = new boolean[s.length()][s.length()];
        build_DP(s);
        helper(s, 0, new ArrayList<String>());
        return result;
    }

    private void build_DP(String s) {
        int s_len = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]));
            }
        }
    }

    private void helper(String s, int start, List<String> cur_arr) {
        if (start == s.length()) result.add(new ArrayList<>(cur_arr));
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                cur_arr.add(s.substring(start, end + 1));
                helper(s, end + 1, cur_arr);
                cur_arr.remove(cur_arr.size() - 1);
            }
        }
        return;
    }
}
