class Solution {
    public boolean canWin(String s) {
        HashMap<String, Boolean> map = new HashMap<>();
        return helper(s, map);
    }

    private boolean helper(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String flipedString = s.substring(0, i) + "--" +  s.substring(i + 2);
                if (canWinRec(flipedString, map)) continue;
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
