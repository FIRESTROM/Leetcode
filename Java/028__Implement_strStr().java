class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.length() == needle.length()) {
            return haystack.equals(needle) ? 0 : -1;
        }
        int i = 0, j = 0;
        while (i <= haystack.length() - needle.length()) {
            boolean check = true;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    check = false;
                }
            }
            if (check) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
