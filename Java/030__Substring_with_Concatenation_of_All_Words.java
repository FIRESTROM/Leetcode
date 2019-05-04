class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        int len = words.length, word_size = words[0].length();
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - (len * word_size); i++) {
            int j = 0;
            HashMap<String, Integer> seen = new HashMap<>();

            while (j < len) {
                int start = i + (j * word_size);
                int end = start + word_size;
                String word = s.substring(start, end);

                if (map.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                } else {
                    break;
                }
                if (map.get(word) < seen.get(word)) {
                    break;
                }
                j++;
            }
            if (j == len) {
                result.add(i);
            }
        }
        return result;
    }
}
