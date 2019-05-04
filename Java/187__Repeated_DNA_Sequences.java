class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String temp = s.substring(i, i + 10);
            if (set.contains(temp) && !result.contains(temp)) {
                result.add(temp);
            } else {
                set.add(temp);
            }
        }
        return result;
    }
}
