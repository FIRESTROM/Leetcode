class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        char[] chars = new char[26];
        for (char c : s.toCharArray()) chars[c - 'a']++;
        if (isValid(chars, k)) return s.length();

        StringBuilder substr = new StringBuilder();
        int result = 0, temp_max = 0;
        for (char c : s.toCharArray()) {
            if (chars[c - 'a'] >= k) {
                substr.append(c);
            } else {
                temp_max = longestSubstring(substr.toString(), k);
                result = Math.max(result, temp_max);
                substr.setLength(0);
            }
        }
        if (substr.length() != 0) {
            temp_max = longestSubstring(substr.toString(), k);
            result = Math.max(result, temp_max);
        }
        return result;
    }

    private boolean isValid(char[] chars, int k) {
        for (int i = 0; i < chars.length; i++)
            if (chars[i] > 0 && chars[i] < k) return false;
        return true;
    }
}
