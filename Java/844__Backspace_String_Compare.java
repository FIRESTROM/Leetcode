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

// Another Solution using Stack
class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}

// Faster Solution using Two Pointers
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {skipS++; i--;}
                else if (skipS > 0) {skipS--; i--;}
                else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {skipT++; j--;}
                else if (skipT > 0) {skipT--; j--;}
                else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--; j--;
        }
        return true;
    }
}
