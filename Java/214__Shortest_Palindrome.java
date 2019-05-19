class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() == 0)
            return s;
        int start = (s.length() - 1) / 2;
        if (check(s, start, start))
            return new StringBuilder(s.substring(start + 1)).reverse().toString() + s.substring(start);

        start--;
        while (start >= 0) {
            if (check(s, start, start + 1))
                return new StringBuilder(s.substring(start + 1)).reverse().toString() + s.substring(start + 1);
            if (check(s, start, start))
                return new StringBuilder(s.substring(start + 1)).reverse().toString() + s.substring(start);
            start--;
        }
        return s;
    }

    private boolean check(String s, int left, int right) {
        while (left >= 0) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left--;
            right++;
        }
        return true;
    }
}
