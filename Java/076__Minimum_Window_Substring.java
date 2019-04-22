class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map_t = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            map_t.put(t.charAt(i), map_t.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = map_t.size();
        int l = 0, r = 0;
        int formed = 0;
        HashMap<Character, Integer> temp = new HashMap<>();
        int[] result = {-1, 0, 0};
        while (r < s.length()) {
            char c = s.charAt(r);
            temp.put(c, temp.getOrDefault(c, 0) + 1);
            if (map_t.containsKey(c) && temp.get(c).intValue() == map_t.get(c).intValue()) {
                formed++;
            }
            while (l <= r && formed == required) {
                c = s.charAt(l);
                if (result[0] == -1 || r - l + 1 < result[0]) {
                    result[0] = r - l + 1;
                    result[1] = l;
                    result[2] = r;
                }

                temp.put(c, temp.get(c) - 1);
                if (map_t.containsKey(c) && temp.get(c).intValue() < map_t.get(c).intValue()) {
                    formed--;
                }

                l++;
            }

            r++;
        }
        return result[0] == -1 ? "" : s.substring(result[1], result[2] + 1);
    }
}
