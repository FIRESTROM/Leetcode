class Solution {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int num_odd = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) % 2 == 1) num_odd++;
            else num_odd--;
        }
        return num_odd <= 1;
    }
}
