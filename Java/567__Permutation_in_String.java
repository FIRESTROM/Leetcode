class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        HashMap<Character, Integer> temp = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) temp.put(s2.charAt(i), temp.getOrDefault(s2.charAt(i), 0) + 1);
        int i = 0, j = s1.length() - 1;
        while (j < s2.length() - 1) {
            if (temp.equals(map)) return true;
            temp.put(s2.charAt(i), temp.get(s2.charAt(i)) - 1);
            if (temp.get(s2.charAt(i)) == 0) temp.remove(s2.charAt(i));
            i++;
            j++;
            temp.put(s2.charAt(j), temp.getOrDefault(s2.charAt(j), 0) + 1);
        }
        if (temp.equals(map)) return true;
        return false;
    }
}
