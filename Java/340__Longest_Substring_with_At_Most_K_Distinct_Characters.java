class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length() == 0 || k == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 1;
        int l = 0, r = 0;
        while (r < s.length()) {
            char cur = s.charAt(r);
            map.put(cur, r++);
            if (map.size() > k) {
                int delete_i = Collections.min(map.values());
                map.remove(s.charAt(delete_i));
                l = delete_i + 1;
            }
            result = Math.max(result, r - l);
        }
        return result;
    }
}
