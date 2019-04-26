class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] s_char = s.toCharArray();
        for (int i = 0; i < s_char.length; i++) {
            map.put(s_char[i], map.getOrDefault(s_char[i], 0) + 1);
        }
        char[] t_char = t.toCharArray();
        for (int i = 0; i < t_char.length; i++) {
            if (!map.containsKey(t_char[i]) || map.get(t_char[i]) == 0) {
                return false;
            }
            map.put(t_char[i], map.get(t_char[i]) - 1);
        }
        return true;
    }
}

// Faster Solution
class Solution {
    public boolean isAnagram(String s, String t) {
        int [] map = new int[26];
        for (char c : s.toCharArray()){
            map[c - 'a']++;
        }
        for (char c : t.toCharArray()){
            if (--map[c - 'a'] < 0) {
              return false;
            }
        }
        for (int count : map) {
            if (count != 0) {
              return false;
            }
        }
        return true;
    }
}
