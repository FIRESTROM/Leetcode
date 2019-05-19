class Solution {
    class IndexWord {
        String word;
        int index;
        IndexWord(String s, int i) {
            word = s;
            index = i;
        }
    }

    public List<String> wordsAbbreviation(List<String> dict) {
        HashMap<String, List<IndexWord>> groups = new HashMap<>();
        String[] result = new String[dict.size()];
        int idx = 0;
        for (String word : dict) {
            String word_abr = abbrev(word, 0);
            if (!groups.containsKey(word_abr)) groups.put(word_abr, new ArrayList());
            groups.get(word_abr).add(new IndexWord(word, idx));
            idx++;
        }
        for (List<IndexWord> group : groups.values()) {
            Collections.sort(group, (a, b) -> a.word.compareTo(b.word));
            int[] longest_common_prefix = new int[group.size()];
            for (int i = 1; i < group.size(); i++) {
                int val = longestCommonPrefix(group.get(i - 1).word, group.get(i).word);
                longest_common_prefix[i] = val;
                longest_common_prefix[i - 1] = Math.max(longest_common_prefix[i - 1], val);
            }
            for (int i = 0; i < group.size(); i++) {
                result[group.get(i).index] = abbrev(group.get(i).word, longest_common_prefix[i]);
            }
        }
        return Arrays.asList(result);
    }

    private String abbrev(String word, int idx) {
        int len = word.length();
        if (len - idx <= 3) return word;
        return word.substring(0, idx + 1) + String.valueOf(len - idx - 2) + Character.toString(word.charAt(len - 1));
    }

    private int longestCommonPrefix(String word1, String word2) {
        int i = 0;
        while (i < word1.length() && i < word2.length() && word1.charAt(i) == word2.charAt(i)) i++;
        return i;
    }
}
