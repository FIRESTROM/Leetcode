class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        HashMap<String, Integer> map = new HashMap();

        String result = "";
        int result_count = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    map.put(finalword, map.getOrDefault(finalword, 0) + 1);
                    if (map.get(finalword) > result_count) {
                        result = finalword;
                        result_count = map.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return result;
    }
}
