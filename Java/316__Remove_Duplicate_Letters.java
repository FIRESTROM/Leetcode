class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null)
            return null;
        StringBuilder result = new StringBuilder();
        int[] count = new int[26];
        boolean[] actual = new boolean[26];
        char[] s_arr = s.toCharArray();
        for (int index = 0 ; index < actual.length ; index++)
            actual[index] = false;
        for (char c : s_arr)
            count[c - 'a']++;
        for( char c : s_arr) {
            int length = result.length();
            while (length > 0 && c < result.charAt(length-1) && count[result.charAt(length - 1) - 'a'] > 1 && !actual[c - 'a']) {
                count[result.charAt(length - 1) - 'a']--;
                actual[result.charAt(length - 1) - 'a'] = false;
                result.deleteCharAt(length - 1);
                length = result.length();
            }
            if (!actual[c - 'a']) {
                result.append(c);
                actual[c - 'a'] = true;
            } else
                count[c - 'a']--;
        }
        return result.toString();
    }
}
