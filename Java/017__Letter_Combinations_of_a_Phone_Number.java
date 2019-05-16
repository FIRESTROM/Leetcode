class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        HashMap<Character, String[]> map = new HashMap<>();
        map.put('2', new String[] {"a", "b", "c"});
        map.put('3', new String[] {"d", "e", "f"});
        map.put('4', new String[] {"g", "h", "i"});
        map.put('5', new String[] {"j", "k", "l"});
        map.put('6', new String[] {"m", "n", "o"});
        map.put('7', new String[] {"p", "q", "r", "s"});
        map.put('8', new String[] {"t", "u", "v"});
        map.put('9', new String[] {"w", "x", "y", "z"});

        result.add("");
        for (char c : digits.toCharArray()) {
            List<String> next = new ArrayList<>();
            for (String str : result) {
                for (String cur : map.get(c)) {
                    next.add(str + cur);
                }
            }
            result = next;
        }
        return result;
    }
}
