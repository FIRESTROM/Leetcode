class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        return helper(str, 0, pattern, 0, new HashMap<>(), new HashSet<>());
    }

    private boolean helper(String str, int str_idx, String pattern, int pattern_idx, Map<Character, String> map, Set<String> set) {
        if (str_idx == str.length() && pattern_idx == pattern.length())
            return true;
        if (str_idx == str.length() || pattern_idx == pattern.length())
            return false;
        char c = pattern.charAt(pattern_idx);
        if (map.containsKey(c)) {
            String cur_str = map.get(c);
            if (!str.startsWith(cur_str, str_idx))
                return false;
            return helper(str, str_idx + cur_str.length(), pattern, pattern_idx + 1, map, set);
        }
        for (int k = str_idx; k < str.length(); k++) {
            String tmpPattern = str.substring(str_idx, k + 1);
            if (set.contains(tmpPattern))
                continue;
            map.put(c, tmpPattern);
            set.add(tmpPattern);
            if (helper(str, k + 1, pattern, pattern_idx + 1, map, set))
                return true;
            map.remove(c);
            set.remove(tmpPattern);
        }
        return false;
    }
}
