class Solution {
    public String minWindow(String S, String T) {
        int len = S.length();
        int[] last = new int[26];
        int[][] next = new int[len][26];
        Arrays.fill(last, -1);

        for (int i = len - 1; i >= 0; i--) {
            last[S.charAt(i) - 'a'] = i;
            for (int k = 0; k < 26; k++) {
                next[i][k] = last[k];
            }
        }

        List<int[]> windows = new ArrayList<>();
        for (int i = 0; i < len; ++i) {
            if (S.charAt(i) == T.charAt(0))
                windows.add(new int[]{i, i});
        }
        for (int j = 1; j < T.length(); j++) {
            int letterIndex = T.charAt(j) - 'a';
            for (int[] window: windows) {
                if (window[1] < len - 1 && next[window[1] + 1][letterIndex] >= 0) {
                    window[1] = next[window[1] + 1][letterIndex];
                }
                else {
                    window[0] = window[1] = -1;
                    break;
                }
            }
        }

        int[] result = {-1, S.length()};
        for (int[] window: windows) {
            if (window[0] == -1)
                break;
            if (window[1] - window[0] < result[1] - result[0])
                result = window;

        }
        return result[0] >= 0 ? S.substring(result[0], result[1] + 1) : "";

    }
}
