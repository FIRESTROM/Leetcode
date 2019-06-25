class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.isEmpty() || s1.equals(s2)) return true;
        int len = s1.length();
        int count = 0;
        int[] saved = new int[128];
        // 正序
        for (int i = 0; i < len-1; i++) {
            if (++saved[s1.charAt(i)] == 0) count--;
            else if (saved[s1.charAt(i)] == 1) count++;
            if (--saved[s2.charAt(i)] == 0) count--;
            else if (saved[s2.charAt(i)] == -1) count++;
            if (count == 0) {
                if (isScramble(s1.substring(0, i+1), s2.substring(0, i+1)) &&
                        isScramble(s1.substring(i+1), s2.substring(i+1))) {
                    return true;
                }
                break;
            }
        }
        if (count != 0) {
            if (++saved[s1.charAt(len-1)] == 0) count--;
            if (--saved[s2.charAt(len-1)] == 0) count--;
        }
        if (count != 0) return false;
        // 逆序
        for (int i = 0; i < len-1; i++) {
            if (++saved[s1.charAt(i)] == 0) count--;
            else if (saved[s1.charAt(i)] == 1) count++;
            if (--saved[s2.charAt(len-i-1)] == 0) count--;
            else if (saved[s2.charAt(len-i-1)] == -1) count++;
            if (count == 0) {
                if (isScramble(s1.substring(0, i+1), s2.substring(len-i-1)) &&
                        isScramble(s1.substring(i+1), s2.substring(0, len-i-1))) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
