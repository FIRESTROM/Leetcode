class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, result = 0;
        while (r < s.length()) {
            map.put(s.charAt(r), r++);
            if (map.size() > 2) {
                int index = Collections.min(map.values());
                map.remove(s.charAt(index));
                l = index + 1;
            }
            result = Math.max(result, r - l);
        }
        return result;
    }
}
