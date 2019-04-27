class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int s_len = s.length(), p_len = p.length();
        if (p_len > s_len) {
            return result;
        }
        HashMap<Character, Integer> p_map = new HashMap<>();
        HashMap<Character, Integer> temp_map = new HashMap<>();

        for (int i = 0; i < p_len; i++) {
            p_map.put(p.charAt(i), p_map.getOrDefault(p.charAt(i), 0) + 1);
            temp_map.put(s.charAt(i), temp_map.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (p_map.equals(temp_map)) {
            result.add(0);
        }
        for (int i = 1; i <= s_len - p_len; i++) {
            temp_map.put(s.charAt(p_len + i - 1), temp_map.getOrDefault(s.charAt(p_len + i - 1), 0) + 1);
            temp_map.put(s.charAt(i - 1), temp_map.get(s.charAt(i - 1)) - 1);
            if (temp_map.get(s.charAt(i - 1)) == 0) {
                temp_map.remove(s.charAt(i - 1));
            }
            if (p_map.equals(temp_map)) {
                result.add(i);
            }
        }
        return result;
    }
}
