class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        int len = order.length();
        for (int i = 0; i < len; i++) {
            map.put(order.charAt(i), len - i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!helper(words[i], words[i + 1], map)) {
                return false;
            }
        }
        return true;
    }
    private boolean helper(String word1, String word2, HashMap<Character, Integer> map) {
        int i = 0;
        while (i < word1.length() && i < word2.length()) {
            if (word1.charAt(i) == word2.charAt(i)) {
                i++;
                continue;
            }
            if (map.get(word1.charAt(i)) < map.get(word2.charAt(i))) {
                return false;
            } else {
                return true;
            }
        }
        if (word1.length() <= word2.length()) {
            return true;
        } else {
            return false;
        }
    }
}
