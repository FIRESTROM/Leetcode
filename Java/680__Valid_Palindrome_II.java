class Solution {
    public boolean validPalindrome(String s) {
        if (check(s)) return true;
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        if (check(s.substring(l, r)) || check(s.substring(l + 1, r + 1))) return true;
        return false;
    }

    private boolean check(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
