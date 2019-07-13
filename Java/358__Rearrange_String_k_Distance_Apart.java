class Solution {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) return "";
        int[] counts = new int[26];
        int[] valid = new int[26];
        char[] s_arr = s.toCharArray();
        for (int i = 0; i < s_arr.length; i++)
            counts[s_arr[i] - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s_arr.length; i++) {
            int nextCharIndex = findValidMax(i, valid, counts);
            if (nextCharIndex == -1) return "";
            sb.append((char) (nextCharIndex + 'a'));
            counts[nextCharIndex]--;
            valid[nextCharIndex] = k + i;
        }
        return sb.toString();
    }

    private int findValidMax(int index, int[] valid, int[] counts) {
        int max = Integer.MIN_VALUE;
        int candidatePos = -1;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0 && counts[i] > max && valid[i] <= index) {
                max = counts[i];
                candidatePos = i;
            }
        }
        return candidatePos;


    }
}
