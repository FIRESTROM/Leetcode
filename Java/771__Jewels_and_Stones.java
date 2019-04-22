class Solution {
    public int numJewelsInStones(String J, String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }
        int result = 0;
        for (int i = 0; i < J.length(); i++) {
            if (map.containsKey(J.charAt(i))) {
                result += map.get(J.charAt(i));
            }
        }
        return result;
    }
}
