class Solution {

    char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
    int result = 0;

    public int strobogrammaticInRange(String low, String high) {
        for (int len = low.length(); len <= high.length(); len++) {
            char[] cur = new char[len];
            dfs(low, high, cur, 0, len - 1);
        }
        return result;
    }

    private void dfs(String low, String high , char[] cur, int left, int right) {
        if (left > right) {
            String s = new String(cur);
            if ((s.length() == low.length() && s.compareTo(low) < 0) || (s.length() == high.length() && s.compareTo(high) > 0)) return;
            result++;
            return;
        }
        for (char[] p : pairs) {
            cur[left] = p[0];
            cur[right] = p[1];
            if (cur.length != 1 && cur[0] == '0') continue;
            if (left == right && p[0] != p[1]) continue;
            dfs(low, high, cur, left + 1, right - 1);
        }
    }
}
