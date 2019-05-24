class Solution {

    Set<String> word_set;
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        word_set = new HashSet<>(wordDict);
        return helper(s, 0);
    }

    private List<String> helper(String s, int start) {
        if (map.containsKey(start))
            return map.get(start);
        List<String> result = new ArrayList<>();
        if (start == s.length())
            result.add("");
        for (int end = start + 1; end <= s.length(); end++) {
            if (word_set.contains(s.substring(start, end))) {
                List<String> lst = helper(s, end);
                for (String str : lst) {
                    result.add(s.substring(start, end) + (str.equals("") ? "" : " ") + str);
                }
            }
        }
        map.put(start, result);
        return result;
    }
}
