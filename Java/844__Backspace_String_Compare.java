class Solution {
    public boolean backspaceCompare(String S, String T) {
        if (helper(S).equals(helper(T))) {
            return true;
        } else {
            return false;
        }
    }

    private String helper(String S) {
        if (S.length() == 0) {
            return S;
        }
        int i = 0;
        while (S.charAt(i) == '#') i++;
        if (i != 0) {
            S = S.substring(i);
            i = 0;
        }
        while (i < S.length() && S.charAt(i) != '#') i++;
        if (i == S.length()) {
            return S;
        } else {
            S = helper(S.substring(0, i - 1) + S.substring(i + 1));
            return S;
        }
    }
}
