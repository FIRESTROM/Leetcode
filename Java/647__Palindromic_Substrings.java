class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += helper(s, i, i) + helper(s, i, i + 1);
        }
        return result;
    }

    private int helper(String s, int left, int right) {
        int result = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            result++;
        }
        return result;
    }

}
