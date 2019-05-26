class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        if (n == m)
            return s.equals(t);
        int index = -1;
        for (int i = 0; i < n; i++) {
            index = t.indexOf(s.charAt(i), index) + 1;
            if (index == 0)
                return false;
        }
        return true;
    }
}
