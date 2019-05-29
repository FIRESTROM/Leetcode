class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        List<String> cur_level = new ArrayList<>();
        cur_level.add(s);
        while (!cur_level.isEmpty()) {
            for (String cur_s : cur_level)
                if (isValid(cur_s))
                    result.add(cur_s);
            if (!result.isEmpty())
                return result;
            List<String> next_level = new ArrayList<>();
            for (String cur_s : cur_level) {
                for (int i = 0; i < cur_s.length(); i++) {
                    if (cur_s.charAt(i) != '(' && cur_s.charAt(i) != ')') continue;
                    String temp = cur_s.substring(0, i) + cur_s.substring(i + 1);
                    if (visited.contains(temp))
                        continue;
                    next_level.add(temp);
                    visited.add(temp);
                }
            }
            cur_level = next_level;
        }
        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') {
                if (count == 0) return false;
                else count--;
            }
        }
        return count == 0;
    }
}
