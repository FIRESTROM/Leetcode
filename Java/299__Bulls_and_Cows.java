class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i))
                bull++;
            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
        }
        for (char c : guess.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) == 0) map.remove(c);
                count++;
            }
        }
        return Integer.toString(bull) + "A" + Integer.toString(count - bull) + "B";
    }
}
