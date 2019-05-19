class Solution {
    public int expressiveWords(String S, String[] words) {
        int result = 0;
        for (String word : words) {
            if (check(S, word))
                result++;
        }
        return result;
    }

    private boolean check(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j))
                return false;
            int count = 1, temp_i = i;
            while (temp_i < s.length() - 1 && s.charAt(temp_i) == s.charAt(temp_i + 1)) {
                temp_i++;
                count++;
            }
            if (count >= 3) {
                while (count > 1 && j < t.length() - 1 && t.charAt(j) == t.charAt(j + 1)) {
                    count--;
                    j++;
                }
                i = temp_i + 1;
                j++;
            } else {
                i++;
                j++;
            }
        }
        if (i == s.length() && j == t.length())
            return true;
        return false;
    }
}
