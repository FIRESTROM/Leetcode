class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] lst = s.toCharArray();
        for (int i = 0; i < lst.length; i++) {
            map.put(lst[i], map.getOrDefault(lst[i], 0) + 1);
        }
        for (int i = 0; i < lst.length; i++) {
            if (map.get(lst[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
